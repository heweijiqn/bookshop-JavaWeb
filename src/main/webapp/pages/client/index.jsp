<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		 $(function(){
			 $("button.addToCart").click(function () {

				 var bookId = $(this).attr("bookId");
				 var bookName = $(this).attr("bookName");
				 if (confirm("确定要将【"+bookName+"】添加到购物车吗？")) {
					 location.href = "${basePath}client/cartServlet?action=addItem&id="+bookId;
				 }
			 });

		 });
	</script>


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/log.jpg" >
			<span class="wel_word">书城</span>
			<div>
				<c:if test="${sessionScope.user != null}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>&nbsp;
					<a href="userServlet?action=loginout">注销</a>
					<a href="client/cartServlet?action=showCart">购物车</a>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<a href="pages/user/login.jsp">登录</a>
					<a href="pages/user/regist.jsp">注册</a>
				</c:if>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<c:if test="${sessionScope.user != null}">
				<div class="book_cond">
					<form action="client/bookServlet" method="get">
						<input type="hidden" name="action" value="pageByPrice">
						价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
							<input id="max" type="text" name="max" value="${param.max}"> 元
							<input type="submit" value="查询" />
					</form>
				</div>
			</c:if>
			<div style="text-align: center">
				<c:if test="${sessionScope.user != null}">
					<span>您的购物车中有${totalCount}件商品</span>
					<div>
						您刚刚将<span style="color: red">${lastName}</span>加入到了购物车中
					</div>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<span>您还没有登录，不能查看购物车</span>
				</c:if>
			</div>
			<c:if test="${sessionScope.user != null}">
				<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button class="addToCart" bookId="${book.id}" bookName="${book.name}">加入购物车</button>
						</div>
					</div>
				</div>
				</c:forEach>
			</c:if>

			<c:if test="${sessionScope.user == null}">
				<div style="text-align: center">
					<span>您还没有登录，请先登录</span>
				</div>
			</c:if>

		</div>

		<c:if test="${sessionScope.user != null}">
			<%@include file="/pages/common/page_nav.jsp"%>
		</c:if>
		<c:if test="${sessionScope.user == null}">
			<div style="text-align: center">

			</div>
		</c:if>




	
	</div>

<div id="footer">
	<%@include file="/pages/common/footer.jsp"%>
</div>

</body>
</html>