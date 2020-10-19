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
                                    <input type="text" class="form-control" name="btKeywordStr" id="btKeywordStr" placeholder="请输入查询关键字">
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
                            class="easyui-treegrid"
                            style="width: 100%"
                            title="图书分类信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath%>/lib/bookType/listLibBookTypeInfo.do"
                            method="post"
                            idField="btId"
                            treeField="btName">
                        <thead>
                        <tr>
                            <th data-options="field:'btId',width:'10%',hidden:'true'">类别ID</th>
                            <th data-options="field:'btName',width:'30%'">类别名称</th>
                            <th data-options="field:'btCode',width:'10%'">类别号</th>
                            <th data-options="field:'btKeyword',width:'60%'">匹配关键字</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addLibBookTypeInfo">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateLibBookTypeInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteLibBookTypeInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">图书分类管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="bookForm">
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                                <br/>
                                <div class="form-group">
                                    <label for="btId">分类ID</label>
                                    <input type="text" class="form-control" name="btId" id="btId" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="btName"><span class="text-danger ">*</span>类别名称</label>
                                    <input type="text" class="form-control" id="btName" name="btName" placeholder="类别名称" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label">类别代码</label>
                                    <input type="text" class="form-control" id="btCode" name="btCode" placeholder="类别代码" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label">匹配关键字</label>
                                    <input type="text" class="form-control" id="btKeyword" name="btKeyword" placeholder="匹配关键字" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>父类别</label>
                                    <div>
                                        <select id="btParentId" name="btParentId">
                                            <option value="0">根类别</option>
                                            <c:forEach items="${rootBookType}" var="item">
                                                <option value="${item.btId}">${item.btName}</option>
                                            </c:forEach>
                                        </select>
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
        InitValidate("bookForm","errContent",{
            btName:{
                required:true,
                maxlength:15
            },
            btCode:{
                maxlength:10
            },
            btParentId:'required'

        },{
            btName:{
                required:"类别名称：必须输入",
                maxlength:"类别名称：长度不能超过15位"
            },
            btCode:{
                maxlength:"类别代码：长度不能超过10位"
            },
            btParentId:"父类别：必须选择"
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


    function queryDataGrid(){
        $("#dataList").treegrid('load',{
            btKeyword:$("#btKeywordStr").val()
        });
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

        $('#bookForm').form('load','<%=basePath %>/lib/bookType/getLibBookTypeInfo.do?btId=' + row.btId);
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

        showConfirm("您确认要删除该分类吗？",function(){
            deleteData(row.btId);
        });

    }

    function saveData(){
        var riId = $('#btId').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/lib/bookType/addLibBookTypeInfo.do";
            SubmitForm("bookForm",url,function(data){
                ShowSuccessDialog("新增分类成功");
                $('#myModal').modal('hide');
                $('#dataList').treegrid('reload');
            },function () {
                ShowErrorDialog("新增分类失败");
            });
        }else{
            //修改角色信息
            url = "<%=basePath %>/lib/bookType/updateLibBookTypeInfo.do";
            SubmitForm("bookForm",url,function(data){
                ShowSuccessDialog("修改分类成功");
                $('#myModal').modal('hide');
                $('#dataList').treegrid('reload');
            },function () {
                ShowErrorDialog("修改分类失败");
            });
        }
    }

    //刪除数据
    function deleteData(btId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/bookType/deleteLibBookTypeInfo.do",
            data: {"btId":btId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("刪除数据成功！");
                    $('#dataList').treegrid('reload');
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
