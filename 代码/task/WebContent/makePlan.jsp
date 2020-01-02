<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>查看任务具体信息</title>



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
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" />查看任务信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/LinkmanServlet" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 任务详细信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
					  <div class="providerView">
                        <p><strong>任务名称：</strong><span>${dutylist.dutyname }</span></p>
                        <p><strong>任务描述：</strong><span>${dutylist.concrete }</span></p>
                        <p><strong>开始时间：</strong><span>${dutylist.starttime }</span>&nbsp;&nbsp;&nbsp;
                        <strong>结束时间：</strong><span>${dutylist.endtime }</span></p>
                        <p><strong>实施人：</strong><span>${dutylist.staff }</span>&nbsp;&nbsp;&nbsp;
                        <strong>任务状态：</strong><span>${dutylist.status }</span></p>
                       </div> 
					</table>
				</div>
            </div>
        </div>
		
	</form>
	<div id="MainArea">
	<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 计划信息&nbsp;
        </div>
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>计划名称</td>
				<td>完成状态</td>
				<td>是否反馈</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
		<tbody id="TableData">
		  <c:forEach items="${planList}"  var="plan" >
			<tr class="TableDetail1">
				<td align="center">${plan.planname }</td>
				<td align="center">${plan.planstatus }</td>
				<td align="center">${plan.planfeedback }</td>
				<td align="center">${plan.planstarttime}</td>
				<td align="center">${plan.planendtime }</td>
				<td>
					<a href="${pageContext.request.contextPath }/PlanServlet?f=4&planname=${plan.planname}&dutyname=${plan.dutyname }" class="FunctionButton">反馈</a>
					<a href="${pageContext.request.contextPath }/PlanServlet?f=6&planname=${plan.planname}&dutyname=${plan.dutyname }" onClick="return delConfirm();" class="FunctionButton">删除</a>						
				</td>	
			</tr>
		  </c:forEach>
        </tbody>
        
    </table>
</div>
</div>
<div style="text-align:center;">
  <a href="${pageContext.request.contextPath }/makePlanList.jsp" class="FunctionButton" >&nbsp;新建&nbsp;</a>
</div>
</body>
</html>