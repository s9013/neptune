<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<title>用户登录</title>
</head>
<body>
		<div class="container" style="margin-top:50px;">
					<c:if test="${not empty param.login_error}">
						<font color="red"> 登录失败，请重试.<br />
						<br /> 原因:<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</font>
					</c:if>
					<c:url value="/login" var="loginUrl" />
					<form action="${loginUrl}" method="post">
						<c:if test="${param.error != null}">
							<p>Invalid username and password.</p>
						</c:if>
						<c:if test="${param.logout != null}">
							<p>You have been logged out.</p>
						</c:if>
						<p>
							<label for="username">Username</label>
							<input type="text" id="username" name="username" />
						</p>
						<p>
							<label for="password">Password</label> 
							<input type="password"	id="password" name="password" />
						</p>
						<button type="submit" class="btn btn-primary">Log in</button>
					</form>
		</div>
	
</body>
</html>

