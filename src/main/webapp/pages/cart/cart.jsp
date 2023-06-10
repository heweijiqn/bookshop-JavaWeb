<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>

	<%@ include file="/pages/common/head.jsp"%>


</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="static/img/log.jpg" >
	<span class="wel_word">购物车</span>

	<%--静态包含，登录 成功之后的菜单 --%>-
		<%@ include file="/pages/common/login_success_menu.jsp"%>


	<script type="text/javascript">
		$(function () {
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗?")
			});
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗?");
			})
			$(".updateCount").change(function () {
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookId');
				var count = this.value;
				if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
					location.href = "${basePath}client/cartServlet?action=updateCount&count="+count+"&id="+id;
				} else {

					this.value = this.defaultValue; // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
				}
			});

		});
	</script>

</div>

<div id="main">

	<table>
		<tr>
			<td>商品名称</td>
			<td>数量</td>
			<td>单价</td>
			<td>金额</td>
			<td>操作</td>
		</tr>
		<c:if test="${requestScope.runcar==null}">
			<tr>
				<td colspan="5"><a href="index.jsp">亲，当前购物车为空！快跟小伙伴们去浏览商品吧！！！</a> </td>
			</tr>
		</c:if>
		<c:if test="${requestScope.runcar!=null}">
			<c:forEach items="${requestScope.cartItems}" var="entry">
				<tr>
					<td>${entry.name}</td>
					<td>
						<input type="text" bookid="${entry.id}"
							   value="${entry.count}" class="updateCount" style="width: 60px">
					</td>
					<td>${entry.price}</td>
					<td>${entry.price*entry.count}</td>
					<td><a href="client/cartServlet?action=deleteItem&id=${entry.id}" class="deleteItem">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<%--如果购物车非空才输出页面的内容--%>
	<c:if test="${requestScope.runcar!=null}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${requestScope.runcar.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${requestScope.runcar.totalPrice}</span>元</span>
			<span class="cart_span"><a href="client/cartServlet?action=clearItem" class="clearItem">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">一键结账</a></span>
		</div>
	</c:if>
	<c:if test="${requestScope.runcar==null}">
		<div class="cart_info">
			<span class="cart_span">购物车中<span class="b_count">无</span>件商品</span>
			<span class="cart_span"><a href="index.jsp">快去选购吧</a> <span class="b_price"></span></span>
		</div>
	</c:if>

	<div class="cart_info">
		<span class="cart_span"><a href="pages/cart/checkout.jsp">查看订单</a></span>
	</div>


</div>
<div id="footer">
	<%@include file="/pages/common/footer.jsp"%>
</div>


</body>
</html>