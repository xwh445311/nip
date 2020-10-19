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

    <style type="text/css">
        .BOOK_EMPTY{
            border-radius:5px;
            background-color: #B9DDA0;
            border:solid #FFFFFF 2px;
            color:#FFFFFF;
        }
        .BOOK_USE{
            border-radius:5px;
            background-color: #E4C9C2;
            border:solid #FFFFFF 2px;
            color:#FFFFFF;
        }
        .BOOK_FULL{
            border-radius:5px;
            background-color: #462B34;
            border:solid #FFFFFF 2px;
            color:#FFFFFF;
        }

        .tabStyle{
            width: 80%;
        }
        .hrstyle{
            height: 60px;
        }
    </style>

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
            <c:if test="${empty libShelfInfoList}">
                <div class="alert alert-warning fade in">
                    <button type="button" class="close close-sm" data-dismiss="alert">
                        <i class="fa fa-times"></i>
                    </button>
                    <strong>Warning!</strong> 还没有添加书架信息哦，请先增加书架信息.
                </div>
            </c:if>

            <c:if test="${not empty libShelfInfoList}">
                <c:forEach items="${libShelfInfoList}" var="item" varStatus="status">
                    <a name="${item.lsNo}"></a>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    书架：${item.lsNo}
                                    <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                            </span>
                                </div>
                                <div class="panel-body">
                                    <br/>
                                    <table class="tabStyle">
                                        <thead>
                                        <td width="5%" align="center"></td>
                                        <c:forEach begin="0" end="${item.lsColCnt-1}" varStatus="sta">
                                            <td align="center">
                                                ${sta.count}
                                            </td>
                                        </c:forEach>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${item.libShelfAddInfoList}" var="add" varStatus="varStat">
                                            <c:choose>
                                                <c:when test="${varStat.index % item.lsColCnt == 0}">
                                                    <tr class="hrstyle">
                                                    <td align="center">
                                                            ${add.siRow}
                                                    </td>
                                                    <td align="center" class="${add.siStatusCss}">
                                                            ${add.siCode}
                                                        <input type="hidden" id="${add.siCode}" name="bookAddr"/>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td align="center" class="${add.siStatusCss}">
                                                        ${add.siCode}
                                                            <input type="hidden" id="${add.siCode}" name="bookAddr"/>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>

                                            <c:if test="${varStat.count % item.lsColCnt == 0}">
                                        </tr>
                                            </c:if>

                                        </c:forEach>

                                        </tbody>
                                    </table>
                                    <br/>
                                    <button type="button" class="btn btn-primary" onclick="returnBack()">返回</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <br/>
                </c:forEach>
            </c:if>


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

    function returnBack(){
        window.location.href="<%=basePath%>/lib/gotoLibShelfInfoPage.do";
    }

</script>
</html>
