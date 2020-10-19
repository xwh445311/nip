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
                    <!--借阅人信息-->
                    <div class="panel panel-primary">
                        <header class="panel-heading">
                            还书人信息
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <div class="col-md-3">
                                <label for="userInput">用户ID</label>
                                <input type="text" class="form-control input-lg m-bot15"  id="userInput" placeholder="请扫描/输入用户ID">
                            </div>

                            <form role="form" id="userForm">
                                <div class="col-md-9">
                                    <div class="row">
                                        <div class="col-md-4 form-group">
                                            <label for="isUserId">用户ID</label>
                                            <input type="text" class="form-control" name="isUserId" id="isUserId" readonly>
                                        </div>
                                        <div class="col-md-4 form-group">
                                            <label for="isUserName">用户姓名</label>
                                            <input type="text" class="form-control" name="isUserName" id="isUserName" readonly>
                                        </div>
                                        <div class="col-md-4 form-group">
                                            <label for="isUserType">用户类型</label>
                                            <input type="text" class="form-control" name="isUserType" id="isUserType" readonly>
                                        </div>

                                        <div class="col-md-4 form-group">
                                            <label for="isMaxCont">最大可借图书量</label>
                                            <input type="text" class="form-control" name="isMaxCont" id="isMaxCont" readonly>
                                        </div>
                                        <div class="col-md-4 form-group">
                                            <label for="isHasCont">已借图书量</label>
                                            <input type="text" class="form-control" name="isHasCont" id="isHasCont" readonly>
                                        </div>
                                        <div class="col-md-4 form-group">
                                            <label for="isCanCont">可借图书量</label>
                                            <input type="text" class="form-control" name="isCanCont" id="isCanCont" readonly>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <br/>

            <div class="row">
                <div class="col-md-12">
                    <!--借阅人信息-->
                    <div class="panel panel-primary">
                        <header class="panel-heading">
                            图书信息
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <div class="col-md-12">
                                <label for="bookInput">图书条码</label>
                                <input type="text" class="form-control input-lg m-bot15"  id="bookInput" placeholder="请扫描/输入图书编号">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--列表区域 -->
            <div class="row">
                <div class="col-md-12" id="gridPanel">
                    <table  id="dataList"
                            style="width: 100%"
                            title="在借图书"
                            rownumbers="true"
                            fitColumns="true"
                            pagination="true"
                            toolbar="#toolbar"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/lib/booksend/listUserLibInSendInfo.do?"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'isId',width:'1%',hidden:'true'">流水号</th>
                            <th data-options="field:'isBookCode',width:'5%'">图书编号</th>
                            <th data-options="field:'isSendStatus',formatter:formatSendState,width:'5%'">图书状态</th>
                            <th data-options="field:'biName',width:'20%'">图书名称</th>
                            <th data-options="field:'biPress',width:'15%'">出版社</th>
                            <th data-options="field:'biAuth',width:'20%'">作者</th>
                            <th data-options="field:'biPrice',width:'5%'">单价</th>
                            <th data-options="field:'isStartDate',width:'5%'">借阅日期</th>
                            <th data-options="field:'isStartTime',width:'5%'">借阅时间</th>
                            <th data-options="field:'isPlanBackDate',width:'5%'">计划归还日期</th>
                            <th data-options="field:'isOverStatus',formatter:formatOverState,width:'5%'">是否超期</th>
                            <th data-options="field:'isOverdueLong',width:'5%'">超期天数</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="regLoseButton()">挂失</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="compBookButton()">解挂</a>

            </div>

            <!-- 挂失表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="regLosModal" class="modal fade">
                <div class="modal-dialog" style="width: 60%;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">挂失信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="regLosForm" >
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label for="regUserId">借阅人ID</label>
                                        <input type="text" class="form-control" name="regUserId" id="regUserId" readonly>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label for="regUserName">借阅人姓名</label>
                                        <input type="text" class="form-control" name="regUserName" id="regUserName" readonly>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="regStartDate">图书编号</label>
                                        <input type="text" class="form-control" name="regBookCode" id="regBookCode" readonly>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="regStartDate">图书名称</label>
                                        <input type="text" class="form-control" name="regName" id="regName" readonly>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="regStartDate">借阅日期</label>
                                        <input type="text" class="form-control" name="regStartDate" id="regStartDate" readonly>
                                    </div>


                                    <div class="col-md-4 form-group">
                                        <label class="control-label"><span class="text-danger ">*</span>待赔偿金额</label>
                                        <input type="text" class="form-control" id="biPlanCompAmt" name="biPlanCompAmt" placeholder="请输入数字金额" />
                                    </div>
                                    <div class="col-md-8 form-group">
                                        <label class="control-label">备注</label>
                                        <input type="text" class="form-control" id="biRegCommon" name="biRegCommon" placeholder="请输入备注" maxlength="120" />
                                    </div>
                                </div>

                                <div class="form-group"  style="text-align: center">
                                    <br/><button type="button" class="btn btn-primary" onclick="submitRegLose()">提交</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <!-- 解挂表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="compBookModal" class="modal fade">
                <div class="modal-dialog" style="width: 60%;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">解挂信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="compBookForm" >
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label for="regUserId">借阅人ID</label>
                                        <input type="text" class="form-control" name="compUserId" id="compUserId" readonly>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label for="regUserName">借阅人姓名</label>
                                        <input type="text" class="form-control" name="compUserName" id="compUserName" readonly>
                                    </div>
                                    <div class="col-md-3 form-group">
                                        <label for="regStartDate">图书编号</label>
                                        <input type="text" class="form-control" name="compBookCode" id="compBookCode" readonly>
                                    </div>
                                    <div class="col-md-3 form-group">
                                        <label for="regStartDate">图书名称</label>
                                        <input type="text" class="form-control" name="compName" id="compName" readonly>
                                    </div>
                                    <div class="col-md-3 form-group">
                                        <label for="regStartDate">挂失日期</label>
                                        <input type="text" class="form-control" name="compDate" id="compDate" readonly>
                                    </div>
                                    <div class="col-md-3 form-group">
                                        <label class="control-label">计划赔偿金额</label>
                                        <input type="text" class="form-control" id="compPlanCompAmt" name="compPlanCompAmt" readonly />
                                    </div>

                                    <div class="col-md-4 form-group">
                                        <label class="control-label"><span class="text-danger ">*</span>解挂方式</label>
                                        <select class="form-control" id="compType" name="compType" onchange="compTypeChange()">
                                            <option value="">请选择</option>
                                            <option value="01">按价格赔偿</option>
                                            <option value="02">用新书赔偿</option>
                                            <option value="03">原书找回</option>
                                        </select>
                                    </div>

                                    <div class="col-md-4 form-group">
                                        <label class="control-label"><span class="text-danger ">*</span>实际赔偿金额</label>
                                        <input type="text" class="form-control" id="blCompAmt" name="blCompAmt" placeholder="请输入数字金额" disabled />
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label class="control-label"><span class="text-danger ">*</span>新书/原书编号</label>
                                        <input type="text" class="form-control" id="blCompBookCode" name="blCompBookCode" placeholder="请输入数字金额" disabled />
                                    </div>
                                    <div class="col-md-8 form-group">
                                        <label class="control-label">备注</label>
                                        <input type="text" class="form-control" id="blCommon" name="blCommon" placeholder="请输入备注" maxlength="120" />
                                    </div>
                                </div>

                                <div class="form-group"  style="text-align: center">
                                    <br/><button type="button" class="btn btn-primary" onclick="submitCompBook()">提交</button>
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

    var bomBatchNo = '${batchNum}';
    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化用户输入框
        readyInputUserId();

        //注册用户ID回车事件
        $('#userInput').bind('keypress',function (event) {
            if(event.keyCode  == '13'){
                handInputUserId();
            }
        });

        //注册图书ID回车事件
        $('#bookInput').bind('keypress',function (event) {
            if(event.keyCode  == '13'){
                handBookCodeInput();
            }
        });





    });


    function formatOverState(val,row)
    {
        if(val == '1')
        {
            return "<span style='color: red'>已超期</span>"
        }
        else
        {
            return "<span style='color: green'>未超期</span>"
        }
    }

    function formatSendState(val, row) {
        if(val == '00')
        {
            return "已还"
        }
        else if(val == '01')
        {
            return "<span style='color: green'>在借</span>"
        }
        else if(val == '02')
        {
            return "<span style='color: orange'>挂失</span>"
        }
        else if(val == '03')
        {
            return "已赔"
        }
        else {
            return val;
        }
    }



    function readyInputUserId(){
        $('#userInput').val('');
        $('#userInput').focus();
    }

    function readyInputBookCode() {
        $('#bookInput').val('');
        $('#bookInput').focus();

    }

    function handInputUserId(){
        var userId =$('#userInput').val();
        if(userId == ''){
            ShowWarningDialog("请扫描或输入用户ID后按回车键");
            return;
        }

        $('#userInput').val('');

        //获取用户的借信息
        ClearForm("userForm");
        $('#userForm').form('load','<%=basePath %>/lib/booksend/getLibInSendUserInfo.do?userId=' + userId);

        readyInputBookCode();

        //获取用户的已借书列表
        reloadDataGrid(userId);
    }


    function reloadDataGrid(userId){
        $("#dataList").datagrid('load',{
            userId:userId
        });
    }

    /*
    处理BOOK CODE输入内容
     */
    function handBookCodeInput() {
        var userId =$('#isUserId').val();
        if(userId == ''){
            ShowWarningDialog("请先扫描或输入用户ID");
            return;
        }


        var bookCode = $('#bookInput').val();
        if(bookCode == ''){
            ShowWarningDialog("请扫描或输入图书编码");
            return;
        }

        //判断是否可以还书
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/checkUserBackBook.do",
            data: {"userId":userId,"bookCode":bookCode},
            dataType: "json",
            success: function(data)
            {
                if(data.data.code == '00'){
                    //可以还书
                    doBackBook(userId,bookCode);

                }else{

                    ShowErrorDialog(data.data.message);

                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("校验用户权限信息失败");
            }
        });
    }

    /*
    处理还书逻辑
     */
    function doBackBook(userId, bookCode) {
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/doBackBook.do",
            data: {"userId":userId,"bookCode":bookCode},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //还书成功
                    reloadDataGrid(userId);

                    //更新借书人信息
                    ClearForm("userForm");
                    $('#userForm').form('load','<%=basePath %>/lib/booksend/getLibInSendUserInfo.do?userId=' + userId);

                    //初始化输入框
                    readyInputBookCode();


                }else{

                    //还书失败
                    ShowErrorDialog(data.data.message);

                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("图书借阅失败失败");
            }
        });
    }

    /*
    处理挂失逻辑
     */
    function regLoseButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要挂失的图书");
            return;
        }

        //检查是否可以挂失
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/checkUserBackBook.do",
            data: {"userId":$('#isUserId').val(),"bookCode":row.isBookCode},
            dataType: "json",
            success: function(data)
            {
                if(data.data.code == '00'){
                    ClearForm("regLosForm");
                    initRegForm(row);
                    $('#regLosModal').modal('show');

                }else{

                    ShowErrorDialog(data.data.message);

                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("检查用户挂失信息失败");
            }
        });



    }

    function initRegForm(row) {
        var regUserId = $('#isUserId').val();
        var regUserName = $('#isUserName').val();
        var regBookCode = row.isBookCode;
        var regName =row.biName;
        var regStartDate = row.isStartDate;
        var biPlanCompAmt = row.biPrice;

        $('#regUserId').val(regUserId);
        $('#regUserName').val(regUserName);
        $('#regBookCode').val(regBookCode);
        $('#regName').val(regName);
        $('#regStartDate').val(regStartDate);
        $('#biPlanCompAmt').val(biPlanCompAmt);

    }

    /*
    处理图书挂失
     */
    function submitRegLose(){
        //校验输入
        var isUserId = $('#regUserId').val();
        var isBookCode = $('#regBookCode').val();
        var biPlanCompAmt = $('#biPlanCompAmt').val();
        var biRegCommon = $('#biRegCommon').val();

        var errMsg = "";

        errMsg = checkEmpty('借阅人',isUserId);
        errMsg = errMsg + checkEmpty('图书编号',isBookCode);
        errMsg = errMsg + checkEmpty('待赔偿金额',biPlanCompAmt);
        errMsg = errMsg + checkNumber('待赔偿金额',biPlanCompAmt);

        if(errMsg.length > 0){
            ShowErrorDialog(errMsg);
            return;
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/doRegLoseBook.do",
            data: {"isUserId":isUserId,"isBookCode":isBookCode,"biPlanCompAmt":biPlanCompAmt,"biRegCommon":biRegCommon},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //挂失成功
                    ShowSuccessDialog("挂失成功");
                    $('#regLosModal').modal('hide');
                    reloadDataGrid(isUserId);

                }else{

                    //挂失失败
                    ShowErrorDialog(data.data.message);

                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("图书挂失失败");
            }
        });
    }

    /*
    解挂操作按键
     */
    function compBookButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要解挂的图书");
            return;
        }

        //检查是否可以挂失
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/checkUserCompkBook.do",
            data: {"userId":$('#isUserId').val(),"bookCode":row.isBookCode},
            dataType: "json",
            success: function(data)
            {
                if(data.data.code == '00'){
                    ClearForm("compBookForm");
                    initCompForm(row);
                    $('#compBookModal').modal('show');

                }else{

                    ShowErrorDialog(data.data);

                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("检查用户解挂信息失败");
            }
        });
    }

    function compTypeChange() {
        var compType = $('#compType').val();

        if(compType == '01'){
            //现金赔偿
            $('#blCompAmt').removeAttr("disabled");
            $('#blCompBookCode').attr("disabled","disabled");
        }else if(compType == '02' || compType == '03'){
            //新书赔偿/原书找回
            $('#blCompBookCode').removeAttr("disabled");
            $('#blCompAmt').attr("disabled","disabled");
        }else
        {
            $('#blCompAmt').attr("disabled","disabled");
            $('#blCompBookCode').attr("disabled","disabled");
        }
    }

    function initCompForm(row) {
        var compUserId = $('#isUserId').val();
        var compUserName = $('#isUserName').val();
        var compBookCode = row.isBookCode;
        var compName =row.biName;
        var compDate = row.blRegDate;
        var compPlanCompAmt = row.biPlanCompAmt;

        $('#compUserId').val(compUserId);
        $('#compUserName').val(compUserName);
        $('#compBookCode').val(compBookCode);
        $('#compName').val(compName);
        $('#compDate').val(compDate);
        $('#compPlanCompAmt').val(compPlanCompAmt);
        $('#blCompAmt').val(compPlanCompAmt);

    }

    /*
    处理图书解挂
     */
    function submitCompBook(){
        //校验输入
        var isUserId = $('#compUserId').val();
        var isBookCode = $('#compBookCode').val();
        var biCompType = $('#compType').val();
        var blCompBookCode = $('#blCompBookCode').val();
        var blCompAmt = $('#blCompAmt').val();
        var blCommon = $('#blCommon').val();

        var errMsg = "";

        errMsg = checkEmpty('借阅人',isUserId);
        errMsg = errMsg + checkEmpty('图书编号',isBookCode);
        errMsg = errMsg + checkEmpty('赔偿方式',biCompType);

        if(biCompType == '01'){
            errMsg = errMsg + checkEmpty('实际赔偿金额',blCompAmt);
            errMsg = errMsg + checkNumber('实际赔偿金额',blCompAmt);
        }
        else if(biCompType == '02'){
            errMsg = errMsg + checkEmpty('新书编号',blCompBookCode);
        }
        else if(biCompType == '03'){
            errMsg = errMsg + checkEmpty('原书编号',blCompBookCode);
        }


        if(errMsg.length > 0){
            ShowErrorDialog(errMsg);
            return;
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/doCompBook.do",
            data: {"isUserId":isUserId,"isBookCode":isBookCode,"biCompType":biCompType,"blCompBookCode":blCompBookCode,"blCompAmt":blCompAmt,"blCommon":blCommon},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //解挂成功
                    ShowSuccessDialog("解挂成功");
                    $('#compBookModal').modal('hide');
                    reloadDataGrid(isUserId);

                }else{

                    //解挂失败
                    ShowErrorDialog(data.data);

                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("图书解挂失败");
            }
        });
    }

</script>
</html>
