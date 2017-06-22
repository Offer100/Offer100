package db;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javassist.bytecode.Descriptor.Iterator;
import redis.clients.jedis.*;
public class FrequencyDA {

	static private Jedis jedis;
	public FrequencyDA() {
		// TODO Auto-generated constructor stub
	}
     public static void getConnection(){
    	 jedis=new Jedis("localhost");
    	 System.out.println("Redis链接成功！");
    	 System.out.println("Server is running: "+jedis.ping());
     }
     /****************************************更新数据库的所有操作********************************************************/
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
//    	 Map<String,Integer> search=new HashMap<String,Integer>();
//    	 search=FrequencyDA.searchAll("java", 10);
//     }
}
