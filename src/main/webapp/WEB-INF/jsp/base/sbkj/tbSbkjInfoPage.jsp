<%--
  Created by Auton Code.
  User: xwh
  Date: 2020-05-17 11:59:17
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
            <%--<div class="row">
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
            <br/>--%>

			<!-- 列表区域 -->
			<div class="row">
				<div class="col-md-12" id="gridPanel">
					<table  id="dataList"
                            style="width: 100%"
                            title="水表口径信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/base/sbkj/listTbSbkjInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'sbkj'" width="50">水表口径</th>
								<th data-options="field:'zxyl'" width="50">最小用量</th>
								<th data-options="field:'gcyl'" width="50">公称用量</th>
								<th data-options="field:'zdyl'" width="50">最大用量</th>
								<th data-options="field:'rjyl'" width="50">日均用量</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addTbSbkjInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_updateTbSbkjInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_deleteTbSbkjInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
			    </auth:ax>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">口径管理</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="tbSbkjInfoForm" name="tbSbkjInfoForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
			           		
			           		<div class="form-group">
			                    <label for="sbkj"><span class="text-danger ">*</span>水表口径</label>
			                    <input type="text" class="form-control" id="sbkj" name="sbkj" placeholder="水表口径">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="zxyl">最小用量</label>
			                    <input type="text" class="form-control" id="zxyl" name="zxyl" placeholder="最小用量">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="gcyl">公称用量</label>
			                    <input type="text" class="form-control" id="gcyl" name="gcyl" placeholder="公称用量">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="zdyl">最大用量</label>
			                    <input type="text" class="form-control" id="zdyl" name="zdyl" placeholder="最大用量">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="rjyl">日均用量</label>
			                    <input type="text" class="form-control" id="rjyl" name="rjyl" placeholder="日均用量">
			                </div>
			           		
			           		<%--<div class="form-group">
			                    <label for="bjsl"><span class="text-danger ">*</span>未定义</label>
			                    <input type="text" class="form-control" id="bjsl" name="bjsl" placeholder="未定义">
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
	var saveType = "N";
$(document).ready(function(){
	
	//初始化DATA GRID分頁控件
	initDataGridPage("dataList");
	
	//初始化校验框架
	InitValidate("tbSbkjInfoForm","errContent",{
				sbkj:{
					required:true,
					digits:true
				},
				zxyl:{
					number:true
				},
				gcyl:{
					number:true
				},
				zdyl:{
					number:true
				},
				rjyl:{
					number:true
				}
        },{
				sbkj:{
					required:"水表口径：必须输入",
					digits:"水表口径：只能输入整数"
				},
				zxyl:{
					number:"最小用量：必须为有效数字"
				},
				gcyl:{
					number:"公称用量：必须为有效数字"
				},
				zdyl:{
					number:"最大用量：必须为有效数字"
				},
				rjyl:{
					number:"日均用量：必须为有效数字"
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
    ClearForm("tbSbkjInfoForm");
    
    //可以下面设置初始默认值
}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{
        	sbkj:$('#sbkjQuery').val(),
        	zxyl:$('#zxylQuery').val(),
        	gcyl:$('#gcylQuery').val(),
        	zdyl:$('#zdylQuery').val(),
        	rjyl:$('#rjylQuery').val(),
        	bjsl:$('#bjslQuery').val()
	});
}

/**
 * 新增按钮
 */
function newButton() {
	saveType = "N";
    ResetValidate();
    resetForm();
    $('#myModal').modal('show');
}

/**
 * 编辑按钮
 */
function editButton()
{
	saveType = "U";
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
        $('#tbSbkjInfoForm').form('load','<%=basePath %>/base/sbkj/getTbSbkjInfo.do?sbkj=' + row.sbkj);
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
		deleteData(row.sbkj);
        /*$.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/base/sbkj/checkTbSbkjInfo.do",
            data: {"sbkj":row.sbkj},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //可以进行删除
                    deleteData(row.sbkj);

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
    var sbkj = $('#sbkj').val();
    var url = '';


    //數據校驗
    if(!Vlaidate()){
        return;
    }

    if(saveType == 'N'){
        //新增
        url = "<%=basePath %>/base/sbkj/addTbSbkjInfo.do";
        SubmitForm("tbSbkjInfoForm",url,function(data){
            ShowSuccessDialog("数据增加成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据增加失败");
        });
    }else{
        //修改用戶信息
        url = "<%=basePath %>/base/sbkj/updateTbSbkjInfo.do";
        SubmitForm("tbSbkjInfoForm",url,function(data){
            ShowSuccessDialog("数据修改成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据修改失败");
        });
    }
}


//刪除数据操作
function deleteData(sbkj){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/base/sbkj/deleteTbSbkjInfo.do",
        data: {"sbkj":sbkj},
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