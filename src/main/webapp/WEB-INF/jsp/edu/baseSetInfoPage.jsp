<%--
  Created by Auton Code.
  User: xwh
  Date: 2018-05-29 13:55:38
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
                            title="基础信息设置记录表"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/baseset/listBaseSetInfo.do"
                            method="post">
						<thead>
							<tr>
								<th data-options="field:'bsTerm'" width="50">学期</th>
								<th data-options="field:'bsUserNm'" width="50">设置人</th>
								<th data-options="field:'bsDate'" width="50">设置日期</th>
								<th data-options="field:'bsTime'" width="50">设置时间</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<br/>



			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <auth:ax srcId="role_addBaseSetInfo">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">设置基础信息</a>
			    </auth:ax>
			</div>

			<!--FORM表单-->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
			            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			            <h4 class="modal-title">BaseSetInfo</h4>
			        </div>
			        
			        <div class="modal-body">
						<form id="baseSetInfoForm" name="baseSetInfoForm" method="post" role="form">
				           <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
			           		
			           		<div class="form-group">
			                    <label for="bsTerm"><span class="text-danger ">*</span>学期</label>
								<efs:selSems name="bsTerm" id="bsTerm" cls="form-control"/>
			                </div>

					        <div class="form-group">
				                <br/><button type="button" class="btn btn-primary" onclick="saveData()">提交</button>
				            </div>
				           
				       </form>
			       	</div>
			       </div>
				</div>
			</div>

			<div class="alert alert-block alert-danger fade in">
				<strong>注意!</strong>&nbsp;<br/>
				1、设置基础信息之前请确保本学期的学期日历已经设置，否则将不能设置基础信息。<br/>
				2、基础信息设置之后，仍然需要根据实际情况在<a href="<%=basePath%>/edu/classes/gotoBaseSchClassInfoPage.do?isMenu=Y">班级管理</a>中设置各班的班主任信息,
				以及在<a href="<%=basePath%>/edu/course/gotoBaseSchScoreInfoPage.do?isMenu=Y">课程信息管理</a>中设置任课老师。<br/>
				3、基础信息设置之后，学生的年级会自动升级，如果有学生因为特殊情况要留级、转校、休学，请到<a href="<%=basePath%>/edu/student/gotoStudnetListPage.do?isMenu=Y">学生信息管理</a>中进行特殊设置。

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
	InitValidate("baseSetInfoForm","errContent",{
            		bsTerm:{
            		    required:true,
                        remote:{
                            url:"<%=basePath%>/edu/baseset/checkNoBaseSet.do",
                            type:"post",
                            data:{
                                bsTerm:function(){
                                    return $('#bsTerm').val();
                                }
                            }
                        }}
        },{
            		bsTerm:{
                        required:"学期：必须选择",
                        remote:"该学期已经设置过基础信息"
					}
        });
});


/*
    重置表单数据
*/
function resetForm(){
    ClearForm("baseSetInfoForm");
    
    //可以下面设置初始默认值
}



/**
 * 新增按钮
 */
function newButton() {
    ResetValidate();
    resetForm();
    $('#myModal').modal('show');
}



//保存数据操作
function saveData(){
    var url = '';

    //數據校驗
    if(!Vlaidate()){
        return;
    }


    url = "<%=basePath %>/edu/baseset/addBaseSetInfo.do";
    SubmitForm("baseSetInfoForm",url,function(data){
        ShowSuccessDialog("设置成功");
        $('#myModal').modal('hide');
        $('#dataList').datagrid('reload');
    },function () {
        ShowErrorDialog("设置失败");
    });
}

</script>
</html>