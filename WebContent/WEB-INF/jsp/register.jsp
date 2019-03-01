<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
  <meta charset="utf-8">
  <title>用户注册</title>
  <%@include file="common/head.jsp" %>
  <link rel="stylesheet" href="./css/account.css">
</head>

<body>
<jsp:include page="common/nav.jsp"/>

<form class="form-signin">
  <div class="alert alert-warning">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Warning!</strong> 注册出错了,请稍后再试!
  </div>
  <h2 class="form-signin-heading">用户注册</h2>
  <input type="email" name="email" class="form-control" placeholder="电子邮件" required autofocus>
  <input type="text" name="username" class="form-control" placeholder="用户名" required>
  <input type="password" name="password" class="form-control" placeholder="密码" required>
  <button class="btn btn-primary btn-block" type="submit">确定</button>
</form>

</body>

</html>
