<%@ page import="com.efs.common.Util.SysConstant" %><%--
  Created by IntelliJ IDEA.
  User: xwh
  Date: 2017/7/5
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/common.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=SysConstant.PAGE_TITLE%></title>
    <%@ include file="/common/css.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/resource/jqueryui_1_5_2/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/resource/jqueryui_1_5_2/themes/icon.css">

</head>
<body class="sticky-header">
<section>

    <!-- main content start-->
    <div class="main-content" >
        <!--body wrapper start-->
        <div class="wrapper">

            <section class="error-wrapper text-center">
                <h1><img alt="" src="<%=basePath%>/resource/frame/images/500-error.png"></h1>
                <h2>系统出错误</h2>
                <h3>您访问的页面已经过期了，系统将在<span id="timeD" style="color: #ff111a">2</span>秒后返回登录页面</h3>
            </section>

        </div>

    </div>
</section>

</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

var t=2;
var a = setInterval(subTime,1000);
function subTime(){
    t--;
    $('#timeD').html(t);

    if(t==0){
        clearInterval(a);
        window.location.href="<%=basePath%>";
    }
}

</script>
</html>
