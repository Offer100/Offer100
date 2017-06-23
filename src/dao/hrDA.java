package dao;
import model.HR;

import java.sql.*;

public class hrDA {
	static HR hr;                     
 	static Connection connection=null; 
 	static Statement statement=null;   
 	static PreparedStatement pps=null; 
 	
 	static String driver="com.mysql.jdbc.Driver";
	static String jdbcUrl="jdbc:mysql://localhost:3306/offer100";	  
	static String user="root";
	static String password="wasd";
    /**************************************数据库链接**********************************************/
   	public static Connection getConnection() {  	  
    	try{
    		//������������    		
			Class.forName(driver);			
    		//�������ݿ�
    		connection=DriverManager.getConnection(jdbcUrl,user,password);
    		statement=connection.createStatement();
    		System.out.println("hr数据库链接成功!");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    	return connection;		
   	}
   	/****************************************关闭数据库*********************************************/
    public static void terminate(){   	
    	try {
    		statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**************************************hr信息查找******************************************/
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
    			throw new NotFoundException("信息不存在");
    		}
    		rs.close();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	return hr;
    }
    /***************************************注册一个用户**********************************************/
    public static void add(HR aHR){
    	String sql="insert into login_table(mail,password) values('"
    			+aHR.getMail()+"','"+aHR.getPassword()+"')";
    	System.out.println(sql);
    	try {
			statement.executeUpdate(sql);
			System.out.println("hr添加成功!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /****************************用户登录帐号密码匹配检测，并防止sql注入******************************/
    public static boolean checkUser(HR aHR) throws SQLException{
    	String sql="select * from login_table where mail=? and password=?";
    	ResultSet rs=null;
    	try {
			pps=connection.prepareStatement(sql);
			pps.setString(1, aHR.getMail());
	    	pps.setString(2, aHR.getPassword());
	    	rs=pps.executeQuery();	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs.next();
    }
}
