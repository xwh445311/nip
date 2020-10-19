<%--
  Created by Auton Code.
  User: xwh
  Date: 2020-05-24 20:51:32
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
                            title="抄表员信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/base/cby/listTbCbyInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'dbId',checkbox:true" width="50"></th>
								<th data-options="field:'gsName'" width="50">所属公司</th>
								<th data-options="field:'cbyId'" width="50">抄表员ID</th>
								<th data-options="field:'cbyName'" width="50">抄表员姓名</th>
								<%--<th data-options="field:'status'" width="50">1有效，0无效</th>--%>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addTbCbyInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_updateTbCbyInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_deleteTbCbyInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
			    </auth:ax>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">TbCbyInfo</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="tbCbyInfoForm" name="tbCbyInfoForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>

							<div class="form-group">
								<label for="dbId">主键ID</label>
								<input type="text" class="form-control" id="dbId" name="dbId" value="" readonly>
							</div>
			           		
			           		<div class="form-group">
			                    <label for="gsNo"><span class="text-danger ">*</span>所属分公司</label>
								<efs:select name="gsNo" id="gsNo" cls="form-control" list="${branchOrgSelect}" onchange="changeOrg()"/>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="cbyId"><span class="text-danger ">*</span>抄表员</label>
								<select name="cbyId" id="cbyId" class="form-control">
									<option value="">请选择</option>
								</select>
			                </div>
			           		
			           		<%--<div class="form-group">
			                    <label for="status"><span class="text-danger ">*</span>状态</label>
			                    <input type="text" class="form-control" id="status" name="status" placeholder="1有效，0无效">
			                </div>--%>

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
	InitValidate("tbCbyInfoForm","errContent",{
				gsNo:required,
				cbyId:required,
				status:required
        },{
				gsNo:"所属分公司:必须选择",
				cbyId:"抄表员:必须选择",
				status:"状态:必须选择"
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
 * 根据机构查询用户信息
 */
function changeOrg() {
	var gsNo = $('#gsNo').val();
	genSelectListFromRemote("cbyId",'<%=basePath %>/sysadmin/userAdmin/listOrgUserList.do',{userOrg:gsNo},true);
}


/*
    重置表单数据
*/
function resetForm(){
    ClearForm("tbCbyInfoForm");
    
    //可以下面设置初始默认值

}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{
        	gsNo:$('#gsNoQuery').val(),
        	cbyId:$('#cbyIdQuery').val(),
        	status:$('#statusQuery').val()
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
		$('#tbCbyInfoForm').form('load','<%=basePath %>/base/cby/getTbCbyInfo.do?dbId=' + row.dbId);
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

		//可以进行删除
		deleteData(row.dbId);

		/*$.ajax({
			async: false,
			ifModified:true,
			type: "POST",
			url: "<%=basePath%>/base/cby/checkTbCbyInfo.do",
			data: {"dbId":row.dbId},
			dataType: "json",
			success: function(data)
			{
				if(data.success){
					//可以进行删除
					deleteData(row.dbId);

				}else {
					ShowErrorDialog("请设置不能删除提示！");
				}
			},
			error: function(request, status, err)
			{
				ShowErrorDialog("删除前检查失败"+ request.status + "," + request.responseText);
			}
		});*/


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
		url = "<%=basePath %>/base/cby/addTbCbyInfo.do";
		SubmitForm("tbCbyInfoForm",url,function(data){
			ShowSuccessDialog("数据增加成功");
			$('#myModal').modal('hide');
			$('#dataList').datagrid('reload');
		},function () {
			ShowErrorDialog("数据增加失败");
		});
	}else{
		//修改用戶信息
		url = "<%=basePath %>/base/cby/updateTbCbyInfo.do";
		SubmitForm("tbCbyInfoForm",url,function(data){
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
		url: "<%=basePath%>/base/cby/deleteTbCbyInfo.do",
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