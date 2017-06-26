<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page language="java" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--导入javabean-->
<%@ page import="model.Offer" %>
<%
	String wrongMsg=(String)session.getAttribute("wrongMsg");
	if(wrongMsg==null||wrongMsg.equals("")){}
	else{
%>
	<script type="text/javascript">
		alert("<%=wrongMsg%>");
	</script>
	<%		//取消wrongMsg；
			session.setAttribute("wrongMsg","");
	}
	%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理招聘信息</title>
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!--web-font-->
<link href='https://fonts.googleapis.com/css?family=Marvel:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//web-font-->
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Plot Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- //js -->	
<!-- start-smoth-scrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>	
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
</script>
<!--//end-smoth-scrolling-->
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!--side-bar-->
					<div class="col-sm-3 col-md-2 sidebar">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt="logo"/></a>
				</div>
				<div class="top-nav">
					<span class="menu-icon"><img src="images/menu-icon.png" alt=""/></span>	
					<div class="nav1">
						<ul class=" nav nav-sidebar">
							<li ><a href="HR_home.jsp">主页</a></li>
							<li class="active"><a href="HR_newInfo.jsp">发布</a></li>
							<li><a href="HR_search.jsp">查询</a></li>
							<li><a href="HR_management.jsp">管理</a></li>
						</ul> 
						<div class="social-icons">
							<ul>
								<li><a href="#"></a></li>
								<li><a href="#" class="fb"></a></li>
								<li><a href="#" class="be"></a></li>
								<li><a href="#" class="gg"></a></li>
							</ul>	
						</div>						
					</div>	
					<!-- script-for-menu -->
						 <script>
						   $( "span.menu-icon" ).click(function() {
							 $( ".nav1" ).slideToggle( 300, function() {
							 // Animation complete.
							  });
							 });
						</script>
						<!-- /script-for-menu -->
				</div>
				<div class="clearfix"> </div>				
				<p>Copyright &copy;offer100</p>
			</div>
			<!--//side-bar-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main about-main manager">
			<div class="services">
			<p>请输入要删除的职位和发布的时间进行查询</p>
			</div>
				<form id="deleteForm" method="post" action="control/ManageJobInfoServlet">
			<input type="text" value="职位" name="position" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '职位';}" required="">
			<input type="text" value="发布时间..输入格式yyyy-mm-dd" name="date-time" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '发布时间..输入格式yyyy-mm-dd';}" required="">
			<input type="submit" value="查找" name="search">
				</form>
			</div>
			<div class="clearfix"> </div>
			
			<%
				ArrayList<Offer> list = (ArrayList<Offer>) session.getAttribute("delete_list");
				if(list==null||list.size()>0){
				    //list不存在或为空
				    //
			}else{%>

			<table>
				<form method="post" action="control/DeleteInfoServlet">
			<%for (int i=0;i<list.size();i++){
				Offer myOffer;
				myOffer=(Offer)list.get(i);
				out.println("<tr><td><input type=\"checkbox\" name=\"delete-name\" value=\""+myOffer.getId()+"\"></td><td>"+myOffer.getJobName()+"</td><td>"+myOffer.getTime()+"</td></tr>");
			}
			out.println("<td><input type='submit' name='delete_btn' value='删除'onclick='check_box()'></td>");
			}
			%>
					<input type="text" name="id_box" style="display: none" ></input>
				</form>
			</table>


			<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
     <script type="text/javascript">
     function check_box(){
     	var obj=document.getElementsByName("delete-name");
     	var form=document.getElementById("deleteForm");
     	var check_val=new Array();
     	for(k in obj){
     		if(obj[k].checked)
     			check_val.push(obj[k].value)
     	}
     	document.getElementsByName("id_box").value=check_val;
		 form.submit();
     }
     </script>
</body>
</html>