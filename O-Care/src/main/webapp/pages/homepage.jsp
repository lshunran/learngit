<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/7/31
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>
<link rel="stylesheet" href="/OCare/Assets/CSS/homepage.css">
<div class="main_content">
    <table class="ui table segment">
        <thead>
        <tr>
            <th>申请ID</th>
            <th>状态</th>
            <th>详细信息</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <%--<tr>--%>
            <%--<td>小明</td>--%>
            <%--<td><i class="question icon"></i>待审核</td>--%>
            <%--<td><i class="icon search"></i>查看</td>--%>
            <%--<td>无</td>--%>
        <%--</tr>--%>
        <%--<tr class="positive">--%>
            <%--<td>张三</td>--%>
            <%--<td><i class="icon checkmark"></i> 已通过</td>--%>
            <%--<td><i class="icon search"></i>查看</td>--%>
            <%--<td>无</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>李四</td>--%>
            <%--<td><i class="question icon"></i>待审核</td>--%>
            <%--<td><i class="icon search"></i>查看</td>--%>
            <%--<td>需电话联系</td>--%>
        <%--</tr>--%>
        <%--<tr class="negative">--%>
            <%--<td>王五</td>--%>
            <%--<td><i class="icon Ban Circle"></i>已拒绝</td>--%>
            <%--<td><i class="icon search"></i>查看</td>--%>
            <%--<td>图片不合格</td>--%>
        <%--</tr>--%>

        <c:forEach items="${list}" var="var">
            <%--//2表示监护类型为普通亲戚；1表示监护类型为监护人；3表示在申请监护人;--%>
            <%--//4表示申请监护人被拒绝;5代表邻居关系;--%>
            <%--//7.代表原来有关系现在没关系了--%>
            <c:if test="${var.type==1}">
                <tr class="positive">
                    <td>${var.id}</td>
                    <td><i class="icon checkmark"></i>已通过</td>
                    <td><a href="/OCare/monitor/agree/${var.id}"><i class="icon search"></i>查看</a></td>
                    <td>无</td>
                </tr>
            </c:if>
            <c:if test="${var.type==3}">
                <tr>
                    <td>${var.id}</td>
                    <td><i class="question icon"></i>待审核</td>
                    <td><a href="/OCare/monitor/undesided/${var.id}"><i class="icon search"></i>查看</a></td>
                    <td>无</td>
                </tr>
            </c:if>
            <c:if test="${var.type==4}">
                <tr class="negative">
                    <td>${var.id}</td>
                    <td><i class="icon Ban Circle"></i>已拒绝</td>
                    <td><a href="/OCare/monitor/reject/${var.id}"><i class="icon search"></i>查看</a></td>
                    <td>无</td>
                </tr>
            </c:if>

        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="templates/footer.jsp"%>