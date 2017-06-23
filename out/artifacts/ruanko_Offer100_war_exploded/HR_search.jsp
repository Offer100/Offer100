<!DOCTYPE html>
<html>
<head>
	<%@ page contentType="text/html; charset=UTF-8" %>
<title>About</title>
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
							<li><a href="index.html">Home</a></li>
							<li class="active"><a href="about.html">About</a></li>
							<li><a href="services.html">Services</a></li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="testmonials.html">Testmonials</a></li>
							<li><a href="contact.jsp">Contact</a></li>
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
				<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
			</div>
			<!--//side-bar-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main about-main">
				<div class="about">
					<h3>About Us</h3>
					<div class="col-md-4 about-grids">
						<img src="images/img7.jpg" alt=""/>
					</div>
					<div class="col-md-4 about-grids">
						<h4>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots</h4>
						<p>Lorem Ipsum was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker 
							including versions.It is a long established fact that a reader will be simply random text. It has roo distracted</p>
					</div>
					<div class="col-md-4 about-grids">
						<ul>
							<li><a href="#">Pestablished fact</a></li>
							<li><a href="#">Apopular belief</a></li>
							<li><a href="#">Vsimply random text</a></li>
							<li><a href="#">Letraset sheetsel </a></li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="about-slid">
					<div class="abt-slid-text">
						<h2>What we do</h2>
						<p>The standard Lorem Ipsum passage, used sincepassage</p>
					</div>
				</div>
				<div class="team">
					<h3>Our Team Members</h3>
					<div class="team-info">
						<div class="col-md-3 about-team-grids">
							<img src="images/img8.jpg" alt=""/>
							<div class="team-text">
								<h5>JOHN DOE</h5>
								<h6>Founder</h6>
							</div>
						</div>
						<div class="col-md-3 about-team-grids">
							<img src="images/img9.jpg" alt=""/>
							<div class="team-text">
								<h5>JERRY JON</h5>
								<h6>Co-founder</h6>
							</div>
						</div>
						<div class="col-md-3 about-team-grids">
							<img src="images/img10.jpg" alt=""/>
							<div class="team-text">
								<h5>JAME MONY</h5>
								<h6>Designer</h6>
							</div>
						</div>
						<div class="col-md-3 about-team-grids">
							<img src="images/img11.jpg" alt=""/>
							<div class="team-text">
								<h5>JOHN SMITH</h5>
								<h6>Developer</h6>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>					
			</div>
			<div class="clearfix"> </div>				
		</div>
	</div>
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
</body>
</html>