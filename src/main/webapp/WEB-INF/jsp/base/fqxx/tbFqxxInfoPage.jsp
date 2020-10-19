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

            <!--列表区域 -->
            <div class="row">
                <div class="col-md-12" id="gridPanel">
                    <table  id="dataList"
                            style="width: 100%"
                            title="区域管理"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/base/fqxx/listTbFqxxInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'qyId'" width="30">区域代码</th>
                            <th data-options="field:'qyOrgName'" width="50">归属分公司</th>
                            <th data-options="field:'qyName'" width="50">区域名称</th>
                            <th data-options="field:'qyStatus',formatter:formatState,width:'40',align:'center'" >状态</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addTbFqxxInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateTbFqxxInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteTbFqxxInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">区域管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="fqxxForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                                <div class="form-group">
                                    <label for="qyId">区域代码</label>
                                    <input type="text" class="form-control" name="qyId" id="qyId" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="qyOrgId"><span class="text-danger ">*</span>所属分公司</label>
                                    <efs:select name="qyOrgId" id="qyOrgId" cls="form-control" list="${branchOrgSelList}"/>
                                </div>

                                <div class="form-group">
                                    <label for="qyName">区域名称</label>
                                    <input type="text" class="form-control" id="qyName" name="qyName" placeholder="区域名称" required >
                                </div>

                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>状态</label>
                                    <div>
                                        <input type="radio" id="qyStatus_1" name="qyStatus" value="1" checked>啟用 &nbsp;&nbsp;
                                        <input type="radio" id="qyStatus_0" name="qyStatus" value="0"> 停用
                                    </div>
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

    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化校验框架
        InitValidate("fqxxForm","errContent",{
            qyOrgId:"required",
            qyName:{
                required:true,
                maxlength:20
            },
            qyStatus:"required"
        },{
            qyOrgId:"归属分公司：必须选择",
            qyName:{
                required:"区域名称：必須輸入",
                maxlength:"区域名称：最大长度不能超过30位"
            },

            qyStatus:"状态：必须选择"
        });


    });

    function formatState(val,row)
    {
        if(val == '1')
        {
            return "<span class='label label-success'>启用</span>"
        }
        else
        {
            return "<span class='label label-danger'>停用</span>"
        }
    }

    function formatDate(val,row){
        return ((row.updDate == null ) ? "" : row.updDate ) + " " + ((row.updTime == null ) ? "" : row.updTime );
    }


    function newButton() {
        $('#passDiv').show();
        $('#confPassDiv').show();
        ResetValidate();
        ClearForm("fqxxForm");
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
        ClearForm("fqxxForm");

        $('#myModal').modal('show');
        $('#fqxxForm').form('load','<%=basePath %>/base/fqxx/getTbFqxxInfo.do?qyId=' + row.qyId);

    }

    /**
     * 刪除功能
     */
    function deleteButton() {

        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要删除的行");
            return;
        }

        showConfirm("您确认要删除该机构吗？",function(){
            deleteUserInfo(row.qyId);
        });

        //检查机构是否在使用
        /*$.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/orgAdmin/checkOrgHasUsed.do",
            data: {"oiCode":row.oiCode},
            dataType: "json",
            success: function(data)
            {
                if(data.data == '0'){
                    //未被使用，可以进行删除
                    showConfirm("您确认要删除该机构吗？",function(){
                        deleteUserInfo(row.oiCode);
                    });

                }else if(data.data == '1'){
                    ShowErrorDialog("该机构中还有用户，请先移除该机构中的用户后再删除！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("检查机构用户信息失败");
            }
        });*/


    }

    function saveData(){
        var riId = $('#qyId').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/base/fqxx/addTbFqxxInfo.do";
            SubmitForm("fqxxForm",url,function(data){
                ShowSuccessDialog("添加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("添加失败");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/base/fqxx/updateTbFqxxInfo.do";
            SubmitForm("fqxxForm",url,function(data){
                ShowSuccessDialog("修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("修改失败");
            });
        }
    }

    //刪除用戶
    function deleteUserInfo(oiCode){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/base/fqxx/deleteTbFqxxInfo.do",
            data: {"qyId":oiCode},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("刪除记录成功！");
                    $('#dataList').datagrid('reload');
                }else{
                    ShowErrorDialog("刪除记录失敗！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("刪除记录失敗");
            }
        });
    }

</script>
</html>
