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
                            借阅人信息
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
                            title="已借图书"
                            rownumbers="true"
                            fitColumns="true"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/lib/booksend/listUserLibInSendInfo.do?"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'isId',width:'1%',hidden:'true'">流水号</th>
                            <th data-options="field:'isBookCode',width:'5%'">图书编号</th>
                            <th data-options="field:'biName',width:'20%'">图书名称</th>
                            <th data-options="field:'biPress',width:'20%'">出版社</th>
                            <th data-options="field:'biAuth',width:'20%'">作者</th>
                            <th data-options="field:'isStartDate',width:'5%'">借阅日期</th>
                            <th data-options="field:'isStartTime',width:'5%'">借阅时间</th>
                            <th data-options="field:'isPlanBackDate',width:'5%'">计划归还日期</th>
                            <th data-options="field:'isSendStatus',formatter:formatSendState,width:'5%'">图书状态</th>
                            <th data-options="field:'isOverStatus',formatter:formatState,width:'5%'">是否超期</th>
                            <th data-options="field:'isOverdueLong',width:'5%'">超期天数</th>
                        </tr>
                        </thead>
                    </table>
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


    function formatState(val,row)
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
        if(val == '01')
        {
            return "<span style='color: green'>在借</span>"
        }
        else
        {
            return "<span style='color: red'>挂失</span>"
        }
    }



    function readyInputUserId(){
        $('#userInput').val('');
        $('#userInput').focus();
    }

    function readyInputBookCode() {
        $('#bookInput').removeAttr("disabled");
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

        //获取用户的已借书列表
        reloadDataGrid(userId);


        //判断用户是否有借书的权限
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/checkUserSendBook.do",
            data: {"userId":userId},
            dataType: "json",
            success: function(data)
            {
                if(data.data.code == '00'){
                    //可以借书
                    readyInputBookCode();

                }else{
                    //不能借书，禁用输入框
                    $('#bookInput').val('');
                    $('#bookInput').attr("disabled","disabled");
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

        //判断是否可以借书
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/checkUserSendBook.do",
            data: {"userId":userId,"bookCode":bookCode},
            dataType: "json",
            success: function(data)
            {
                if(data.data.code == '00'){
                    //可以借书
                    doSendBook(userId,bookCode);

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
    处理借书逻辑
     */
    function doSendBook(userId, bookCode) {
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/booksend/doSendBook.do",
            data: {"userId":userId,"bookCode":bookCode},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //借书成功
                    reloadDataGrid(userId);

                    //更新借书人信息
                    ClearForm("userForm");
                    $('#userForm').form('load','<%=basePath %>/lib/booksend/getLibInSendUserInfo.do?userId=' + userId);

                    //初始化输入框
                    readyInputBookCode();


                }else{

                    //借书失败
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

</script>
</html>
