<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="OCare">
  <meta name="author" content="">
  <meta name="keywords" content="OCare">

  <title>OCare</title>
  <link rel="stylesheet" href="/OCare/Assets/CSS/header.css">
  <link rel="stylesheet" href="/OCare/Assets/CSS/footer.css">
  <link rel="stylesheet" href="/OCare/Assets/CSS/sidebar.css">
  <link rel="stylesheet" href="/OCare/Assets/CSS/semantic.css" media="screen">
  <link rel="stylesheet" href="/OCare/Assets/CSS/icon.css" media="screen">
  <script src="/OCare/Assets/JS/jquery-2.1.4.js"></script>
  <script src="/OCare/Assets/JS/jquery.address.js"></script>
  <script src="/OCare/Assets/JS/semantic.js"></script>
</head>
<body>
<div class="header-globle">
  <div class="container">
    <img src="/OCare/Assets/Images/Ocare-logo.png">
    <div class="greeting">
      您好! <strong>admin</strong><a>注销</a>
    </div>
    <div class="nav" >
      <ul>
        <li>
          <a class="active item" href="/OCare/pages/index.jsp"><i class="home icon"></i> 首页</a>
        </li>
        <li>
          <a class="item"><i class="gift icon"></i> 关于我们</a>
        </li>
        <li>
          <a class="item"><i class="photo icon"></i> 幸福相册</a>
        </li>
        <li>
          <a class="item"><i class="sitemap icon"></i> 合作伙伴</a>
        </li>
        <li>
          <a class="item"><i class="phone icon"></i> 联系我们</a>
        </li>
      </ul>
    </div>
  </div>
</div>

<%--<div class="ui small modal" style="width:30%; margin-left: -15%">--%>
  <%--<i class="close icon"></i>--%>
  <%--<div class="header" style="background-color: #78D6CC;padding:1.1rem 2rem">--%>
    <%--<i class="user icon"></i>用户登陆--%>
  <%--</div>--%>
  <%--<div class="content" style="line-height: 40px;padding:2em 0rem;display: inline-block;">--%>
    <%--<div class="ui form">--%>
    <%--<div style="padding:0rem 1rem">--%>
        <%--<label>用户名/手机号/邮箱:</label></br>--%>
        <%--<div class="ui input" style="display: initial;">--%>
          <%--<input id="username" name="username" type="text" >--%>
        <%--</div></br>--%>
        <%--<label>密码</label></br>--%>
        <%--<div class="ui input" style="display: initial;">--%>
          <%--<input id="password" name="password" type="password" >--%>
        <%--</div>--%>
    <%--</div>--%>
     <%--<div class="actions">--%>
        <%--<a href="/OCare/pages/Register.jsp" style="color: white;">--%>
        <%--<div class="ui black button" style="float: left;background-color: #FF7770;margin-left: -10px;">--%>
          <%--注册--%>
        <%--</div>--%>
        <%--</a>--%>
        <%--忘记密码?--%>
        <%--<div class="ui positive right labeled icon submit button" style="background-color: #78D6CC">--%>
          <%--登陆--%>
          <%--<i class="checkmark icon"></i>--%>
        <%--</div>--%>
     <%--</div>--%>
      <%--<div class="ui error message" style="width: 90%;margin-left: 20px;"></div>--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</div>--%>

  <%--<script type="text/JavaScript">--%>
  <%--var aFunction = function()--%>
  <%--{--%>
    <%--//modal settings--%>
    <%--//Note that if settings is incorrect, the modal may freeze, and won't output any console error or such--%>
    <%--$('.modal').modal({--%>
      <%--detachable: true,--%>
      <%--//By default, if click outside of modal, modal will close--%>
      <%--//Set closable to false to prevent this--%>
      <%--closable: false,--%>
      <%--transition: 'fade up',--%>
      <%--//Callback function for the submit button, which has the class of "ok"--%>
      <%--onApprove : function() {--%>
        <%--//Submits the semantic ui form--%>
        <%--//And pass the handling responsibilities to the form handlers, e.g. on form validation success--%>
        <%--$('.ui.form').submit();--%>
        <%--//Return false as to not close modal dialog--%>
        <%--return false;--%>
      <%--},--%>
    <%--});--%>
    <%--$("#login").on("click", function(){--%>
      <%--//Resets form input fields--%>
      <%--$('.ui.form').trigger("reset");--%>
      <%--//Resets form error messages--%>
      <%--$('.ui.form .field.error').removeClass( "error" );--%>
      <%--$('.ui.form.error').removeClass( "error" );--%>
      <%--$('.modal').modal('show');--%>
    <%--});--%>
  <%--}--%>
  <%--$(document).ready( aFunction );--%>
<%--</script>--%>
<%--<script>--%>
  <%--var formValidationRules =--%>
  <%--{--%>
    <%--username: {--%>
      <%--identifier : 'username',--%>
      <%--rules: [--%>
        <%--{--%>
          <%--type   : 'empty',--%>
          <%--prompt : '请输入用户名/手机号/邮箱'--%>
        <%--}--%>
      <%--]--%>
    <%--},--%>
    <%--password: {--%>
      <%--identifier : 'password',--%>
      <%--//Below line sets it so that it only validates when input is entered, and won't validate on blank input--%>
      <%--optional   : true,--%>
      <%--rules: [--%>
        <%--{--%>
          <%--type   : 'empty',--%>
          <%--prompt : '请输入密码'--%>
        <%--}--%>
      <%--]--%>
    <%--}--%>
  <%--}--%>

  <%--var formSettings =--%>
  <%--{--%>
    <%--onSuccess : function()--%>
    <%--{--%>
      <%--//Hides modal on validation success--%>
      <%--alert("Valid Submission, modal will close.");--%>
      <%--$('.modal').modal('hide');--%>
    <%--}--%>
  <%--}--%>

  <%--$('.ui.form').form(formValidationRules, formSettings);--%>
<%--</script>--%>
