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
    <div class="ui form">
    <div class="inline fields">
        <div class="three wide field"><label>请选择查询条件：</label></div>
        <div class="three wide field">
           <div class="ui dropdown">
                    <div class="text">请选择</div>
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="item">列出所有在职人员</div>
                        <div class="item">身份证号</div>
                        <div class="item">合同编号</div>
                        <div class="item">电话号码</div>
                        <div class="item">联系地址</div>
                    </div>
                </div>
        </div>

        <div class="six wide field">
            <div class="ui icon input">
                <input type="text" placeholder="请输入查询内容...">
                <i class="search icon"></i>
            </div>
        </div>
    </div>
    </div>
    <div class="inline fields">
        <table class="ui striped table">
            <thead>
            <tr>
                <th>工号</th>
                <th>合同编号</th>
                <th class="one wide">职员姓名</th>
                <th>职员身份证号</th>
                <th>职员电话</th>
                <th>职员部门</th>
                <th>部门主管</th>
                <th>职员岗位</th>
                <th>合同执行情况</th>
                <th>合同起止日期</th>
                <th>联系地址</th>
                <th>最新考核情况</th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>00001</td>
                <td>T4827499</td>
                <td>张三</td>
                <td>31010101010</td>
                <td>138888888</td>
                <td>出口部</td>
                <td>李四</td>
                <td>职员</td>
                <td>未知</td>
                <td>9.22~9.24</td>
                <td>啊哈黑暗灭</td>
                <td>良好</td>
            </tr>
            <tr>
                <td>00001</td>
                <td>T4827499</td>
                <td>张三</td>
                <td>31010101010</td>
                <td>138888888</td>
                <td>出口部</td>
                <td>李四</td>
                <td>职员</td>
                <td>未知</td>
                <td>9.22~9.24</td>
                <td>啊哈黑暗灭</td>
                <td>良好</td>
            </tr>
            <tr>
                <td>00001</td>
                <td>T4827499</td>
                <td>张三</td>
                <td>31010101010</td>
                <td>138888888</td>
                <td>出口部</td>
                <td>李四</td>
                <td>职员</td>
                <td>未知</td>
                <td>9.22~9.24</td>
                <td>啊哈黑暗灭</td>
                <td>良好</td>
            </tr>
            </tbody>
        </table>
        </br>
        <button class="ui basic green button"><i class="icon cloud"></i>信息导出</button>
    </div>
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