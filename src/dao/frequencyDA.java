package dao;
//在一鹏完成之前暂时先注释。
/*
import redis.clients.jedis.*;
public class frequencyDA {
	static int[] results_times=new int[12];
	static private Jedis jedis;
	public frequencyDA() {
		// TODO Auto-generated constructor stub
	}
     public void getConnection(){
    	 jedis=new Jedis("localhost");
    	 System.out.println("���ӳɹ���");
    	 System.out.println("Server is running: "+jedis.ping());
     }
     public static void update(String key,String date){
    	 
     }
     public int[] search(String key,String[] result_date){
    	 for(int n=0;n<result_date.length;n++){
    		 results_times[n]=Integer.parseInt(jedis.hget(key, result_date[n]));
    		 System.out.println(result_date[n]);
    	 }
    	 return results_times;
     }
}
*/