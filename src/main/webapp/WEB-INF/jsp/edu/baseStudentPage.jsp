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
                                    <input type="text" class="form-control" name="uiName" id="uiQueryName" placeholder="请输入学生姓名">&nbsp;
                                    <input type="text" class="form-control" name="uiId" id="uiIDQuery" placeholder="请输入学号">&nbsp;
                                    班级：
                                    <efs:selClass cls="form-control" id="usClassQuery" name="usClass" />
                                    学籍状态：
                                    <efs:selParam name="usSchStatus" id="usSchStatusQuery" type="BASE_STUDENT_STATUS" cls="form-control" />
                                </div>
                                <button type="button" class="btn btn-primary" onclick="queryDataGrid()">查询</button>

                                <button type="button" class="btn btn-primary" onclick="gotoUpload()">上传学生信息</button>

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
                            title="学生信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/student/listStudentInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'uiId',width:'10%'">学号</th>
                            <th data-options="field:'uiName',width:'10%'">姓名</th>
                            <th data-options="field:'uiBirthday',width:'10%'">出生日期</th>
                            <th data-options="field:'uiSex',formatter:formatSex,width:'5%'">性别</th>
                            <th data-options="field:'usClassName',width:'10%'">班级</th>
                            <th data-options="field:'uiMobile',width:'10%'">联系人电话</th>
                            <th data-options="field:'usFirstName',formatter:formatFirstName,width:'10%'">联系人姓名</th>
                            <th data-options="field:'usSchStatus',formatter:formatUsSchStatus,width:'10%'">学籍状态</th>
                            <th data-options="field:'uiUpdUser',width:'10%'">修改人</th>
                            <th data-options="field:'uiUpdDate',formatter:formatDate,width:'15%'">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="editButton('D')">明细</a>

                <auth:ax srcId="role_addTsStudentInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updTsStudentInfo">
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
                            <h4 class="modal-title">学生信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="userForm">
                                <input type="hidden" id="handType" />
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/><br/>
                                <div class="form-group">
                                    <label for="uiId">学号</label>
                                    <input type="text" class="form-control" name="uiId" id="uiId" placeholder="学号">
                                </div>
                                <div class="form-group">
                                    <label for="uiName"><span class="text-danger ">*</span>姓名</label>
                                    <input type="text" class="form-control" id="uiName" name="uiName" placeholder="姓名">
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
                                    <label for="usClass"><span class="text-danger ">*</span>所在班级</label>
                                    <efs:selClass cls="form-control" id="usClass" name="usClass" />
                                </div>

                                <div class="form-group">
                                    <label for="usEntryDate">入学日期</label>
                                    <input type="text" class="form-control" id="usEntryDate" name="usEntryDate" placeholder="入学日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                                </div>

                                <div class="form-group">
                                    <label for="usSchStatus"><span class="text-danger ">*</span>学籍状态</label>
                                    <efs:selParam name="usSchStatus" id="usSchStatus" type="BASE_STUDENT_STATUS" cls="form-control" />
                                </div>


                                <div class="form-group">
                                    <label for="usFirstPhone"><span class="text-danger ">*</span>第一联系人手机号</label>
                                    <input type="text" class="form-control" id="usFirstPhone" name="usFirstPhone" placeholder="第一联系人手机号">
                                </div>

                                <div class="form-group">
                                    <label for="usFirstName"><span class="text-danger ">*</span>第一联系人姓名</label>
                                    <input type="text" class="form-control" id="usFirstName" name="usFirstName" placeholder="第一联系人姓名">
                                </div>

                                <div class="form-group">
                                    <label for="usFirstShip"><span class="text-danger ">*</span>第一联系人与学生关系</label>
                                    <efs:selParam name="usFirstShip" id="usFirstShip" type="BASE_MEMBER_SHIP" cls="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="usSecPhon">第二联系人手机号</label>
                                    <input type="text" class="form-control" id="usSecPhon" name="usSecPhon" placeholder="第二联系人手机号">
                                </div>

                                <div class="form-group">
                                    <label for="usSecName">第二联系人姓名</label>
                                    <input type="text" class="form-control" id="usSecName" name="usSecName" placeholder="第二联系人姓名">
                                </div>

                                <div class="form-group">
                                    <label for="usSecShip">第二联系人与学生关系</label>
                                    <efs:selParam name="usSecShip" id="usSecShip" type="BASE_MEMBER_SHIP" cls="form-control" />
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
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
    <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    //初始化条码打印打印控件
    var ws;

    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化校验框架
        InitValidate("userForm","errContent",{

            uiId:{
                required:true,
                remote:{
                    url:"<%=basePath%>/sysadmin/userAdmin/checkUserIdRepeat.do",
                    type:"post",
                    data:{
                        uiId:function(){
                            return $('#uiId').val();
                        },
                        handType:function(){
                            return $('#handType').val();
                        }
                    }
                }
            },

            uiName:{
                required:true,
                maxlength:10
            },
            uiSex:'required',
            uiBirthday:'required',
            usClass:'required',
            usSchStatus:'required',
            usFirstPhone:{
                minlength:5,
                pattern:"^[0-9\-\(\)]+"

            },
            usFirstName:'required',
            usFirstShip:'required'
        },{
            uiId:{
                required:"学号：必须输入",
                remote:"学号：已经存在"
            },

            uiName:{
                required:"姓名：必须输入",
                maxlength:"姓名：不能超过10位"
            },
            uiSex:"性别：必须选择",
            uiBirthday:"出生日期：必须选择",
            usClass:"班级：必须选择",
            usSchStatus:"学生状态：必须选择",
            usFirstPhone:{
                minlength:"第一联系人手机：长度不能低于5位",
                pattern:"第一联系人手机：格式不正确"

            },
            usFirstName:"第一联系人姓名：必须输入",
            usFirstShip:"第一联系人与学生关系：必须选择"

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

    function formatUsSchStatus(val,row){
        if(val=='01'){
            return "<font color='green'>在校</font>";
        }else if(val=='02'){
            return "<font color='gray'>转走</font>";
        }else if(val=='03'){
            return "<font color='orange'>休学</font>";
        }else if(val=='04'){
            return "<font color='gray'>毕业</font>";
        }
    }

    function formatFirstName(val,row){
        return "(" + row.usFirstShip + ") " + row.usFirstName;
    }

    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            uiId:$('#uiIDQuery').val(),
            uiName:$("#uiQueryName").val(),
            usClass:$("#usClassQuery").val(),
            usSchStatus:$("#usSchStatusQuery").val()
        });
    }

    function newButton() {
        $('#passDiv').show();
        $('#confPassDiv').show();
        ResetValidate();
        ClearForm("userForm");
        specHandler("A");
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

    function specHandler(type) {
        if(type == "A"){
            //新增
            $('#uiId').removeAttr('readonly');
            $('#handType').val(type);
        }else{
            //修改
            $('#uiId').attr("readonly","readonly");
            $('#handType').val(type);
        }
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
        var handType = $('#handType').val();


        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(handType == 'A'){
            //新增
            url = "<%=basePath %>/edu/student/addTsStudentInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("学生增加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("学生增加失败");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/edu/student/updTsStudentInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("学生修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("学生修改失败");
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
        var usClass=$("#usClassQuery").val();
        var usSchStatus=$("#usSchStatusQuery").val();

        if(uiId=='' && uiName=='' && usClass=='' && usSchStatus == ''){
            ShowErrorDialog("您未选择任何查询条件，请选择查询条件后再进行打印");
            return;
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/student/batchPrintStuentBar.do",
            data: {"uiId":uiId,"uiName":uiName,"usClass":usClass,"usSchStatus":usSchStatus},
            dataType: "json",
            success: function(data)
            {
                if(data.success){

                    $.each(data.data,function (index, val) {
                        doPrint(val.key,val.value);
                    })

                }else{
                    ShowErrorDialog("查询学生信息失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("查询学生信息失败");
            }
        });
    }

    function doPrint(uiCode,uiName) {
        printArgonxBarCodeAndTextDef(uiCode,uiName+"_"+uiCode,codeTextX,codeTextY);
    }

</script>
</html>
