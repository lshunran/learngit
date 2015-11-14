<%--
  Created by IntelliJ IDEA.
  User: 重书
  Date: 2015/10/20
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>
<link rel="stylesheet" href="/OCare/Assets/CSS/homepage.css">
<div class="ui container HR">
    <table class="ui blue striped celled table">
        <thead>
        <tr>
            <th class="one wide">职位</th>
            <th class="one wide">工号</th>
            <th class="one wide">姓名</th>
            <th class="one wide">性别</th>
            <th class="one wide">身份证号</th>
            <th class="one wide">联系电话</th>
            <th class="one wide">地址</th>
            <th class="one wide">照片</th>
            <th class="one wide">权限管理</th>
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


        <tr class="left aligned">
            <td>
                职位A
            </td>
            <td>
                123456
            </td>
            <td>
                yuzihan
            </td>
            <td >
                female
            </td>
            <td>
                1234567890
            </td>
            <td>
                1234567890
            </td>
            <td>非的决赛发烧呢附件四
            </td>
            <td>
                <img src="/OCare/Assets/Images/testIcon.jpg"/>
            </td>
            <td>

                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限1</label>
                </div>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限2</label>
                </div>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限3</label>
                </div>

            </td>
        </tr>
        <tr class="left aligned">
            <td>
                职位B
            </td>
            <td>
                123456
            </td>
            <td>
                yuzi
            </td>
            <td >
                female
            </td>
            <td>
                1234567890
            </td>
            <td>
                1234567890
            </td>
            <td>
                上海内面覅是免费
            </td>
            <td>
                <img src="/OCare/Assets/Images/testIcon.jpg"/>
            </td>
            <td>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限1</label>
                </div>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限2</label>
                </div>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限3</label>
                </div>

            </td>
        </tr>
        <tr class="left aligned">
            <td>
                职位C
            </td>
            <td>
                123456
            </td>
            <td>
                zihan
            </td>
            <td >
                male
            </td>
            <td>
                1234567890
            </td>
            <td>
                1234567890
            </td>
            <td>
                房内面我发的神马呢
            </td>
            <td>
                <img src="/OCare/Assets/Images/testIcon.jpg"/>
            </td>
            <td>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限1</label>
                </div>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限2</label>
                </div>
                <div class="ui toggle checkbox">
                    <input type="checkbox" name="public">
                    <label>权限3</label>
                </div>

            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr><th colspan="9">
            <div class="ui right floated pagination menu">
                <a class="icon item">
                    <i class="left chevron icon"></i>
                </a>
                <a class="item">1</a>
                <a class="item">2</a>
                <a class="item">3</a>
                <a class="item">4</a>
                <a class="icon item">
                    <i class="right chevron icon"></i>
                </a>
            </div>
        </th>
        </tr></tfoot>
    </table>
</div>

<script type="text/javascript">
    $('.ui.dropdown')
            .dropdown()
    ;
    $('.ui.checkbox')
            .checkbox()
    ;


</script>


<%@include file="templates/footer.jsp"%>