<%--
  Created by IntelliJ IDEA.
  User: hoanghiep
  Date: 5/27/17
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Spring Jazz Application</title>
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
            <a href="javascript:document.getElementById('logout').submit();" style="margin-left: 30px">Dang xuat</a>
        </sec:authorize>
    </p>
    <form action="/j_spring_security_logout" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
    <tiles:insertAttribute name="body"/>
</body>
</html>
