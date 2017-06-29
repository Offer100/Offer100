<%@ page import="model.Offer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
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
<title>Testmonials</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">

<style type="text/css">/* 表格格式 */

	html, body, div, span, object, iframe,
	h1, h2, h3, h4, h5, h6, p, blockquote, pre,
	abbr, address, cite, code,
	del, dfn, em, img, ins, kbd, q, samp,
	small, strong, sub, sup, var,
	b, i,
	dl, dt, dd, ol, ul, li,
	fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td {
		margin:0;
		padding:0;
		border:0;
		outline:0;
		font-size:100%;
		vertical-align:baseline;
		background:transparent;
	}
	
	body {
		margin:0;
		padding:0;
		font:12px/15px "Helvetica Neue",Arial, Helvetica, sans-serif;
		color: #555;
	}
	
	a {color:#666;}
	
	#content {width:65%; max-width:690px; margin:6% auto 0;}
	
	/*
	Pretty Table Styling
	CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
	*/
	
	table {
		overflow:hidden;
		border:1px solid #d3d3d3;
		background:#fefefe;
		width:70%;
		margin:5% auto 0;
		-moz-border-radius:5px; /* FF1+ */
		-webkit-border-radius:5px; /* Saf3-4 */
		border-radius:5px;
		-moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
		-webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
	}
	
	th, td {padding:18px 28px 18px; text-align:center; }
	
	th {padding-top:22px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}
	
	td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
	
	tr.odd-row td {background:#f6f6f6;}
	
	td.first, th.first {text-align:left}
	
	td.last {border-right:none;}
	
	/*
	Background gradients are completely unnecessary but a neat effect.
	*/
	
	td {
		background: -moz-linear-gradient(100% 25% 90 deg, #fefefe, #f9f9f9);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
	}
	
	tr.odd-row td {
		background: -moz-linear-gradient(100% 25% 90 deg, #f6f6f6, #f1f1f1);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f1f1f1), to(#f6f6f6));
	}
	
	th {
		background: -moz-linear-gradient(100% 20% 90 deg, #e8eaeb, #ededed);
		background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
	}
	
	
	tr:first-child th.first {
		-moz-border-radius-topleft:5px;
		-webkit-border-top-left-radius:5px; /* Saf3-4 */
	}
	
	tr:first-child th.last {
		-moz-border-radius-topright:5px;
		-webkit-border-top-right-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.first {
		-moz-border-radius-bottomleft:5px;
		-webkit-border-bottom-left-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.last {
		-moz-border-radius-bottomright:5px;
		-webkit-border-bottom-right-radius:5px; /* Saf3-4 */
	}

</style>




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
						    <li><a href="HR_home.jsp">主页</a></li>
							<li><a href="HR_newInfo.jsp">发布</a></li>
							<li class="active"><a href="HR_search.jsp">查询</a></li>
							<li><a href="HR_management.jsp">管理</a></li>
							
							<li><a href="contact.html">Contact</a></li>
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
			</div>
			<!--//side-bar-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main about-main">
                <div id="HR_SearchersResult" style="display:inline;width:85%;float:left;">
                     <p style="margin-left:10%;font-family:'宋体';font-size:35px;font-weight:900;">历史招聘显示</p>
                 <div style="margin-left:2%;margin-right:96%;float:left;font-size:15px;width:96%;">
                     <br/><br /><br />
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
                         List<Offer> list = (ArrayList<Offer>) session.getAttribute("search_offer");
                         if(list!=null){
                             Offer myOffer=null;
                     %>
                       <form  method="post" id="search_offer" action="control/HRToOfferDetailsServlet">
                      <%for(int i=0;i<list.size();i++){
                        myOffer=(Offer)list.get(i);
                        out.println(" <tr>");
                        out.println("<td style=\"text-align:center;\"><a href=\"javascript:getOfferId("+myOffer.getId()+")\">"+i+"</a>");
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
                </table>
           </div>
           </div>	

				<div class="col-md-8 contact-form">

							<span style="display:block; width:1130px; text-align:center">
								<input type="button" value="返回" class="btn" onclick="jump()">
                            </span>
						</div>
			</div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
            <script src="js/HRSearchResultJS.js"></script>
        </div>
    </div>
</body>
</html>