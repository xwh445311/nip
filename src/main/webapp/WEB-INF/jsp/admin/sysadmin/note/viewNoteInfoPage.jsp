<%--
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
    <!-- left side start-->
    <%@ include file="/WEB-INF/jsp/admin/left.jsp" %>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content" >
        <!-- header section start-->
        <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
        <!-- header section end-->

        <!-- page heading start-->
        <%@ include file="/WEB-INF/jsp/admin/pageHeader.jsp" %>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
            <!-- 查詢條件區域 -->
            <div class="row">
                <div class="col-md-12">

                    <section class="mail-list">
                        <div class="mail-sender">
                            <div class="row">
                                <div class="col-md-8">
                                    <strong>
                                        ${tsNoteInfo.ntHead}
                                    </strong>
                                </div>
                                <div class="col-md-4">
                                    <p class="date">
                                        ${tsNoteInfo.ntSendDate}&nbsp;${tsNoteInfo.ntSendTime}
                                    </p>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="view-mail">
                            ${tsNoteInfo.ntContent}
                        </div>
                        <hr/>
                        <div class="compose-btn pull-left">
                            <button type="button" class="btn btn-sm btn-primary" onclick="backPage()"><i class="fa fa-reply"></i> 返回</button>
                        </div>
                    </section>

                </div>
            </div>
        </div>
    </div>
</section>


</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    function backPage(){
        window.location.href="<%=basePath%>/sysadmin/noteInfo/gotoTsNoteInfoPage.do?isMenu=Y&isBack=Y";
    }

</script>
</html>
