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
                            查询条件
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                             </span>
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="uiName" id="uiQueryName" placeholder="请输入姓名">&nbsp;
                                    <input type="text" class="form-control" name="uiId" id="uiIDQuery" placeholder="请输入用户ID">&nbsp;
                                    工作状态：
                                    <efs:selParam name="utWorkStatus" id="utWorkStatusQuery" type="BASE_TEACHER_STATUS" cls="form-control" />
                                </div>
                                <button type="button" class="btn btn-primary" onclick="queryDataGrid()">查询</button>

                                <button type="button" class="btn btn-info" onclick="printUserCode()">批量打印条码</button>
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
                            title="教职工信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/teacher/listTeacherInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'uiId',width:'50'">用户ID</th>
                            <th data-options="field:'uiName',width:'50'">姓名</th>
                            <th data-options="field:'uiShortName',width:'50'">简称</th>
                            <th data-options="field:'uiBirthday',width:'50'">出生日期</th>
                            <th data-options="field:'uiSex',formatter:formatSex,width:'50'">性别</th>
                            <th data-options="field:'uiMobile',width:'50'">手机</th>
                            <th data-options="field:'utDutyVal',width:'50'">职务</th>
                            <th data-options="field:'utLevelVal',width:'50'">职称</th>
                            <th data-options="field:'utWorkStatus',formatter:formatUtWorkStatus,width:'50'">工作状态</th>
                            <th data-options="field:'uiUpdUser',width:'50'">修改人</th>
                            <th data-options="field:'uiUpdDate',formatter:formatDate,width:'50'">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="editButton('D')">明细</a>

                <auth:ax srcId="role_addTsTeacherInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updTsTeacherInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <%--<auth:ax srcId="role_deleteTsUserInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>--%>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">教职工信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="userForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/><br/>
                                <div class="form-group">
                                    <label for="uiId">用户ID</label>
                                    <input type="text" class="form-control" name="uiId" id="uiId" readonly="readonly">
                                </div>
                                <div class="form-group">
                                    <label for="uiName"><span class="text-danger ">*</span>姓名</label>
                                    <input type="text" class="form-control" id="uiName" name="uiName" placeholder="姓名">
                                </div>
                                <div class="form-group">
                                    <label for="uiShortName">简称</label>
                                    <input type="text" class="form-control" id="uiShortName" name="uiShortName" placeholder="简称">
                                </div>
                                <div class="form-group">
                                    <label for="uiSex_M"><span class="text-danger ">*</span>性别</label>
                                    <div>
                                        <input type="radio" id="uiSex_M" name="uiSex" value="M">男 &nbsp;&nbsp;
                                        <input type="radio" id="uiSex_F" name="uiSex" value="F">女
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="uiBirthday"><span class="text-danger ">*</span>出生日期</label>
                                    <input type="text" class="form-control" id="uiBirthday" name="uiBirthday" placeholder="出生日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                                </div>

                                <div class="form-group">
                                    <label for="uiMobile"><span class="text-danger ">*</span>手机号</label>
                                    <input type="text" class="form-control" id="uiMobile" name="uiMobile" placeholder="姓名">
                                </div>

                                <div class="form-group">
                                    <label for="uiEmail">个人邮箱</label>
                                    <input type="text" class="form-control" id="uiEmail" name="uiEmail" placeholder="姓名">
                                </div>

                                <div class="form-group">
                                    <label for="utDuty"><span class="text-danger ">*</span>职务</label>
                                    <efs:selParam name="utDuty" id="utDuty" type="BASE_DUTY" cls="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="utLevel"><span class="text-danger ">*</span>职称</label>
                                    <efs:selParam name="utLevel" id="utLevel" type="BASE_TEACHER_LEVEL" cls="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="utWorkStatus"><span class="text-danger ">*</span>工作状态</label>
                                    <efs:selParam name="utWorkStatus" id="utWorkStatus" type="BASE_TEACHER_STATUS" cls="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="utEntryDate">入职日期</label>
                                    <input type="text" class="form-control" id="utEntryDate" name="utEntryDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                                </div>

                                <div class="form-group">
                                    <label for="utLeaveDate">离职/退休日期</label>
                                    <input type="text" class="form-control" id="utLeaveDate" name="utLeaveDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                                </div>

                                <div class="form-group">
                                    <label for="usAddr">现居住地址</label>
                                    <input type="text" class="form-control" id="usAddr" name="usAddr" placeholder="现居住地址">
                                </div>


                                <div class="form-group">
                                <br/><button type="button" class="btn btn-primary" onclick="saveData()" id="saveButton">提交</button>
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

    //初始化条码打印打印控件
    var ws;

    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化校验框架
        InitValidate("userForm","errContent",{
            uiName:{
                required:true,
                maxlength:10
            },
            uiShortName:{
                remote:{
                    url:"<%=basePath%>/sysadmin/userAdmin/checkShortNameRepeat.do",
                    type:"post",
                    data:{
                        uiShortName:function(){
                            return $('#uiShortName').val();
                        },
                        uiId:function(){
                            return $('#uiId').val();
                        }
                    }
                }
            },
            uiSex:'required',
            uiBirthday:'required',
            uiMobile:{
                minlength:5,
                pattern:"^[0-9\-\(\)]+"

            },
            utDuty:'required',
            utLevel:'required',
            utWorkStatus:'required'
        },{
            uiName:{
                required:"姓名：必须输入",
                maxlength:"姓名：不能超过10位"
            },
            uiShortName:{
                remote:"简称：已经存在"
            },
            uiSex:"性别：必须选择",
            uiBirthday:"出生日期：必须选择",
            uiMobile:{
                minlength:"手机号：长度不能低于5位",
                pattern:"手机号：格式不正确"

            },
            utDuty:"职务：必须选择",
            utLevel:"职称：必须选择",
            utWorkStatus:"工作状态：必须选择"
        });

        //初始化打印插件
        argonxConnect();

    });

    function formatState(val,row)
    {
        if(val == '1')
        {
            return "<span class='label label-success'>啟用</span>"
        }
        else
        {
            return "<span class='label label-danger'>停用</span>"
        }
    }

    function formatDate(val,row){
        return ((row.uiUpdDate == null ) ? "" : row.uiUpdDate ) + " " + ((row.uiUpdTime == null ) ? "" : row.uiUpdTime );
    }


    function formatSex(val,row) {
        if(val == 'F'){
            return '女';
        }else if(val == 'M'){
            return '男';
        }
    }

    function formatUtWorkStatus(val,row){
        if(val=='01'){
            return "<font color='green'>在职</font>";
        }else if(val=='02'){
            return "<font color='gray'>离职</font>";
        }else if(val=='03'){
            return "<font color='orange'>退休</font>";
        }else{
            return val;
        }
    }

    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            uiId:$('#uiIDQuery').val(),
            uiName:$("#uiQueryName").val(),
            utWorkStatus:$("#utWorkStatusQuery").val()
        });
    }

    function newButton() {
        $('#passDiv').show();
        $('#confPassDiv').show();
        ResetValidate();
        ClearForm("userForm");
    }

    /**
     * 修改按鈕
     */
    function editButton(type) {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            if(type=="D")
            {
                ShowWarningDialog("请选择要查看的行");
            }
            else
            {
                ShowWarningDialog("请选择要修改的行");
            }

            return;
        }

        ResetValidate();
        ClearForm("userForm");

        if(type=='D')
        {
            $('#saveButton').attr('disabled','disabled');
        }else{
            $('#saveButton').removeAttr('disabled');
        }

        $('#myModal').modal('show');
        $('#userForm').form('load','<%=basePath %>/sysadmin/userAdmin/getTsUserInfo.do?uiId=' + row.uiId);
    }

    /**
     * 刪除功能
     */
    function deleteButton() {

        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要刪除的用戶");
            return;
        }

        showConfirm("您確認要刪除此用戶嗎，刪除後無法恢復？",function(){
            deleteUserInfo(row.uiId);
        });
    }

    function saveData(){
        var riId = $('#uiId').val();
        var url = '';


        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/edu/teacher/addTsTeacherInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("教师增加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("教师增加失败");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/edu/teacher/updTsTeacherInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("教师修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("教师修改失败");
            });
        }
    }

    //刪除用戶
    function deleteUserInfo(uiId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/userAdmin/deleteTsUserInfo.do",
            data: {"uiId":uiId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("刪除記錄成功！");
                    $('#dataList').datagrid('reload');
                }else{
                    ShowErrorDialog("刪除記錄失敗！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("刪除記錄失敗");
            }
        });
    }

    function gotoUpload() {
        window.location.href="<%=basePath%>/edu/student/gotoStudentUploadPage.do";
    }

    function printUserCode(){
        var uiId = $('#uiIDQuery').val();
        var uiName=$("#uiQueryName").val();
        var utWorkStatus=$("#utWorkStatusQuery").val();

        if(uiId=='' && uiName=='' && utWorkStatus==''){
            ShowErrorDialog("您未选择任何查询条件，请选择查询条件后再进行打印");
            return;
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/teacher/batchPrintTeacherBar.do",
            data: {"uiId":uiId,"uiName":uiName,"utWorkStatus":utWorkStatus},
            dataType: "json",
            success: function(data)
            {
                if(data.success){

                    $.each(data.data,function (index, val) {
                        doPrint(val.key,val.value);
                    })

                }else{
                    ShowErrorDialog("查询教工信息失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("查询教工信息失败");
            }
        });
    }

    function doPrint(uiCode,uiName) {
        printArgonxBarCodeAndTextDef(uiCode,uiName+"_"+uiCode,codeTextX,codeTextY);
    }

</script>
</html>
