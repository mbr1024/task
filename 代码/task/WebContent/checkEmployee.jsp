<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>查看员工具体信息</title>



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
					src="style/images/title_arrow.gif" />查看员工信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/LinkmanServlet" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 员工信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
					  <div class="providerView">
                        <p><strong>姓名：</strong><span>${checkList.name }</span></p>
                        <p><strong>密码：</strong><span>${checkList.password }</span></p>
                        <p><strong>性别：</strong><span>${checkList.sex }</span></p>
                        <p><strong>出生日期：</strong><span>${checkList.birthday }</span></p>
                        <p><strong>学历：</strong><span>${checkList.school }</span></p>
                        <p><strong>职位：</strong><span>${checkList.title }</span></p>
                        <p><strong>入职时间：</strong><span>${checkList.time }</span></p>
                        <p><strong>所属角色：</strong><span>${checkList.job }</span></p>
                    </div>
					</table>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>
</body>
</html>