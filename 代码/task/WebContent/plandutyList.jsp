<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>查询计划信息</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
<link href="css/lyz.calendar.css" rel="stylesheet" type="text/css" />

<script src="http://www.jq22.com/jquery/1.4.4/jquery.min.js"></script>

<script src="js/lyz.calendar.min.js" type="text/javascript"></script>
<script>

    $(function () {

        $("#txtBeginDate").calendar({

            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"

            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200

            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true

            readonly: true,                                       // 目标对象是否设为只读，默认：true

            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)

            lowerLimit: new Date("2000/01/01"),                   // 日期下限，默认：NaN(不限制)
        });

        $("#txtEndDate").calendar();
    });

</script>


</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" />查询计划信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/PlanServlet?f=8" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 查询计划信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
					  <div class="providerView">
                        <p><strong>计划名称：</strong><span>
                            <input type ="text" name="planname" id="plananme" value=""/>
                        </span></p>
                        <p><strong>所属任务：</strong><span>
                           <select name="dutyname" style="width:80px">
                            <c:forEach items="${plandutyList}"  var="plandutyList" varStatus="status">
			   						<option value="${plandutyList.dutyname}" 
			   							selected="selected"
			   						>${plandutyList.dutyname}</option>
			   				</c:forEach>
			   				<input type="hidden" name="dutyname" id="dutyname" value="" /></td>	
			   				</select>                                                        
			   			  	 
                        </span></p>
                        <p><strong>开始时间：</strong><span>
                                                      从：<input type ="text" name="planstarttime1" id="txtBeginDate" value=""/>
                                                      到：<input type ="text" name="planendtime1" id="txtEndDate" value=""/>
                        </span></p>
                        <p><strong>结束时间：</strong><span>
                                                       从：<input type ="Date" name="planstarttime2" id="txtBeginDate1" value=""/>
                                                        到：<input type ="Date" name="planendtime2" id="txtEndDate1" value=""/>
                        </span></p>
                        <p><strong>是否反馈：</strong><span>
						     <select name="planfeedback" style="width:80px">
						            <option value="" 
			   							selected="selected"
			   						></option>
			   						<option value="未反馈" 
			   						>未反馈</option>
			   						<option value="已反馈" 
			   						>已反馈</option>               
			   				</select>
			   				 <input type="hidden" name="planfeedback" id="planfeedback" value="" /></td>
						</span>
						</p>
						<p> <input type="submit" value="查询计划"/></p>
						<p>&nbsp;</p>
                       </div> 
					</table>
				</div>
            </div>
        </div>
	</form>
	</div>
	<div id="MainArea">
	<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 计划信息
        </div>
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>计划名称</td>
				<td>所属任务</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>计划状态</td>
				<td>是否反馈</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
		<tbody id="TableData">
		  <c:forEach items="${planList}"  var="plan" >
			<tr class="TableDetail1">
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
			</tr>
		  </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
        