<%--
  Created by Auton Code.
  User: xwh
  Date: 2020-08-08 22:41:38
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
                            title="启用量设立"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/base/qylsl/listTbSbqyl.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'dbId',checkbox:true" width="50"></th>
								<th data-options="field:'xzmc'" width="50">性质名称</th>
								<th data-options="field:'sbkj'" width="50">水表口径</th>
								<th data-options="field:'qyl'" width="50">启用量</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addTbSbqyl">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_updateTbSbqyl">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_deleteTbSbqyl">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
			    </auth:ax>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">TbSbqyl</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="tbSbqylForm" name="tbSbqylForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
			           		
			           		<div class="form-group">
			                    <label for="dbId"><span class="text-danger ">*</span>主键ID</label>
			                    <input type="text" class="form-control" id="dbId" name="dbId" placeholder="主键ID" readonly="readonly">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="xzdm"><span class="text-danger ">*</span>用户性质</label>
								<efs:select id="xzdm" name="xzdm" list="${ysxzList}" cls="form-control"/>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="sbkj"><span class="text-danger ">*</span>水表口径</label>
								<efs:select id="sbkj" name="sbkj" list="${sbkjList}" cls="form-control"/>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="qyl"><span class="text-danger ">*</span>启用量</label>
			                    <input type="text" class="form-control" id="qyl" name="qyl" placeholder="启用量">
			                </div>
				           
					        <div class="form-group">
				                <br/><button type="button" class="btn btn-primary" onclick="saveData()">提交</button>
				            </div>
				           
				       </form>
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
	InitValidate("tbSbqylForm","errContent",{
		xzdm:"required"	,
		sbkj:"required"
		,
		qyl:{
			required:true,
			digits:true
		}
	},{
		xzdm:"用水性质：必须选择",
		sbkj:"水表口径：必须选择",
		qyl:{
			required:"启用量：必须输入",
			digits:"启用量：必须为数字"
		}
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


/*
    重置表单数据
*/
function resetForm(){
    ClearForm("tbSbqylForm");
    
    //可以下面设置初始默认值
}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{
        	dbId:$('#dbIdQuery').val(),
        	xzdm:$('#xzdmQuery').val(),
        	sbkj:$('#sbkjQuery').val(),
        	qyl:$('#qylQuery').val()
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
        $('#tbSbqylForm').form('load','<%=basePath %>/base/qylsl/getTbSbqyl.do?dbId=' + row.dbId);
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
    showConfirm("您确认要删除吗？",function(){

		deleteData(row.dbId);

    });

}

//保存数据操作
function saveData(){
    var dbId = $('#dbId').val();
    var url = '';


    //數據校驗
    if(!Vlaidate()){
        return;
    }

    if(dbId == ''){
        //新增
        url = "<%=basePath %>/base/qylsl/addTbSbqyl.do";
        SubmitForm("tbSbqylForm",url,function(data){
            ShowSuccessDialog("数据增加成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据增加失败");
        });
    }else{
        //修改用戶信息
        url = "<%=basePath %>/base/qylsl/updateTbSbqyl.do";
        SubmitForm("tbSbqylForm",url,function(data){
            ShowSuccessDialog("数据修改成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据修改失败");
        });
    }
}


//刪除数据操作
function deleteData(dbId){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/base/qylsl/deleteTbSbqyl.do",
        data: {"dbId":dbId},
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