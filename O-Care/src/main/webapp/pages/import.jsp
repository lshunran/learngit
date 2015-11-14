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
    <div class="ui three column grid">
        <div class="column">
          <div class="ui fluid buttons">
             <button class="ui blue fluid button">模板下载</button>
             <button class="ui blue fluid button">职工信息导入预览</button>
             <button class="ui blue fluid button">职工信息正式导入</button>

          </div>

        </div>
    </div>
</div>

<script type="text/javascript">

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