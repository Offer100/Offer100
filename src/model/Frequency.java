package model;
import java.util.HashMap;
import java.util.Map;

import db.FrequencyDA;
public class Frequency {
	  /****************************构造方法********************************************/
      public Frequency(){    	  
      }
     /********************************查找函数*****************************************/
      //参数：关键词key；指定天数k；
      public Map<String,Integer> searchAll(String key,int day){
    	  FrequencyDA.getConnection();
    	  Map<String,Integer> search=new HashMap<String,Integer>();
    	  search=FrequencyDA.searchAll(key, day);
    	  return search;
      }
      /*******************************更新函数******************************************/
      //参数day是为了手动向数据库添加测试数据（格式：2017-01-01）而设置的，
      //后期在使用软件的时候，day值传null即可；
      public void update(String key,String day){
    	  FrequencyDA.getConnection();
    	  FrequencyDA.update(key,day);
      }
      
}
