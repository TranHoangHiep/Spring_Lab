<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Trang Đăng Nhập</h1>
		<c:if test="${!error }"><p>Sai ten dang nhap hoac mat khau</p></c:if>
		<form method="post" action="/j_spring_security_check">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			<p>
				<input type="text" name="username" id="username" placeholder="Username">
			</p>
			<p>
				<input type="password" name="password" id="password" placeholder="Password">
			</p>
			<p class="submit">
				<input type="submit" name="commit" value="Login">
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>