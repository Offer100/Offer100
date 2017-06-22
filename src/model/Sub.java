package model;
import java.io.*;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import db.hrDA;
import db.subDA;
import db.NotFoundException;

public class Sub implements Serializable{
     /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private String mail;        //��ҵ����
     private String direction;   //����
     /*���������Ƹ��Ϣ����*/
//     private List<Offer> list=new ArrayList<Offer>();
     /****************************���ֹ��췽��***************************/
     public Sub(){
    	 super();
     }
     public Sub(String mail,String direction){
    	  super();
    	  setMail(mail);
    	  setDirection(direction);
      }
     /*************************get��set����******************************/
     public void setMail(String mail ){
    	  this.mail=mail;
      }
     public void setDirection(String direction){
    	  this.direction=direction;
      }
     public String getMail(){
    	  return mail;
      }
     public String getDirection(){
    	  return direction;
      }
     /******************************************************************/
//     public List<comment>getlist(){
//    	 return list;
//     }
//     public void setList(List<comment> list){
//    	 this.list=list;
//     }
     /****************************��������****************************/
     //������û�
     public void add(){
    	 subDA.getConnection();
    	 subDA.add(this);
    	 subDA.terminate();
     }
     //������������û���Ϣ
   /*  private HR find(String mail) throws NotFoundException{
    	 subDA.getConnection();
    	 Sub aSub=subDA.find(mail);
    	 subDA.terminate();
    	 return aHR;
     }
     //����û���¼�ʺ������Ƿ�һ�£�����ֹsqlע��
     private boolean check(HR aHR) throws SQLException{
    	 hrDA.getConnection();
    	 boolean gotIt=hrDA.checkUser(aHR);
    	 hrDA.terminate();
    	 return gotIt;
     }*/
     
}
