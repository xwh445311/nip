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
                    <header class="header"> <h4>我的快捷菜单</h4> </header>
                    <div class="mail-nav-body">
                        <div class="left">
                            <ul id="treeDemo" class="ztree"></ul>
                        </div>
                    </div>
                </aside>


            </div>
            <br/>
            <div class="alert alert-warning"><strong>注意!</strong> 最多只能选6个快捷菜单.</div>
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
            onCheck:clickTree
        },
        check:{
            enable: true,
            chkStyle: "checkbox",
            chkboxType: {"Y":"", "N":""}
        }
    };

    $(document).ready(function(){

        //初始化树
        $.fn.zTree.init($("#treeDemo"), setting, ${treeJson});

    });


    /**
     * 選種某個菜單結點，加載菜單信息
     */
    function clickTree(event, treeId, treeNode) {

        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var selNode = treeObj.getCheckedNodes(true).length;
        var url = "";
        var msg = "";

        if(selNode > 6){
            alert("只能設定6個快捷菜單!");
            return;
        }

        if(treeNode.checked)
        {
            //选中
            url = "<%=basePath%>/sysadmin/funcAdmin/addQuickLinkFunc.do";
            msg = "添加到快捷菜單成功！"
        }else{
            //取消
            url = "<%=basePath%>/sysadmin/funcAdmin/delQuickLinkFunc.do";
            msg = "取消快捷菜單成功！"
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: url,
            data: {"funcId":treeNode.id},
            dataType: "json",
            success: function(data)
            {
                if(data.success == true){
                    ShowSuccessDialog(msg);
                }else{
                    ShowErrorDialog("操作失敗！")
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request + "," + status + "," + err);
                ShowErrorDialog("操作失敗");
            }
        });

    }


</script>
</html>
