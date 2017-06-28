package dao;


import model.Link_offer_hr;
import model.Offer;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class OfferDA {
	static List<String> industryCatalog=new ArrayList<String>(Arrays.asList("IT","金融","教育"));
	static List<String> jobType=new ArrayList<String>(Arrays.asList("实习","全职ְ","应届"));
	static List<String> adress=new ArrayList<String>(Arrays.asList("武汉","北京","上海","深圳","广州","杭州"));
	
	static List<Offer> offerList;
	static Offer offer;
	static Link_offer_hr link=new Link_offer_hr();
	static Connection connection=null;
	static Statement statement=null;
	static PreparedStatement pps=null;
	
	static String driver="com.mysql.jdbc.Driver";
	static String jdbcUrl="jdbc:mysql://localhost:3306/offer100";	  
	static String user="root";
	//static String password="wasd";
	static String password="mayapril1996";
	/*****************offerDA链接数据库**********************/
	public static Connection getConnection(){
		try{
			Class.forName(driver);
			connection=DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("offer数据库链接成功！");
			statement=connection.createStatement();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	/***********************数据库关闭***************************/
	public static void terminate(){
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/***********************增加一条新的招聘信息并更新link_hr_offer
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException ******************************/
	public static void add(Offer offer,String mail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String sql="insert into jobOffer_table (JobType,IndustryCatalog,CompanyName,JobName,WorkSkill,MonthSalary,Contact,Time,Adress,OtherInformation,AllString) values('"
				                                      +offer.getJobType()+"','"
				                                      +offer.getIndustryCatalog()+"','"
				                                      +offer.getCompanyName()+"','"
				                                      +offer.getJobName()+"','"
				                                      +offer.getWorkSkill()+"','"
				                                      +offer.getMonthSalary()+"','"
				                                      +offer.getContact()+"','"
				                                      +java.sql.Date.valueOf(offer.getTime())+"','"
				                                      +offer.getAdress()+"','"
				                                      +offer.getOtherInformation()+"','"
				                                      +offer.getAllString()+"')";
		
		System.out.println(sql);
		try{
			pps=connection.prepareStatement(sql,0x1);
					//Statement.RETURN_GENERATED_KEYS);
			pps.executeUpdate();
			ResultSet rs=pps.getGeneratedKeys();
			System.out.println("插入成功！");
			if(rs.next()){
				int num=rs.getInt(1);
				System.out.println(num);
				link.add(num, mail);
				System.out.println("更新link_offer_hr成功！！");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/************************根据邮箱查找link_offer_hr的招聘信息id，去jobOffer表中查找招聘信息，返回对象list集合*****************************/
	public static List<Offer> find(String mail){
		offerList=new ArrayList<Offer>();
		String sql="select * from jobOffer_table where id in (select id from link_hr_offer where mail='"+mail+"')order by Time desc";
		System.out.println(sql);
		ResultSet rs;
		try {
			rs = statement.executeQuery(sql);
			while(rs.next()){
			offer=new Offer();
			offer.setId(rs.getInt(1));
			offer.setJobType(rs.getString(2));
			offer.setIndustryCatalog(rs.getString(3));
			offer.setCompanyName(rs.getString(4));
			offer.setJobName(rs.getString(5));
			offer.setWorkSkill(rs.getString(6));
			offer.setMonthSalary(rs.getString(7));
			offer.setContact(rs.getString(8));
			offer.setTime(rs.getDate(9).toString());
			offer.setAdress(rs.getString(10));
			offer.setOtherInformation(rs.getString(11));
			offer.setAllString(rs.getString(12));
			offerList.add(offer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offerList;
	}
	/**********************删除一条招聘信息*******************************/
	public static void delete(int id,String mail){
		String sql="delete from JobOffer_table where id='"+id+"'";
		System.out.println(sql);
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/************************根据id查找一条招聘信***************************/
	public static Offer findByID(int id){
		String sql="select * from JobOffer_table where id='"+id+"'";
		System.out.println(sql);
		ResultSet rs;
		try{
			rs = statement.executeQuery(sql);
			offer=new Offer();
			if(rs.next()){
				offer.setId(rs.getInt(1));
				offer.setJobType(rs.getString(2));
				offer.setIndustryCatalog(rs.getString(3));
				offer.setCompanyName(rs.getString(4));
				offer.setJobName(rs.getString(5));
				offer.setWorkSkill(rs.getString(6));
				offer.setMonthSalary(rs.getString(7));
				offer.setContact(rs.getString(8));
				offer.setTime(rs.getDate(9).toString());
				offer.setAdress(rs.getString(10));
				offer.setOtherInformation(rs.getString(11));
				offer.setAllString(rs.getString(12));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return offer;
	}

}
