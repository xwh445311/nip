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

					<section class="mail-box-info" id="printPlan">
						<header class="header">
							<div class="compose-btn pull-right">
								<a class="btn btn-sm btn-primary" href="javascript:void(0)" onclick="returnBack()"><i class="fa fa-reply"></i> Reply</a>
								<button title="" data-placement="top" data-toggle="tooltip" type="button" data-original-title="Print" class="btn btn-default  btn-sm tooltips" onclick="printPage()"><i class="fa fa-print"></i> </button>
							</div>
							<div class="btn-toolbar" >
								<h4 style="text-align: center">
									${messageInfo.miTitle}
								</h4>
							</div>
						</header>

						<section class="mail-list">
							<div class="mail-sender">
								<div class="row">
									<div class="col-md-8">
										<span>${messageInfo.miIssueUserNm}</span>
									</div>
									<div class="col-md-4">
										<p class="date"> ${messageInfo.miIssueDate} ${messageInfo.miIssueTime}</p>
									</div>
								</div>
							</div>
							<div class="view-mail">
								${messageInfo.miContent}
							</div>
							<c:if test="${not empty messageInfo.fileUploadList}">
								<div class="attachment-mail">
									<p>
										<span><i class="fa fa-paperclip"></i> ${fn:length(messageInfo.fileUploadList)} 个附件可下载： </span>

									</p>
									<ul>

										<c:forEach items="${messageInfo.fileUploadList}" var="item">
											<li>
												<a href="javascript:void(0)" onclick="dowloadFile('${item.fpId}')"  class="atch-thumb" style="text-align: center;">
													<img src="<%=basePath%>/resource/images/file.png" style="width: 50px;height: 50px;">
												</a>
												<div class="links">
													<a href="javascript:void(0)" onclick="dowloadFile('${item.fpId}')">${item.fpName}</a>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</c:if>

						</section>
					</section>

                </div>
            </div>
            <br/>

		</div>
	</div>
</section>
</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

function dowloadFile(fpId){
    window.location.href="<%=basePath%>/office/message/downloadFile.do?fileId=" + fpId;
}

function returnBack(){
    var flag = '${flag}';

    if(flag=='00'){
        //来源于首页
		window.location.href="<%=basePath%>/login/gotoMain.do";
    }else{
        window.location.href="<%=basePath%>/office/message/gotoTsMessageInfoPage.do?isBack=Y";
    }
}

function printPage(){
    oldHtml =window.document.body.innerHTML;
    window.document.body.innerHTML=$('#printPlan').html();
    window.print();
    window.document.body.innerHTML=oldHtml;
}

</script>
</html>