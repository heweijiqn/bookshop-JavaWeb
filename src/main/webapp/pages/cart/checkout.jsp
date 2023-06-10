<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单页面</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	#refund-container {
		position: fixed;
		left: 20px;
		bottom: 20px;
	}
	.refund-button {
		display: inline-block;
		padding: 10px 20px;
		font-size: 16px;
		font-weight: bold;
		text-align: center;
		text-decoration: none;
		background-color: #ff6666;
		color: #ffffff;
		border-radius: 5px;
		transition: background-color 0.3s ease;
	}

	.refund-button:hover {
		background-color: #ff4d4d;
	}
</style>
<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				// 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
				/**
				 * confirm是确认提示框函数
				 * 参数是它的提示内容
				 * 它有两个按钮，一个确认，一个是取消。
				 * 返回true表示点击了，确认，返回false表示点击取消。
				 */
				return confirm("你确定要退款该顶单【" + ${sessionScope.orderNumberInt} + "】?");
				// return false// 阻止元素的默认行为===不提交请求
			});
		});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/log.jpg" >
			<span class="wel_word">订单</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
<c:if test="${sessionScope.orderNumberInt!=null}">
	<div id="main">
		<h1>你的订单已结算，订单号为:${sessionScope.orderNumberInt}</h1>

		<div id="refund-container">
			<a class="refund-button deleteClass" href="orderServlet?action=deleteOrder&id=${sessionScope.orderNumberInt}">退款</a>
		</div>
	</div>
</c:if>
<c:if test="${sessionScope.orderNumberInt==null}">
	<div id="main">
		<h1>你还没有订单</h1>
	</div>
</c:if>


	<div id="footer">
		<%@include file="/pages/common/footer.jsp"%>
	</div>
</body>
</html>