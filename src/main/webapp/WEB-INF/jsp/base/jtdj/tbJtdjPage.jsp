<%--
  Created by Auton Code.
  User: xuwh
  Date: 2020-05-19 21:51:13
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
            </div>--%>
            <br/>

			<!-- 列表区域 -->
			<div class="row">
				<div class="col-md-12" id="gridPanel">
					<table  id="dataList"
                            style="width: 100%"
                            title="阶梯单价"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/base/jtdj/listTbJtdj.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'dbId',checkbox:true" width="50"></th>
								<th data-options="field:'xzmc'" width="50">用水性质</th>
								<th data-options="field:'fymc'" width="50">费用名称</th>
								<th data-options="field:'jth'" width="50">阶梯号</th>
								<th data-options="field:'jtdj'" width="50">阶梯单价</th>
								<th data-options="field:'jtqs'" width="50">阶梯起始</th>
								<th data-options="field:'jtjs'" width="50">阶梯结束</th>
								<%--<th data-options="field:'csrq'" width="50">添加日期</th>--%>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addTbJtdj">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_updateTbJtdj">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_deleteTbJtdj">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
			    </auth:ax>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">TbJtdj</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="tbJtdjForm" name="tbJtdjForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
			           		
			           		<div class="form-group">
			                    <label for="dbId">业务编码</label>
			                    <input type="text" class="form-control" id="dbId" name="dbId" value="" readonly>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="ysxz"><span class="text-danger ">*</span>用水性质</label>
								<efs:select name="ysxz" id="ysxz" cls="form-control" list="${ysxzList}"/>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="fydm"><span class="text-danger ">*</span>费用名称</label>
								<efs:select name="fydm" id="fydm" cls="form-control" list="${fyxxList}"/>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="jth"><span class="text-danger ">*</span>阶梯号</label>
			                    <input type="text" class="form-control" id="jth" name="jth" placeholder="阶梯号">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="jtdj"><span class="text-danger ">*</span>阶梯单价</label>
			                    <input type="text" class="form-control" id="jtdj" name="jtdj" placeholder="阶梯单价">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="jtqs"><span class="text-danger ">*</span>阶梯起始</label>
			                    <input type="text" class="form-control" id="jtqs" name="jtqs" placeholder="阶梯起始">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="jtjs"><span class="text-danger ">*</span>阶梯结束</label>
			                    <input type="text" class="form-control" id="jtjs" name="jtjs" placeholder="阶梯结束">
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
	InitValidate("tbJtdjForm","errContent",{
		ysxz:"required",
		fydm:"required",
		jth:{
			required:true,
			digits:true
		},
		jtdj:{
			number:true
		},
		jtqs:{
			digits:true
		},
		jtjs:{
			digits:true
		}
        },{
			ysxz:"用水性质：必须选择",
			fydm:"费用名称：必须选择",
			jth:{
				required:"阶梯号:必须输入",
				digits:"阶梯号:必须输入"
			},
			jtdj:{
				number:"单价：必须是数字"
			},
			jtqs:{
				digits:"阶梯开始：必须是整数"
			},
			jtjs:{
				digits:"阶梯结束：必须是整数"
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
    ClearForm("tbJtdjForm");
    
    //可以下面设置初始默认值
}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{
        	dbId:$('#dbIdQuery').val(),
        	ysxz:$('#ysxzQuery').val(),
        	fydm:$('#fydmQuery').val(),
        	jth:$('#jthQuery').val(),
        	jtdj:$('#jtdjQuery').val(),
        	jtqs:$('#jtqsQuery').val(),
        	jtjs:$('#jtjsQuery').val(),
        	delbz:$('#delbzQuery').val(),
        	csrq:$('#csrqQuery').val()
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
        $('#tbJtdjForm').form('load','<%=basePath %>/base/jtdj/getTbJtdj.do?dbId=' + row.dbId);
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
            url: "<%=basePath%>/base/jtdj/checkTbJtdj.do",
            data: {"dbId":row.dbId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){


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
        url = "<%=basePath %>/base/jtdj/addTbJtdj.do";
        SubmitForm("tbJtdjForm",url,function(data){
            ShowSuccessDialog("数据增加成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据增加失败");
        });
    }else{
        //修改用戶信息
        url = "<%=basePath %>/base/jtdj/updateTbJtdj.do";
        SubmitForm("tbJtdjForm",url,function(data){
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
        url: "<%=basePath%>/base/jtdj/deleteTbJtdj.do",
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