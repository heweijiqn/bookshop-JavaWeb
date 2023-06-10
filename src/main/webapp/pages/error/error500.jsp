<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>500 - Internal Server Error</title>

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
	<h1>500 - Internal Server Error</h1>
	<p>很抱歉，您访问的后台程序出现了错误，程序猿小哥，正在努力的为您抢修！！！</p>
	<p><a href="pages/user/login.jsp">返回首页</a></p>
</div>
</body>
</html>
