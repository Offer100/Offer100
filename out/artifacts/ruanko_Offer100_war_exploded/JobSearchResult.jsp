<%@ page import="model.Offer" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html >
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TrendSearchersResult-Page</title>
</head>
<body>
   <div id="background" style="position:absolute; left:0px; top:0px; width:100%; height:100%;">
      <img src="background1ForJobSearchResult.jpg" width="100%" height="100%"/>
    <div style="position:absolute;width:100%;height:100%;z-indent:2;left:0;top:0;background-color:rgba(210,210,210,0.6); "id="searchResultPage"> 
      <div style="text-align:right;">
       <br /><br />
       <a href="JobSearch.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>回到首页</b></a>&nbsp
        <a href="login.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>登录/注册</b></a>&nbsp;&nbsp;&nbsp;&nbsp;
       </div> 
       <br /><br />
        <div>
          <div id="TrendSearchersResult" style="display:inline;width:85%;float:left;">
           <p style="margin-left:10%;font-family:'宋体';font-size:35px;font-weight:900;">招聘结果显示</p>
           <div style="margin-left:2%;margin-right:96%;float:left;font-size:15px;width:96%;">
             <p style="font-size:12px">（查看详情点击职务名称）</p>
                <table border="1" width="100%" style="background-color:rgba(255,255,255,0.9);border-color:#FFC">
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
                     <%
                         ArrayList list = (ArrayList) session.getAttribute("search_list");
                         if(list!=null){
                             Offer myOffer=null;
                     %>
                       <form action="control/ToOfferDetailsServlet" method="post" id="offer" >
                      <%for(int i=0;i<list.size();i++){
                        myOffer=(Offer)list.get(i);
                        out.println(" <tr>");
                        out.println("<td style=\"text-align:center;\"><a href=\"javascript:getOfferId("+i+")\">"+i+"</a>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getJobName()+"</td>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getCompanyName()+"</td>");
                        out.println("<td syle=\"text-align:center;\">"+myOffer.getAdress()+"</td>");
                        out.println("<td style=\"text-align:center;color:#F00;\">"+myOffer.getMonthSalary()+"</td>");
                        out.println("<td style=\"text-align:center;\">"+myOffer.getTime()+"</td>");
                        out.println("</tr>");}
                      }
                      %>
                           <input type="text" class="btn" name="GetOfferId" id="GetOfferId" value="" style="display: none;"/>
                    </form>
                </table>
           </div>
           </div>
          
            <div id="subscription" style="display:inline;width:14%;float:left;height:250px;background-color:rgba(210,210,210,0.6);"> <br /><br />
           <p style="text-align:center;font-size:20px;font-family:'宋体';"><b>订阅招聘信息</b></p>
           <p style="text-align:left;font-size:18px;font-family:'宋体';margin-left:5%;">我的电子邮箱地址：</p>
                <form method="post" action="control/SubscriptionServlet">
           <input  type="text" id="email" style="width:80%;height:20px;margin-left:5%;"/>
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
