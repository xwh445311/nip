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
                                    消息主旨：
                                    <input type="text" class="form-control" name="ntHead" id="q_ntHead" value="${sessionScope.pcPetInfoForm.oiName}" placeholder="請輸入消息主旨">
                                </div>
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
                            class="easyui-datagrid"
                            style="width: 100%"
                            title="系統消息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/sysadmin/noteInfo/listTsNoteInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'ntId',checkbox:true"></th>
                            <th data-options="field:'ntHead',width:'100'">消息主旨</th>
                            <th data-options="field:'ntSendUser',width:'35'">發布人</th>
                            <th data-options="field:'ntSendDate',formatter:formatDate,width:'35'">發布時間</th>
                            <th data-options="field:'ntStatus',formatter:formatState,width:'30'">是否閱讀</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addTsNoteInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增消息</a>
                </auth:ax>

                <auth:ax srcId="role_updateTsNoteInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改消息</a>
                </auth:ax>

                <auth:ax srcId="role_deleteTsNoteInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除消息</a>
                </auth:ax>

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="viewButton()">閱讀消息</a>
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


    function formatDate(val,row){

        return row.ntSendDate + ' ' + row.ntSendTime;

    }

    function formatState(val,row) {
        if(val != '0')
        {
            return "<font color='green'>已讀</font>";
        }
        else
        {
            return "<font color='red'>未讀</font>";
        }
    }


    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            ntHead:$("#q_ntHead").val()
        });
    }

    function newButton() {
        window.location.href="<%=basePath%>/sysadmin/noteInfo/gotoAddNoteInfo.do";
    }

    /**
     * 修改按鈕
     */
    function editButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要修改的行");
            return;
        }

        window.location.href="<%=basePath%>/sysadmin/noteInfo/gotoUpdateNoteInfo.do?ntId=" + row.ntId;
    }

    /**
     * 修改按鈕
     */
    function deleteButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要刪除的行");
            return;
        }

        showConfirm("您確認要刪除此類型嗎，刪除後無法恢復？",function(){
            deleteData(row.ntId);
        });
    }


    //刪除
    function deleteData(ntId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/noteInfo/deleteTsNoteInfo.do",
            data: {"ntId":ntId},
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

    function viewButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要閱讀的行");
            return;
        }

        window.location.href='<%=basePath %>/sysadmin/noteInfo/gotoViewNotePage.do?ntId=' + row.ntId;
    }

</script>
</html>
