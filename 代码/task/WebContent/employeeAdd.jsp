<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <!-- 包含公共的JSP代码片段 -->
	
<title>添加员工</title>



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
			
				
					<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 添加员工
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/EmployeeServlet?f=4" method="post" >
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 员工信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
					
						<tr>
							<td width="80px">用户名</td>
							<td><input type="text" name="name" id="name" /> *</td>
						</tr>
						<tr>
							<td>密码</td>
							<td><input type="password" name="password" id="password"/> *</td>
						</tr>
						<tr>
							<td class="label">性别：</td>  
                            <td class="controler"><input type="radio" name="sex" checked="checked" value="男">男<input type="radio" name="sex" value="女">女</td>  
						</tr>
                        <tr>
							<td>出生日期</td>
                            <td><input type ="text" name="birthday" id="txtBeginDate" value=""/></td>
						</tr>
						 <tr>
							<td>入职时间</td>
							<td><input type ="text" name="time" id="txtEndDate" value=""/></td>
						</tr>
						 <tr>
							<td>职位</td>
							<td><input type="text" name="title" id="title" /> </td>
						</tr>
						<tr>
							<td width="80px">学历</td>
							<td>
						  <select name="school" style="width:80px">
	                            
			   						<option value="本科" 
			   							selected="selected"
			   						>本科</option>
			   						<option value="研究生" 	
			   						>研究生</option>
									<option value="硕士" 	
			   						>硕士</option>
									<option value="博士" 	
			   						>博士</option>
                            </select>
                             <input type="hidden" name="shcool" id="school"  /></td>
						</tr>
						<tr>
							<td>工作经历</td>
							<td><textarea name="experience" class="TextareaStyle"></textarea>
							<input type="hidden" name="experience" id="experience" value="" /></td>
						</tr>
						<tr>
							<td width="80px">身份标识</td>
							<td>
						  <select name="job" style="width:80px">
	                            
			   						<option value="主管" 
			   							selected="selected"
			   						>主管</option>
			   						<option value="员工" 	
			   						>员工</option>
                            </select>
                             *<input type="hidden" name="job" id="job"/></td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		<div id="InputDetailBar">
            <input type="submit" value="添加" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
</html>
    