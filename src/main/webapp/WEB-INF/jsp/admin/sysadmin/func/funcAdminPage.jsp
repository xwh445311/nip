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
            <div class="mail-box">
                <aside class="mail-nav mail-nav-bg-color">
                    <header class="header"> <h4>系統菜單</h4> </header>
                    <div class="mail-nav-body">
                        <div class="left">
                            <ul id="treeDemo" class="ztree"></ul>
                        </div>
                    </div>
                </aside>

                <section class="mail-box-info">
                    <header class="header">
                        <div class="btn-toolbar">
                            <h4 class="pull-left">
                                菜單詳情
                            </h4>
                        </div>

                    </header>
                    <section class="mail-list">
                        <div class="compose-mail">
                            <div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div>
                            <form method="post" id="funcForm">
                                <input type="hidden" name="muDbId" id="muDbId"/>
                                <input type="hidden" name="muParDbId" id="muParDbId"/>
                                <div class="form-group">
                                    <label for="muId" class="control-label"><span class="text-danger ">*</span>資源ID:</label>
                                    <input type="text" tabindex="1" name="muId" id="muId" class="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="muName" class="control-label"><span class="text-danger ">*</span>資源名稱:</label>
                                    <input type="text" tabindex="1" name="muName" id="muName" class="form-control" />
                                </div>

                                <div class="form-group">
                                    <label for="muUrl" class="control-label">URL路徑:</label>
                                    <input type="text" tabindex="1" name="muUrl" id="muUrl" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="muCss" class="control-label">圖標樣式:</label>
                                    <input type="text" tabindex="1" name="muCss" id="muCss" class="form-control">
                                    <a href="#myModal" data-toggle="modal" class="btn btn-success">
                                        選擇
                                    </a>
                                </div>

                                <div class="form-group" style="padding-bottom: 0px;padding-top: 5px;">
                                    <label class="control-label"><span class="text-danger ">*</span>資源狀態:</label>
                                    <div class="icheck ">
                                        <div class="square-green" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muStatus1" name="muStatus" value="1" checked >
                                                有效
                                            </div>
                                        </div>
                                        <div class="square-yellow" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muStatus0" name="muStatus" value="0">
                                                無效
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label"><span class="text-danger ">*</span>資源類型:</label>
                                    <div class="icheck " >
                                        <div class="square-green" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muTypes_M" name="muTypes" value="M" checked required>
                                                菜單
                                            </div>
                                        </div>
                                        <div class="square-yellow" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muTypes_U" name="muTypes" value="U" required>
                                                請求
                                            </div>
                                        </div>
                                        <div class="square-yellow" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muTypes_F" name="muTypes" value="F" required>
                                                纯功能
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label">是否為快捷菜單:</label>
                                    <div class="icheck " >
                                        <div class="square-green" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muQuickLink_1" name="muQuickLink" value="1">
                                                是
                                            </div>
                                        </div>
                                        <div class="square-yellow" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muQuickLink_0" name="muQuickLink" value="0" checked>
                                                否
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="muUrl" class="control-label">快捷菜单URL路徑:</label>
                                    <input type="text" tabindex="1" name="muQuickUrl" id="muQuickUrl" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="muUrl" class="control-label">快捷菜单定位ID:</label>
                                    <input type="text" tabindex="1" name="muQuickPosId" id="muQuickPosId" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label class="control-label">是否为超级用户:</label>
                                    <div class="icheck " >
                                        <div class="square-green" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muIsSuper_1" name="muIsSuper" value="1">
                                                是
                                            </div>
                                        </div>
                                        <div class="square-yellow" style="padding-left: 15px;">
                                            <div class="radio ">
                                                <input type="radio" id="muIsSuper_0" name="muIsSuper" value="0" checked>
                                                否
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-primary" type="button" onclick="addMenu()" >新增</button>
                                        <button class="btn btn-primary" type="button" onclick="updMenu()" >修改</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </section>
                </section>
            </div>
        </div>

        <!-- ICON选择对话框 -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">功能圖標</h4>
                    </div>
                    <div class="modal-body">
                        <%@ include file="funcIcon.jsp" %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">確認</button>
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
        edit: {
            enable: true,
            showRemoveBtn: true,
            showRenameBtn: false,
            drag:{
                isMove:true,
                prev:true,
                next:true,
                inner:true
            }
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onDrop: onDrop,
            onClick:clickTree,
            onRemove:deleteMenuNode
        }
    };

    $(document).ready(function(){

        //初始化校验框架
        InitValidate("funcForm","errContent",{
            muId:{
                required:true,
                remote:{
                    url:"<%=basePath%>/sysadmin/funcAdmin/checkFuncIdExists.do",
                    type:"post",
                    data:{
                        muId:function(){
                            return $('#muId').val();
                        }
                    }
                }
            },
            muName:"required",
            muStatus:"required",
            muTypes:"required"
        },{
            muId:{
                required:"資源ID:必須輸入",
                remote:"資源ID：已經存在"
            },
            muName:"資源名稱:必須輸入",
            muStatus:"資源狀態:必須輸入",
            muTypes:"資源類型:必須輸入"
        });


        //初始化树
        $.fn.zTree.init($("#treeDemo"), setting, ${treeJson});

    });


    function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy){
        var obj = $.fn.zTree.getZTreeObj(treeId).getNodes();
        var nodeP = targetNode.getParentNode();
        var child;
        if(nodeP){
            child = nodeP.children;
        } else{
            child = obj;
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/funcAdmin/updateFuncOrders.do",
            data: {"resFuncId":treeNodes[0].id,"newParentId":targetNode.pId,"targetId":targetNode.id,"moveType": moveType,"newTreeJson": JSON.stringify(child)},
            dataType: "json",
            success: function(data)
            {
                if(data.success == true){
                    ShowSuccessDialog("菜单更新成功");
                    freshMenu();
                }else{
                    ShowErrorDialog("菜单更新失败")
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request + "," + status + "," + err);
                ShowErrorDialog("菜单更新失败");
            }
        });

        return true;
    }

    /**
     * 選種某個菜單結點，加載菜單信息
     */
    function clickTree(event, treeId, treeNode, clickFlag) {

        if(treeNode.id == '0'){
            //根菜單
            ClearForm('funcForm');

            $('#muDbId').val('0');
            $('#muParDbId').val('0');
            $('#muName').val('根菜單');

        }
        else{
            $('#funcForm').form('load','<%=basePath%>/sysadmin/funcAdmin/getTsFuncIfno.do?muDbId=' + treeNode.id + '&timeStamp' + (new Date()).valueOf());
        }

    }

    function deleteMenuNode(event, treeId, treeNode){
        showConfirm("您確認刪除該菜單及其子菜單嗎？",function(){
            //提交数据
            var muDbId = treeNode.id;
            $.ajax({
                async: false,
                ifModified:true,
                type: "POST",
                url: "<%=basePath%>/sysadmin/funcAdmin/deleteTsFuncIfno.do?muDbId=" + muDbId,
                dataType: "json",
                success: function(data)
                {
                    if(data.success == true){
                        ShowSuccessDialog("刪除菜單成功");
                    }else{
                        ShowErrorDialog("刪除菜單失敗!" + data.message );
                    }

                    freshMenu();
                },
                error: function(request, status, err)
                {
                    ShowErrorDialog(request + "," + status + "," + err);
                    ShowErrorDialog("刪除菜單失敗!");
                }
            });
        });
    }

    /**
     * 新增菜單
     */
    function addMenu(){

        var dbId = $('#muDbId').val();
        var parDbId = $('#muParDbId').val();
        var url = '<%=basePath%>/sysadmin/funcAdmin/addTsFuncIfno.do';

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        //对于新增菜单，把父ID设置为当前节点ID
        $('#muParDbId').val(dbId);
        if(parDbId == ''){
            ShowWarningDialog("請先選擇父級菜單");
            return;
        }

        //校驗提交框架


        SubmitForm('funcForm',url,function (data) {
            freshMenu();
        });
    }

    /**
     * 修改菜單信息
     */
    function updMenu(){
        var url = '<%=basePath%>/sysadmin/funcAdmin/updateTsFuncIfno.do';

        SubmitForm('funcForm',url,function (data) {
            freshMenu();
            ShowSuccessDialog("菜單更新成功");
        });
    }

    //刷新菜单
    function freshMenu(){
        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/funcAdmin/getFuncResource.do",
            dataType: "json",
            success: function(data)
            {
                if(data.success == true){
                    $.fn.zTree.init($("#treeDemo"), setting, eval('('+data.data+')'));
                }else{
                    ShowErrorDialog("获取资源树JSON失败");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request + "," + status + "," + err);
                ShowErrorDialog("获取资源树JSON失败");
            }
        });
    }


</script>
</html>
