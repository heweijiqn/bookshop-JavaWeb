<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单管理</title>
	<%@ include file="/pages/common/head.jsp"%>

	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>

	<script>
		function updateStatus(rowId) {
			var statusCell = document.getElementById(rowId).querySelector('.status');
			if (statusCell.innerText === '未发货') {
				statusCell.innerText = '发货';
			} else {
				statusCell.innerText = '未发货';
			}
		}
	</script>

</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/log.jpg" >
	<span class="wel_word">订单管理系统</span>
	<%@ include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">
	<c:if test="${not empty orders}">
	<table>
		<tr>
			<td>订单号</td>
			<td>用户ID</td>
			<td>状态</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${requestScope.orders}" var="order" varStatus="loop">
			<tr id="row${loop.index}">
				<td>${order.orderid}</td>
				<td>${order.userid}</td>
				<td class="status">未发货</td>
				<td>
					<button onclick="updateStatus('row${loop.index}')">点击发货</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty orders}">
		<h1>暂无订单</h1>
	</c:if>
</div>

<div id="footer">
	<%@include file="/pages/common/footer.jsp"%>
</div>

</body>
</html>
