<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
	</head>
	<body>
			<div class="container" >
					<span color="red">登录成功!</span>
					<span id="userId"></span>
					<a href="admin.jsp">admin</a>
			</div>
			
			
			<div>

			  <!-- Nav tabs -->
			  <ul class="nav nav-tabs" role="tablist">
			    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"> 好友</a></li>
			    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">我的动态</a></li>
			    <li role="presentation"><a href="#dongtai" aria-controls="dongtai" role="tab" data-toggle="tab">动态</a></li>
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div role="tabpanel" class="tab-pane active" id="home">聊天</div>
			    <div role="tabpanel" class="tab-pane" id="profile">我的动态</div>
			    <div role="tabpanel" class="tab-pane" id="dongtai">动态</div>
			  </div>

</div>
			
	</body>
	<script data-main="js/config" src="lib/requirejs/require.js"></script>
</html>