<%--
  Created by Auton Code.
  User: xwh
  Date: 2018-05-24 13:41:27
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
                            	发布新通知
                        </header>
                        <div class="panel-body" style="padding: 5px;">
							<form action="<%=basePath%>/office/message/addTsMessageInfo.do" id="tsMessageInfoForm" name="tsMessageInfoForm" method="post" role="form" enctype="multipart/form-data">
								<div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>

								<div class="form-group">
									<label for="miIssueDept"><span class="text-danger ">*</span>发布单位</label>
									<select class="form-control" id="miIssueDept" name="miIssueDept">
										<option value="">请选择</option>
										<c:forEach items="${orgSelList}" var="item">
											<option value="${item.key}">${item.value}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group">
									<label for="miType"><span class="text-danger ">*</span>通知类型</label>
									<select class="form-control" id="miType" name="miType">
										<option value="">请选择</option>
										<option value="01">内部</option>
										<option value="02">外部</option>
									</select>
								</div>

								<div class="form-group">
									<label for="miLvl"><span class="text-danger ">*</span>通知级别</label>
									<efs:selParam name="miLvl" id="miLvl" type="TS_MESSAGE_LVL" cls="form-control"/>
								</div>

								<div class="form-group">
									<label for="miTitle"><span class="text-danger ">*</span>标题</label>
									<input type="text" class="form-control" id="miTitle" name="miTitle" placeholder="标题">
								</div>

								<div class="form-group">
									<label><span class="text-danger ">*</span>正文</label>
									<ckeditor:editor textareaAttributes="<%=attr %>"
													 basePath="/SGOP/resource/ckeditor/" config="<%=settings %>"
													 editor="miContent"/>
								</div>

								<div class="form-group">
									<label for="uploadFiles">附件(可多选)</label>
									<input type="file" id="uploadFiles" name="uploadFiles" multiple="multiple">
								</div>


								<div class="form-group">
									<br/><button type="submit" class="btn btn-primary">提交</button>
								</div>

							</form>
                        </div>
                    </div>
                </div>
            </div>
            <br/>

		</div>
	</div>
</section>
</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	
    //初始化校验框架
    InitValidate("tsMessageInfoForm","errContent",{

            miIssueDept:"required"
            ,
            miType:"required"
            ,
            miLvl:"required"
			,
            miTitle:{
                maxlength:100,
				required:true
            },
        	miContent:"required"

},{
        miIssueDept:"发布单位:必须选择"

    ,
        miType:"通知类型:必须选择"
    ,

        miLvl:"通知级别:必须选择"
    ,
        miTitle:{
            maxlength:"标题：长度不能超过100位",
			required:"标题：必须输入"
        }
        ,
        miContent:"通知内容：必须输入"
    });
});


</script>
</html>