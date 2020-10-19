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
        .book_label{
            font-weight: bold;
            text-align: right;
            padding-right: 1px;
        }

        .book_cont{
            padding-left: 1px;
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
            <div class="row">
                <div class="col-md-12">
                    <div class="panel" >
                        <div class="panel-body">
                                <div class="col-md-3">
                                    <div class="blog-img-sm" style="padding-left: 0px;">
                                        <img src="${libInSendInfo.showImgUrl}" alt="暂无图片">
                                    </div>
                                    <br/>
                                    <div style="text-align: center">
                                        <button type="button" class="btn btn-primary" onclick="returnBack()">返回</button>
                                        <br/>
                                    </div>
                                </div>

                                <div class="col-md-9">
                                    <h1 class="" style="color: #65CEA7; ">
                                        ${libInSendInfo.biName}
                                    </h1>
                                    <p class="auth-row">
                                        图书编号：${libInSendInfo.isBookCode}
                                    </p>
                                    <div class="row">
                                        <div class="col-md-2 book_label">图书名称：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.biName}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">作者：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.biAuth}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">出版社：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.biPress}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">价格：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.biPrice}</div>
                                    </div>

                                    <br/>

                                    <div class="row">
                                        <div class="col-md-2 book_label">借阅状态：</div>
                                        <div class="col-md-10 book_cont">${applicationScope.LIB_SEND_BOOK_STATUS[libInSendInfo.isSendStatus]}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">借阅时间：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.isStartDate } ${libInSendInfo.isStartTime}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">借阅处理人：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.isSendHandler}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">是否超期：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.isOverStatus == "1" ? "是" : "否"}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">超期时长：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.isOverdueLong}</div>
                                    </div>

                                    <br/>
                                    <div class="row">
                                        <div class="col-md-2 book_label">还书日期：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.isBackDate } ${libInSendInfo.isBackTime}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">还书处理人：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.isBackHandler}</div>
                                    </div>

                                    <br>
                                    <div class="row">
                                        <div class="col-md-2 book_label">挂失日期：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blRegDate} ${libInSendInfo.biRegTime}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">挂失处理人：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blRegUser}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">挂失备注：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.biRegCommon}</div>
                                    </div>

                                    <br>
                                    <div class="row">
                                        <div class="col-md-2 book_label">赔偿日期：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blCompDate} ${libInSendInfo.blCompTime}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 book_label">赔偿处理人：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blCompHandler}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 book_label">赔偿方式：</div>
                                        <div class="col-md-10 book_cont">${applicationScope.LIB_COMP_BOOK_TYPE[libInSendInfo.biCompType]}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 book_label">计划赔偿金额：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.biPlanCompAmt}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 book_label">实际赔偿金额：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blCompAmt}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 book_label">赔偿新书编号：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blCompBookCode}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 book_label">赔偿备注：</div>
                                        <div class="col-md-10 book_cont">${libInSendInfo.blCommon}</div>
                                    </div>
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

    function returnBack(){
        window.location.href='<%=basePath %>/lib/booksend/gotoUserAllSendInfo.do';
    }

</script>
</html>
