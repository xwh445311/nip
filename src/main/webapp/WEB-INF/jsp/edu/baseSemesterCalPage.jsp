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
                            title="学期日历"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/edu/semesterCal/listBaseSemesterCal.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'scTerm',checkbox:true" width="50"></th>
                            <th data-options="field:'scTermDesc'" width="50">学期</th>
                            <th data-options="field:'scStartDate'" width="50">开学日期</th>
                            <th data-options="field:'scEndDate'" width="50">放假日期</th>
                            <th data-options="field:'updUser'" width="50">最修改人</th>
                            <th data-options="field:'updDate',formatter:formatDate,width:'50'">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">
                <auth:ax srcId="role_addBaseSemesterCal">
                <a href="#myModal" data-toggle="modal" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newButton()">新增</a>
                </auth:ax>

                <auth:ax srcId="role_updateBaseSemesterCal">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteBaseSemesterCal">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">学期管理</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="userForm">
                                <input type="hidden" id="saveType" value=""/>
                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>
                                <div class="form-group">
                                    <label for="scTerm">学期ID</label>
                                    <input type="text" class="form-control" name="scTerm" id="scTerm" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="scYear"><span class="text-danger ">*</span>年度</label>
                                    <efs:selYear startYear="2018" yearLen="10" name="scYear" id="scYear" cls="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="scHalfYear"><span class="text-danger ">*</span>学期</label>
                                    <select class="form-control" name="scHalfYear" id="scHalfYear">
                                        <option value="">请选择</option>
                                        <option value="01">春</option>
                                        <option value="02">秋</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="scStartDate"><span class="text-danger ">*</span>开学日期</label>
                                    <input type="text" class="form-control" id="scStartDate" name="scStartDate" placeholder="开学日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                                </div>

                                <div class="form-group">
                                    <label for="scStartDate"><span class="text-danger ">*</span>放假日期</label>
                                    <input type="text" class="form-control" id="scEndDate" name="scEndDate" placeholder="放假日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
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
        InitValidate("userForm","errContent",{
            scYear:'required',
            scHalfYear:'required',
            scStartDate:"required",
            scEndDate:"required"
        },{

            scYear:'年度：必须选择',
            scHalfYear:'学期：必须选择',
            scStartDate:"开学日期：必须选择",
            scEndDate:"放假日期：必须选择"

        });


    });

    function formatDate(val,row){
        return ((row.updDate == null ) ? "" : row.updDate ) + " " + ((row.updTime == null ) ? "" : row.updTime );
    }


    function genTermId() {
        var year = $('#scYear').val();
        var term = $('#scHalfYear').val();

        var termStr = year + term;

        if(save)
        $('#uiId').val(termStr);
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


        ResetValidate();
        ClearForm("userForm");

        $('#myModal').modal('show');
        $('#userForm').form({
            onLoadSuccess:function (data) {
                initSelList(data);
            }
        }).form('load','<%=basePath %>/edu/semesterCal/getBaseSemesterCal.do?scTerm=' + row.scTerm);

    }

    function initSelList(data) {
        var scTerm = data.scTerm;
        $('#scYear').val(scTerm.substr(0,4));
        $('#scHalfYear').val(scTerm.substr(4));
    }

    /**
     * 刪除功能
     */
    function deleteButton() {

        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("請選擇要刪除的数据");
            return;
        }

        //检查是否已经删除
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/semesterCal/checkCurInTerm.do",
            data: {"scTerm":row.scTerm},
            dataType: "json",
            success: function(data)
            {
                if(data.data == 'Y'){
                    //未被使用，可以进行删除
                    showConfirm("您确认要删除吗？",function(){
                        deleteData(row.scTerm);
                    });

                }else {
                    ShowErrorDialog("历史学期日历不能删除！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("检查历史信息失败");
            }
        });
    }

    function saveData(){
        var riId = $('#scTerm').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/edu/semesterCal/addBaseSemesterCal.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("增加成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("增加失敗");
            });
        }else{
            //修改用戶信息
            url = "<%=basePath %>/edu/semesterCal/updateBaseSemesterCal.do";
            SubmitForm("userForm",url,function(data){
                ShowSuccessDialog("修改成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("修改失敗");
            });
        }
    }

    //刪除用戶
    function deleteData(scTerm){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/edu/semesterCal/deleteBaseSemesterCal.do",
            data: {"scTerm":scTerm},
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

</script>
</html>
