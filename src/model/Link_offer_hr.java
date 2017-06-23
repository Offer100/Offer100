package model;



import dao.Link_offer_hrDA;

import java.util.ArrayList;
import java.util.List;

public class Link_offer_hr {
      private int id;
      private String mail;
      /**************************构造方法*********************************/
     public Link_offer_hr(){
    	
     }
	 public Link_offer_hr(int id, String mail) {
		super();
		this.id = id;
		this.mail = mail;
	 }
	 /**************************get和set方法*****************************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	/******************************其他方法**********************************/
	public void add(int id,String mail){
		Link_offer_hrDA.getConnection();
		Link_offer_hrDA.add(id, mail);
	}
	public List<Integer> find(String mail){
		List<Integer> idList=new ArrayList<Integer>();
		Link_offer_hrDA.getConnection();
		idList=Link_offer_hrDA.find(mail);
		return idList;
	}
}
