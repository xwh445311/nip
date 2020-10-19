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
        
			<!-- 列表区域 -->
			<div class="row">
				<div class="col-md-12" id="gridPanel">
					<table  id="dataList"
                            style="width: 100%"
                            title="办公台"
                            rownumbers="true"
                            fitColumns="true"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/office/proc/listProcDefPage.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'id',checkbox:true" width="50"></th>
								<th data-options="field:'name'" width="50">流程名称</th>
								<th data-options="field:'description'" width="50">流程说明</th>
								<th data-options="field:'key',formatter:formatType" width="50">操作</th>
							</tr>
						</thead>
					</table>
				</div>
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