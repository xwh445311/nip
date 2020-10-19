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

			<!--历史成绩展示-->
			<div class="row">
				<div class="col-md-12">
					<section class="panel">
						<header class="panel-heading">
							历年考试班级排名变化图
							<span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                         </span>
						</header>
						<div class="panel-body">
							<div id="rankChart" style="width: 100%;height:358px; text-align: center; margin:0 auto;">
							</div>
						</div>
					</section>
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
                            url="<%=basePath %>/edu/record/listStudentRecord.do?riStuId=${riStuId}"
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


			<!-- 列表工具栏 -->
			<div id="toolbar">
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">查看评定</a>
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
                                <textarea class="form-control" id="riLeaderCommon" name="riLeaderCommon" rows="5" cols="30" disabled></textarea>
			                </div>
				       </form>
			       	</div>
			       </div>
				</div>
			</div>
            <br/>

            <!--返回按钮-->
            <c:if test='${flag == "1"}'>
                <div class="row">
                    <div class="col-md-12">
                        <button type="button" class="btn btn-primary" onclick="returnBack()">返回</button>
                    </div>
                </div>
            </c:if>


		</div>
	</div>
</section>
</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    var rankChart = echarts.init(document.getElementById('rankChart'));
    var option = {
        title: {
            text: ''
        },
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data:['语文','数学','英语','科学','品德与社会','总分']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ${stuRankLabelStr}
            }
        ],
        yAxis : [
            {
                type : 'value',
				inverse : true
            }
        ],
        series : ${stuRankDataStr}
    };

    rankChart.setOption(option);

$(document).ready(function(){
	
	//初始化DATA GRID分頁控件
	initDataGridPage("dataList");


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
 * 编辑按钮
 */
function editButton()
{
	var row = $("#dataList").datagrid('getSelected');
	if(!row)
	{
		alert("请选择要查看的行");
	}
	else
	{
        ResetValidate();
        resetForm();

        //可以进行评价
        $('#myModal').modal('show');
        $('#eduRecordInfoForm').form('load','<%=basePath %>/edu/record/getEduRecordInfo.do?riId=' + row.riId);
	}
	
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

function returnBack(){
    window.location.href="<%=basePath %>/edu/record/gotoEduRecordInfoPage.do?isBack=Y"
}
</script>
</html>