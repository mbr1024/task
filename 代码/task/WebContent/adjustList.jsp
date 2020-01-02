<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>调整任务</title>



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
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 未实施任务信息
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>任务名称</td>
				<td>实施人</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>任务状态</td>
				<td>选择</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
		
        <tbody id="TableData">
		  <c:forEach items="${adjustList}"  var="adjust" >
			<tr class="TableDetail1">
				<td align="center">${adjust.dutyname }</td>
				<td align="center">${adjust.staff }</td>
				<td align="center">${adjust.starttime}</td>
				<td align="center">${adjust.endtime }</td>
				<td align="center">${adjust.status }</td>
				<td>
					<a href="${pageContext.request.contextPath }/DutyServlet?f=10&dutyname=${adjust.dutyname }" class="FunctionButton">调整</a>						
				</td>
			</tr>
		  </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
    