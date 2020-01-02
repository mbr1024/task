<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>跟踪任务具体信息</title>



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
					src="style/images/title_arrow.gif" />跟踪任务信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/DutyServlet?f=8" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 跟踪任务信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
					  <div class="providerView">
                        <p><strong>任务名称：</strong><span>${followlist.dutyname }</span></p>
                        <p><strong>任务描述：</strong><span>${followlist.concrete }</span></p>
                        <p><strong>开始时间：</strong><span>${followlist.starttime }</span>&nbsp;&nbsp;&nbsp;
                        <strong>结束时间：</strong><span>${followlist.endtime }</span></p>
                        <p><strong>实施人：</strong><span>${followlist.staff }</span>&nbsp;&nbsp;&nbsp;
                        <strong>任务状态：</strong><span>
						<select name="status" style="width:80px">
			   						<option value="未实施" 
			   							selected="selected"
			   						>未实施</option>
			   						<option value="实施中" >
                                                                           实施中</option>
                                    <option value="已完成" >
                                                                           已完成</option>                                                                                      
                         </select>
						</span>
						<input type="hidden" name="dutyname" id="dutyname" value="${followlist.dutyname }"/>
						<input type="hidden" name="status" id="status" value="" />
						<p> <input type="submit" value="提交">&nbsp;&nbsp;<a href="javascript:history.go(-1);">返回</a></p>
						<p>&nbsp;</p>
						 <div>
            		      <font color="red">${requestScope.follow }</font>
            	       </div>
                       </div> 
					</table>
				</div>
            </div>
        </div>
	</form>
	</div>
	<div id="MainArea">
	<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 实施计划&nbsp;
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
			</tr>
		  </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
        
