
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录首页</title>
</head>
<body>
<span color="red">登录成功!</span>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<a href="admin.jsp">admin</a>
</body>
</html>