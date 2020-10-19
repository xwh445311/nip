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
                            	查询条件
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                             </span>
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form class="form-inline" role="form">
                                <div class="form-group">
									学期：
									<efs:selSems name="tiTerm" id="tiTermQuery" cls="form-control" />&nbsp;
									科目：
									<efs:selParam name="tiCourCode" id="tiCourCodeQuery" type="BASE_SCORE_INFO" cls="form-control" />&nbsp;
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
                            title="教案检查发布信息表"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/teaplan/listIssueEduTeaplanInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'tiDbId',checkbox:true" width="50"></th>
								<th data-options="field:'tiBatchId'" width="50">检查批次号</th>
								<th data-options="field:'tiTermNm'" width="50">学期</th>
								<th data-options="field:'tiCourName'" width="50">科目</th>
								<th data-options="field:'totCnt',formatter:totFormat" width="50">检查总人数</th>
								<th data-options="field:'submitCnt',formatter:subFormat" width="50">未提交人数</th>
								<th data-options="field:'evalCnt',formatter:evalFormat" width="50">未评定人数</th>
								<th data-options="field:'tiEndDate'" width="50">提交截止日期</th>
								<th data-options="field:'tiIssueDate'" width="50">任务发布日期</th>
								<th data-options="field:'tiIssueUserNm'" width="50">发布人</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">发布检查任务</a>

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
			    <auth:ax srcId="role_updateEduTeaplanInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
			    </auth:ax>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">EduTeaplanInfo</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="eduTeaplanInfoForm" name="eduTeaplanInfoForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>

			           		<div class="form-group">
			                    <label for="tiBatchId"><span class="text-danger ">*</span>检查批次号</label>
			                    <input type="text" class="form-control" id="tiBatchId" name="tiBatchId" placeholder="检查批次号" readonly="readonly">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="tiTerm"><span class="text-danger ">*</span>学期</label>
								<efs:selSems name="tiTerm" id="tiTerm" cls="form-control" />
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="tiCourCode"><span class="text-danger ">*</span>科目</label>
								<efs:selParam name="tiCourCode" id="tiCourCode" type="BASE_SCORE_INFO" cls="form-control" />
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="tiEndDate"><span class="text-danger ">*</span>提交截止日期</label>
								<input type="text" class="form-control" id="tiEndDate" name="tiEndDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
			                </div>

                            <div class="form-group">
                                <label for="tiEndDate">备注</label>
                                <textarea name="tiIssueCommon" id="tiIssueCommon" rows="5" cols="30" class="form-control"></textarea>
                            </div>


					        <div class="form-group">
				                <br/><button type="button" class="btn btn-primary" onclick="saveData()">提交</button>
				            </div>
				           
				       </form>
			       	</div>
			       </div>
				</div>
			</div>

            <br/>
            <!-- 弹出各人明细 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="funcModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">人员明细</h4>
                        </div>
                        <div class="modal-body">
                            <span id="teachs"></span>
                        </div>
                    </div>
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
	
	//初始化校验框架
	InitValidate("eduTeaplanInfoForm","errContent",{
            		tiTerm:"required"

				,
            		tiCourCode:"required"

				,
            		tiEndDate:"required"
        },{

            		tiTerm:"学期：必须选择"
				,
            		tiCourCode:"科目:必须选择"
				,
            		tiEndDate:"截至日期：必须选择"
        });
});

/*
 * 格式化代码
 */
function formatState(val,row)
{
	
}

function formatDate(val,row){
        return ((row.updDate == null ) ? "" : row.updDate ) + " " + ((row.updTime == null ) ? "" : row.updTime );
}

function totFormat(val, row) {
    //查询总人数
    return "<a href='#' onclick='showTeachers(\"" +row.tiBatchId+ "\",\"9\")'>"+val+"</a>";
}

function subFormat(val, row) {
    //查询未提交
    return "<a href='#' onclick='showTeachers(\"" +row.tiBatchId+ "\",\"0\")'>"+val+"</a>";
}

function evalFormat(val, row) {
    //查询未评定
    return "<a href='#' onclick='showTeachers(\"" +row.tiBatchId+ "\",\"2\")'>"+val+"</a>";
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
        	tiCourCode:$('#tiCourCodeQuery').val()
	});
}

/**
 * 新增按钮
 */
function newButton() {
    ResetValidate();
    resetForm();
    $('#myModal').modal('show');
}

/**
 * 编辑按钮
 */
function editButton()
{
	var row = $("#dataList").datagrid('getSelected');
	if(!row)
	{
		alert("请选择要修改的行");
	}
	else
	{
		ResetValidate();
        resetForm();
        
		$('#myModal').modal('show');
        $('#eduTeaplanInfoForm').form('load','<%=basePath %>/edu/teaplan/getEduTeaplanInfo.do?tiDbId=' + row.tiDbId);
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
    showConfirm("您确认要删除这个批次的教案吗，删除后不能恢复？",function(){

        deleteData(row.tiBatchId);

    });

}

//保存数据操作
function saveData(){
    var url = '';

    //數據校驗
    if(!Vlaidate()){
        return;
    }

    url = "<%=basePath %>/edu/teaplan/issueEduTeaplanInfo.do";
    SubmitForm("eduTeaplanInfoForm",url,function(data){
        ShowSuccessDialog("数据增加成功");
        $('#myModal').modal('hide');
        $('#dataList').datagrid('reload');
    },function () {
        ShowErrorDialog("数据增加失败");
    });
}


//刪除数据操作
function deleteData(tiBatchId){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/edu/teaplan/deleteBatchEduTeaplan.do",
        data: {"tiBatchId":tiBatchId},
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


/**
 * 顯示角色的功能明細
 * @param roleId
 */
function showTeachers(tiBatchId,tiStatus){

    $('#teachs').empty();
    $('#funcModal').modal('show');

    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/edu/teaplan/getStatusTeachers.do",
        data: {"tiBatchId":tiBatchId,"tiStatus":tiStatus},
        dataType: "json",
        success: function(data)
        {
            if(data.success){
                $('#teachs').empty();
                $('#teachs').append(data.data);
            }else{
                ShowErrorDialog("获取数据信息失败！");
            }
        },
        error: function(request, status, err)
        {
            ShowErrorDialog("获取信息数据失败:" + request.status + "," + request.responseText);
        }
    });
}

</script>
</html>