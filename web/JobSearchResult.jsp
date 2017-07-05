<%@ page import="model.Offer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html >
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <%
        String wrongMsg=(String)session.getAttribute("wrongMsg");
        if(wrongMsg==null||wrongMsg.equals("")){
            //不弹窗
        }else{
    %>
    <script type="text/javascript">
        alert("<%=wrongMsg%>");
    </script>
    <%}
        session.setAttribute("wrongMsg","");
    %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script type="text/javascript" language="javascript" src="js/fenye.js">
    </script>
	<script type="text/javascript" language="javascript" src="js/gettab.js">
	</script>
    <style>
	.P_Font{ font-size:12px;color:#0088DD; text-decoration:none; cursor:pointer;}
	.P_Font:hover{ font-size:12px;color:#0088DD; text-decoration:underline; cursor:pointer;}
	.P_DISABLE{font-size:12px;}
</style>
<title>TrendSearchersResult-Page</title>
</head>
<body onload="getdata()">
   <div id="background" style="position:absolute; left:0px; top:0px; width:100%; height:100%;">
    <div style="position:absolute;width:100%;height:100%;z-indent:2;left:0;top:0; " id="searchResultPage"> 
      <div style="text-align:right;">
       <br /><br />
       <a href="JobSearch.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>回到首页</b></a>&nbsp
        <a href="login.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>登录/注册</b></a>&nbsp;&nbsp;&nbsp;&nbsp;
       </div> 
       <br /><br />
     <div>
       <div id="TrendSearchersResult" style="float:left;display:inline;width:75%;margin-left:2%">
         <p style="display:inline;font-size:50px;font-family:'华文新魏';">&nbsp招聘结果显示
         </p>    
         <p style="font-size:12px">（查看详情点击职务名称）</p>
                <table id="table1" border="1" width="100%" style="background-color:rgba(255,255,255,0.9);border-color:#FFC">
                     <tr>
                         <td style="text-align:center;width:5%;color:#444;">
                             <b>编号</b>
                         </td>
                       <td style="text-align:center;width:15%;color:#444;">
                        <b>职务名称</b>
                       </td>
                       <td style="text-align:center;width:20%;color:#444;">
                        <b>公司名</b>
                       </td>
                       <td style="text-align:center;width:15%;color:#444;">
                        <b>工作地点</b>
                       </td>
                       <td style="text-align:center;width:20%;color:#444;">
                        <b>薪资</b>
                       </td>
                       <td style="text-align:center;color:#444;width:20%;">
                        <b>发布时间</b>
                       </td>         
                     </tr>
                     <tbody id="group_one">
                     <%
                         List<Offer> list = (ArrayList<Offer>) session.getAttribute("search_list");
                         if(list!=null){
                             Offer myOffer=null;
                     %>
                       <form action="control/ToOfferDetailsServlet" method="post" id="offer2" >
                      <%for(int i=0;i<list.size();i++){
                        myOffer=(Offer)list.get(i);
                        out.println(" <tr>");
                        out.println("<td style=\"text-align:center;\"><a href=\"javascript:getOfferId2("+myOffer.getId()+")\">"+i+"</a>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getJobName()+"</td>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getCompanyName()+"</td>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getAdress()+"</td>");
                        out.println("<td style=\"text-align:center;color:#F00;\">"+myOffer.getMonthSalary()+"</td>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getTime()+"</td>");
                        out.println("</tr>");}
                      }
                      %>
                           <input type="text" class="btn" name="GetOfferId" id="GetOfferId" value="" style="display: none;"/>
                     </form>
                    </tbody>
                </table>
                <span id="s"></span>
	            <table>
		           <tr>
			         <td style="width:15%;text-align:center;"><span id ="first" onclick="page.firstPage();" class="P_Font">首页</span></td>
			          <td style="width:15%;text-align:center;"><span id ="pre" onclick="page.prePage();" class="P_Font">上一页</span></td>
			          <td style="width:15%;text-align:center;">第<span id="pageindex" class="P_Font">1</span>页</td>
			         <td style="width:15%;text-align:center;"><span id ="next" onclick="page.nextPage();" class="P_Font">下一页</span></td>
			          <td style="width:15%;text-align:center;"><span id ="last" onclick="page.lastPage();" class="P_Font">尾页</span></td>
			          <td style="width:15%;text-align:center;">第<select id="pageselect" onchange="page.changePage();" class="P_Font"></select>页</td>
		            </tr>
	             </table>
           </div>
          <br /><br /><br /><br /><br /><br />
            <div id="subscription" style="display:inline;width:14%;float:left;height:250px;background-color:rgba(210,210,210,0.6);margin-left:1%"> <br />
           <p style="text-align:center;font-size:20px;font-family:'宋体';"><b>订阅招聘信息</b></p>
           <p style="text-align:left;font-size:18px;font-family:'宋体';margin-left:5%;">我的电子邮箱地址：</p>
                <form method="post" action="control/SubscriptionServlet">
           <input  type="text" name="email" style="width:80%;height:20px;margin-left:5%;"/>
           <select name="industry-category"
                   style="width:81%;height:20px;margin-left:5%;">
               <option id="IT">IT</option>
               <option id="教育">教育</option>
               <option id="金融">金融</option>
           </select>
           <br />
                    <input type="submit" id="startSubscription" name="startSubscription" style="width:35%;margin-left:5%;border-radius:12px;font-family:'宋体';font-size:18px;"/>
           <br />
           <p style="font-family:'宋体';font-size:10px;margin-left:8%;color:#666">您可以随时取消招聘提醒</p>
                </form>
           </div>
         </div>
       </div>
   </div>
   <script src="js/JobSearchResultJS.js"></script>
</body>
</html>
