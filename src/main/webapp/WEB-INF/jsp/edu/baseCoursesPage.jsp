<%--
  Created by IntelliJ IDEA.
  User: xwh
  Date: 2017/7/5
  Time: 0:02
  To change this template use File | Settings | File Templates.
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

            <!-- 查詢條件區域 -->
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
                                    <efs:selSems name="ssTerm" id="ssTermQuery" cls="form-control" onchange='changeClassFromTerm("ssTermQuery","ssClassQuery")' />
                                    &nbsp;
                                    班级：
                                    <efs:selClass cls="form-control" id="ssClassQuery" name="ssClass" />
                                </div>
                                <button type="button" class="btn btn-primary" onclick="queryDataGrid()">查詢</button>
                                &nbsp;&nbsp;
                                <auth:ax srcId="role_addBaseSchScoreInfo">
                                <button type="button" class="btn btn-success" onclick="batchAddButton()">复制课程</button>
                                </auth:ax>


                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <br/>

            <!--列表区域 -->
            <div class="row">
                <div class="col-md-12" id="gridPanel">
                    <table  id="dataList"
                            style="width: 100%"
                            title="课程信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/course/listBaseSchScoreInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'ssId',checkbox:true" width="50"></th>
                            <th data-options="field:'ssTermName'" width="50">学期</th>
                            <th data-options="field:'ssClassName'" width="50">班级</th>
                            <th data-options="field:'ssScoreName'" width="50">课程</th>
                            <th data-options="field:'ssCount'" width="50">课时</th>
                            <th data-options="field:'ssFullMark'" width="50">课程满分</th>
                            <th data-options="field:'ssTestTypeVal'" width="50">考试类型</th>
                            <th data-options="field:'ssTeacherName'" width="50">任课教师</th>
                            <th data-options="field:'updUserName'" width="50">修改人</th>
                            <th data-options="field:'updDate',formatter:formatDate" width="50">修改日期</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addBaseSchScoreInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateBaseSchScoreInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteBaseSchScoreInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>


            <!-- Form表单区域-批量拷贝课程 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalBatchAdd" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">复制课程信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="batchAddForm">
                                <div class="form-group">
                                    <label for="ssTerm"><span class="text-danger ">*</span>原学期</label>
                                    <efs:selSems name="ssTerm" id="ssTerm_b" cls="form-control" onchange='changeClassFromTerm("ssTerm_b","ssClass_b")'/>
                                </div>
                                <div class="form-group">
                                    <label for="ssClass">原班级</label>
                                    <efs:selClass name="ssClass" id="ssClass_b" cls="form-control"/>
                                </div>

                                <div class="form-group">
                                    <label for="newSsTerm"><span class="text-danger ">*</span>新学期</label>
                                    <efs:selSems name="newSsTerm" id="newSsTerm" cls="form-control" onchange='changeClassFromTerm("newSsTerm","newClasses")'/>
                                </div>
                                <div class="form-group">
                                    <label for="newClasses">新班级</label>
                                    <efs:selClass name="newClasses" id="newClasses" cls="form-control"/>
                                </div>


                                <div class="form-group">
                                    <br/><button type="button" class="btn btn-primary" onclick="batchCopyScore()">复制</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">课程管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="userForm">
                                <input type="hidden" name="ssId" id="ssId" value=""/>

                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
                                <br/>


                                <div class="form-group">
                                    <label for="ssTerm"><span class="text-danger ">*</span>学期</label>
                                    <efs:selSems name="ssTerm" id="ssTerm" cls="form-control" onchange="changeTerm()"/>
                                </div>

                                <div class="form-group">
                                    <label for="ssClass"><span class="text-danger ">*</span>班级</label>
                                    <efs:selClass cls="form-control" id="ssClass" name="ssClass" />
                                </div>

                                <div class="form-group">
                                    <label for="ssScore"><span class="text-danger ">*</span>课程</label>
                                    <efs:selParam name="ssScore" id="ssScore" type="BASE_SCORE_INFO" cls="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="ssCount"><span class="text-danger ">*</span>课时</label>
                                    <input type="text" class="form-control" id="ssCount" name="ssCount" placeholder="课时">
                                </div>

                                <%--<div class="form-group">
                                    <label for="ssCredit">课程学分</label>
                                    <input type="text" class="form-control" id="ssCredit" name="ssCredit" placeholder="课程学分">
                                </div>--%>

                                <div class="form-group">
                                    <label for="ssFullMark"><span class="text-danger ">*</span>满分</label>
                                    <input type="text" class="form-control" id="ssFullMark" name="ssFullMark" placeholder="课程满分" onchange="scoreChange()">
                                </div>
                                <div class="form-group">
                                    <label for="ssHighMark"><span class="text-danger ">*</span>高分</label>
                                    <input type="text" class="form-control" id="ssHighMark" name="ssHighMark" placeholder="课程高分">
                                </div>

                                <div class="form-group">
                                    <label for="ssExcelMark"><span class="text-danger ">*</span>优分</label>
                                    <input type="text" class="form-control" id="ssExcelMark" name="ssExcelMark" placeholder="课程优分">
                                </div>

                                <div class="form-group">
                                    <label for="ssPassMark"><span class="text-danger ">*</span>及格</label>
                                    <input type="text" class="form-control" id="ssPassMark" name="ssPassMark" placeholder="及格分数">
                                </div>

                                <div class="form-group">
                                    <label for="ssLowMark"><span class="text-danger ">*</span>低分</label>
                                    <input type="text" class="form-control" id="ssLowMark" name="ssLowMark" placeholder="课程低分">
                                </div>

                                <%--<div class="form-group">
                                    <label for="ssStudyType"><span class="text-danger ">*</span>选修类型</label>
                                    <input type="text" class="form-control" id="ssStudyType" name="ssStudyType" placeholder="选修类型">
                                </div>--%>

                                <div class="form-group">
                                    <label for="ssTestType"><span class="text-danger ">*</span>考试类型</label>
                                    <efs:selParam name="ssTestType" id="ssTestType" type="BASE_TEST_TYPE" cls="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="ssTeacher"><span class="text-danger ">*</span>任课老师</label>
                                    <efs:selUser name="ssTeacher" id="ssTeacher" userType="3" cls="form-control"/>
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

    //全局记录变量，记录上一次增加的内容
    var sTerm;
    var sClass;

    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化校验框架
        InitValidate("userForm","errContent",{
            ssTerm:{
                required:true
            }
            ,
            ssScore:{
                required:true
            }
            ,
            ssClass:{
                required:true
            }
            ,
            ssCount:{
                required:true,
                digits:true
                ,
                maxlength:10
            }
            ,
            ssFullMark:{
                required:true,
                number:true
                ,
                maxlength:7
            }
            ,
            ssHighMark:{
                required:true,
                number:true
                ,
                maxlength:7
            }
            ,
            ssExcelMark:{
                required:true,
                number:true
                ,
                maxlength:7
            }
            ,
            ssPassMark:{
                required:true,
                number:true
                ,
                maxlength:7
            }
            ,
            ssLowMark:{
                required:true,
                number:true
                ,
                maxlength:7
            }
            ,
            ssTestType:{
                required:true
            }
            ,
            ssTeacher:{
                required:true
            }
        },{
            ssTerm:{
                required:"学期：必须输入"
            }
            ,
            ssScore:{
                required:"课程：必须选择"
            }
            ,
            ssClass:{
                required:"开课班级：必须选择"
            }
            ,

            ssCount:{
                required:"课时：必须选择",
                digits:"课时：必须为有数字"
                ,
                maxlength:"课时：长度不能超过10位"
            }
            ,
            ssFullMark:{
                required:"课程满分：必须选择",
                number:"课程满分：必须为合法数值"
                ,
                maxlength:"课程满分：长度不能超过7位"
            }
            ,

            ssHighMark:{
                required:"课程高分：必须选择",
                number:"课程高分：必须为合法数值"
                ,
                maxlength:"课程高分：长度不能超过7位"
            }
            ,

            ssExcelMark:{
                required:"课程优分：必须选择",
                number:"课程优分：必须为合法数值"
                ,
                maxlength:"课程优分：长度不能超过7位"
            }
            ,

            ssPassMark:{
                required:"及格分数：必须选择",
                number:"及格分数：必须为合法数值"
                ,
                maxlength:"及格分数：长度不能超过7位"
            }
            ,

            ssLowMark:{
                required:"课程低分：必须选择",
                number:"课程低分：必须为合法数值"
                ,
                maxlength:"课程低分：长度不能超过7位"
            }
            ,
            ssTestType:{
                required:"考试类型：必须选择"
            }
            ,
            ssTeacher:{
                required:"任课教师：必须选择"
            }

        });


    });

    function formatDate(val,row){
        return ((row.updDate == null ) ? "" : row.updDate ) + " " + ((row.updTime == null ) ? "" : row.updTime );
    }

    /*
    重置表单数据
    */
    function resetForm(){
        ClearForm("userForm");

        //设置默认值
        $('#ssFullMark').val(100);
        $('#ssHighMark').val(90);
        $('#ssExcelMark').val(80);
        $('#ssPassMark').val(60);
        $('#ssLowMark').val(30);
    }

    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            ssTerm:$("#ssTermQuery").val(),
            ssClass:$('#ssClassQuery').val()
        });
    }

    function newButton() {
        ResetValidate();
        resetForm();

        //取消禁用
        cancleDisabledField("ssTerm");
        cancleDisabledField("ssScore");
        cancleDisabledField("ssClass");

        //设置值为上次输入的内容，避免重复选择
        $('#ssTerm').val(sTerm);
        $('#ssClass').val(sClass);

        $('#myModal').modal('show');
    }


    /**
     * 修改按鈕
     */
    function editButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要修改的行");
            return;
        }


        ResetValidate();
        resetForm();

        //禁止修改以下内容
        disabledField("ssTerm");
        disabledField("ssScore");
        disabledField("ssClass");

        $('#myModal').modal('show');
        $('#userForm').form('load','<%=basePath %>/edu/course/getBaseSchScoreInfo.do?ssId=' + row.ssId);
    }


    /**
     * 刪除功能
     */
    function deleteButton() {

        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要删除的数据");
            return;
        }

        //删除前检查逻辑
        showConfirm("您确认要删除吗？删除后可能会影响其它使用课程的功能",function(){
            deleteData(row.ssId);
        });

    }

    //保存数据操作
    function saveData(){
        var ssId = $('#ssId').val();
        var url = '';


        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(ssId == ''){

            //新增前把值赋给全局变量
            sTerm = $('#ssTerm').val();
            sClass = $('#ssClass').val();

            //新增
            url = "<%=basePath %>/edu/course/addBaseSchScoreInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("数据增加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("数据增加失败");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/edu/course/updateBaseSchScoreInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("数据修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("数据修改失败");
            });
        }
    }

    //刪除数据操作
    function deleteData(ssId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/course/deleteBaseSchScoreInfo.do",
            data: {"ssId":ssId},
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
                ShowErrorDialog("删除失败"+ request.status + "," + request.responseText);
            }
        });
    }

    /**
     * 分数改变自动变化
     */
    function scoreChange() {
        var fullScore = $('#ssFullMark').val();
        var highScore = fullScore * 0.9;
        var exclScore = fullScore * 0.8;
        var passScore = fullScore * 0.6;
        var lowScore = fullScore * 0.3;

        $('#ssHighMark').val(highScore);
        $('#ssExcelMark').val(exclScore);
        $('#ssPassMark').val(passScore);
        $('#ssLowMark').val(lowScore);
    }

    function changeTerm(){
        var ssTerm = $('#ssTerm').val();
        genSelectListFromRemote("ssTeacher",'<%=basePath %>/edu/teacher/listCanCourTeacher.do',{ssTerm:ssTerm},true);
    }


    function batchAddButton() {

        ClearForm("batchAddForm");

        $('#myModalBatchAdd').modal('show');
    }

    /*
    批量添加班级信息
    */
    function batchCopyScore(){
        var ssTerm = $('#ssTerm_b').val();
        var ssClass = $('#ssClass_b').val();
        var newSsTerm = $('#newSsTerm').val();
        var newClasses = $('#newClasses').val();

        var essMsg ='';
        errMsg = checkEmpty("原学期",ssTerm);
        errMsg += checkEmpty("新学期",newSsTerm);

        if((ssClass != '' && newClasses=='') ||  (ssClass == '' && newClasses!='') )
        {
            errMsg += "原班级和新班必须同时指定或者同时不指定";
        }

        if(errMsg.length > 0){
            ShowErrorDialog(errMsg);
            return;
        }

        url = "<%=basePath %>/edu/course/batchCopyScore.do";
        SubmitForm("batchAddForm",url,function(data){
            ShowSuccessDialog("复制成功成功");
            $('#myModalBatchAdd').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("复制失败");
        });
    }

</script>
</html>
