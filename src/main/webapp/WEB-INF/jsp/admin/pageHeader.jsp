<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="page-heading">
    <ul class="breadcrumb">
        <li><a href="<%=basePath%>/login/gotoMain.do?isMenu=Y"><i class="fa fa-home"></i> 我的首頁</a></li>
        <c:forEach items="${SESSION_KEY_PAGE_HEADER }" var="item" varStatus="stat">
            <c:if test="${!stat.last}">
                <li><a href="#">${item.muName}</a></li>
            </c:if>
            <c:if test="${stat.last}">
                <li class="active">${item.muName}</li>
            </c:if>
        </c:forEach>
    </ul>
</div>
