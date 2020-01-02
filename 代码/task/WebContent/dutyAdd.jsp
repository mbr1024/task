<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		   <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 制定任务
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/DutyServlet?f=1" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 任务信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
							<td>任务名称</td>
							<td><input type="text" name="dutyname" id="dutyname" value=""/> *</td>
						</tr>
						<tr>
							<td width="40px">开始时间</td>
							<td><input type="text" name="starttime" id="txtBeginDate" value=""/> *</td>
							<td >&nbsp;&nbsp;结束时间&nbsp;&nbsp;</td>
							<td><input type="text" name="endtime" id="txtEndDate" value=""/> *</td>
						</tr>
                        <tr>
							<td width="40px">实施人</td>
							<td>
						      <select name="staff" style="width:80px">
						      <c:forEach items="${List }"  var="list" varStatus="status">
			   						<option value="${list.name }" 
			   							selected="selected"
			   						>${list.name }</option>
			   				  </c:forEach>
                              </select>
                             <input type="hidden" name="staff" id="staff" value="${list.name }" />*</td>
						</tr>
						
						<tr>
							<td>任务描述</td>
							<td><textarea name="describe" id="describe"></textarea>*</td>
							<input type="hidden" name="describe" id="describe" value="" /></td>
						</tr>
						<tr>
							<td width="80px">任务状态*</td>
							<td align="center">未实施&nbsp;</td>
							<td><input type="hidden" name="status" id="status" value="未实施"/></td>
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
</div>
</body>
</html>
    