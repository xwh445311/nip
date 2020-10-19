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
                                    学期：
                                    <efs:selSems name="scTerm" id="scTermQuery" cls="form-control" />
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
                            title="班级信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/classes/listBaseSchClassInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'scId',checkbox:true" width="50"></th>
                            <th data-options="field:'scTermDesc'" width="50">学期</th>
                            <th data-options="field:'scClassName'" width="50">班级</th>
                            <th data-options="field:'scLeaderName'" width="50">班主任</th>
                            <th data-options="field:'updDate',formatter:formatDate" width="50">最后修改日期</th>
                            <th data-options="field:'updUserName'" width="50">修改人</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addBaseSchClassInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">批量增加</a>
                </auth:ax>

                <auth:ax srcId="role_addBaseSchClassInfo">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addSingleClass()">单个增加</a>
                </auth:ax>

                <auth:ax srcId="role_updateBaseSchClassInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteBaseSchClassInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域-批量增加班级 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalBatchAdd" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">产生班级信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="batchAddForm">
                                <div class="form-group">
                                    <label for="scTerm"><span class="text-danger ">*</span>学期</label>
                                    <efs:selSems name="scTerm" id="scTerm" cls="form-control" hasClasses="N"/>
                                </div>
                                <div class="form-group">
                                    <label for="gradeCnt"><span class="text-danger ">*</span>年级数</label>
                                    <input class="form-control" type="text" name="gradeCnt" id="gradeCnt">
                                </div>
                                <div class="form-group">
                                    <label for="clsCnt"><span class="text-danger ">*</span>每个年级班数</label>
                                    <input class="form-control" type="text" name="clsCnt" id="clsCnt">
                                </div>

                                <div class="form-group">
                                    <br/><button type="button" class="btn btn-primary" onclick="batchAddCls()">产生</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">班级管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="userForm">
                                <input type="hidden" name="scId" id="scId" value=""/>
                                <input type="hidden" name="scTerm" id="scTermCls" value=""/>
                                <input type="hidden" name="scClassCode" id="scClassCode" value=""/>
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
                                <div class="form-group">
                                    <label for="scTermDesc">学期</label>
                                    <input type="text" class="form-control" name="scTermDesc" id="scTermDesc" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="scClassName">班级</label>
                                    <input type="text" class="form-control" name="scClassName" id="scClassName" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="scLeader"><span class="text-danger ">*</span>班主任</label>
                                    <select class="form-control" name="scLeader" id="scLeader">
                                        <option value="">请选择</option>
                                        <c:forEach items="${teacherList}" var="item">
                                            <option value="${item.uiId}">${item.uiName}(${item.uiShortName})</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                <br/><button type="button" class="btn btn-primary" onclick="saveData()">提交</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <!-- 新增表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">新增班级</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="addClassForm">

                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent2" style="display: none"></div><br/>
                                <div class="form-group">
                                    <label for="scTermDesc"><span class="text-danger ">*</span>学期</label>
                                    <efs:selSems name="scTerm" id="scTermAdd" cls="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="scGradeAdd"><span class="text-danger ">*</span>年级</label>
                                    <select name="scGrade" id="scGradeAdd" class="form-control">
                                        <option value="">请选择</option>
                                        <c:forEach begin="1" end="6" varStatus="stat">
                                            <option value="${stat.count}">${stat.count}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="scClsAdd"><span class="text-danger ">*</span>班级</label>
                                    <select name="scCls" id="scClsAdd" class="form-control">
                                        <option value="">请选择</option>
                                        <c:forEach begin="1" end="8" varStatus="stat">
                                            <option value="${stat.count}">${stat.count}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="scLeader"><span class="text-danger ">*</span>班主任</label>
                                    <select class="form-control" name="scLeader" id="scLeaderAdd">
                                        <option value="">请选择</option>
                                        <c:forEach items="${teacherList}" var="item">
                                            <option value="${item.uiId}">${item.uiName}(${item.uiShortName})</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <br/><button type="button" class="btn btn-primary" onclick="saveSingleClass()">提交</button>
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
        InitValidate("userForm","errContent",{
            scLeader:{
                required:true,
                remote:{
                    url:"<%=basePath%>/edu/classes/checkClassLeaderExist.do",
                    type:"post",
                    data:{
                        scTerm:function(){
                            return $('#scTermCls').val();
                        },
                        scClassCode:function(){
                            return $('#scClassCode').val();
                        },
                        scLeader:function(){
                            return $('#scLeader').val();
                        }
                    }
                }
            }
        },{

            scLeader:{
                required:"班主任：必须输入",
                remote:"班主任：已经是其它班的班主任"
            }
        });


        //初始化单个校验框架
        InitValidate("addClassForm","errContent2",{

            scTerm:'required',
            scGrade:'required',
            scCls:'required',
            scLeader:'required'
        },{
            scTerm:'学期：必须选择',
            scGrade:'年级：必须选择',
            scCls:'班级：必须选择',
            scLeader:'班主任：必须选择'
        });
    });

    function formatDate(val,row){
        return ((row.updDate == null ) ? "" : row.updDate ) + " " + ((row.updTime == null ) ? "" : row.updTime );
    }

    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            scTerm:$("#scTermQuery").val()
        });
    }

    function newButton() {

        ClearForm("batchAddForm");

        $('#myModalBatchAdd').modal('show');
    }

    /*
    批量添加班级信息
    */
    function batchAddCls(){
        var scTerm = $('#scTerm').val();
        var gradeCnt = $('#gradeCnt').val();
        var clsCnt = $('#clsCnt').val();

        var essMsg ='';
        errMsg = checkEmpty("学期",scTerm);
        errMsg += checkEmpty("年级数量",gradeCnt);
        errMsg += checkDigit("年级数量",gradeCnt);
        errMsg += checkEmpty("每个年级班数",clsCnt);
        errMsg += checkDigit("每个年级班数",clsCnt);

        if(errMsg.length > 0){
            ShowErrorDialog(errMsg);
            return;
        }

        url = "<%=basePath %>/edu/classes/addBaseSchClassInfo.do";
        SubmitForm("batchAddForm",url,function(data){
            ShowSuccessDialog("增加成功");
            $('#myModalBatchAdd').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("增加失败");
        });
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
        ClearForm("userForm");

        $('#myModal').modal('show');
        $('#userForm').form('load','<%=basePath %>/edu/classes/getBaseSchClassInfo.do?scId=' + row.scId);
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
        showConfirm("您确认要删除吗？",function(){

            $.ajax({
                async: false,
                ifModified:true,
                type: "POST",
                url: "<%=basePath%>/edu/classes/checkCanDelClass.do",
                data: {"scId":row.scId},
                dataType: "json",
                success: function(data)
                {
                    if(data.success){
                        //可以进行删除
                        deleteData(row.scId);

                    }else {
                        ShowErrorDialog("历史学期班级不能删除！");
                    }
                },
                error: function(request, status, err)
                {
                    ShowErrorDialog(request.status + "," + request.responseText);
                    ShowErrorDialog("检查历史信息失败");
                }
            });


        });

    }

    function saveData(){
        var riId = $('#scId').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        //修改用戶信息
        url = "<%=basePath %>/edu/classes/updateBaseSchClassInfo.do";
        SubmitForm("userForm",url,function(data){
            ShowSuccessDialog("修改成功");
            $('#myModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("修改失敗");
        });
    }

    //刪除用戶
    function deleteData(scId){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/classes/deleteBaseSchClassInfo.do",
            data: {"scId":scId},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    ShowSuccessDialog("刪除记录成功！");
                    $('#dataList').datagrid('reload');
                }else{
                    ShowErrorDialog("刪除记录失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("刪除记录失败");
            }
        });
    }

    function addSingleClass(){
        ResetValidate();
        ClearForm("addClassForm");
        $('#addModal').modal('show');
    }

    function saveSingleClass(){
        //數據校驗
        if(!Vlaidate()){
            return;
        }

        //修改用戶信息
        url = "<%=basePath %>/edu/classes/addSingleClass.do";
        SubmitForm("addClassForm",url,function(data){
            ShowSuccessDialog("添加成功");
            $('#addModal').modal('hide');
            $('#dataList').datagrid('reload');
        },function () {
            ShowErrorDialog("添加失败");
        });
    }

</script>
</html>
