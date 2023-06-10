<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>404 - Page Not Found</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f1f1f1;
		}

		.container {
			max-width: 400px;
			margin: 50px auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			text-align: center;
		}

		h1 {
			color: #f44336;
			margin-top: 0;
		}

		p {
			margin-top: 20px;
		}

		a {
			color: #007bff;
			text-decoration: none;
		}
	</style>

</head>
<body>
<div class="container">
	<h1>404 - Page Not Found</h1>
	<p>很抱歉，您请求的页面未找到，请确认您输入的URL是否正确。</p><br/>
	<p>或者访问的页面不存在，或已经被删除！！！</p>
	<p><a href="pages/user/login.jsp">返回首页</a></p>
</div>
</body>
</html>
