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
                            	查詢條件
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                             </span>
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    	标签：
                                    <input type="text" class="form-control" name="uiId" id="uiIDQuery" placeholder="请输入学号">&nbsp;
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
                            title="系统通知"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/office/message/listTsMessageInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'miCode',checkbox:true" width="50"></th>
								<th data-options="field:'miIssueDeptNm'" width="50">发布单位</th>
								<th data-options="field:'miIssueUserNm'" width="50">发布人姓名</th>
								<th data-options="field:'miType',formatter:formatType" width="50">通知类型</th>
								<th data-options="field:'miTitle'" width="50">标题</th>
								<th data-options="field:'miLvlNm'" width="50">通知级别</th>
								<th data-options="field:'miIssueDate',formatter:formatIssueDate" width="50">发布日期</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addTsMessageInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">发布通知</a>
			    </auth:ax>

			    <auth:ax srcId="role_updateTsMessageInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改通知</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_deleteTsMessageInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除通知</a>
			    </auth:ax>

				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="detailhButton()">查看通知</a>
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
function formatType(val,row)
{
	if(val=='01'){
	    return "内部";
	}else{
	    return "外部";
	}
}

function formatIssueDate(val,row){
        return row.miIssueDate + " " + row.miIssueTime;
}


/*
    重置表单数据
*/
function resetForm(){
    ClearForm("tsMessageInfoForm");
    
    //可以下面设置初始默认值
}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{
        	miCode:$('#miCodeQuery').val(),
        	miIssueDept:$('#miIssueDeptQuery').val(),
        	miIssueUser:$('#miIssueUserQuery').val(),
        	miIssueUserNm:$('#miIssueUserNmQuery').val(),
        	miType:$('#miTypeQuery').val(),
        	miTitle:$('#miTitleQuery').val(),
        	miContent:$('#miContentQuery').val(),
        	miLvl:$('#miLvlQuery').val(),
        	miFileIds:$('#miFileIdsQuery').val(),
        	miIssueDate:$('#miIssueDateQuery').val(),
        	miIssueTime:$('#miIssueTimeQuery').val()
	});
}

/*
 * 查看明细
 */
function detailhButton() {
    var row = $("#dataList").datagrid('getSelected');
    if(!row)
    {
        alert("请选择要查看的通知");
    }
    else
    {
        window.location.href="<%=basePath %>/office/message/gotoDetailPage.do?miCode=" + row.miCode;
    }
}

/**
 * 新增按钮
 */
function newButton() {
    window.location.href="<%=basePath%>/office/message/gotoAddNewMessagePage.do";
}

/**
 * 编辑按钮
 */
function editButton()
{
	var row = $("#dataList").datagrid('getSelected');
	if(!row)
	{
        ShowErrorDialog("请选择要修改的行");
	}
	else
	{
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/office/message/checkUserIssueMessage.do",
            data: {"miCode":row.miCode},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //可以进行删除
                    window.location.href="<%=basePath%>/office/message/gotoUpdatePage.do?miCode=" + row.miCode;

                }else {
                    ShowErrorDialog("该通知并非由你所发出，不能进行修改！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("检查失败"+ request.status + "," + request.responseText);
            }
        });

	}
	
}


/**
 * 刪除按钮
 */
function deleteButton() {

    var row = $("#dataList").datagrid('getSelected');
    if(!row)
    {
        ShowWarningDialog("请选择要删除的数据");
        return;
    }

    //删除前检查逻辑
    showConfirm("您确认要删除该通知吗？",function(){

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/office/message/checkUserIssueMessage.do",
            data: {"miCode":row.miCode},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //可以进行删除
                    deleteData(row.miCode);

                }else {
                    ShowErrorDialog("该通知并非由你所发出，不能进行删除！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("删除前检查失败"+ request.status + "," + request.responseText);
            }
        });


    });

}

//刪除数据操作
function deleteData(miCode){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/office/message/deleteTsMessageInfo.do",
        data: {"miCode":miCode},
        dataType: "json",
        success: function(data)
        {
            if(data.success){
                ShowSuccessDialog("删除数据成功！");
                $('#dataList').datagrid('reload');
            }else{
                ShowErrorDialog("删除数据失败！");
            }
        },
        error: function(request, status, err)
        {
            ShowErrorDialog("删除数据失败"+ request.status + "," + request.responseText);
        }
    });
}


</script>
</html>