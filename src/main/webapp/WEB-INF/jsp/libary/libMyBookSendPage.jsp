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
                                    <input type="text" class="form-control" name="isBookCode" id="isBookCode" placeholder="图书编号" value="${sessionScope.libBooksInfoForm.biIsbn}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biName" id="biName" placeholder="图书名称" value="${sessionScope.libBooksInfoForm.biCode}">
                                </div>
                                <div class="form-group">
                                    是否超期：
                                    <select class="form-control" name="isOverStatus" id="isOverStatus">
                                        <option value="">请选择</option>
                                        <option value="1">已超期</option>
                                        <option value="0">未超期</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    借阅状态：
                                    <select class="form-control" name="isSendStatus" id="isSendStatus">
                                        <option value="">请选择</option>
                                        <option value="00">已还</option>
                                        <option value="01">在借</option>
                                        <option value="02">挂失</option>
                                        <option value="03">已赔</option>
                                    </select>
                                </div>

                                &nbsp;

                                <button type="button" class="btn btn-primary" onclick="queryDataGrid()">查詢</button>
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
                            title="我借阅的图书"
                            rownumbers="true"
                            fitColumns="true"
                            pagination="true"
                            toolbar="#toolbar"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/lib/booksend/listUserAllSendInfo.do?isUserId=${userId}"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'isId',width:'1%',hidden:'true'">流水号</th>
                            <th data-options="field:'isBookCode',width:'5%'">图书编号</th>
                            <th data-options="field:'biName',width:'25%'">图书名称</th>
                            <th data-options="field:'biPress',width:'15%'">出版社</th>
                            <th data-options="field:'biPrice',width:'5%'">单价</th>
                            <th data-options="field:'isSendStatus',formatter:formatSendState,width:'5%'">借阅状态</th>
                            <th data-options="field:'isOverStatus',formatter:formatOverState,width:'5%'">是否超期</th>
                            <th data-options="field:'isOverdueLong',width:'6%'">超期天数</th>
                            <th data-options="field:'isStartDate',width:'6%'">借阅日期</th>
                            <th data-options="field:'isBackDate',width:'6%'">归还日期</th>
                            <th data-options="field:'blRegDate',width:'6%'">挂失日期</th>
                            <th data-options="field:'blCompDate',width:'6%'">赔偿日期</th>
                            <th data-options="field:'biCompType',formatter:formatCompState,width:'6%'">赔偿方式</th>
                            <th data-options="field:'blCompAmt',width:'5%'">赔偿金额</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="detailButton()">查看</a>

            </div>

            <br/>

            <c:if test="${flag == 'BOOK_DETAIL'}">
                <div class="row" style="text-align: center">
                    <button type="button" class="btn btn-primary" onclick="returnBack()">返回</button>
                </div>
            </c:if>
        </div>

    </div>
</section>

</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

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

    function formatCompState(val, row) {
        if(val == '01')
        {
            return "价格赔偿"
        }
        else if(val == '02')
        {
            return "新书赔偿"
        }
        else if(val == '03')
        {
            return "原书找回"
        }
        else {
            return val;
        }
    }


    function queryDataGrid(){
        var isBookCode = $('#isBookCode').val();
        var biName = $('#biName').val();
        var isOverStatus = $('#isOverStatus').val();
        var isSendStatus = $('#isSendStatus').val();

        $("#dataList").datagrid('load',{
            isBookCode:isBookCode,
            biName:biName,
            isOverStatus:isOverStatus,
            isSendStatus:isSendStatus
        });
    }

    function detailButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要查看的行");
            return;
        }

        window.location.href='<%=basePath %>/lib/booksend/gotoShowSendPage.do?isId=' + row.isId;
    }

    function returnBack(){
        var biCode = '${bookCode}';
        window.location.href='<%=basePath %>/lib/bookAdmin/gotoShowBookPage.do?flag=ADMIN&biCode=' + biCode;
    }

</script>
</html>
