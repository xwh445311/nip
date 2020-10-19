<%--
  Created by Auton Code.
  User: xuwh
  Date: 2018-05-04 23:25:56
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
                                    <efs:selSems name="riTerm" id="riTermQuery" cls="form-control" onchange="changeClass()" selVal="${sessionScope.eduRecordInfoForm.riTerm}"/>&nbsp;
									期中/期末:
									<efs:selParam name="riMidTerm" id="riMidTermQuery" cls="form-control" type="BASE_MID_TERM" selVal="${sessionScope.eduRecordInfoForm.riMidTerm}"/>&nbsp;
									班级
									<efs:selClass name="riClass" id="riClassQuery" cls="form-control" selVal="${sessionScope.eduRecordInfoForm.riClass}"/>

                                </div>
                                &nbsp;
                                <button type="button" class="btn btn-primary" onclick="searchButton()">查询</button>
                                &nbsp;
								<button type="button" class="btn btn-primary" onclick="computeStatics()">计算成绩统计</button>
								&nbsp;
                                <button type="button" class="btn btn-primary" onclick="downClassButton()">下载班统计表</button>
								&nbsp;
								<button type="button" class="btn btn-primary" onclick="downSchoolButton()">下载学校统计表</button>
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
                            title="学生成绩信息表"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/record/listEduRecordInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'riId',checkbox:true" width="50" rowspan="2"></th>
								<th data-options="field:'riTermName'" width="50" rowspan="2">学期</th>
								<th data-options="field:'riMidTerm',formatter:formateMidTerm" width="50" rowspan="2">期中/末</th>
								<th data-options="field:'riClassName'" width="50" rowspan="2">班级</th>
								<th data-options="field:'riStuId'" width="50" rowspan="2">学号</th>
								<th data-options="field:'riStuName'" width="50" rowspan="2">姓名</th>
								<%--<th data-options="field:'riTestId'" width="50" rowspan="2">考号</th>--%>
								<th data-options="field:'riYw'" width="50" rowspan="2">语文</th>
								<th data-options="field:'riSx'" width="50" rowspan="2">数学</th>
								<th data-options="field:'riEng'" width="50" rowspan="2">英语</th>
								<th data-options="field:'riKx'" width="50" rowspan="2">科学</th>
								<th data-options="field:'riPs'" width="50" rowspan="2">品社</th>
								<th data-options="field:'riTot'" width="50" rowspan="2">总分</th>
								<th colspan="2">总分排名</th>
								<th colspan="2">语文排名</th>
								<th colspan="2">数学排名</th>
								<th colspan="2">英语排名</th>
								<th colspan="2">科学排名</th>
								<th colspan="2">品社排名</th>
								<th data-options="field:'hasCommon',formatter:formatCommon" width="50" rowspan="2">是否评定</th>
							</tr>
							<tr>
								<th data-options="field:'riClassRanChgVal'" width="50">班级</th>
								<th data-options="field:'riGradeRanChg2Val'" width="50">年级</th>
								<th data-options="field:'riYwClsRanChgVal'" width="50">班级</th>
								<th data-options="field:'riYwGraRanChg2Val'" width="50">年级</th>
								<th data-options="field:'riSxClsRanChgVal'" width="50">班级</th>
								<th data-options="field:'riSxGraRanChg2Val'" width="50">年级</th>
								<th data-options="field:'riEngClsRanChgVal'" width="50">班级</th>
								<th data-options="field:'riEngGraRanChg2Val'" width="50">年级</th>
								<th data-options="field:'riKxClsRanChgVal'" width="50">班级</th>
								<th data-options="field:'riKxGraRanChg2Val'" width="50">年级</th>
								<th data-options="field:'riPsClsRanChgVal'" width="50">班级</th>
								<th data-options="field:'riPsGraRanChg2Val'" width="50">年级</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

			<br/><br/>
			<!-- 列表区域 -->
			<div class="row">
				<div class="col-md-12" id="gridPanel2">
					<table  id="dataList2"
							style="width: 100%"
							title="班级成绩统计表"
							rownumbers="true"
							fitColumns="true"
							singleSelect="true"
							collapsible="true"
							url="<%=basePath %>/edu/record/listClassStatic.do"
							method="post">
						<thead>
						<tr>
							<th data-options="field:'csTermName'" width="50">学期</th>
							<th data-options="field:'csMidTerm',formatter:formateMidTerm" width="50">期中/末</th>
							<th data-options="field:'csClassName'" width="50">班级</th>
							<th data-options="field:'csLeadName'" width="50">班主任</th>
							<th data-options="field:'csCourName'" width="50">课程</th>
							<th data-options="field:'csCourTeacherNm'" width="50">任课老师</th>
							<th data-options="field:'csCourYkr'" width="50">应考人</th>
							<th data-options="field:'csCourSkr'" width="50">实考人</th>
							<th data-options="field:'csCourCklVal'" width="50">参考率</th>
							<th data-options="field:'csCourZf'" width="50">总分</th>
							<th data-options="field:'csCourJf'" width="50">均分</th>
							<th data-options="field:'csCourJfPm'" width="50">均分排名</th>
							<th data-options="field:'csCourGfrs'" width="50">高分人</th>
							<th data-options="field:'csCourGflVal'" width="50">高分率</th>
							<th data-options="field:'csCourGflPm'" width="50">高分率排名</th>
							<th data-options="field:'csCourYfrs'" width="50">优分人</th>
							<th data-options="field:'csCourYflVal'" width="50">优分率</th>
							<th data-options="field:'csCourYflPm'" width="50">优分率排名</th>
							<th data-options="field:'csCourJgrs'" width="50">及格人</th>
							<th data-options="field:'csCourJglVal'" width="50">及格率</th>
							<th data-options="field:'csCourJglPm'" width="50">及格率排名</th>
							<th data-options="field:'csCourDfrs'" width="50">低分人</th>
							<th data-options="field:'csCourDflVal'" width="50">低分率</th>
							<th data-options="field:'csCourDflPm'" width="50">低分率排名</th>
						</tr>
						</thead>
					</table>
				</div>
			</div>

			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addEduRecordInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
			    </auth:ax>
			    
			    <auth:ax srcId="role_updateLeaderCommont">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">班主任评价</a>
			    </auth:ax>
			    
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-more" plain="true" onclick="detailButton()">详情</a>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">班主任评定</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="eduRecordInfoForm" name="eduRecordInfoForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
                            <input type="hidden" class="form-control" id="riId" name="riId">

			           		<div class="form-group">
			                    <label for="riStuId">学号</label>
			                    <input type="text" class="form-control" id="riStuId" name="riStuId" readonly="readonly">
			                </div>

			           		<div class="form-group">
			                    <label for="riStuName">姓名</label>
			                    <input type="text" class="form-control" id="riStuName" name="riStuName" readonly="readonly">
			                </div>

			           		<div class="form-group">
			                    <label for="riTot">总分</label>
			                    <input type="text" class="form-control" id="riTot" name="riTot" readonly="readonly">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="riClassRan">总分班内排名</label>
			                    <input type="text" class="form-control" id="riClassRan" name="riClassRan" readonly="readonly">
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="riClassRanChg">总分班内排名变化</label>
			                    <input type="text" class="form-control" id="riClassRanChg" name="riClassRanChg" readonly="readonly">
			                </div>

			           		<div class="form-group">
			                    <label for="riGenEval"><span class="text-danger ">*</span>综合评定</label>
                                <efs:selParam name="riGenEval" id="riGenEval" type="EDU_GEN_EVAL"/>
			                </div>
			           		
			           		<div class="form-group">
			                    <label for="riLeaderCommon"><span class="text-danger ">*</span>班主任评价</label>
                                <textarea class="form-control" id="riLeaderCommon" name="riLeaderCommon" rows="5" cols="30"></textarea>
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

    initDataGridPage("dataList2");
	
	//初始化校验框架
	InitValidate("eduRecordInfoForm","errContent",{
            riGenEval:"required"
            ,
            riLeaderCommon:"required"

        },{

            riGenEval:"综合评定：必须选择"
            ,
            riLeaderCommon:"班主任评价：必须输入"

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
    ClearForm("eduRecordInfoForm");
    
    //可以下面设置初始默认值
}

/**
 * 搜索按钮
 */
function searchButton(){
	$("#dataList").datagrid('load',{
        	riTerm:$('#riTermQuery').val(),
        	riMidTerm:$('#riMidTermQuery').val(),
        	riClass:$('#riClassQuery').val()
	});

    $("#dataList2").datagrid('load',{
        riTerm:$('#riTermQuery').val(),
        riMidTerm:$('#riMidTermQuery').val(),
        riClass:$('#riClassQuery').val()
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

	    //检查是否为班主任
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/classes/checkCurUserIsClassLeader.do",
            data: {"scTerm":row.riTerm,"scClass":row.riClass},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //可以进行评价
                    $('#myModal').modal('show');
                    $('#eduRecordInfoForm').form('load','<%=basePath %>/edu/record/getEduRecordInfo.do?riId=' + row.riId);

                }else {
                    ShowErrorDialog("非本班班主任不能进行评价！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("检查失败"+ request.status + "," + request.responseText);
            }
        });


        

	}
	
}

/*
明细按钮
 */
function detailButton(){
    var row = $("#dataList").datagrid('getSelected');
    if(!row)
    {
        alert("请选择要修改的行");
    }else{
        window.location.href="<%=basePath%>/edu/record/gotoStudentRecordPage.do?stuId=" + row.riStuId;
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

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/record/checkEduRecordInfo.do",
            data: {"riId":row.riId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //可以进行删除
                    deleteData(row.riId);

                }else {
                    ShowErrorDialog("请设置不能删除提示！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("删除前检查失败"+ request.status + "," + request.responseText);
            }
        });


    });

}

//保存数据操作
function saveData(){
    var riId = $('#riId').val();
    var url = '';


    //數據校驗
    if(!Vlaidate()){
        return;
    }

    if(riId == ''){
        //新增
        url = "<%=basePath %>/edu/record/addEduRecordInfo.do";
        SubmitForm("eduRecordInfoForm",url,function(data){
            ShowSuccessDialog("数据增加成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据增加失败");
        });
    }else{
        //修改用戶信息
        url = "<%=basePath %>/edu/record/updateLeaderCommont.do";
        SubmitForm("eduRecordInfoForm",url,function(data){
            ShowSuccessDialog("数据修改成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("数据修改失败");
        });
    }
}


//刪除数据操作
function deleteData(riId){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: "<%=basePath%>/edu/record/deleteEduRecordInfo.do",
        data: {"riId":riId},
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

function formateMidTerm(val,row){
    if(val=='01'){
        return "期中";
	}else if(val == '02'){
        return "期末";
	}
}

function changeClass() {
	var term = $('#riTermQuery').val();
    genSelectListFromRemote("riClassQuery",'<%=basePath %>/edu/classes/listClassSelectListFromTerm.do',{term:term},true);

}

function formatCommon(val,row){
    if(val =='1'){
        return "<font color='green'>是</font>"
	}else {
        return "<font color='#ff4500'>否</font>"
	}
}

function downClassButton(){
    var riTerm = $('#riTermQuery').val();
    var riMidTerm=$('#riMidTermQuery').val();
    var riClass=$('#riClassQuery').val();

    if(riTerm == ''){
        ShowErrorDialog("请选择学期");
        return;
    }

    if(riMidTerm == ''){
        ShowErrorDialog("请选择期中/期末");
        return;
    }

    if(riClass == ''){
        ShowErrorDialog("请选择班级");
        return;
    }

    window.location.href="<%=basePath %>/edu/record/downloadClassRecord.do?riTerm=" + riTerm +"&riMidTerm=" + riMidTerm + "&riClass=" + riClass;
}

function downSchoolButton() {
    var riTerm = $('#riTermQuery').val();
    var riMidTerm=$('#riMidTermQuery').val();

    if(riTerm == ''){
        ShowErrorDialog("请选择学期");
        return;
    }

    if(riMidTerm == ''){
        ShowErrorDialog("请选择期中/期末");
        return;
    }

    window.location.href="<%=basePath %>/edu/record/downloadSchoolRecord.do?riTerm=" + riTerm +"&riMidTerm=" + riMidTerm ;
}

function computeStatics(){

    var riTerm = $('#riTermQuery').val();
    var riMidTerm=$('#riMidTermQuery').val();

    if(riTerm == ''){
        ShowErrorDialog("请选择学期");
        return;
    }

    if(riMidTerm == ''){
        ShowErrorDialog("请选择期中/期末");
        return;
    }

    showConfirm("重新计算前请确认所有班级成绩已经上传.",function(){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/record/computeStatic.do",
            data: {"riTerm":riTerm,"riMidTerm":riMidTerm},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("数据计算成功！");
                    $('#dataList2').datagrid('reload');
                }else{
                    ShowErrorDialog("数据计算失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("数据计算失败"+ request.status + "," + request.responseText);
            }
        });
	});
}

</script>
</html>