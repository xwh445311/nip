<%--
  Created by Auton Code.
  User: xwh
  Date: 2018-05-22 14:25:16
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
        
        	<!-- 查询条件 -->
            <div class="row">
                <div class="col-md-12">
                    <!--查询条件-->
                    <div class="panel panel-primary">
                        <header class="panel-heading">
                            	教案上传
                        </header>
                        <div class="panel-body" style="padding: 5px;">
							<form action="<%=basePath%>/edu/teaplan/doUploadTeaPlan.do" id="eduTeaplanInfoForm" name="eduTeaplanInfoForm" method="post" role="form" enctype="multipart/form-data">
								<div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
								<input type="hidden" class="form-control" id="tiDbId" name="tiDbId" value="${teaplanInfo.tiDbId}">

								<div class="form-group">
									<label for="tiBatchId"><span class="text-danger ">*</span>检查批次号</label>
									<input type="text" class="form-control" id="tiBatchId" name="tiBatchId" readonly="readonly" value="${teaplanInfo.tiBatchId}">
								</div>

								<div class="form-group">
									<label for="tiCheckedUserNm"><span class="text-danger ">*</span>被检查人姓名</label>
									<input type="text" class="form-control" id="tiCheckedUserNm" name="tiCheckedUserNm" readonly="readonly" value="${teaplanInfo.tiCheckedUser}_${teaplanInfo.tiCheckedUserNm}">
								</div>

								<div class="form-group">
									<label for="tiTermNm">学期</label>
									<input type="text" class="form-control" id="tiTermNm" name="tiTermNm" readonly="readonly" value="${teaplanInfo.tiTermNm}">
								</div>

								<div class="form-group">
									<label for="tiClassNm">班级</label>
									<input type="text" class="form-control" id="tiClassNm" name="tiClassNm" readonly="readonly" value="${teaplanInfo.tiClassNm}">
								</div>

								<div class="form-group">
									<label for="tiCourName">科目</label>
									<input type="text" class="form-control" id="tiCourName" name="tiCourName" readonly="readonly" value="${teaplanInfo.tiCourName}">
								</div>

								<div class="form-group">
									<label for="tiIssueDate">任务发布日期</label>
									<input type="text" class="form-control" id="tiIssueDate" name="tiIssueDate" readonly="readonly" value="${teaplanInfo.tiIssueDate}">
								</div>

								<div class="form-group">
									<label for="tiIssueUserNm">任务发布人</label>
									<input type="text" class="form-control" id="tiIssueUserNm" name="tiIssueUserNm" readonly="readonly" value="${teaplanInfo.tiIssueUserNm}">
								</div>

								<div class="form-group">
									<label for="tiIssueUserNm">说明</label>
									<textarea name="tiIssueCommon" id="tiIssueCommon" rows="5" cols="30" readonly="readonly" class="form-control">${teaplanInfo.tiIssueCommon}</textarea>
								</div>

								<div class="form-group">
									<label for="tiFileId"><span class="text-danger ">*</span>上传教案</label>
									<input type="file" id="tiFileId" name="tiFileId">
								</div>


								<div class="form-group">
									<br/><button type="button" class="btn btn-primary" onclick="saveData()">提交</button>&nbsp;
									<button type="button" class="btn btn-primary" onclick="returnBack()">返回</button>
								</div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <br/>
			<!-- 显示结果 -->
			<div class="row">
				<div class="col-md-12">

					<c:if test="${!empty errMsg}">
						<div class="alert alert-info fade in">
							<strong>上传结果提示!</strong> ${errMsg}
						</div>
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
	InitValidate("eduTeaplanInfoForm","errContent",{
        	tiFileId:"required"
        },{
        tiFileId:"上传教案必须输入"
        });
});


//保存数据操作
function saveData(){

    $('#eduTeaplanInfoForm').submit();
}

function returnBack(){
    window.location.href="<%=basePath%>/edu/teaplan/gotoMyTeachPlan.do?isBack=Y"
}

</script>
</html>