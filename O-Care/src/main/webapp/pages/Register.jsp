<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/10/15
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@include file="templates/header.jsp"%>
<div style="width:1250px;margin:30px auto">
  <!--步骤条-->
     <div class="ui ordered steps" style="margin: 10px 410px">
          <div class="active step">
            <div class="content">
              <div class="title">填写信息</div>
            </div>
          </div>
          <div class="disabled step">
            <div class="content">
              <div class="title">申请审核</div>
            </div>
          </div>
          <div class="disabled step">
            <div class="content">
              <div class="title">注册成功</div>
            </div>
          </div>
     </div>
  <!--步骤条-->

  <div id="context1" style="width:1250px">
    <!--个人机构选择按钮-->
      <div class="ui secondary menu" style="margin:10px 500px">
        <a class="item active" data-tab="first">机构注册</a>
        <a class="item " data-tab="second">个人注册</a>
      </div>
    <!--个人机构选择按钮-->
    <!-------------------------------------------->
                  <!--机构注册-->
    <!-------------------------------------------->
    <div class="ui tab segment active" data-tab="first">
      <form class="ui form" method="post" action="/OCare/pages/WaitPermition.jsp" target="_blank">
            <table style="margin: 30px 100px;">
              <tr style="line-height: 80px;">
                <td>机构名称:</td>
                <td>
                  <div class="ui input"><input type="text" id="agent_name" name="agent_name" style="width:300px"></div>
                </td>
                <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">营业执照上传</button></td>
                <td><div class="ui input"><input type="text" id="licence_pic" style="width:300px"></div></td>
              </tr>
              <tr style="line-height: 80px;">
                <td>组织结构代码证号：</td>
                <td>
                  <div class="ui input"><input type="text" id="angent_code" style="width:300px"></div>
                </td>
                <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">组织代码证上传</button></td>
                <td><div class="ui input"><input type="text" id="code_pic" style="width:300px"></div></td>
              </tr>
              <tr style="line-height: 80px;">
                <td>法人姓名：</td>
                <td>
                  <div class="ui input"><input type="text" id="legalperson_name" style="width:300px"></div>
                </td>
                <td></td>
                <td></td>
              </tr>
              <tr style="line-height: 80px;">
                <td>法人身份证号：</td>
                <td>
                  <div class="ui input"><input type="text" id="legalperson_id" style="width:300px"></div>
                </td>
                <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">身份证上传</button></td>
                <td><div class="ui input"><input type="text" id="id_pic" style="width:300px"></div></td>
              </tr>
              <tr style="line-height: 80px;">
                <td>法人手机号：</td>
                <td>
                  <div class="ui input"><input type="text" id="legalperson_tel" style="width:300px"></div>
                </td>
                <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">获取验证码</button></td>
                <td><div class="ui input"><input type="text" id="verification" style="width:300px"></div></td>
              </tr>
              <tr style="line-height: 80px;">
                <td>密码</td>
                <td>
                  <div class="ui input"><input type="password" id="password" name="password" style="width:300px"></div>
                </td>
                <td></td>
                <td></td>
              </tr>
              <tr style="line-height: 80px;">
                <td>再次输入密码</td>
                <td>
                  <div class="ui input">
                    <input type="password" id="confirm" name="confirmPassword" style="width:300px">
                  </div>
                </td>
              </tr>
            </table>

             <div class="ui checkbox" style="margin-left: 130px;">
               <input name="isAgree" type="checkbox"/>
               <label>我同意相关协议</label>
             </div>
               <div class="ui fluid positive large submit button" style="margin: 30px 100px;width:80%">
                 提交
               </div>
        <div class="ui error message" style="width: 80%;margin-left: 100px;"></div>
      </form>

    </div>
    <!-------------------------------------------->
                  <!--机构注册结束-->
    <!-------------------------------------------->

    <div class="ui tab segment active" data-tab="second">
      <div class="ui top attached tabular menu">
        <a class="active item" data-tab="second/a">监护人</a>
        <a class="item" data-tab="second/b">志愿者</a>
      </div>
    <!-------------------------------------------->
                  <!--监护人注册-->
    <!-------------------------------------------->

      <div class="ui bottom attached active tab segment" data-tab="second/a">
        <form class="ui form" method="post" action="/OCare/pages/WaitPermition.jsp" target="_blank">
             <table style="margin: 30px auto;">
               <tr style="line-height: 80px;">
                 <td>姓名：</td>
                 <td>
                   <div class="ui input"><input type="text" id="guardian_name" name="name" style="width:300px"></div>
                 </td>
                 <td>
                   <form method="get" action="xznetwork" name="textfile" >
                     <div class="ui teal button" style="width: 200px;background-color: #78D6CC;">上传头像
                       <input type="file" name="file" id="doc" multiple="multiple" style="opacity: 0;margin-top: -23px;" onchange="javascript:setImagePreview();">
                     </div>
                   </form>
                 </td>
                 <td rowspan="3" height="301" align="center">
                   <div id="localImag">
                     <img id="preview" src="" width="300" height="300" style="display: block;border-radius: 10px;" />
                   </div>
                 </td>
               </tr>
               <tr>
                 <td>性别：</td>
                 <td>
                   <div class="ui form" id="guardian_gender">
                     <input type="hidden" name="gender" id="user_gender" value="">
                     <div class="grouped inline fields">
                         <div class="field" style="display: inline-block;">
                           <div class="ui radio checkbox">
                             <label>男</label>
                             <input name="gender" value="male" checked="checked" type="radio" style="top: -1px;left: -3px;opacity: 0.3;">
                           </div>
                         </div>
                         <div class="field" style="display: inline-block;">
                           <div class="ui radio checkbox">
                             <label>女</label>
                             <input name="gender" value="female" type="radio" style="top: -1px;left: -3px;opacity: 0.5;">
                           </div>
                         </div>
                       </div>
                     </div>
                 </td>
                   <input type="hidden" name="confirm" id="confirm_default" value="">
                 </td>
               </tr>
               <tr style="line-height: 80px;">
                 <td>出生年月：</td>
                 <td>
                   <div class="ui selection dropdown">
                     <input type="hidden" name="Year">
                     <div class="default text">选择年份</div>
                     <i class="dropdown icon"></i>
                     <div class="menu">
                       <div class="item" data-value="1">1960</div>
                       <div class="item" data-value="1">1961</div>
                       <div class="item" data-value="1">1962</div>
                       <div class="item" data-value="1">1963</div>
                       <div class="item" data-value="1">1964</div>
                       <div class="item" data-value="1">1965</div>
                       <div class="item" data-value="1">1966</div>
                       <div class="item" data-value="1">1967</div>
                       <div class="item" data-value="1">1968</div>
                       <div class="item" data-value="1">1969</div>
                       <div class="item" data-value="1">1970</div>
                       <div class="item" data-value="1">1971</div>
                       <div class="item" data-value="1">1972</div>
                       <div class="item" data-value="1">1973</div>
                       <div class="item" data-value="1">1974</div>
                       <div class="item" data-value="1">1975</div>
                       <div class="item" data-value="1">1976</div>
                       <div class="item" data-value="1">1977</div>
                       <div class="item" data-value="1">1978</div>
                       <div class="item" data-value="1">1979</div>
                       <div class="item" data-value="1">1980</div>
                       <div class="item" data-value="1">1981</div>
                       <div class="item" data-value="1">1982</div>
                       <div class="item" data-value="1">1983</div>
                       <div class="item" data-value="1">1984</div>
                       <div class="item" data-value="1">1985</div>
                       <div class="item" data-value="1">1986</div>
                       <div class="item" data-value="1">1987</div>
                       <div class="item" data-value="1">1988</div>
                       <div class="item" data-value="1">1989</div>
                       <div class="item" data-value="1">1990</div>
                       <div class="item" data-value="1">1991</div>
                       <div class="item" data-value="1">1992</div>
                       <div class="item" data-value="1">1993</div>
                       <div class="item" data-value="1">1994</div>
                       <div class="item" data-value="1">1995</div>
                       <div class="item" data-value="1">1996</div>
                       <div class="item" data-value="1">1997</div>
                       <div class="item" data-value="1">1998</div>
                       <div class="item" data-value="1">1999</div>
                       <div class="item" data-value="1">2000</div>
                       <div class="item" data-value="1">2001</div>
                       <div class="item" data-value="1">2002</div>
                       <div class="item" data-value="1">2003</div>
                       <div class="item" data-value="1">2004</div>
                       <div class="item" data-value="1">2005</div>
                       <div class="item" data-value="1">2006</div>
                       <div class="item" data-value="1">2007</div>
                       <div class="item" data-value="1">2008</div>
                       <div class="item" data-value="1">2009</div>
                       <div class="item" data-value="1">2010</div>
                     </div>
                   </div>
                   <div class="ui selection dropdown">
                     <input type="hidden" name="Month">
                     <div class="default text">选择月份</div>
                     <i class="dropdown icon"></i>
                     <div class="menu">
                       <div class="item" data-value="Jan">1</div>
                       <div class="item" data-value="Feb">2</div>
                       <div class="item" data-value="Mar">3</div>
                       <div class="item" data-value="Apr">4</div>
                       <div class="item" data-value="May">5</div>
                       <div class="item" data-value="Jun">6</div>
                       <div class="item" data-value="Jul">7</div>
                       <div class="item" data-value="Aug">8</div>
                       <div class="item" data-value="Sep">9</div>
                       <div class="item" data-value="Oct">10</div>
                       <div class="item" data-value="Nov">11</div>
                       <div class="item" data-value="Dec">12</div>
                     </div>
                   </div>
                 </td>
               </tr>

               <tr style="line-height: 80px;">
                 <td>身份证号：</td>
                 <td>
                   <div class="ui input"><input type="text" id="guardian_id" style="width:300px"></div>
                 </td>
                 <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">身份证上传</button></td>
                 <td><div class="ui input"><input type="text" id="guardian_pic" style="width:300px"></div></td>
               </tr>
               <tr style="line-height: 80px;">
                 <td>手机号：</td>
                 <td>
                   <div class="ui input"><input type="text" id="guardian_tel" style="width:300px"></div>
                 </td>
                 <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">获取验证码</button></td>
                 <td><div class="ui input"><input type="text" id="guardian_verification" style="width:300px"></div></td>
               </tr>
               <tr style="line-height: 80px;">
                 <td>密码</td>
                 <td>
                   <div class="ui input"><input type="password" id="guardian_password" name="password" style="width:300px"></div>
                 </td>
                 <td></td>
                 <td></td>
               </tr>
               <tr style="line-height: 80px;">
                 <td>再次输入密码</td>
                 <td>
                   <div class="ui input"><input type="password" id="guardian_confirm" name="conformPassword" style="width:300px"></div>
                 </td>
                 <td></td>
                 <td></td>
               </tr>
             </table>
        <div class="ui checkbox" style="margin-left: 130px;">
          <input name="isAgree" type="checkbox"/>
          <label>我同意相关协议</label>
        </div>
          <div class="ui fluid positive large submit button" style="margin: 30px 100px;width:80%">
            提交
          </div>
          <div class="ui error message" style="width: 80%;margin-left: 100px;"></div>
        </form>
      </div>
      <!-------------------------------------------->
                   <!--监护人注册结束-->
      <!-------------------------------------------->

      <!-------------------------------------------->
                    <!--志愿者注册-->
      <!-------------------------------------------->
      <div class="ui bottom attached tab segment" data-tab="second/b">
        <form class="ui form" method="post" action="/OCare/pages/WaitPermition.jsp" target="_blank">
        <table style="margin: 30px auto;">
          <tr style="line-height: 80px;">
            <td>姓名：</td>
            <td>
              <div class="ui input"><input type="text" id="volenteer_name" name="name" style="width:300px"></div>
            </td>
            <td>
              <form method="get" action="xznetwork" name="textfile">
                <div class="ui teal button" style="width: 200px;background-color: #78D6CC;">上传头像
                  <input type="file" name="file" id="doc1" multiple="multiple" style="opacity: 0;margin-top: -23px;" onchange="javascript:setImagePreview1();">
                </div>
              </form>
            </td>
            <td rowspan="3" height="301" align="center">
              <div id="localImag1">
                <img id="preview1" src="" width="300" height="300" style="display: block;border-radius: 10px;" />
              </div>
            </td>
          </tr>
          <tr>
            <td>性别：</td>
            <td>
              <div class="ui form">
                <div class="grouped inline fields">
                  <div class="field" style="display: inline-block;">
                    <div class="ui radio checkbox">
                      <label>男</label>
                      <input name="gender" value="male" checked="checked" type="radio" style="top: -1px;left: -3px;opacity: 0.3;">
                    </div>
                  </div>
                  <div class="field" style="display: inline-block;">
                    <div class="ui radio checkbox">
                      <label>女</label>
                      <input name="gender" value="female" type="radio" style="top: -1px;left: -3px;opacity: 0.5;">
                    </div>
                  </div>
                </div>
              </div>
            </td>
          </tr>
          <tr style="line-height: 80px;">
            <td>出生年月：</td>
            <td>
              <div class="ui selection dropdown">
                <input type="hidden" name="Year">
                <div class="default text">选择年份</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                  <div class="item" data-value="1">1960</div>
                  <div class="item" data-value="1">1961</div>
                  <div class="item" data-value="1">1962</div>
                  <div class="item" data-value="1">1963</div>
                  <div class="item" data-value="1">1964</div>
                  <div class="item" data-value="1">1965</div>
                  <div class="item" data-value="1">1966</div>
                  <div class="item" data-value="1">1967</div>
                  <div class="item" data-value="1">1968</div>
                  <div class="item" data-value="1">1969</div>
                  <div class="item" data-value="1">1970</div>
                  <div class="item" data-value="1">1971</div>
                  <div class="item" data-value="1">1972</div>
                  <div class="item" data-value="1">1973</div>
                  <div class="item" data-value="1">1974</div>
                  <div class="item" data-value="1">1975</div>
                  <div class="item" data-value="1">1976</div>
                  <div class="item" data-value="1">1977</div>
                  <div class="item" data-value="1">1978</div>
                  <div class="item" data-value="1">1979</div>
                  <div class="item" data-value="1">1980</div>
                  <div class="item" data-value="1">1981</div>
                  <div class="item" data-value="1">1982</div>
                  <div class="item" data-value="1">1983</div>
                  <div class="item" data-value="1">1984</div>
                  <div class="item" data-value="1">1985</div>
                  <div class="item" data-value="1">1986</div>
                  <div class="item" data-value="1">1987</div>
                  <div class="item" data-value="1">1988</div>
                  <div class="item" data-value="1">1989</div>
                  <div class="item" data-value="1">1990</div>
                  <div class="item" data-value="1">1991</div>
                  <div class="item" data-value="1">1992</div>
                  <div class="item" data-value="1">1993</div>
                  <div class="item" data-value="1">1994</div>
                  <div class="item" data-value="1">1995</div>
                  <div class="item" data-value="1">1996</div>
                  <div class="item" data-value="1">1997</div>
                  <div class="item" data-value="1">1998</div>
                  <div class="item" data-value="1">1999</div>
                  <div class="item" data-value="1">2000</div>
                  <div class="item" data-value="1">2001</div>
                  <div class="item" data-value="1">2002</div>
                  <div class="item" data-value="1">2003</div>
                  <div class="item" data-value="1">2004</div>
                  <div class="item" data-value="1">2005</div>
                  <div class="item" data-value="1">2006</div>
                  <div class="item" data-value="1">2007</div>
                  <div class="item" data-value="1">2008</div>
                  <div class="item" data-value="1">2009</div>
                  <div class="item" data-value="1">2010</div>
                </div>
              </div>
              <div class="ui selection dropdown">
                <input type="hidden" name="Month">
                <div class="default text">选择月份</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                  <div class="item" data-value="Jan">1</div>
                  <div class="item" data-value="Feb">2</div>
                  <div class="item" data-value="Mar">3</div>
                  <div class="item" data-value="Apr">4</div>
                  <div class="item" data-value="May">5</div>
                  <div class="item" data-value="Jun">6</div>
                  <div class="item" data-value="Jul">7</div>
                  <div class="item" data-value="Aug">8</div>
                  <div class="item" data-value="Sep">9</div>
                  <div class="item" data-value="Oct">10</div>
                  <div class="item" data-value="Nov">11</div>
                  <div class="item" data-value="Dec">12</div>
                </div>
              </div>
            </td>
          </tr>
          <tr style="line-height: 80px;">
            <td>身份证号：</td>
            <td>
              <div class="ui input"><input type="text" id="volenteer_id" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">身份证上传</button></td>
            <td><div class="ui input"><input type="text" id="vid_pic" style="width:300px"></div></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>手机号：</td>
            <td>
              <div class="ui input"><input type="text" id="vol_tel" style="width:300px"></div>
            </td>
            <td><button class="ui teal button" style="width: 200px;background-color: #78D6CC;">获取验证码</button></td>
            <td><div class="ui input"><input type="text" id="vol_verification" style="width:300px"></div></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>密码</td>
            <td>
              <div class="ui input"><input type="password" id="vol_password" name="password" style="width:300px"></div>
            </td>
            <td></td>
            <td></td>
          </tr>
          <tr style="line-height: 80px;">
            <td>再次输入密码</td>
            <td>
              <div class="ui input"><input type="password" id="vol_confirm" name="confirmPassword" style="width:300px"></div>
            </td>
            <td></td>
            <td></td>
          </tr>
        </table>
          <div class="ui checkbox" style="margin-left: 130px;">
            <input name="isAgree" type="checkbox"/>
            <label>我同意相关协议</label>
          </div>
          <div class="ui fluid positive large submit button" style="margin: 30px 100px;width:80%">
            提交
          </div>
          <div class="ui error message" style="width: 80%;margin-left: 100px;"></div>
        </form>
      </div>
      <!-------------------------------------------->
                 <!--志愿者注册结束-->
      <!-------------------------------------------->
    </div>
</div>
<script>

  $('.ui.form')
          .form({
            agent_name:{
              identifier:'agent_name',
              rules:[{
                type:'empty',
                prompt:"请输入机构名称"
              }]
            },
            name:{
              identifier:'name',
              rules:[{
                type:'empty',
                prompt:"请输入您的姓名"
              }]
            },
            password: {
              identifier: 'password',
              rules: [{
                type: 'empty',
                prompt: "请设置您的密码"
              }, {
                type: 'length[3]',
                prompt: "密码最少长度为3个字符"
              }]
            },
            confirmPassword: {
              identifier: 'confirmPassword',
              rules: [{
                type: 'match[password]',
                prompt: "密码不符"
              }]
            },
            isAgree: {
              identifier: 'isAgree',
              rules: [{
                type: 'checked',
                prompt: "您必须先同意相关条例"
              }]
            },
            gender: {
              identifier: 'gender',
              rules:[{
                type:'checked',
                prompt:"请选择您的性别"
              }]
            },
  })
</script>
<script>
  function setImagePreview(avalue) {
  //input
  var docObj = document.getElementById("doc");
  //img
  var imgObjPreview = document.getElementById("preview");
  //div
  var divs = document.getElementById("localImag");

  if (docObj.files && docObj.files[0]) {

    //火狐下，直接设img属性

    imgObjPreview.style.display = 'block';

    imgObjPreview.style.width = '300px';

    imgObjPreview.style.height = '300px';

    //imgObjPreview.src = docObj.files[0].getAsDataURL();

    //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式

    imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);

  } else {

    //IE下，使用滤镜

    docObj.select();

    var imgSrc = document.selection.createRange().text;

    var localImagId = document.getElementById("localImag");

    //必须设置初始大小

    localImagId.style.width = "300px";

    localImagId.style.height = "300px";

    //图片异常的捕捉，防止用户修改后缀来伪造图片

    try {

      localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";

      localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;

    } catch(e) {

      alert("您上传的图片格式不正确，请重新选择!");

      return false;

    }

    imgObjPreview.style.display = 'none';

    document.selection.empty();

  }

  return true;

}</script>
<script>
  function setImagePreview1(avalue) {
    //input
    var docObj1 = document.getElementById("doc1");
    //img
    var imgObjPreview1 = document.getElementById("preview1");
    //div
    var divs1 = document.getElementById("localImag1");

    if (docObj1.files && docObj1.files[0]) {

      //火狐下，直接设img属性

      imgObjPreview1.style.display = 'block';

      imgObjPreview1.style.width = '300px';

      imgObjPreview1.style.height = '300px';

      //imgObjPreview1.src = docObj1.files[0].getAsDataURL();

      //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式

      imgObjPreview1.src = window.URL.createObjectURL(docObj1.files[0]);

    } else {

      //IE下，使用滤镜

      docObj1.select();

      var imgSrc = document.selection.createRange().text;

      var localImagId = document.getElementById("localImag");

      //必须设置初始大小

      localImagId.style.width = "300px";

      localImagId.style.height = "300px";

      //图片异常的捕捉，防止用户修改后缀来伪造图片

      try {

        localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";

        localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;

      } catch(e) {

        alert("您上传的图片格式不正确，请重新选择!");

        return false;

      }

      imgObjPreview1.style.display = 'none';

      document.selection.empty();
    }
    return true;
  }</script>

  <script src="/OCare/Assets/JS/register.js"></script>

<%@include file="templates/footer.jsp"%>