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
                                    <input type="text" class="form-control" name="uiName" id="uiQueryName" placeholder="請輸入用戶名稱">
                                    &nbsp;
                                    <efs:selParam cls="form-control" name="uiBusType" id="uiBusTypeQuery" type="TS_USER_TYPE"/>
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
                            title="用戶信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/sysadmin/userAdmin/listTsUserInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'uiId',width:'10%'">用戶ID</th>
                            <th data-options="field:'uiName',width:'10%'">用戶名称</th>
                            <th data-options="field:'uiMobile',width:'10%'">手机</th>
                            <th data-options="field:'uiBirthday',width:'10%'">出生日期</th>
                            <th data-options="field:'uiAge',width:'5%'">年龄</th>
                            <th data-options="field:'uiSex',formatter:formatSex,width:'5%'">性别</th>
                            <th data-options="field:'uiBusTypeVal',width:'10%'">用户类型</th>
                            <th data-options="field:'uiUpdUser',width:'10%'">修改人</th>
                            <th data-options="field:'uiUpdDate',formatter:formatDate,width:'10%'">修改时间</th>
                            <th data-options="field:'uiStatus',formatter:formatState,width:'10%',align:'center'">用户状态</th>
                            <th data-options="field:'uiUpdTime',formatter:formatDetail,width:'10%',align:'center'">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addTsUserInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateTsUserInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteTsUserInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>

                <auth:ax srcId="role_addTsUserInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="resetButton()">密码重置</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">用戶管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="userForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
                                <div class="form-group">
                                    <label for="uiId">用戶ID</label>
                                    <input type="text" class="form-control" name="uiId" id="uiId" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="uiName"><span class="text-danger ">*</span>姓名</label>
                                    <input type="text" class="form-control" id="uiName" name="uiName" placeholder="姓名">
                                </div>
                                <div class="form-group">
                                    <label for="uiShortName">姓名简称</label>
                                    <input type="text" class="form-control" id="uiShortName" name="uiShortName" placeholder="姓名简称">
                                </div>
                                <div class="form-group">
                                    <label for="uiSex"><span class="text-danger ">*</span>性别</label>
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
                                    <label for="uiMobile">手机号码</label>
                                    <input type="text" class="form-control" id="uiMobile" name="uiMobile" placeholder="手机号码">
                                </div>
                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>用戶状态</label>
                                    <div>
                                        <input type="radio" id="uiStatus_1" name="uiStatus" value="1" checked>启用 &nbsp;&nbsp;
                                        <input type="radio" id="uiStatus_0" name="uiStatus" value="0"> 停用
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>用户类型</label>
                                    <div>
                                        <select id="uiBusType" name="uiBusType">
                                            <option value="">請選擇</option>
                                            <c:forEach items="${applicationScope.TS_USER_TYPE}" var="item">
                                                <option value="${item.key}">${item.value}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label">用戶所属机构</label>
                                    <div>
                                        <input class="easyui-combobox"
                                               name="userOrgs"
                                               id="userOrgs"
                                               data-options="
                                                    url:'<%=basePath %>/sysadmin/orgAdmin/listAllEnableOrgs.do?random=<%=Math.random() %>',
                                                    method:'post',
                                                    valueField:'oiCode',
                                                    textField:'oiName',
                                                    multiple:true,
                                                    panelHeight:'auto'" />
                                    </div>
                                </div>



                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>用戶角色</label>
                                    <div>
                                        <input class="easyui-combobox"
                                               name="userRoles"
                                               id="userRoles"
                                               data-options="
                                                    url:'<%=basePath %>/sysAdmin/role/listAllEnableRole.do?random=<%=Math.random() %>',
                                                    method:'get',
                                                    valueField:'riId',
                                                    textField:'riName',
                                                    multiple:true,
                                                    panelHeight:'auto'" />
                                    </div>
                                </div>

                                <c:if test='${sessionScope.SESSION_KEY_SYSUSER.uiIsSup =="1"}'>
                                    <div class="form-group">
                                        <label class="control-label">超級用戶</label>
                                        <div>
                                            <input type="radio" id="uiIsSup_1" name="uiIsSup" value="1" >是 &nbsp;&nbsp;
                                            <input type="radio" id="uiIsSup_0" name="uiIsSup" value="0" checked> 否
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
                            <h4 class="modal-title">角色明細</h4>
                        </div>
                        <div class="modal-body">
                            <span id="roleListPane"></span>
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
        InitValidate("userForm","errContent",{
            uiName:{
                required:true,
                maxlength:10
            },
            uiSex:'required',
            uiBirthday:'required',
            uiMobile:{
                minlength:5,
                pattern:"^[0-9\-\(\)]+"

            },
            uiStatus:"required",
            uiBusType:"required",
            userRoles:"required"
        },{
            uiName:{
                required:"用户名称：必须输入",
                maxlength:"用户名称：最大长度不能超过10位"
            },
            uiSex:'性别：必须选择',
            uiBirthday:'出生日期：必须选择',
            uiMobile:{
                minlength:"手机号码：长度必须大于5位",
                pattern:"手机号码：包含不合法字符"
            },
            uiStatus:"用戶状态：必须选择",
            uiBusType:"用戶类型：必须选择",
            userRoles:"用戶角色：必须选择"

        },function () {
            var errMsg = "";
            if($('#userRoles').val() == ""){
                errMsg += "用戶角色：必须选择\n";
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
        return ((row.uiUpdDate == null ) ? "" : row.uiUpdDate ) + " " + ((row.uiUpdTime == null ) ? "" : row.uiUpdTime );
    }

    function formatDetail(val,row){
        return "<a href='#' onclick='showRoleFunc(\"" +row.uiId+ "\")'>角色明細</a>";
    }

    function formatSex(val,row) {
        if(val == 'F'){
            return '女';
        }else if(val == 'M'){
            return '男';
        }
    }

    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            uiName:$("#uiQueryName").val(),
            uiBusType:$('#uiBusTypeQuery').val()
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
    function editButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要修改的行");
            return;
        }

        $('#passDiv').hide();
        $('#confPassDiv').hide();

        ResetValidate();
        ClearForm("userForm");

        $('#myModal').modal('show');
        $('#userForm').form('load','<%=basePath %>/sysadmin/userAdmin/getTsUserInfo.do?uiId=' + row.uiId);

        $('#passDiv').val('000000');
        $('#confPassDiv').val('000000');
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
            url = "<%=basePath %>/sysadmin/userAdmin/addTsUserInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("用戶增加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("用戶增加失敗");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/sysadmin/userAdmin/updateTsUserInfo.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("用戶修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("用戶修改失敗");
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

    function showRoleFunc(uiId){
        $('#roleListPane').empty();

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/userAdmin/getUserRoleList.do",
            data: {"uiId":uiId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    $('#roleListPane').append(data.data);
                    $('#funcModal').modal('show');
                }else{
                    ShowErrorDialog("获取数据信息失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("获取信息数据失败:" + request.status + "," + request.responseText);
            }
        });
    }

    function resetButton(){
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择用户");
            return;
        }

        showConfirm("确定要重置该用户的密码吗？",function(){
            doResetPass(row.uiId);
        });
    }

    function doResetPass(uiId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/userAdmin/resetUserPassword.do",
            data: {"uiId":uiId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("密码重置成功，请告知用户重新登录并修改密码!");
                }else{
                    ShowErrorDialog("密码重置失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog("密码重置失败:" + request.status + "," + request.responseText);
            }
        });
    }
</script>
</html>
