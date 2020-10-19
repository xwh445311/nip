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
                            入库批次号：【${batchNum}】
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                             </span>
                        </header>
                        <div class="panel-body" style="padding: 5px;">
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    <input type="text" class="form-control input-lg m-bot15" name="biIsbnStr" id="biIsbnStr" placeholder="ISBN编号" value="${sessionScope.libBooksInfoForm.biIsbn}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control input-lg m-bot15" name="biCodeStr" id="biCodeStr" placeholder="图书编号" value="${sessionScope.libBooksInfoForm.biCode}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biNameStr" id="biNameStr" placeholder="图书名称" value="${sessionScope.libBooksInfoForm.biName}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="biInBatchNoStr" id="biInBatchNoStr" placeholder="上传批次号" value="${sessionScope.libBooksInfoForm.biInBatchNo}">
                                </div>
                                <div class="form-group">
                                    图书类别：
                                    <select class="easyui-combobox" name="biTypeStr" id="biTypeStr">
                                        <option value="">请选择</option>
                                        <c:forEach items="${bookTypeInfoList}" var="item">
                                            <option value="${item.btName}">${item.btName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    图书状态：
                                    <select class="form-control" name="biStatusStr" id="biStatusStr">
                                        <option value="">请选择</option>
                                        <c:forEach items="${applicationScope.LIB_BOOK_STATUS}" var="item">
                                            <option value="${item.key}">${item.value}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                &nbsp;

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
                            title="图书入库/查询信息"
                            rownumbers="true"
                            fitColumns="true"
                            toolbar="#toolbar"
                            pagination="true"
                            pageSize="20"
                            singleSelect="true"
                            collapsible="true"
                            url="<%=basePath %>/lib/bookAdmin/listLibBooksInfo.do"
                            method="post">
                        <thead>
                        <tr>
                            <th data-options="field:'biCode',width:'6%'">图书编号</th>
                            <th data-options="field:'biIsbn',width:'8%'">ISBN编号</th>
                            <th data-options="field:'biName',width:'30%'">图书名称</th>
                            <th data-options="field:'biPress',width:'16%'">出版社</th>
                            <th data-options="field:'biAuth',width:'10%'">作者</th>
                            <th data-options="field:'biInUser',width:'5%'">入库人</th>
                            <th data-options="field:'biInDate',width:'6%'">入库日期</th>
                            <th data-options="field:'biAddr',width:'5%'">书架地址</th>
                            <th data-options="field:'biInBatchNo',width:'10%'">入库批次</th>
                            <th data-options="field:'biStatusVal',formatter:formatState,width:'5%'">图书状态</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>

            <div id="toolbar">

                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="detailButton()">查看</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print" plain="true" onclick="printBarCode()">打印条码</a>
                <auth:ax srcId="role_updateLibBooksInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editButton()">修改</a>
                </auth:ax>

                <auth:ax srcId="role_deleteLibBooksInfo">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteButton()">刪除</a>
                </auth:ax>
            </div>

            <!-- Form表单区域 -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog" style="width: 60%;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">图书信息</h4>
                        </div>
                        <div class="modal-body">

                            <form role="form" id="bookForm" >
                                <input type="hidden" name="biInBatchNo" id="biInBatchNo" />
                                <input type="hidden" name="biRemSmImg" id="biRemSmImg" />
                                <input type="hidden" name="biRemLgImg" id="biRemLgImg" />
                                <input type="hidden" name="biLocSmImg" id="biLocSmImg" />
                                <input type="hidden" name="biLocLgImg" id="biLocLgImg" />
                                <input type="hidden" name="biEbookUrl" id="biEbookUrl" />

                                <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                                <br/>

                                <div class="row">
                                    <div class="col-md-4 form-group">
                                        <label for="biCode">图书编码</label>
                                        <input type="text" class="form-control" name="biCode" id="biCode" value="" readonly>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="biIsbn"><span class="text-danger ">*</span>ISBN码</label>
                                        <input type="text" class="form-control" id="biIsbn" name="biIsbn" placeholder="ISBN码" />
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="repeatCont">重复本数</label>
                                        <input type="text" class="form-control" id="repeatCont" name="repeatCont" placeholder="重复本数" />
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label class="control-label"><span class="text-danger ">*</span>图书名称</label>
                                        <input type="text" class="form-control" id="biName" name="biName" placeholder="图书名称" />
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label class="control-label">图书原名</label>
                                        <input type="text" class="form-control" id="biOriName" name="biOriName" placeholder="图书原名" />
                                    </div>

                                    <div class="col-md-4 form-group">
                                        <label for="biAuth"><span class="text-danger ">*</span>原作者</label>
                                        <input type="text" class="form-control" id="biAuth" name="biAuth" placeholder="原作者" />
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="biTranslater">翻译者</label>
                                        <input type="text" class="form-control" id="biTranslater" name="biTranslater" placeholder="翻译者" />
                                    </div>

                                    <div class="col-md-4 form-group">
                                        <label for="biPublishDate"><span class="text-danger ">*</span>出版日期</label>
                                        <input type="text" class="form-control" id="biPublishDate" name="biPublishDate" placeholder="出版日期" onclick="WdatePicker({dateFmt:'yyyy年M月'})" readonly="readonly"/>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="biPress"><span class="text-danger ">*</span>出版社</label><br/>
                                        <select class="easyui-combobox" name="biPress" id="biPress">
                                            <option value="">请选择</option>
                                            <c:forEach items="${selectBeanList}" var="item">
                                                <option value="${item.key}">${item.value}</option>
                                            </c:forEach>
                                        </select>

                                    </div>

                                    <div class="col-md-4 form-group">
                                        <label for="biType"><span class="text-danger ">*</span>图书类别</label><br/>
                                        <select class="easyui-combobox" name="biType" id="biType">
                                            <option value="">请选择</option>
                                            <c:forEach items="${bookTypeInfoList}" var="item">
                                                <option value="${item.btName}">${item.btName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="biPrice"><span class="text-danger ">*</span>图书单价</label>
                                        <input type="text" class="form-control" id="biPrice" name="biPrice" placeholder="图书单价" />
                                    </div>

                                    <div class="col-md-4 form-group">
                                        <label for="biPageCount"><span class="text-danger ">*</span>页数</label>
                                        <input type="text" class="form-control" id="biPageCount" name="biPageCount" placeholder="页数" />
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="biBookSize">装订开本</label>
                                        <input type="text" class="form-control" id="biBookSize" name="biBookSize" placeholder="装订开本" />
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label for="biAddr"><span class="text-danger ">*</span>上架位置</label><br/>
                                        <select class="form-control" name="biAddr" id="biAddr" >
                                            <option value="">请选择</option>
                                            <c:forEach items="${libShelfAddInfoList}" var="item">
                                                <option value="${item.siCode}">${item.siCode}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <label for="biBookBrief">内容简价</label>
                                        <textarea rows="6" class="form-control" id="biBookBrief" name="biBookBrief"></textarea>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label for="biBookCata">目录</label>
                                        <textarea rows="6" class="form-control" id="biBookCata" name="biBookCata"></textarea>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label for="biAuthInfo">作者信息</label>
                                        <textarea rows="6" class="form-control" id="biAuthInfo" name="biAuthInfo"></textarea>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <label for="biAuthInfo">打印条码</label>
                                        <input type="checkbox" id="printBar" value="1">
                                    </div>
                                </div>




                                <div class="form-group"  style="text-align: center">
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
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
    <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>



<%@ include file="/common/script.jsp" %>
<script type="text/javascript">

    //初始化条码打印打印控件
    var ws;


    var bomBatchNo = '${batchNum}';
    $(document).ready(function(){

        //初始化DATAGRID
        initDataGridPage("dataList");

        //初始化出版下拉框
        //$('.combobox').combobox();


        //注册ISBN回车事件
        $('#biIsbnStr').bind('keypress',function (event) {
            if(event.keyCode  == '13'){
                openForAddBook();
            }
        });

        readyInputISBN();

        //初始化校验框架
        InitValidate("bookForm","errContent",{
            biIsbn:{
                required:true,
                digits:15
            },
            biName:'required',
            biPublishDate:'required',
            biAuth:'required',
            biType:'required',
            biPress:'required',
            biPrice:'required',
            biPageCount:{
                required:true,
                digits:15
            },
            biAddr:'required'


        },{
            biIsbn:{
                required:"ISBN码：必须输入",
                digits:"ISBN码：必须为数字"
            },
            biName:"图书名称：必须输入",
            biPublishDate:'出版日期：必须选择',
            biAuth:'原作者：必须输入',
            biType:'图书类别：必须选择',
            biPress:'出版社：必须选择',
            biPrice:'图书单价：必须输入',
            biPageCount:{
                required:'页数：必须输入',
                digits:'页数：必须为数字'
            },
            biAddr:'上架位置：必须选择'
        });

        //初始化打印插件
        argonxConnect();

    });


    function formatState(val,row)
    {
        if(val == '借出')
        {
            return "<span style='color: orange'>"+val+"</span>"
        }
        else if(val == '在库')
        {
            return "<span style='color: green'>"+val+"</span>"
        }
        else if(val == '挂失')
        {
            return "<span style='color: red'>"+val+"</span>"
        }
        else
        {
            return val;
        }
    }


    function queryDataGrid(){
        $("#dataList").datagrid('load',{
            biInBatchNo:$("#biInBatchNoStr").val(),
            biName:$("#biNameStr").val(),
            biCode:$("#biCodeStr").val(),
            biIsbn:$("#biIsbnStr").val(),
            biType:$('#biTypeStr').val(),
            biStatus:$('#biStatusStr').val()

        });
    }

    function reloadBatchBook() {
        $("#dataList").datagrid('load',{
            biInBatchNo:bomBatchNo
        });
    }

    function resetForm(){
        ClearForm("bookForm");
        $('#biInBatchNo').val(bomBatchNo);
        $("#printBar").attr("checked", 'checked');
    }

    function newButton() {
        ResetValidate();
        resetForm("bookForm");
    }


    /**
     * 扫描枪添加信息
     */
    function openForAddBook() {
        ResetValidate();
        resetForm("bookForm");

        var isbnCode = $('#biIsbnStr').val();
        if(isbnCode == ''){
            ShowWarningDialog("请扫描ISBN码或者输入ISBN码后按回车键");
            return;
        }

        $('#myModal').modal('show');
        $('#bookForm').form('load','<%=basePath %>/lib/bookAdmin/getBooksInfoFromISBN.do?biIsbn=' + isbnCode+'&biInBatchNo=' + bomBatchNo);
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
        resetForm("bookForm");

        $('#myModal').modal('show');

        $('#bookForm').form('load','<%=basePath %>/lib/bookAdmin/getLibBooksInfo.do?biCode=' + row.biCode);
    }

    /**
     * 查看按钮
     */
    function detailButton() {
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要查看的行");
            return;
        }

        window.location.href='<%=basePath %>/lib/bookAdmin/gotoShowBookPage.do?biCode=' + row.biCode + '&flag=ADMIN';
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

        showConfirm("您确认要删除该图书吗？",function(){

            $.ajax({
                async: false,
                ifModified:true,
                type: "POST",
                url: "<%=basePath%>/lib/bookAdmin/checkBookDelete.do",
                data: {"biCode":row.biCode},
                dataType: "json",
                success: function(data)
                {
                    if(data.data == "Y"){
                        deleteData(row.biCode);
                    }else{
                        ShowErrorDialog("此图书已经借出或者挂失，不能删除！");
                    }
                },
                error: function(request, status, err)
                {
                    ShowErrorDialog(request.status + "," + request.responseText);
                    ShowErrorDialog("检查图书信息失败");
                }
            });




        });

    }

    function saveData(){
        var riId = $('#biCode').val();
        var url = '';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        if(riId == ''){
            //新增
            url = "<%=basePath %>/lib/bookAdmin/addLibBooksInfo.do";
            SubmitForm("bookForm",url,function(data){
                ShowSuccessDialog("新增图书成功");

                //批量打印标签
                batchPrirntBarCode(data);

                readyInputISBN();
                $('#myModal').modal('hide');
                reloadBatchBook();
            },function () {
                ShowErrorDialog("新增图书失败");
            });
        }else{
            //修改角色信息
            url = "<%=basePath %>/lib/bookAdmin/updateLibBooksInfo.do";
            SubmitForm("bookForm",url,function(data){
                ShowSuccessDialog("修改图书信息成功");
                $('#myModal').modal('hide');
                $('#dataList').datagrid('reload');
            },function () {
                ShowErrorDialog("修改图书信息失败");
            });
        }
    }

    //刪除数据
    function deleteData(biCode){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/lib/bookAdmin/deleteLibBooksInfo.do",
            data: {"biCode":biCode},
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


    function readyInputISBN(){
        $('#biIsbnStr').val('');
        $('#biIsbnStr').focus();
    }

    function printBarCode(){
        var row = $("#dataList").datagrid('getSelected');
        if(!row)
        {
            ShowWarningDialog("请选择要打印的图书");
            return;
        }

        printBookBarCode(row.biCode);
    }

    function batchPrirntBarCode(barStr) {
        if($('#printBar').is(':checked')) {
            if(barStr.length > 0){
                $.each(barStr,function (index, val) {
                    printBookBarCode(val);
                })
            }
        }
    }

    function printBookBarCode(biCode) {
        printArgonxBarCodeAndText(biCode,biCode);
    }


</script>
</html>
