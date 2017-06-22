<!DOCTYPE html>
<html>
<head>
	<%@ page contentType="text/html; charset=UTF-8" %>
<title>发布新招聘信息</title>
<meta charset="gb2312">
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

<script src="js/jquery-1.11.1.min.js"></script> 
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
	
					<!-- script-for-menu -->
						 <div class="col-sm-3 col-md-2 sidebar">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt="logo"/></a>
				</div>
				<div class="top-nav">
					<span class="menu-icon"><img src="images/menu-icon.png" alt=""/></span>	
					<div class="nav1">
						<ul class=" nav nav-sidebar">
							<li ><a href="HR_home.html">主页</a></li>
							<li class="active"><a href="HR_newInfo.jsp">发布</a></li>
							<li><a href="HR_search.jsp">查询</a></li>
							<li><a href="HR_delete.jsp">管理</a></li>
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

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			
			<div class="col-md-8 info-form ">
				<h4>发布新招聘信息</h4>
				<form>
				<label>招聘公司：<input type="text"name="company">
				工作地点：
					<select name="workplace">
					<option value="wuhan">武汉</option>
					<option value="beijing">北京</option>
					<option value="hangzhou">杭州</option>
					<option value="shanghai">上海</option>
					<option value="shenzhen">深圳</option>
					<option value="guangzhou">广州</option>
				</select></label>
				<label>
				</input>职务名称：<input type="text"name="position"></input>
				行业类别：
				<select name="industry-category">
					<option value="IT">IT</option>
					<option value="finance">金融</option>
					<option value="education">教育</option>
				</select>
				</label>
				<label>工作技能：<input type="text"name="work-skill" ></input>工作薪酬：<input type="text" name="wage" ></input></label>
				<label>联系方式：<input type="text" name="phone"></input>
				工作类型：
					<select name="job_category">
						<option value="intern">实习</option>
						<option value="full_time">全职</option>
						<option value="fresh">应届</option>
					</select></label>
					<label><textarea type="text" name="details" class="det" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '详细信息...';}" required="">详细信息...</textarea></label>
					<input type="submit" name="submit" value="提交"></input>
				</form>
			</div>
			</div>

	</div>	

	</div>
    <script src="js/bootstrap.js"> </script>
</body>
</html>