<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>员工信息查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 员工信息
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>员工编号</td>
				<td>密码</td>
				<td>真实姓名</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>所属角色</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
		
        <tbody id="TableData">
		  <c:forEach items="${allotList}"  var="allot" varStatus="status">
			<tr class="TableDetail1">
				<td align="center">${status.count }</td>
				<td align="center">${allot.password }</td>
				<td align="center">${allot.name }</td>
				<td align="center">${allot.sex }</td>
				<td align="center">${allot.birthday }</td>
				<td align="center">${allot.job }</td>
				<td>
					<a href="${pageContext.request.contextPath }/EmployeeServlet?f=6&id=${allot.id}" class="FunctionButton">分配部门</a>							
				</td>
			</tr>
		  </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
    