package dao;
import model.HR;
import model.Offer;

import java.sql.*;
import java.util.List;

public class hrDA {
	static HR hr;                      //hr����
 	static List<Offer> list;           //��Ƹ��Ϣ��list����
 	static Connection connection=null; //������
 	static Statement statement=null;   //sql���ԵĲ�����
 	static PreparedStatement pps=null; //��ֹsqlע��

 	static String driver="com.mysql.jdbc.Driver";
	static String jdbcUrl="jdbc:mysql://localhost:3306/offer100";
	static String user="root";
	static String password="wasd";
    /**************************************�������ݿ�**********************************************/
   	public static Connection getConnection() {
    	try{
    		//������������
			Class.forName(driver);
    		//�������ݿ�
    		connection=DriverManager.getConnection(jdbcUrl,user,password);
    		statement=connection.createStatement();
    		System.out.println("Succeed connecting database!");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    	return connection;
   	}
   	/****************************************�ر����ݿ�*********************************************/
    public static void terminate(){
    	try {
    		statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**************************************����������û�******************************************/

    public static HR find(String mail) throws NotFoundException{
    	hr=new HR();
    	String sql="select * from login_table where mail='"+mail+"'";
    	System.out.println(sql);
    	try{
    		ResultSet rs=statement.executeQuery(sql);
    		boolean gotIt=rs.next();
    		if(gotIt){
    			hr.setMail(rs.getString(1));
    			hr.setPassword(rs.getString(2));
    		}else{

    			throw new NotFoundException("�û������ڣ�");

    		}
    		rs.close();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	return hr;
    }
    /****************************************�û�ע��**********************************************/
    public static void add(HR aHR){
    	String sql="insert into login_table(mail,password) values('"
    			+aHR.getMail()+"','"+aHR.getPassword()+"')";
    	System.out.println(sql);
    	try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /****************************���������ʺ��Ƿ�ƥ�䣬����ֹsqlע��******************************/
    public static boolean checkUser(HR aHR) throws SQLException{
    	String sql="select * from login_table where mail=? and password=?";
    	ResultSet rs=null;
    	try {
			pps=connection.prepareStatement(sql);
			//��������ֵ����set
			pps.setString(1, aHR.getMail());
	    	pps.setString(2, aHR.getPassword());
	    	rs=pps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs.next();
    }
    /***************************************�ӿڷ�����д*******************************************/

	public static void main(String[] args)throws Exception{
//		hrDA user=new hrDA();
//		hrDA.getConnection();
	}

}
