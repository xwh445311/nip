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
                            图书查询
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                             </span>
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biIsbnStr" id="biIsbnStr" placeholder="ISBN编号" value="${sessionScope.libBooksInfoForm.biIsbn}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biCodeStr" id="biCodeStr" placeholder="图书编号" value="${sessionScope.libBooksInfoForm.biCode}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biNameStr" id="biNameStr" placeholder="图书名称" value="${sessionScope.libBooksInfoForm.biName}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biAuthStr" id="biAuthStr" placeholder="作者/译者" value="${sessionScope.libBooksInfoForm.biAuth}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biPressStr" id="biPressStr" placeholder="出版社" value="${sessionScope.libBooksInfoForm.biPress}">
                                </div>
                                <div class="form-group">
                                    图书类别：
                                    <select class="easyui-combobox" name="biTypeStr" id="biTypeStr">
                                        <option value="">请选择</option>
                                        <c:forEach items="${bookTypeInfoList}" var="item">
                                        <option value="${item.btName}" <c:if test="${sessionScope.libBooksInfoForm.biType == item.btName}">selected</c:if> >${item.btName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    图书状态：
                                    <select class="form-control" name="biStatusStr" id="biStatusStr">
                                        <option value="">请选择</option>
                                        <c:forEach items="${applicationScope.LIB_BOOK_STATUS}" var="item">
                                            <option value="${item.key}" <c:if test="${sessionScope.libBooksInfoForm.biStatus == item.key}">selected</c:if>>${item.value}</option>
                                        </c:forEach>
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
                            title="查询信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/lib/bookAdmin/listLibBooksInfo.do?isUser=Y"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'biCode',width:'8%'">图书编号</th>
                            <th data-options="field:'biIsbn',width:'12%'">ISBN编号</th>
                            <th data-options="field:'biName',width:'22%'">图书名称</th>
                            <th data-options="field:'biPress',width:'15%'">出版社</th>
                            <th data-options="field:'biAuth',width:'28%'">作者</th>
                            <th data-options="field:'biInUser',width:'5%'">入库人</th>
                            <th data-options="field:'biInDate',width:'6%'">入库日期</th>
                            <th data-options="field:'biAddr',width:'5%'">书架地址</th>
                            <th data-options="field:'biStatusVal',formatter:formatState,width:'5%'">图书状态</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="detailButton()">查看</a>

            </div>

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


    function formatState(val,row)
    {
        if(val == '借出')
        {
            return "<span style='color: orange'>"+val+"</span>"
        }
        else if(val == '在库')
        {
            return "<span style='color: green'>"+val+"</span>"
        }
        else if(val == '挂失')
        {
            return "<span style='color: red'>"+val+"</span>"
        }
        else
        {
            return val;
        }
    }


    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            biName:$("#biNameStr").val(),
            biCode:$("#biCodeStr").val(),
            biIsbn:$("#biIsbnStr").val(),
            biType:$('#biTypeStr').val(),
            biStatus:$('#biStatusStr').val(),
            biAuth:$('#biAuthStr').val(),
            biPress:$('#biPressStr').val()
        });
    }

    /**
     * 查看按钮
     */
    function detailButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要查看的行");
            return;
        }

        window.location.href='<%=basePath %>/lib/bookAdmin/gotoShowBookPage.do?biCode=' + row.biCode + '&flag=USER';
    }


    function showAddrFunc(lsNo) {
        window.location.href="<%=basePath%>/lib/gotoShielfAddrPage.do?lsNo=" + lsNo;
    }


</script>
</html>
