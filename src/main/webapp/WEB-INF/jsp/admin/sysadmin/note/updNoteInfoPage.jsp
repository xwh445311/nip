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

            <form action="<%=basePath%>/sysadmin/noteInfo/updateTsNoteInfo.do" role="form" id="noteForm">
                <input type="hidden" name="ntId" value="${tsNoteInfo.ntId}">
            <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
            <!-- 查詢條件區域 -->
            <div class="row">
                <div class="col-md-12">
                    <!--消息头-->
                    <div class="panel panel-primary">
                        <header class="panel-heading">
                            系統消息
                        </header>
                        <div class="panel-body" style="padding: 5px;">

                            <div class="form-group">
                                <label class="control-label"><span class="text-danger ">*</span>消息主旨</label>
                                <input type="text" class="form-control" name="ntHead" id="ntHead" maxlength="50" value="${tsNoteInfo.ntHead}" placeholder="請輸入消息主旨">
                            </div>
                    </div>

                    <!--消息内容-->
                    <div id="petDiv">
                        <div>
                            <section class="panel">
                                <header class="panel-heading">
                                    <span class="petTitle"><span class="text-danger ">*</span>消息內容</span>
                                    <span class="tools pull-right">
                                 </span>
                                </header>
                                <div class="panel-body" style="padding: 5px;">

                                    <ckeditor:editor textareaAttributes="<%=attr %>"
                                                     basePath="/PetHospital/resource/ckeditor/" config="<%=settings %>"
                                                     editor="ntContent"
                                                     value="${tsNoteInfo.ntContent }"/>
                                </div>
                            </section>
                        </div>
                    </div>

                    <br/><br/>
                    <button type="button" class="btn btn-primary" onclick="checkAndSubmit()">儲存</button>
                    <button type="button" class="btn btn-danger" onclick="backPage()">返回</button>
                </div>
            </div>
            </div>
            </form>

        </div>

    </div>
</section>


</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    $(document).ready(function(){

        //初始化校验框架
        InitValidate("noteForm","errContent",{
            ntHead:{
                required:true,
                maxlength:50
            },
            ntContent:{
                required:true,
                maxlength:350
            }
        },{
            ntHead:{
                required:"消息主旨：必須輸入",
                maxlength:"消息主旨：最大長度小於50"
            },
            ntContent:{
                required:"消息內容：必須輸入",
                maxlength:"消息內容：最大長度小於350"
            }
        });
    });

    /**
     * 校验并提交表单
     *
     **/
    function checkAndSubmit() {

        $('#noteForm').submit();
    }


    function backPage(){
        window.location.href="<%=basePath%>/base/petInfo/gotoPcPetInfoPage.do?isBack=Y";
    }

</script>
</html>
