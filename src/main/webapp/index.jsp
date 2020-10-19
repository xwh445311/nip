<!DOCTYPE html>
<%@ include file="/common/common.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: xwh
  Date: 2017/6/22
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<body>
<%
    response.sendRedirect(basePath + "/login/gotoLogin.do");
%>
</body>
</html>