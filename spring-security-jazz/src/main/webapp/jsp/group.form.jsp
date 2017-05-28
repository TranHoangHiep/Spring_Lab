<%--
  Created by IntelliJ IDEA.
  User: hoanghiep
  Date: 5/28/17
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Add Group</h1>
        <form:form method="post" action="/nhom/luu">
            <p>
                <form:input type="text" name="name" placeholder="Group name" path="name"/>
            </p>
            <p class="submit">
                <input type="submit" name="add" value="Add">
            </p>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
