<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>易书城会员登录成功页面</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
		<img class="logo_img" alt="" src="static/img/log.jpg" >
		<%@include file="/pages/common/login_success_menu.jsp"%>
		</div>
		
		<div id="main">
			<c:if test="${sessionScope.user != null && sessionScope.user.username != 'admin'}">
			<h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>
			</c:if>
			<c:if test="${sessionScope.user == null || sessionScope.user.username == 'admin'}">
			 <h1><a href="pages/manager/manager.jsp">请管理员转入后台管理</a></h1>
			</c:if>
	
		</div>

		<div id="footer">
			<%@include file="/pages/common/footer.jsp"%>
		</div>
</body>
</html>