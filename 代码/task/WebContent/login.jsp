<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="snow-container">
			  <div class="snow foreground"></div>
			  <div class="snow foreground layered"></div>
			  <div class="snow middleground"></div>
			  <div class="snow middleground layered"></div>
			  <div class="snow background"></div>
			  <div class="snow background layered"></div>
			</div>

<div class="top-buttons-agileinfo">
</div>
<h1>任务管理系统
</h1>
<div class="main-agileits">
		<div class="form-w3-agile">
			<h2 class="sub-agileits-w3layouts">登录</h2>
			<form action="${pageContext.request.contextPath}/UserServlet?f=1" method="post">
			     <div>
            		<font color="red">${requestScope.error }</font>
            	</div>
            	<div>
            		<font color="red">${requestScope.remind }</font>
            	</div>
            	<div>
					<input type="text" name="username" placeholder="用户名" required="" />
					<input type="password" name="password" placeholder="密码" required="" />
					<select name="id" style="width:80px">
						<option value="1">管理员</option>
						<option value="2">主管</option>
						<option value="3">员工 </option>
					</select>
					*<input type="hidden" name="id" value="" /></td>
				</div>
				<div class="submit-w3l">
					<input type="submit" value="登录">
				</div>
			</form>
		</div>
		</div>
	<div class="copyright w3-agile">
		<p> © 2018</a></p>
	</div>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

</body>
</html>