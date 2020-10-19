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
                            title="书架信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/lib/listLibShelfInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'lsNo',width:'10%'">书架编号</th>
                            <th data-options="field:'lsRowCnt',width:'10%'">书架层数</th>
                            <th data-options="field:'lsColCnt',width:'10%'">书架列数</th>
                            <th data-options="field:'lsMaxBookCnt',width:'10%'">每格最大放书量</th>
                            <th data-options="field:'lsTotAddCnt',width:'10%'">最大格数</th>
                            <th data-options="field:'lsTotBookCnt',width:'10%'">最大放书量</th>
                            <th data-options="field:'lsStarAddr',width:'10%'">开始地址</th>
                            <th data-options="field:'lsEndAddr',width:'10%'">结束地址</th>
                            <th data-options="field:'lsUseStatus',formatter:formatState,width:'10%',align:'center'">使用状态</th>
                            <th data-options="field:'riAddTime',formatter:formatDetail,width:'10%',align:'center'">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addLibShelfInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateLibShelfInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteLibShelfInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">书架管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="bookForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                                <br/>
                                <div class="form-group">
                                    <label for="lsNo">书架编号</label>
                                    <input type="text" class="form-control" name="lsNo" id="lsNo" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="lsRowCnt"><span class="text-danger ">*</span>书架层数</label>
                                    <input type="text" class="form-control" id="lsRowCnt" name="lsRowCnt" placeholder="书架层数" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>书架列数</label>
                                    <input type="text" class="form-control" id="lsColCnt" name="lsColCnt" placeholder="书架列数" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>每列最大存书量</label>
                                    <input type="text" class="form-control" id="lsMaxBookCnt" name="lsMaxBookCnt" placeholder="每列最大存书量" />
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
        InitValidate("bookForm","errContent",{
            lsRowCnt:{
                required:true,
                digits:true
            },
            lsColCnt:{
                required:true,
                digits:true
            },
            lsMaxBookCnt:{
                required:true,
                digits:true
            }

        },{
            lsRowCnt:{
                required:"书架层数：必须输入",
                digits:"书架层数：必须为数字"
            },
            lsColCnt:{
                required:"书架列数：必须输入",
                digits:"书架列数：必须为数字"
            },
            lsMaxBookCnt:{
                required:"每列最大存书量：必须输入",
                digits:"每列最大存书量：必须为数字"
            }
        });


    });

    function formatState(val,row)
    {
        if(val == '1')
        {
            return "<span class='label label-success'>已用</span>"
        }
        else
        {
            return "<span class='label label-danger'>未用</span>"
        }
    }

    function formatDetail(val,row){
        return "<a href='#' onclick='showAddrFunc(\"" +row.lsNo+ "\")'>书架布局</a>";
    }


    function newButton() {
        ResetValidate();
        ClearForm("bookForm");
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
        ClearForm("bookForm");

        $('#myModal').modal('show');

        $('#bookForm').form('load','<%=basePath %>/lib/getLibShelfInfo.do?lsNo=' + row.lsNo);
    }

    /**
     * 刪除功能
     */
    function deleteButton() {

        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要删除的数据");
            return;
        }

        //检查是否已经删除
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/checkShielfInUse.do",
            data: {"lsNo":row.lsNo},
            dataType: "json",
            success: function(data)
            {
                if(data.data == '0'){
                    //未被使用，可以进行删除
                    showConfirm("您确认要删除该书架吗？",function(){
                        deleteData(row.lsNo);
                    });

                }else if(data.data == '1'){
                    ShowErrorDialog("该书架上还有图书，请先移走图书后再删除！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("检查书架信息失败");
            }
        });

    }

    function saveData(){
        var riId = $('#lsNo').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/lib/addLibShelfInfo.do";
            SubmitForm("bookForm",url,function(data){
                ShowSuccessDialog("新增书架成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("新增书架失败");
            });
        }else{
            //修改角色信息
            url = "<%=basePath %>/lib/updateLibShelfInfo.do";
            SubmitForm("bookForm",url,function(data){
                ShowSuccessDialog("修改书架成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("修改书架失败");
            });
        }
    }

    //刪除角色
    function deleteData(lsNo){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/deleteLibShelfInfo.do",
            data: {"lsNo":lsNo},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("刪除数据成功！");
                    $('#dataList').datagrid('reload');
                }else{
                    ShowErrorDialog("刪除数据失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("刪除数据失败");
            }
        });
    }

    function showAddrFunc(lsNo) {
        window.location.href="<%=basePath%>/lib/gotoShielfAddrPage.do?lsNo=" + lsNo;
    }

</script>
</html>
