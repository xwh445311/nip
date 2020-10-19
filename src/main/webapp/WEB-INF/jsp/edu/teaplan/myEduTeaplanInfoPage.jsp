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
                            	查詢條件
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                             </span>
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form class="form-inline" role="form">
                                <div class="form-group">
									学期：
									<efs:selSems name="tiTerm" id="tiTermQuery" cls="form-control" selVal="${sessionScope.eduTeaplanInfoForm.tiTerm}" />&nbsp;
									课程：
									<efs:selParam name="tiCourCode" id="tiCourCodeQuery" type="BASE_SCORE_INFO" cls="form-control" selVal="${sessionScope.eduTeaplanInfoForm.tiCourCode}"/>&nbsp;
									状态：
									<select name="tiStatus" id="tiStatusQuery" class="form-control">
										<option value="">请选择</option>
										<option value="0" <c:if test="${sessionScope.eduTeaplanInfoForm.tiStatus=='0'}">selected</c:if>>未提交</option>
										<%--<option value="1" <c:if test="${sessionScope.eduTeaplanInfoForm.tiStatus=='1'}">selected</c:if>>已上传未提交</option>--%>
										<option value="2" <c:if test="${sessionScope.eduTeaplanInfoForm.tiStatus=='2'}">selected</c:if>>已提交</option>
										<option value="3" <c:if test="${sessionScope.eduTeaplanInfoForm.tiStatus=='3'}">selected</c:if>>已评定</option>
									</select>
                                </div>
                                <button type="button" class="btn btn-primary" onclick="searchButton()">查询</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <br/>

			<!-- 列表区域 -->
			<div class="row">
				<div class="col-md-12" id="gridPanel">
					<table  id="dataList"
                            style="width: 100%"
                            title="我的教案"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/teaplan/listMyEduTeaplanInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'tiDbId',checkbox:true" width="50"></th>
								<th data-options="field:'tiBatchId'" width="50">检查批次号</th>
								<th data-options="field:'tiTermNm'" width="50">学期</th>
								<th data-options="field:'tiClassNm'" width="50">班级</th>
								<th data-options="field:'tiCourName'" width="50">科目</th>
								<th data-options="field:'tiEndDate'" width="50">提交截止日期</th>
								<th data-options="field:'tiStatus',formatter:formatStatus" width="50">提交状态</th>
								<th data-options="field:'tiIssueDate'" width="50">发布日期</th>
								<th data-options="field:'tiIssueUserNm'" width="50">发布人</th>
								<th data-options="field:'tiIssueCommon'" width="50">发布说明</th>
								<th data-options="field:'tiSubDate'" width="50">提交日期</th>
								<th data-options="field:'tiSubUserNm'" width="50">提交人</th>
								<th data-options="field:'tiEvalLvlNm'" width="50">评价等级</th>
								<th data-options="field:'tiEvalScore'" width="50">评价分数</th>
								<th data-options="field:'tiEvalComm'" width="50">评价说明</th>
								<th data-options="field:'tiEvalDate'" width="50">评价日期</th>
								<th data-options="field:'tiEvalUserNm'" width="50">评价人</th>
								<th data-options="field:'tiEvalTime',formatter:formatDetail" width="50">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">教案上传</a>

			    <auth:ax srcId="role_updateEduTeaplanInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_deleteEduTeaplanInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
			    </auth:ax>
			</div>

		</div>
	</div>
</section>
</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	
	//初始化DATA GRID分頁控件
	initDataGridPage("dataList");
});

/*
 * 格式化代码
 */
function formatStatus(val,row)
{
	if(val == '0'){
	    return "<font color='red'>未提交</font>";
    }else if(val == '2'){
        return "<font color='green'>已提交</font>";
    }else if(val == '3'){
        return "<font color='#a9a9a9'>已评定</font>";
    }
}

function formatDetail(val,row){

    if(row.tiStatus == '0'){
        return "";
	}
	else{
        return "<a href='#' onclick='downTeachPlan(\"" +row.tiFileId+ "\")'>下载教案</a>";
	}

}

function formatDate(val,row){
        return ((row.updDate == null ) ? "" : row.updDate ) + " " + ((row.updTime == null ) ? "" : row.updTime );
}

function downTeachPlan(fileId){
    window.location.href="<%=basePath%>/edu/teaplan/downloadTeaplan.do?tiFileId=" + fileId;
}


/*
    重置表单数据
*/
function resetForm(){
    ClearForm("eduTeaplanInfoForm");
    
    //可以下面设置初始默认值
}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{

        	tiTerm:$('#tiTermQuery').val(),
        	tiCourCode:$('#tiCourCodeQuery').val(),
            tiStatus:$('#tiStatusQuery').val()
	});
}

/**
 * 新增按钮
 */
function newButton() {

    var row = $("#dataList").datagrid('getSelected');
    if(!row)
    {
        ShowErrorDialog("请选择要上传的科目");
        return;
    }

    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/edu/teaplan/checkPlanHasNoUpload.do",
        data: {"tiDbId":row.tiDbId},
        dataType: "json",
        success: function(data)
        {
            if(data.success){
                //可以进行提交
                window.location.href="<%=basePath%>/edu/teaplan/gotoUploadPlanPage.do?tiDbId=" + row.tiDbId;

            }else {
                ShowErrorDialog("该教案已经上传！");
            }
        },
        error: function(request, status, err)
        {
            ShowErrorDialog("检查失败"+ request.status + "," + request.responseText);
        }
    });
}

</script>
</html>