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
                            title="组织机构信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/sysadmin/orgAdmin/listTsOrgInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'oiCode',width:'30'">机构代码</th>
                            <th data-options="field:'oiName',width:'80'">机构名称</th>
                            <th data-options="field:'oiSfdz'" width="40">收费地址</th>
                            <th data-options="field:'oiKhyh'" width="40">开户银行</th>
                            <th data-options="field:'oiYhzh'" width="40">银行账号</th>
                            <th data-options="field:'oiZzsh'" width="40">增值税号</th>
                            <th data-options="field:'oiLxdh'" width="40">联系电话</th>
                            <th data-options="field:'oiLxr'" width="40">联系人</th>
                            <th data-options="field:'oiDwfzr'" width="40">单位负责人</th>
                            <th data-options="field:'oiYwfzr'" width="40">业务负责人</th>
                            <th data-options="field:'updUser',width:'40'">修改人</th>
                            <th data-options="field:'updDate',formatter:formatDate,width:'40'">修改時間</th>
                            <th data-options="field:'oiStatus',formatter:formatState,width:'40',align:'center'">狀態</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addTsOrgInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateTsOrgInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteTsOrgInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">组织机构管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="orgForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                                <div class="form-group">
                                    <label for="oiCode">机构代码</label>
                                    <input type="text" class="form-control" name="oiCode" id="oiCode" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="oiName"><span class="text-danger ">*</span>机构名称</label>
                                    <input type="text" class="form-control" id="oiName" name="oiName" placeholder="机构名称" required>
                                </div>

                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>机构状态</label>
                                    <div>
                                        <input type="radio" id="oiStatus_1" name="oiStatus" value="1" checked>啟用 &nbsp;&nbsp;
                                        <input type="radio" id="oiStatus_0" name="oiStatus" value="0"> 停用
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>机构类别</label>
                                    <div>
                                        <input type="radio" id="oiType_1" name="oiType" value="01" checked>公司 &nbsp;&nbsp;
                                        <input type="radio" id="oiType_0" name="oiType" value="02"> 部门
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="oiName">收费地址</label>
                                    <input type="text" class="form-control" id="oiSfdz" name="oiSfdz" placeholder="收费地址" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">开户银行</label>
                                    <input type="text" class="form-control" id="oiKhyh" name="oiKhyh" placeholder="开户银行" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">银行账号</label>
                                    <input type="text" class="form-control" id="oiYhzh" name="oiYhzh" placeholder="银行账号" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">增值税号</label>
                                    <input type="text" class="form-control" id="oiZzsh" name="oiZzsh" placeholder="增值税号" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">联系电话</label>
                                    <input type="text" class="form-control" id="oiLxdh" name="oiLxdh" placeholder="联系电话" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">联系人</label>
                                    <input type="text" class="form-control" id="oiLxr" name="oiLxr" placeholder="联系人" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">单位负责人</label>
                                    <input type="text" class="form-control" id="oiDwfzr" name="oiDwfzr" placeholder="单位负责人" >
                                </div>

                                <div class="form-group">
                                    <label for="oiName">业务负责人</label>
                                    <input type="text" class="form-control" id="oiYwfzr" name="oiYwfzr" placeholder="业务负责人" >
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
        InitValidate("orgForm","errContent",{
            oiName:{
                required:true,
                maxlength:20
            },

            oiStatus:"required",
            oiType:"required"
        },{
            oiName:{
                required:"机构名称：必須輸入",
                maxlength:"机构名称：最大长度不能超过20位"
            },

            uiStatus:"机构状态：必须选择",
            oiType:"机构类别：必须选择"

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
        ClearForm("orgForm");
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
        ClearForm("orgForm");

        $('#myModal').modal('show');
        $('#orgForm').form('load','<%=basePath %>/sysadmin/orgAdmin/getTsOrgInfo.do?oiCode=' + row.oiCode);

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

        //检查机构是否在使用
        $.ajax({
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
        });


    }

    function saveData(){
        var riId = $('#oiCode').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/sysadmin/orgAdmin/addTsOrgInfo.do";
            SubmitForm("orgForm",url,function(data){
                ShowSuccessDialog("添加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("添加失败");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/sysadmin/orgAdmin/updateTsOrgInfo.do";
            SubmitForm("orgForm",url,function(data){
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
            url: "<%=basePath%>/sysadmin/orgAdmin/deleteTsOrgInfo.do",
            data: {"oiCode":oiCode},
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
