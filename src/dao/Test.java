package dao;

import model.Frequency;


public class Test {
/************************测试hr***********************************/	
//	public static void main(String[] args) {
//		HR hr=new HR("12345678@qq.com","12345678");
//		hr.add(hr);
//	}
/***********************测试redis**************************************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Frequency frenquency=new Frequency();
		 frenquency.update("java","2017-06-21");
         frenquency.searchAll("java", 10);
        
	}
/*******************************测试offer*******************************/
//	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//		Offer offer=new Offer();
////		List <Offer> offerList=new ArrayList<Offer>();
////		Offer offer2=new Offer("华科","产品经理","python","10000","1715123874","no","2017-07-08","no","IT","实习","深圳");
//        try {
////        	offer2.add(offer2, "1715123874@qq.com");  //添加一条招聘信息      	
////        	offerList=offer.find("1715123874@qq.com");//超找一个用户发布的所有招聘信息
////        	System.out.println(offerList.size());
////        	for(int i=0;i<offerList.size();i++){
////        		offer=offerList.get(i);
////        		System.out.println(offer.getId()+offer.getWorkSkill());
////        	}
//		    offer.delete(69, "1715123874@qq.com");
////			
//		} catch (SecurityException e) {
////			// TODO Auto-generated catch block
////		     e.printStackTrace();
//		} catch (IllegalArgumentException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}      
//	}
/*****************************测试订阅*****************************************/
//	public static void main(String[] args) {
//		Sub sub=new Sub("12345678@qq.com","java");
//        sub.add();
//	}
}
