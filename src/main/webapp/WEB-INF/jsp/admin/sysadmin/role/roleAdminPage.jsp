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
                                    <input type="text" class="form-control" name="riName" id="riQueryName" placeholder="請輸入角色名稱">
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
                            style="width: 100%"
                            title="角色信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/sysAdmin/role/listTsRoleInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'riId',width:'10%'">角色ID</th>
                            <th data-options="field:'riName',width:'30%'">角色名稱</th>
                            <th data-options="field:'riAddUser',width:'20%'">修改人</th>
                            <th data-options="field:'riAddDate',formatter:formatDate,width:'20%'">修改時間</th>
                            <th data-options="field:'riStatus',formatter:formatState,width:'10%',align:'center'">狀態</th>
                            <th data-options="field:'riAddTime',formatter:formatDetail,width:'10%',align:'center'">操作</th>

                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addTsRoleInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateTsRoleInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteTsRoleInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">角色管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="roleForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                                <div class="form-group">
                                    <label for="riId">角色ID</label>
                                    <input type="text" class="form-control" name="riId" id="riId" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="riName"><span class="text-danger ">*</span>角色名稱</label>
                                    <input type="text" class="form-control" id="riName" name="riName" placeholder="角色名稱" required>
                                </div>
                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>角色狀態:</label>
                                    <div>
                                        <input type="radio" id="riStatus_1" name="riStatus" value="1" checked>啟用 &nbsp;&nbsp;
                                        <input type="radio" id="riStatus_0" name="riStatus" value="0"> 停用
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>角色功能</label>
                                    <div>
                                        <input name="roleFunc" id="roleFunc"
                                                class="easyui-combotree"
                                                data-options="url:'<%=basePath %>/sysadmin/funcAdmin/getFuncRoleSelectResource.do',method:'get',cascadeCheck:false"
                                                multiple
                                                style="width:200px;" />
                                    </div>
                                </div>
                                <c:if test='${sessionScope.SESSION_KEY_SYSUSER.uiIsSup =="1"}'>
                                    <div class="form-group">
                                        <label class="control-label">超級用戶角色</label>
                                        <div>
                                            <input type="radio" id="riIsSuper_1" name="riIsSuper" value="1" >是 &nbsp;&nbsp;
                                            <input type="radio" id="riIsSuper_0" name="riIsSuper" value="0" checked> 否
                                        </div>
                                    </div>
                                </c:if>


                                <div class="form-group">
                                <br/><button type="button" class="btn btn-primary" onclick="saveData()">提交</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <!-- 弹出角色功能明细 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="funcModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">功能明細</h4>
                        </div>
                        <div class="modal-body">
                            <div class="left">
                            <ul id="treeDemo" class="ztree"></ul>
                            </div>
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

    var setting = {
        check: {
            enable: true,
            nocheckInherit: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        view:{
            fontCss:{
                "font-size":"14px"
            }
        }
    };


    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化校验框架
        InitValidate("roleForm","errContent",{
            riName:"required",
            riStatus:"required",
            roleFunc:"required"

        },{
            riName:"角色名稱：必須輸入",
            riStatus:"角色狀態：必須選擇",
            roleFunc:"角色功能：必須選擇"
        },function () {
            var errMsg = "";
            if($('#roleFunc').val() == ""){
                errMsg += "角色功能：必須選擇";
            }
            return errMsg;
        });


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
        return ((row.riAddDate == null ) ? "" : row.riAddDate ) + " " + ((row.riAddTime == null ) ? "" : row.riAddTime );
    }

    function formatDetail(val,row){
        return "<a href='#' onclick='showRoleFunc(\"" +row.riId+ "\")'>功能明細</a>";
    }

    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            riName:$("#riQueryName").val()
        });
    }

    function newButton() {
        ResetValidate();
        ClearForm("roleForm");
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

        ResetValidate();
        ClearForm("roleForm");

        $('#myModal').modal('show');

        $('#roleForm').form('load','<%=basePath %>/sysAdmin/role/getTsRoleInfo.do?riId=' + row.riId);
        $('#roleFunc').combotree('reload','<%=basePath %>/sysadmin/funcAdmin/getFuncRoleSelectResource.do?roleId=' + row.riId + '&timeStamp=' + (new Date()).valueOf());
    }

    /**
     * 刪除功能
     */
    function deleteButton() {

        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要刪除的角色");
            return;
        }

        showConfirm("此角色已經分配給用戶了，確認要繼續刪除嗎？",function(){
            //檢查此角色是否還有用
            $.ajax({
                async: false,
                ifModified:true,
                type: "POST",
                url: "<%=basePath%>/sysAdmin/role/checkRoleHasUser.do",
                data: {"riId":row.riId},
                dataType: "json",
                success: function(data)
                {
                    if(data.success){
                        if(data.data != '0'){
                            showConfirm("此角色已經分配給用戶了，確認要繼續刪除嗎？",function(){
                                deleteRoleInfo(row.riId);
                            });
                        }else{
                            deleteRoleInfo(row.riId);
                        }

                    }else{
                        alert("查詢記錄失敗！");
                    }

                },
                error: function(request, status, err)
                {
                    alert(request.status + "," + request.responseText);
                    alert("查詢記錄失敗");
                }
            });
        });
    }

    function saveData(){
        var riId = $('#riId').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/sysAdmin/role/addTsRoleInfo.do";
            SubmitForm("roleForm",url,function(data){
                ShowSuccessDialog("角色添加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("角色添加失敗");
            });
        }else{
            //修改角色信息
            url = "<%=basePath %>/sysAdmin/role/updateTsRoleInfo.do";
            SubmitForm("roleForm",url,function(data){
                ShowSuccessDialog("角色修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("角色修改失敗");
            });
        }


    }

    //刪除角色
    function deleteRoleInfo(roleId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysAdmin/role/deleteTsRoleInfo.do",
            data: {"riId":roleId},
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

    /**
     * 顯示角色的功能明細
     * @param roleId
     */
    function showRoleFunc(roleId){

        $('#funcModal').modal('show');

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/funcAdmin/getFuncRoleTreeJson.do",
            data: {"roleId":roleId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    //alert(data.data);
                    $.fn.zTree.destroy("treeDemo");
                    $.fn.zTree.init($("#treeDemo"), setting,eval('('+data.data+')'));
                }else{
                    ShowErrorDialog("讀取角功能息失敗！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("讀取角功能息失敗！");
            }
        });
    }



</script>
</html>
