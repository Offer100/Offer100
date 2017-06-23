<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TrendSearchers-Page</title>
</head>
<body>
   <div id="background" style="position:absolute; left:0px; top:0px; width:100%; height:100%;">
      <img src="images/background1ForTrendSearchers.jpg" width="100%" height="100%"/>
       <div style="position:absolute;width:100%;height:100%;z-indent:2;left:0;top:0;" name="TrendSearchers">
      <div style="text-align:right;">
       <br /><br />
       <a href="HR_home.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>回到首页</b></a>&nbsp
        <a href="login.jsp" style="color:#000;font-family:'宋体';font-size:20px;"><b>登录/注册</b></a>&nbsp;&nbsp;&nbsp;&nbsp;
       </div> 
       <br /><br /><br /><br /><br /><br />
       <br /><br /><br /><br /><br /><br />
       <br /><br /><br />
           <form method="post" action="control/TrendSearcherServlet">
       <div style="text-align:center">
           <div style="display:inline;font-size:25px;font-family:'宋体';">
            <b>职位关键词</b>
            </div>
            <div style="display:inline;">
              <select  style="width:400px;height:25px;vertical-align:top;" name="hotword" id="hotword">
                 <option id=".net">.NET</option>
                 <option id="c#">C#</option>
                 <option id="c/c++">C/C++</option>
                 <option id="java">Java</option>
                 <option id="javascript">JavaScript</option>
                 <option id="object-c">Object-C</option>
                 <option id="php">php</option>
                 <option id="python">Python</option>
                 <option id="r">R</option>
              </select>
             </div>
             <div style="display:inline">
             <input type="submit" style="border-radius:12px;font-family:'宋体';font-size:25px;" name="TrendSearchers" value="搜索指数">
             </div>
        </div>
           </form>
       </div>
   </div>
</body>
</html>
