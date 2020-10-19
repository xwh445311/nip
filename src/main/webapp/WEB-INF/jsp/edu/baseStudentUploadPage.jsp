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
                            学生信息上传
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form role="form" id="studentForm" name="studentForm" action="<%=basePath%>/edu/student/uploadStudentInfo.do" method="post" enctype="multipart/form-data">

                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
                                <div class="form-group">
                                    <label for="usClass"><span class="text-danger ">*</span>班级</label>
                                    <efs:selClass cls="form-control" id="usClass" name="usClass" />
                                </div>

                                <div class="form-group">
                                    <label for="uploadFile"><span class="text-danger ">*</span>上传文件</label>
                                    <input type="file" name="uploadFile" id="uploadFile" />
                                    &nbsp;
                                    <a href="<%=basePath%>/fileModel/downLoadModel.do?modelId=uploadStudentModel">下载模板</a>
                                </div>


                                <button type="submit" class="btn btn-success">上传</button> &nbsp;
                                <button type="button" class="btn btn-primary" onclick="returnList()">返回</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 显示结果 -->
            <div class="row">
                <div class="col-md-12">

                    <c:if test="${!empty msg}">
                        <div class="alert alert-info fade in">
                            <strong>上传结果提示!</strong> ${msg}
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <c:if test="${!empty repeatUser}">
                        重复上传学生信息:<br/>
                        <c:forEach items="${repeatUser}" var="item">
                            ${item.uiId}-${item.uiName},
                        </c:forEach>
                    </c:if>
                </div>
            </div>

        </div>

    </div>
</section>

</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    $(document).ready(function(){

        //初始化校验框架
        InitValidate("studentForm","errContent",{

            usClass:'required',
            uploadFile:'required'
        },{
            usClass:"班级：必须选择",
            uploadFile:"上传文件：必须选择"
        });
    });

    function returnList() {
        window.location.href="<%=basePath%>/edu/student/gotoStudnetListPage.do"
    }


</script>
</html>
