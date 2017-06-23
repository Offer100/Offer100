<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JobSearch——page</title>
</head>
<body>
   <div id="background" style="position:absolute; left:0px; top:0px; width:100%; height:100%;">
      <img src="images/backgroundForJobSearch.jpg" width="100%" height="100%"/>
       <div style="position:absolute;width:100%;height:100%;z-indent:2;left:0;top:0;"id="searchpage">
      <div style="text-align:right;">
       <br /><br />
       <a href="TrendSearchers.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>搜索指数</b></a>&nbsp
        <a href="login.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>登录/注册</b></a>&nbsp;&nbsp;&nbsp;&nbsp;
       </div> 
       <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
       <div style="text-align:center">
        <p style="text-align:center;font-size:20px;font-family:'华文新魏';">让优秀的人才遇见更好的机会</p>
        <br /><br />
           <form method="post" action="control/JobSearcherServlet">
           <div style="display:inline;font-size:25px;font-family:'宋体';">
            <b>职位关键词</b>
            </div>
            <div style="display:inline;">
              <input type="text" id="keyword" name="keyword" style="width:400px;height:25px;vertical-align:top;">
             </div>
             <div style="display:inline">
             <input type="submit" style="border-radius:12px;font-family:'宋体';font-size:25px;" value="找工作" >
             </div>
             <p style="font-family:'宋体';font-size:14px;color:#666">职务名称、行业类别、公司名字、工作地点或者工作技能等</p>
           </form>
        </div>
       </div>
   </div>
</body>
</html>
