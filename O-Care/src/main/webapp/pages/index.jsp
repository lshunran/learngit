<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head lang="en">
    <title>HomePage</title>
    <link rel="stylesheet" href="/OCare/Assets/CSS/index.css">
    <link rel="stylesheet" href="/OCare/Assets/CSS/semantic.css" media="screen">
    <link rel="stylesheet" href="/OCare/Assets/CSS/icon.css" media="screen">
    <script src="/OCare/Assets/JS/jquery-2.1.4.js"></script>
    <script src="/OCare/Assets/JS/jquery.address.js"></script>
    <script src="/OCare/Assets/JS/semantic.js"></script>
</head>
<body class="home">
<div class="headers" >
    <div class="header-container">
        <img src="/OCare/Assets/Images/Ocare-logo.png">
        <div class="greeting">
             <strong>您好!</strong>
            <a id="login" class="login">登陆</a>
            <a href="/OCare/pages/Register.jsp">注册</a>
        </div>
        <div class="nav" >
            <ul>
                <li>
                    <a class="active item"><i class="home icon"></i> 首页</a>
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
<div class="container">
    <div class="ad" >
        <h2>福联网</h2>
        <h4>更权威  更全面  更放心  的老人关爱平台</h4>
    </div>
    <div class="bg-image">
        <img src="/OCare/Assets/Images/old-couple.jpg">
    </div>
    <div class="pic-left">
        <img src="/OCare/Assets/Images/work.jpg">
        <div class="right-block">
            <h3>我们如何工作</h3>
            <p>fewedafsdfnewfnnefainwfieonafieundhpfiansdfba</p>
        </div>
    </div>
    <div class="pic-right">
        <img src="/OCare/Assets/Images/old.jpg">
        <div class="left-block">
            <h3>我们的成果</h3>
            <p>fewedafsdfnewfnnefainwfieonafieundhpfiansdfba</p>
        </div>
    </div>
    <div class="pic-left">
        <img src="/OCare/Assets/Images/co.jpg">
        <div class="right-block">
            <h3>我们与谁合作</h3>
            <p>fewedafsdfnewfnnefainwfieonafieundhpfiansdfba</p>
        </div>
    </div>

    <div class="ui horizontal icon divider">
        <i class="icon home"></i>
    </div>

    <div class="whole">
        <h3>加入我们</h3>
        <div class="one-third">
            <img src="/OCare/Assets/Images/company.jpg">
            <h4>机构</h4>
            <p>afefopaepufa[odfjasdojfa;dfjia;oiejfaefsdf</p>
        </div>
        <div class="one-third">
            <img src="/OCare/Assets/Images/relative.jpg">
            <h4>家属</h4>
            <p>afefopaepufa[odfjasdojfa;dfjia;oiejfaefsdf</p>
        </div>
        <div class="one-third">
            <img src="/OCare/Assets/Images/volunteer.jpg">
            <h4>志愿者</h4>
            <p>afefopaepufa[odfjasdojfa;dfjia;oiejfaefsdf</p>
        </div>
    </div>

    <%--<div class="contect">--%>
        <%--<div class="ui attached message">--%>
            <%--<h2>联系我们</h2>--%>
            <%--<p style="text-align: center">如您想加入我们的团队，或有任何建议，请联系我们</p>--%>
        <%--</div>--%>
        <%--<form class="ui form attached fluid segment">--%>
            <%--<div class="two fields">--%>
                <%--<div class="field">--%>
                    <%--<label>姓名</label>--%>
                    <%--<input placeholder="name..." type="text">--%>
                <%--</div>--%>
                <%--<div class="field">--%>
                    <%--<label>电话</label>--%>
                    <%--<input placeholder="telephone..." type="text">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="field">--%>
                <%--<label>邮箱</label>--%>
                <%--<input placeholder="email..." type="text">--%>
            <%--</div>--%>
            <%--<div class="field">--%>
                <%--<label>您的意见</label>--%>
                <%--<textarea placeholder="your message... "></textarea>--%>
            <%--</div>--%>
            <%--<div class="inline field">--%>
                <%--<div class="ui checkbox">--%>
                    <%--<input id="terms" type="checkbox">--%>
                    <%--<label for="terms">我同意OCare网站的相关协议</label>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="ui teal submit button" style="text-align: center">提交</div>--%>
        <%--</form>--%>
    <%--</div>--%>
</div>
<!-----------登陆对话框--------->
<!----------------------------->
<div class="ui small modal" style="width:30%; margin-left: -15%">
    <i class="close icon"></i>
    <div class="header" style="background-color: #78D6CC;padding:1.1rem 2rem">
        <i class="user icon"></i>用户登陆
    </div>
    <div class="content" style="line-height: 40px;padding:2em 0rem;display: inline-block;">
        <form class="ui form" method="post" action="/OCare/pages/Map.jsp" target="_self">
            <div style="padding:0rem 1rem">
                <label>用户名/手机号/邮箱:</label></br>
                <div class="ui input" style="display: initial;">
                    <input id="username" name="username" type="text" >
                </div></br>
                <label>密码</label></br>
                <div class="ui input" style="display: initial;">
                    <input id="password" name="password" type="password" >
                </div>
            </div>
            <div class="actions">
                <a href="/OCare/pages/Register.jsp" style="color: white;">
                    <div class="ui black button" style="float: left;background-color: #FF7770;margin-left: -10px;">
                        注册
                    </div>
                </a>
                忘记密码?
                <div class="ui positive right labeled icon submit button" style="background-color: #78D6CC">
                    登陆
                    <i class="checkmark icon"></i>
                </div>
            </div>
            <div class="ui error message" style="width: 90%;margin-left: 20px;"></div>
        </form>
    </div>
</div>

<script type="text/JavaScript">
    var aFunction = function()
    {
        //modal settings
        //Note that if settings is incorrect, the modal may freeze, and won't output any console error or such
        $('.modal').modal({
            detachable: true,
            //By default, if click outside of modal, modal will close
            //Set closable to false to prevent this
            closable: false,
            transition: 'fade up',
            //Callback function for the submit button, which has the class of "ok"
            onApprove : function() {
                //Submits the semantic ui form
                //And pass the handling responsibilities to the form handlers, e.g. on form validation success
                $('.ui.form').submit();
                //Return false as to not close modal dialog
                return false;
            }
        });
        $(".login").on("click", function(){
            //Resets form input fields
            $('.ui.form').trigger("reset");
            //Resets form error messages
            $('.ui.form .field.error').removeClass( "error" );
            $('.ui.form.error').removeClass( "error" );
            $('.modal').modal('show');
        });
    }
    $(document).ready( aFunction );
</script>
<script>
    var formValidationRules =
    {
        username: {
            identifier : 'username',
            rules: [
                {
                    type   : 'empty',
                    prompt : '请输入用户名/手机号/邮箱'
                }
            ]
        },
        password: {
            identifier : 'password',
            //Below line sets it so that it only validates when input is entered, and won't validate on blank input
            optional   : true,
            rules: [
                {
                    type   : 'empty',
                    prompt : '请输入密码'
                }
            ]
        }
    }

    var formSettings =
    {
        onSuccess : function()
        {
            $('.modal').modal('hide');
        }
    }

    $('.ui.form').form(formValidationRules, formSettings);
</script>

</body>
</html>