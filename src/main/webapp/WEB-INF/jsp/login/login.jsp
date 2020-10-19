<!DOCTYPE html>
<%@ include file="/common/common.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: xwh
  Date: 2017/6/21
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>官店民族小学综合办公平台</title>
    <%@ include file="/common/css.jsp" %>

    <script type="text/javascript">

        function freshImg(){
            $("#kapid").attr("src","<%=basePath%>/Kaptcha.jpg?timeStamp=" + (new Date()).valueOf());
        }


    </script>

</head>


<body class="login-body">

<div class="container">

    <form class="form-signin" action="<%=basePath%>/login/doLogin.do" method="post">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title"></h1>
            <img src="<%=basePath%>/resource/frame/images/schoolLogo.png" alt="" style="with:200px;height: 130px;"/>
        </div>
        <div class="login-wrap">
            <input type="text" name="uiId" id="uiId" class="form-control" placeholder="学号/用户ID" autofocus>
            <input type="password" name="uiPassword" id="uiPassword" class="form-control" placeholder="密码">
            <input type="text" name="validCode" id="validCode" class="form-control" placeholder="验证码" />
            <a href="#" onclick="freshImg()" ><img id="kapid" alt="" src="<%=basePath%>/Kaptcha.jpg" width="80" height="30"></a>

            <button class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>

            <div class="registration">
                Copyright 2018 徐武海  AllRightsReserved
            </div>
            <%--<label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> Forgot Password?</a>

                </span>
            </label>--%>

        </div>

        <div>
            <c:if test="${errMsg eq '1' }">
                <div align="center" >
                    <b><font color="red">登錄錯誤，員工編號不存在！</font></b>
                </div>
            </c:if>
            <c:if test="${errMsg eq '2' }">
                <div align="center" >
                    <b><font color="red">登錄錯誤，密碼不正確！</font></b>
                </div>
            </c:if>
            <c:if test="${errMsg eq '3' }">
                <div align="center">
                    <b><font color="red">登錄錯誤，此用戶己被禁用！</font></b>
                </div>
            </c:if>
            <c:if test="${errMsg eq '4' }">
                <div align="center">
                    <b><font color="red">登錄錯誤，用戶類型不正確！</font></b>
                </div>
            </c:if>
            <c:if test="${errMsg eq '5' }">
                <div align="center">
                    <b><font color="red">登录错误，尚未开通系统使用权限！</font></b>
                </div>
            </c:if>
            <c:if test="${errMsg eq '6' }">
                <div align="center">
                    <b><font color="red">校驗碼錯誤！</font></b>
                </div>
            </c:if>

        </div>

        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Forgot Password ?</h4>
                    </div>
                    <div class="modal-body">
                        <p>Enter your e-mail address below to reset your password.</p>
                        <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                        <button class="btn btn-primary" type="button">Submit</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal -->

    </form>

</div>


</body>
<%@ include file="/common/script.jsp" %>
</html>
