<%@ page import="model.Offer" %>
<!DOCTYPE html>
<html>
<head>
  <%@ page contentType="text/html; charset=UTF-8" %>
  <%
    String wrongMsg=(String)session.getAttribute("wrongMsg");
    Offer DetailedOffer=(Offer)session.getAttribute("DetailedOffer");
    if(wrongMsg==null||wrongMsg.equals("")){
        //不弹窗
    }else if(DetailedOffer==null){
  %><script type="text/javascript">
  alert("详细列表为空，返回查询界面。");
  window.location.href="../Offer100/JobSearch.jsp";
</script>
    <%}
    else{
  %>
  <script type="text/javascript">
    alert("<%=wrongMsg%>");
  </script>
  <%
    session.setAttribute("wrongMsg", "");}
  %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>more details</title>
</head>

<body>
  <h1 style="text-align:center">招聘信息详情</h1>
  <table border="1" style="margin-left:20%;width:60%;table-layout:fixed;">
    <tr>
      <td width="26%" style="text-align:right">公司名称：</td>
      <td><%=DetailedOffer.getCompanyName()%></td>
    </tr>
    <tr>
      <td style="text-align:right">行业类别：</td>
      <td><%=DetailedOffer.getIndustryCatalog()%></td>
    </tr>
    <tr>
      <td style="text-align:right">职务名称：</td>
      <td><%=DetailedOffer.getJobName()%></td>
    </tr>
    <tr>
      <td style="text-align:right">工作技能：</td>
      <td><%=DetailedOffer.getWorkSkill()%></td>
    </tr>
    <tr>
      <td style="text-align:right">薪酬中位数：</td>
      <td><%=DetailedOffer.getMonthSalary()%></td>
    </tr>
    <tr>
      <td style="text-align:right">联系方式：</td>
      <td><%=DetailedOffer.getContact()%></td>
    </tr>
    <tr>
      <td style="text-align:right">工作类型：</td>
      <td><%=DetailedOffer.getJobType()%></td>
    </tr>
    <tr>
      <td style="text-align:right">发布时间：</td>
      <td><%=DetailedOffer.getTime()%></td>
    </tr>
    <tr>
      <td style="text-align:right">详细描述信息：</td>
      <td style="word-wrap:break-word;"><%=DetailedOffer.getOtherInformation()%></td>
    </tr>
  </table>
</body>
</html>
