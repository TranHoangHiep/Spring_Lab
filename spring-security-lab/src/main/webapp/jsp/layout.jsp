<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Java Application</title>
</head>
<body>
	<h1>Welcome to Spring Jazz</h1>
	<p>
		<a href="/">Trang chu</a>
		<sec:authorize access="!hasAnyRole('ROLE_USER')">
			<a href="/dang-nhap" style="margin-left: 30px">Dang nhap</a>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_USER')">
			<a href="/nguoi-dung" style="margin-left: 30px">Nguoi dung</a>
			<a href="javascript:document.getElementById('logout').submit()" style="margin-left: 30px">Dang xuat</a>
		</sec:authorize>
	</p>
	<form action="/j_spring_security_logout" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>
	<tiles:insertAttribute name="body" />
</body>
</html>