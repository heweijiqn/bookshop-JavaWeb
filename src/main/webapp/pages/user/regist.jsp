<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>易书城会员注册页面</title>
		<!--写base标签，永远固定相对路径跳转的结果-->
		<%@include file="/pages/common/head.jsp"%>
		<script type="text/javascript">
			// 页面加载完成之后
			$(function () {
				$("#code_img").click(function () {
					// 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
					// src属性表示验证码img标签的 图片路径。它可读，可写
					// alert(this.src);
					this.src = "${basePath}kaptcha.jpg?time=" + new Date().getTime();
				});
				$("#sub_btn").click(function () {
					var usernameText = $("#username").val();
					var usernamePatt = /^\w{5,12}$/;
					if (!usernamePatt.test(usernameText)) {
						$("span.errorMsg").text("用户名不合法！");

						return false;
					}


					var passwordText = $("#password").val();
					var passwordPatt = /^\w{5,12}$/;
					if (!passwordPatt.test(passwordText)) {
						$("span.errorMsg").text("密码不合法！");

						return false;
					}

					var repwdText = $("#repwd").val();
					if (repwdText != passwordText) {
						$("span.errorMsg").text("确认密码和密码不一致！");

						return false;
					}

					var emailText = $("#email").val();
					var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
					if (!emailPatt.test(emailText)) {
						$("span.errorMsg").text("邮箱格式不合法！");

						return false;
					}

					var codeText = $("#code").val();


					codeText = $.trim(codeText);
					if (codeText == null || codeText == "") {
						//4 提示用户
						$("span.errorMsg").text("验证码不能为空！");

						return false;
					}

					$("span.errorMsg").text("");

				});

			});

		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/log.jpg" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册易书城会员</h1>
								<span class="errorMsg">
									${requestScope.errormsg==null?"":requestScope.errormsg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username==null?"":requestScope.username}">
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"

										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"

										   autocomplete="off" tabindex="1" name="email" id="email"
										   value="${requestScope.email==null?"":requestScope.email}">

									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 100px;" id="code" />
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 100px;height: 26px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<div id="footer">
			<%@include file="/pages/common/footer.jsp"%>
		</div>
	</body>
</html>