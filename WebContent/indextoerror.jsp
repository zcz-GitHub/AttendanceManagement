<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="utils.*" import="java.util.*" import="pic.entity.*"
	import="java.io.File"
	import="db.entity.*" pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/wown.css" />
<title>Insert title here</title>
</head>
<body>
<script>
var str=" ";
window.onload = function() {
		count = <%=session.getAttribute("coursesNum")%>;

		if ( count > 1){//课程冲突，返回SUCCESS，由界面判断处理
			//session.put("coursesInfo", courses);//课程冲突，将所有课传入，便于页面显示
			
				
			str = "上课时间冲突,不能签到";
		}else if ( count == -1 ){//当天无课，返回SUCCESS，由界面判断处理
			//session.put("coursesInfo", "这周不属于上课周，放假或者为自习周，无课");
		
			var str = "这周不属于上课周，放假或者为自习周，无课";
			
		}

		document.getElementById("tips").innerHTML=str;
}

</script>
<body>
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png"
						class="img-responsive" alt="" /></a> <font class="login_font_title">超人点名</font>
				</div>
				<div class="header-right">
					<div class="menu">
						<span class="menu"> </span>
						<ul class="navigatoin">
							<li><a href="index.html" class="active">帮助</a></li>

						</ul>
						<div class="clearfix"></div>

					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="line">
		<a href="#"><img src="images/line.png" class="img-responsive"
			alt="" /></a>
		<div class="clearfix"></div>
	</div>
	<div class="welcome_center">
<font color="red" size="4pt"><div class="check_tip" id="tips"></div></font>
</div>
</body>
</html>