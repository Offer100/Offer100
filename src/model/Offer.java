package model;

import dao.OfferDA;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Offer implements Serializable {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
       private String CompanyName;
       private String JobName;
       private String WorkSkill;
       private String MonthSalary;
       private String Contact;
       private String OtherInformation;
       private String Time;
       private String AllString;
       
       private String IndustryCatalog;//ְ职业种类：IT，教育，金融
       private String JobType;//工作类型：全职，实习，应届
       private String Adress;//地址;
       
       /***************************���췽��*****************************************/
       public Offer(){
    	   super();
       }
	    
	    public Offer(String companyName, String jobName, String workSkill, String monthSalary, String contact,
			String otherInformation, String time, String allString, String industryCatalog, String jobType,
			String adress) {
		super();
		CompanyName = companyName;
		JobName = jobName;
		WorkSkill = workSkill;
		MonthSalary = monthSalary;
		Contact = contact;
		OtherInformation = otherInformation;
		Time = time;
		AllString = allString;
		IndustryCatalog = industryCatalog;
		JobType = jobType;
		Adress = adress;
	    }
        /************************get和set方法******************************************/
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCompanyName() {
			return CompanyName;
		}

		public void setCompanyName(String companyName) {
			CompanyName = companyName;
		}

		public String getJobName() {
			return JobName;
		}

		public void setJobName(String jobName) {
			JobName = jobName;
		}

		public String getWorkSkill() {
			return WorkSkill;
		}

		public void setWorkSkill(String workSkill) {
			WorkSkill = workSkill;
		}

		public String getMonthSalary() {
			return MonthSalary;
		}

		public void setMonthSalary(String monthSalary) {
			MonthSalary = monthSalary;
		}

		public String getContact() {
			return Contact;
		}

		public void setContact(String contact) {
			Contact = contact;
		}

		public String getOtherInformation() {
			return OtherInformation;
		}

		public void setOtherInformation(String otherInformation) {
			OtherInformation = otherInformation;
		}

		public String getTime() {
			return Time;
		}

		public void setTime(String time) {
			Time=time;
		}

		public String getAllString() {
			return AllString;
		}

		public void setAllString(String allString) {
			AllString = allString;
		}

		public String getIndustryCatalog() {
			return IndustryCatalog;
		}

		public void setIndustryCatalog(String industryCatalog) {
			IndustryCatalog = industryCatalog;
		}

		public String getJobType() {
			return JobType;
		}

		public void setJobType(String jobType) {
			JobType = jobType;
		}

		public String getAdress() {
			return Adress;
		}

		public void setAdress(String adress) {
			Adress = adress;
		}
		/***********************************其他方法
		 * @throws InvocationTargetException 
		 * @throws IllegalArgumentException 
		 * @throws IllegalAccessException 
		 * @throws SecurityException 
		 * @throws NoSuchMethodException ***************************************/
		//增加一条招聘信息，参数是对象
		public void add(Offer offer,String mail) throws NoSuchMethodException, 
		                                                 SecurityException, 
		                                                 IllegalAccessException, 
		                                                 IllegalArgumentException, 
		                                                 InvocationTargetException{
			OfferDA.getConnection();
			OfferDA.add(offer,mail);
			OfferDA.terminate();
		}
		//查询所有招聘信息返回对象list，参数是mail；
		public  List<Offer> find(String mail){
			List<Offer> offerList=new ArrayList<Offer>();
			OfferDA.getConnection();
			offerList=OfferDA.find(mail);
			OfferDA.terminate();
			return offerList;
		}
		//删除一条招聘信息
		public void delete(int id,String mail){
			OfferDA.getConnection();
			OfferDA.delete(id, mail);
			OfferDA.terminate();
		}	
}
