<%--
  Created by IntelliJ IDEA.
  User: hoanghiep
  Date: 5/28/17
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Group list</h1>
        <table style="width: 100%">
            <tr>
                <td>Name</td>
                <td>#</td>
            </tr>
            <tr>
                <td colspan="2">
                    <form method="get" action="/nhom/danh-sach">
                        <input type="text" name="pattern"/>
                        <input type="submit" value="search"/>
                    </form>
                </td>
            </tr>
            <c:forEach items="${groups}" var="item" varStatus="loop">
                <tr>
                    <td>${item.name}</td>
                    <td>
                        <a href="sua?id=${item.id}">Update</a>
                        <a href="xoa/${item.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>
