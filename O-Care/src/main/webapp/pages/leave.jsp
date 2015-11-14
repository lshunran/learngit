<%--
  Created by IntelliJ IDEA.
  User: 重书
  Date: 2015/10/20
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/sidebar.jsp"%>
<link rel="stylesheet" href="/OCare/Assets/CSS/homepage.css">
<div class="ui container Entry">
    <form class="ui form">
        <h4 class="ui dividing header">离职信息</h4>

        <div class="two fields">
        <div class="field">
            <label>姓名：</label>
            <input type="text" name="name" placeholder="请输入姓名">
            </br>
            <label>地址：</label>
            <input type="text" name="address" placeholder="请输入正确的地址">
            </br>
            <label>电话：</label>
            <input type="text" name="phone" placeholder="请输入您的电话">
            </br>
            <label>身份证号：</label>
            <input type="text" name="ID" placeholder="请输入身份证号">
            </br>
            </br>
            <label>部门：</label>
                <div class="ui dropdown">
                    <div class="text">请选择</div>
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="item">护工班组</div>
                        <div class="item">人事经理室</div>
                    </div>
                </div>
                <%--<label>部门：</label>--%>
                <%--<select class="ui fluid dropdown" name="department">--%>
                    <%--<option value="">请选择</option>--%>
                    <%--<option value="AL">胡工班组</option>--%>
                    <%--<option value="AL">人事经理室</option>--%>
                <%--</select>--%>
                </br>
                </br>
                <label>职位：</label>
                <div class="ui dropdown">
                    <div class="text">请选择</div>
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="item">护工班组</div>
                        <div class="item">人事经理室</div>
                    </div>
                </div>
                </br>
                </br>
                <label>上级主管：</label>
                <div class="ui dropdown">
                    <div class="text">请选择</div>
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="item">张三</div>
                        <div class="item">李四</div>
                    </div>
                </div>

                </br>
                </br>
            </br>
            </br>
            <div class="field">
                <label>离职原因：</label>
                <textarea name="reason"></textarea>
            </div>
            <button class="negative ui submit button">注销</button>


        </div>
            <div class="field">
                <label>图片：</label>
                <div class="two fields">
                    <div class="field">
                        <img src="/OCare/Assets/Images/testIcon.jpg"/>
                    </div>
                    <div class="field">
                        <img src="/OCare/Assets/Images/testIcon.jpg"/>
                    </div>
                </div>
                <div class="two fields">
                    <div class="field">
                        <img src="/OCare/Assets/Images/testIcon.jpg"/>
                    </div>
                    <div class="field">
                        <img src="/OCare/Assets/Images/testIcon.jpg"/>
                    </div>
                </div>

            </div>


        </div>
    </form>
</div>

<script type="text/javascript">

 $('.ui.dropdown')
            .dropdown()
    ;
    $('.ui.checkbox')
            .checkbox()
    ;


    $('.ui.form')
            .form({
                field: {
                    name: {
                        identifier: 'name',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter your name'
                            }
                        ]
                    },
                    reason: {
                        identifier: 'reason',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter your reason'
                            }
                        ]
                    },
                    address: {
                        identifier: 'address',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter your address'
                            }
                        ]
                    },
                    phone: {
                        identifier: 'phone',
                        rules: [
                            {
                                type   : 'integer',
                                prompt : 'Please enter your phone'
                            }
                        ]
                    },
                    ID: {
                        identifier: 'ID',
                        rules: [
                            {
                                type   : 'integer',
                                prompt : 'Please enter your ID'
                            }
                        ]
                    },
                    skills: {
                        identifier: 'skills',
                        rules: [
                            {
                                type   : 'minCount[2]',
                                prompt : 'Please select at least two skills'
                            }
                        ]
                    },
                    position: {
                        identifier: 'position',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please select a position'
                            }
                        ]
                    },
                    superior: {
                        identifier: 'superior',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please select a superior'
                            }
                        ]
                    },
                    department: {
                        identifier: 'department',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please select a department'
                            }
                        ]
                    },
                    username: {
                        identifier: 'username',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter a username'
                            }
                        ]
                    },
                    password: {
                        identifier: 'password',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter a password'
                            },
                            {
                                type   : 'minLength[6]',
                                prompt : 'Your password must be at least {ruleValue} characters'
                            }
                        ]
                    },
                    checked: {
                        identifier: 'checked',
                        rules: [
                            {
                                type   : 'checked',
                                prompt : 'You must agree to the terms and conditions'
                            }
                        ]
                    }
                }
            })
    ;
</script>
<%@include file="templates/footer.jsp"%>