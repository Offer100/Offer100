package dao;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javassist.bytecode.Descriptor.Iterator;
public class FrequencyDA {
	static private Jedis jedis=null;
	public FrequencyDA() {
		// TODO Auto-generated constructor stub
	}
     public static void getConnection(){
		///try {
			//仅当jedis未初始化时链接
			//if(jedis==null)
				jedis = new Jedis("127.0.0.1", 6379);

		//}catch(Exception e){
			//already connect
		//}
    	 System.out.println("Redis链接成功！");
    	 System.out.println("Server is running: "+jedis.ping());
     }
     /****************************************更新数据库（在指定关键字，当前日期的频率上加1）********************************************************/
     public static void update(String key,String day){
    	     String nowDay ;   	
    		 Date now=new Date();
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        	 nowDay = dateFormat.format( now ); 
        	 if(day!=null){
        		nowDay=day; 
        	 }    	 
    	 //查询关键词对应的日期是否存在，若存在，点击量+1；若不存在，新增一个域，初始化为1
    		 jedis.hincrBy(key, nowDay, 1);    	 
     }
    /*******************************************定时更新所有关键词的频率***************************************************/
    public static void TimedUpdate(int hour,int minute,int second){
    	Calendar cal=Calendar.getInstance();//（系统中最好设置为0.0.0）
    	cal.set(Calendar.HOUR_OF_DAY, hour);
    	cal.set(Calendar.MINUTE, minute);
    	cal.set(Calendar.SECOND, second);
    	Timer timer=new Timer();
    	timer.schedule(new TimerTask(){
    		public void run(){
    			//获取所有关键词
    			Set<String> keys=jedis.keys("*");
    			//获取今天的日期
    			String nowDay ;   	
    	    	Date now=new Date();
    	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
    	        nowDay = dateFormat.format( now ); 
    			//循环判断今天是否有点击，若有，则不更新；若没有，则添加今天的时间域，初始化为0；
    	        //判断今天是否有点击：因为服务器开启在人工设置时间后，更新时间则不是人工设置的时间，而是服务器开启时间；
    	        java.util.Iterator<String> it=keys.iterator();
    	        while(it.hasNext()){
    	        	//判断今天的时间域是否存在
    	        	String key=(String)it.next();
    	        	//如果不存在，初始化为0
    	        	if(!jedis.hexists(key, nowDay)){
    	        		 jedis.hincrBy(key, nowDay, 0); 
    	        	}
    	        }
    		}
    	}
    		,cal.getTime());
    	
    	
    }
    /************************获取指定天数搜索频率的所有相关函数**************************************************/
     //获取数据库的所有日期并排序
	public static List<String> initialDate(String key){
		List<String> dateList=new ArrayList<String>();
    	 Set<String> keys=jedis.hkeys(key);
    	 String[] fields=keys.toArray(new String[0]);
    	 for(int i=0;i<fields.length;i++){
    		// System.out.println(fields[i]);
    		 dateList.add(fields[i]);
    	 }
    	 Collections.sort(dateList);//排序结果从小到大
    	 System.out.println("***************日期从小到大排列********************");
    	 for(int i=0;i<dateList.size();i++){
    		 System.out.println(dateList.get(i));
    	 }
    	 Collections.reverse(dateList);
    	 return dateList;
     }
     //查找数据库里面的所有记录，返回次数
     public static int[] searchTimes(String key,List<String> dateList){
    	 int[] results_times=new int[dateList.size()];
    	 for(int i=0;i<dateList.size();i++){
    		 results_times[i]=Integer.parseInt(jedis.hget(key, dateList.get(i)));
    	 }
    	 return results_times;
     }
     //获取指定天数的记录（日期和次数），参数：关键词；排好序的日期(从小到大)List集合；所需天数；
     public static Map<String,Integer> searchAll(String key,int day){
    	 
    	 List<String> dateList=new ArrayList<String>();
    	 dateList=initialDate(key);
    	 int[] results_times=new int[dateList.size()];
    	 results_times=searchTimes(key, dateList);
    	 if(day>dateList.size()){
    		 System.out.println("超出数据库的天数范围,只能显示"+dateList.size()+"天的数据");
    		 day=dateList.size();
    	 }
    	 //有序Map
    	 Map<String,Integer> searchAll=new LinkedHashMap<String,Integer>();
    	 for(int i=0;i<day;i++){
    		 searchAll.put(dateList.get(i),results_times[i]);
    	 }
    	 //遍历map；
    	 for(Map.Entry<String, Integer>entry:searchAll.entrySet()){
    		 System.out.println("key= " + entry.getKey() + " and value= "
    				                    + entry.getValue());
    	 }
    	 return searchAll;
     }
     /******************************测试函数**************************************************/
//	public static void main(String[] args){
//    	 FrequencyDA.getConnection();
////    	 Map<String,Integer> search=new HashMap<String,Integer>();
////    	 search=FrequencyDA.searchAll("java", 10);
//    	 FrequencyDA.TimedUpdate(9, 40, 0);
//    	 
//     }
}
