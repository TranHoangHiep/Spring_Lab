<%--
  Created by IntelliJ IDEA.
  User: hoanghiep
  Date: 5/27/17
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Trang dang nhap</h1>
        <c:if test="${!error}"><p>Sai ten dang nhap hoac mat khau</p></c:if>
        <form method="post" action="/j_spring_security_check">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <p>
                <input type="text" name="username" id="username" placeholder="Username">
            </p>
            <p>
                <input type="password" name="password" id="pasword" placeholder="Password">
            </p>
            <p class="submit">
                <input type="submit" name="commit" value="Login">
            </p>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>
