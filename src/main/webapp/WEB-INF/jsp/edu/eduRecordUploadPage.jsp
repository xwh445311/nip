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

            <!-- 查詢條件區域 -->
            <div class="row">
                <div class="col-md-12">
                    <!--查询条件-->
                    <div class="panel panel-primary">
                        <header class="panel-heading">
                            学生成绩上传
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form role="form" id="studentForm" name="studentForm" action="<%=basePath%>/edu/record/uploadStuRecordInfo.do" method="post" enctype="multipart/form-data">
                                <input type="hidden" id="riTerm" name="riTerm" value="${semesterCal.scTerm}">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>

                                <div class="form-group">
                                    <label>学期：</label>
                                    ${semesterCal.scTermDesc}
                                </div>

                                <div class="form-group">
                                    <label for="riClass"><span class="text-danger ">*</span>期中/期末</label>
                                    <efs:selParam name="riMidTerm" id="riMidTerm" type="BASE_MID_TERM" />
                                </div>

                                <div class="form-group">
                                    <label for="riClass">班级(<span class="text-danger ">下载模板时必选</span>)</label>
                                    <efs:selClass cls="form-control" id="riClass" name="riClass" scTerm="${semesterCal.scTerm}" />
                                </div>

                                <div class="form-group">
                                    <label for="uploadFile"><span class="text-danger ">*</span>上传文件</label>
                                    <input type="file" name="uploadFile" id="uploadFile" multiple="multiple" />
                                </div>

                                <button type="button" class="btn btn-success" onclick="doUploadFile()">上传</button> &nbsp;
                                <button type="button" class="btn btn-info" onclick="downloadModel()">下载模板</button> &nbsp;
                                <!--<button type="button" class="btn btn-primary" onclick="returnList()">返回</button> -->
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-md-12">
                <efs:msgPane msgType="INFO" title="上传注意事项">
                    <br/>
                    1、数据上传时，请先根据班级和期中/期末下载模板，模板会自动导出学生信息，导出模板后，请不要修改模板的班级名称。<br/>
                    2、填充好模板内容后，上传数据时，不需要选择班级，系统根据每个上传文件的班级名称进行处理。<br/>
                    3、如果已经上传过了成绩，重新上传时，则会覆盖之前上传的内容，以本次上传的结果为准。
                </efs:msgPane>

                <c:if test="${not empty errMsg}">
                    <efs:msgPane msgType="ERROR" content="${errMsg}"/>
                </c:if>
                </div>
            </div>

            <!-- 显示结果 -->
            <div class="row">
                <div class="col-md-12">

                    <c:if test="${!empty msg}">
                        <efs:msgPane msgType="WARN" title="上传结果提示!" content="${msg}"/>
                    </c:if>
                </div>
            </div>
        </div>

    </div>
</section>

<form id="downForm" method="post" action="<%=basePath%>/edu/record/downFileModel.do" style="display: none">
    <input type="hidden" id="riTerm_d" name="riTerm" value="${semesterCal.scTerm}">
    <input type="hidden" id="riClass_d" name="riClass">
    <input type="hidden" id="riMidTerm_d" name="riMidTerm">
</form>
</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    $(document).ready(function(){

        //初始化校验框架
        InitValidate("studentForm","errContent",{

            riTerm:'required',
            riMidTerm:'required',
            uploadFile:'required'
        },{
            riTerm:'当前学期日历尚未指定',
            riMidTerm:'期中/期末：必须选择',
            uploadFile:'上传文件：必须选择'
        });
    });

    function returnList() {
        window.location.href="<%=basePath%>/edu/student/gotoStudnetListPage.do"
    }

    function downloadModel(){
        var riTerm = $('#riTerm_d').val();
        var riClass = $('#riClass').val();
        var riMidTerm = $('#riMidTerm').val();

        if(riTerm == ''){
            ShowWarningDialog("当前学期日历尚未指定");
            return;
        }

        if(riClass == ''){
            ShowWarningDialog("班级必须选择");
            return;
        }

        if(riMidTerm == ''){
            ShowWarningDialog("期中/期末必须选择");
            return;
        }

        $('#riClass_d').val(riClass);
        $('#riMidTerm_d').val(riMidTerm);
        $('#downForm').submit();
    }

    /**
     * 上传文件
     */
    function doUploadFile() {

        $('#studentForm').submit();
        $('body').mLoading({text:'正在上传，请等待'});
    }


</script>
</html>
