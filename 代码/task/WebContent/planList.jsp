<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>查看计划具体信息</title>



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
					src="style/images/title_arrow.gif" />查看计划信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/DutyServlet" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 计划信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
					  <div class="providerView">
                        <p><strong>计划名称：</strong><span>${plan.planname }</span></p>
                        <p><strong>计划描述：</strong><span>${plan.planconcrete }</span></p>
                        <p><strong>开始时间：</strong><span>${plan.planstarttime }</span>&nbsp;&nbsp;&nbsp;
                        <strong>结束时间：</strong><span>${plan.planendtime }</span></p>
                        <p><strong>所属任务：</strong><span>${plan.dutyname }</span>&nbsp;&nbsp;&nbsp;
                        <strong>计划状态：</strong><span>${plan.planstatus }</span></p>
						 <p><strong>反馈信息：</strong><span>${plan.planfeedback }</span></p>
                       </div> 
					</table>
				</div>
            </div>
        </div>
		<div id="InputDetailBar">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
</html>
    