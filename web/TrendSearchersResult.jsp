<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <%
        String wrongMsg=(String)session.getAttribute("wrongMsg");
        if(wrongMsg==null&&wrongMsg.equals("")){
            //不显示弹窗
        }else{
    %>
    <script type="text/javascript">
        alert("<%=wrongMsg%>");
    </script>
    <%}%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TrendSearchersResult-Page</title>
</head>
<body>
   <div id="background" style="position:absolute; left:0px; top:0px; width:100%; height:100%;">
      <img src="images/background2ForTrendSearchersResult.jpg" width="100%" height="100%"/>
       <div style="position:absolute;width:100%;height:100%;z-indent:2;left:0;top:0;"id="hotwordpage"> 
      <div style="text-align:right;">
       <br /><br />
       <a href="HR_home.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>回到首页</b></a>&nbsp
        <a href="login.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>登录/注册</b></a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="TrendSearchers.jsp"><b>返回查询界面</b></a>&nbsp;&nbsp;&nbsp;&nbsp;
       </div> 
       <br /><br />
           <br /><br />
           <br /><br />

           <div id="result-box">
          <div id="TrendSearchersResult" style="display:inline;width:60%;float:left;">
            <p style="margin-left:20%;font-size:25px;font-family:'宋体';"><b>搜索指数整体趋势</b></p>
             <img src="" style="margin-left:5%;width:80%;" />
           </div>
           <br /><br /><br />
               <form method="post" action="/control/SubscriptionServlet">
           <div id="subscription" style="display:inline;width:25%;float:left;height:220px;background-color:rgba(210,210,210,0.9);">
           <p style="text-align:center;font-size:22px;font-family:'宋体';"><b>订阅本次搜索结果</b></p>
           <p style="text-align:left;font-size:20px;font-family:'宋体';margin-left:5%;">我的电子邮箱地址：</p>
           <input  type="text" id="email" name="email" style="width:80%;height:20px;margin-left:5%;"/>
           <br />
               行业类别：
               <select name="industry-category">
                   <option value="IT">IT</option>
                   <option value="finance">金融</option>
                   <option value="education">教育</option>
               </select>
           <input type="submit" id="startSubscription" name="startSubscription" style="width:35%;margin-left:5%;border-radius:12px;font-family:'宋体';font-size:18px;"/>
           <br /><br />
           <p style="font-family:'宋体';font-size:10px;margin-left:8%;color:#666">您可以随时取消招聘提醒</p>
           </div>
               </form>
         </div>
       </div>
   </div>
</body>
</html>
