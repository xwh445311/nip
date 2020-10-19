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
                                        <img src="${booksInfo.showImgUrl}" alt="暂无图片">
                                    </div>
                                    <br/>
                                    <div style="text-align: center">
                                        <button type="button" class="btn btn-primary" onclick="returnBack()">返回</button>
                                        <br/>
                                    </div>
                                </div>

                                <div class="col-md-9">
                                    <h1 class="" style="color: #65CEA7; ">
                                        <c:if test="${not empty booksInfo.biEbookUrl}">
                                            <a href="#">${booksInfo.biName}</a>
                                        </c:if>

                                        <c:if test="${empty booksInfo.biEbookUrl}">
                                            ${booksInfo.biName}
                                        </c:if>
                                        </h1>
                                    <p class="auth-row">
                                        条码编号：${booksInfo.biCode} | ISBN编号：${booksInfo.biIsbn}
                                    </p>
                                    <div class="row">
                                        <div class="col-md-2 book_label">原著名称：</div>
                                        <div class="col-md-4 book_cont">${empty booksInfo.biOriName ? booksInfo.biName : booksInfo.biOriName}</div>

                                        <div class="col-md-2 book_label">图书状态：</div>
                                        <div class="col-md-1 book_cont">${booksInfo.biStatusVal}</div>

                                        <c:if test="${flag == 'ADMIN' and booksInfo.biStatus == '01'}">
                                            <div class="col-md-2 book_label">借阅人：</div>
                                            <div class="col-md-1 book_cont"><a href="javascript:void(0)" onclick="showUserSend('${booksInfo.sendUserId}')">${booksInfo.sendUserName}</a></div>
                                        </c:if>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">作者：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biAuth}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">翻译：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biTranslater}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">图书分类：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biType}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">书架位置：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biAddr}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">出版社：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biPress}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">出版日期：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biPublishDate}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">价格：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biPrice}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">页数：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biPageCount}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">开本：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biBookSize}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">上架日期：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biInDate}</div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">电子图书：</div>
                                        <div class="col-md-10 book_cont">
                                            <c:if test="${not empty booksInfo.biEbookUrl}">
                                                <a href="">${booksInfo.biEbookUrl}</a>
                                            </c:if>

                                            <c:if test="${empty booksInfo.biEbookUrl}">
                                                无
                                            </c:if>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2 book_label">作者信息：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biAuthInfo}</div>
                                    </div>

                                    <br/>

                                    <div class="row">
                                        <div class="col-md-2 book_label">图书简介：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biBookBrief}</div>
                                    </div>

                                    <br/>
                                    <div class="row">
                                        <div class="col-md-2 book_label">目录浏览：</div>
                                        <div class="col-md-10 book_cont">${booksInfo.biBookCata}</div>
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
        var flag = '${flag}';

        if(flag == 'ADMIN'){
            window.location.href='<%=basePath %>/lib/bookAdmin/gotoAddBookPage.do?isBack=Y'
        }else{
            window.location.href='<%=basePath %>/lib/bookAdmin/gotoListBookPage.do?isBack=Y'
        }
    }

    function showUserSend(userId) {
        window.location.href='<%=basePath %>/lib/booksend/gotoUserAllSendInfo.do?userId=' + userId + '&bookCode=${booksInfo.biCode}&flag=BOOK_DETAIL';
    }

</script>
</html>
