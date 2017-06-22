<!DOCTYPE html>
<html>
<head>
	<%@ page contentType="text/html; charset=UTF-8" %>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Deliccio Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='https://fonts.googleapis.com/css?family=UnifrakturMaguntia' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:600,600italic,700,400' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<!-- FlexSlider -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
						$(window).load(function(){
						  $('.flexslider').flexslider({
							animation: "slide",
							start: function(slider){
							  $('body').removeClass('loading');
							}
						  });
						});
					  </script>
<!-- //FlexSlider -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head>
	
<body>
<!-- banner -->
	<div class="banner">
		<div class="container">
			<div class="header-nav">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
						<div class="logo">
							<a class="navbar-brand" href="login.html">Offer100<span>让优秀的人才遇见更好的机会
							</span></a>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
				</nav>
					</div><!-- /.navbar-collapse -->
			</div>
			<div class="banner-info">
		
				<div class="col-md-6 banner-info-right">
					<div class="sap_tabs">	
						<div id="horizontalTab" style="display: block; width: 100%; margin: 0;">
							<ul class="resp-tabs-list">
							  <li class="resp-tab-item grid1" aria-controls="tab_item-0" role="tab"><span>登录</span></li>
							  <li class="resp-tab-item grid2" aria-controls="tab_item-1" role="tab"><span>注册</span></li>
							  <div class="clear"></div>
							</ul>				  	 
							<div class="resp-tabs-container">
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts">
										<div class="sign-in-form">
											<div class="in-form">
												<form id="HR_SIGN_IN" method="post" action="control/HRLoginServlet">
													<input type="text" name="login_mailbox"placeholder="企业邮箱" required >
													<input type="password" name="login_password"placeholder="密码" required >
												</form>
												<div class="ckeck-bg">
													<div class="checkbox-form">
														<div class="check-left">
															<div class="check">
																<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>记住密码</label>
															</div>
														</div>
														<div class="check-right">
															<form>
																<!--<input type="submit" name="login_btn" value="登录">-->
																<input type="button" name="login_btn" value="登录" onclick="HRLogin(1)">
															</form>
														</div>
														<div class="clearfix"> </div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
										<div class="sign-in-form">
											<div class="in-form Personal">
												
												<form id="HR_SIGN_UP" method="post" action="control/HRSignUpServlet">
													<input type="text" class="textbox" name="register_mailbox" value="输入您的企业邮箱..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入您的企业邮箱...';}">
													<input type="text" class="password" name="register_password" value="输入您的密码..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入您的密码';}">
													<input type="text" class="password" name="check_password" value="确认密码..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '确认密码';}">
												</form>
												<form>
													<!--<input type="submit" name="register_btn" value="注册">-->
                                                    <input type="button" name="register_btn" value="注册" onclick="HRLogin(2)">
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
							<script type="text/javascript">
								$(document).ready(function () {
									$('#horizontalTab').easyResponsiveTabs({
										type: 'default', //Types: default, vertical, accordion           
										width: 'auto', //auto or any width like 600px
										fit: true   // 100% fit in a container
									});
								});
							</script>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-row">
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	
<!--//footer-->	
<!-- for bootstrap working -->
<script src="js/bootstrap.js"> </script>
<script src="js/HRLoginJS.js"></script>
<!-- //for bootstrap working -->
</body>
</html>