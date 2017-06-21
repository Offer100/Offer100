package db;
import java.sql.*;
import java.util.*;
import model.HR;
import model.Offer;

public class hrDA {
	static HR hr;                      //hr对象
 	static List<Offer> list;           //招聘信息的list集合
 	static Connection connection=null; //链接器
 	static Statement statement=null;   //sql语言的操作器
 	static PreparedStatement pps=null; //防止sql注入
 	
 	static String driver="com.mysql.jdbc.Driver";
	static String jdbcUrl="jdbc:mysql://localhost:3306/offer100";	  
	static String user="root";
	static String password="wasd";
    /**************************************链接数据库**********************************************/
   	public static Connection getConnection() {  	  
    	try{
    		//加载驱动程序    		
			Class.forName(driver);			
    		//连接数据库
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
    /**************************************用邮箱查找用户******************************************/
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
    			throw new NotFoundException("用户不存在！");
    		}
    		rs.close();
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	return hr;
    }
    /****************************************用户注册**********************************************/
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
    /****************************检测密码和帐号是否匹配，并防止sql注入******************************/
    public static boolean checkUser(HR aHR) throws SQLException{
    	String sql="select * from login_table where mail=? and password=?";
    	ResultSet rs=null;
    	try {
			pps=connection.prepareStatement(sql);
			//给参数赋值，用set
			pps.setString(1, aHR.getMail());
	    	pps.setString(2, aHR.getPassword());
	    	rs=pps.executeQuery();	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs.next();
    }
    /***************************************接口方法重写*******************************************/
	
	public static void main(String[] args)throws Exception{
//		hrDA user=new hrDA();
//		hrDA.getConnection();
	}

}
