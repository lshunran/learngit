<%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 8/2/15
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MonitorRequest</title>
</head>
<body>
<h1>MonitorRequest</h1>
<table>
  <thead>
  <tr>
    <th>申请ID</th>
    <th>被申请人ID</th>
    <th>申请人ID</th>
    <th>合照</th>
    <th>操作</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="var">
    <tr>
      <td>${var.id}</td>
      <td>${var.elder_id}</td>
      <td>${var.relative_id}</td>
      <td>${var.togetherImg}</td>
      <td><a href="/OCare/monitor/agree/${var.id}">通过</a>|<a href="/OCare/monitor/reject/${var.id}">拒绝</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
