package db;


import java.sql.*;
import java.util.*;

import model.Link_offer_hr;

public class Link_offer_hrDA {
	static String driver="com.mysql.jdbc.Driver";
	static String jdbcUrl="jdbc:mysql://localhost:3306/offer100";	  
	static String user="root";
	static String password="wasd";
	
	//static List<Offer> offerList;
	//static Offer offer;
	//static Link_offer_hr link;
	static List<Integer> idList;
	static Connection connection=null;
	static Statement statement=null;
	
	public static Connection getConnection(){
		try{
			Class.forName(driver);
			connection=DriverManager.getConnection(jdbcUrl,user,password);
			statement=connection.createStatement();
			System.out.println("link数据库链接成功！");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
    public static void add(int id,String mail){
    	String sql="insert into link_hr_offer(id,mail) values('"+id+"','"+mail+"')";
    	System.out.println(sql);
    	try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static List<Integer> find(String mail){
    	idList=new ArrayList<Integer>();
    	String sql="select * from link_hr_offer where mail='"+mail+"'";
    	System.out.println(sql);
    	ResultSet rs;
    	try {
			rs=statement.executeQuery(sql);
			while(rs.next()){
				idList.add(rs.getInt(mail));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}    	
    	return idList;
    }
}
