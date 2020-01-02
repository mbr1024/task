<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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
		   <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 反馈信息
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/PlanServlet?f=5" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 反馈信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
							<td>计划名称</td>
							<td>${feedback.planname }</td>
							<input type="hidden" name="planname" id="planname" value="${feedback.planname }" />
						</tr>
						<tr>
							<td>计划描述</td>
							<td>${feedback.planconcrete }</td>
						</tr>
						<tr>
							<td width="40px">开始时间</td>
							<td>${feedback.planstarttime }</td>
							<td >&nbsp;&nbsp;结束时间&nbsp;&nbsp;</td>
							<td>${feedback.planendtime }</td>
						</tr>
						<tr>
							<td width="80px">计划状态*</td>
							  <td><select name="planstatus" style="width:80px">
			   						<option value="未实施" 
			   							selected="selected"
			   						>未实施</option>
			   						<option value="实施中" 
			   						>实施中</option>
			   						<option value="已完成" 
			   						>已完成</option>
                                 </select></td>
                              <input type="hidden" name="planstatus" id="planstatus" value="" />
						</tr>
						<tr>
							<td width="80px">是否反馈*</td>
							 <td><select name="planfeedback" style="width:80px">
			   						<option value="未反馈" 
			   							selected="selected"
			   						>未反馈</option>
			   						<option value="已反馈" 
			   						>已反馈</option>
			   					</select></td>
			   					<input type="hidden" name="planfeedback" id="planfeedback" value="" />
						</tr>
						<tr>
							<td>反馈信息</td>
							<td><textarea name="backmessage" id="backmessage"></textarea>*</td>
							<input type="hidden" name="backmessage" id="backmessage" value="" /></td>
						</tr>
					</table>
				</div>
            </div>
        </div>	
		<!-- 表单操作 -->
		<div id="InputDetailBar">	
		    <input type="submit" value="提交" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	                 <div>
            		      <font color="red">${requestScope.backmessage }</font>
            	       </div>
</div>
</body>
</html>
    