<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
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
<a href="login.jsp">登录</a><a href="register.jsp" class="active">注册</a>
</div>
<h1>任务管理系统</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<h2 class="sub-agileits-w3layouts">注册</h2>
			<form action="${pageContext.request.contextPath }/UserServlet" method="post">
			        <div>
            		  <font color="red">${requestScope.error }</font>
            	    </div>
			        <input type="hidden" name="f" value="2">
					<input type="text" name="username" placeholder="请输入用户名" required="" />
					<input type="password" name="password" placeholder="请输入密码" required="" />
					<input type="password" name="rePassword" placeholder="请确认密码" required="" />
				<div class="submit-w3l">
					<input type="submit" value="注册">
				</div>
			</form>
		</div>
		</div>
	<div class="copyright w3-agile">
		<p> 218版权所有 <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
	</div>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

</body>
</html>