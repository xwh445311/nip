<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.ckeditor.CKEditorConfig,
				java.util.Map,
				java.util.HashMap" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://mfs/auth" prefix="auth" %>
<%@ taglib uri="http://xwh/efs" prefix="efs" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%
    String basePath = request.getContextPath();

    Map<String, String> attr = new HashMap<String, String>();
    attr.put("rows", "15");
    attr.put("cols", "500");
    CKEditorConfig settings = new CKEditorConfig();
    settings.addConfigValue("width", "1200");
    settings.addConfigValue("toolbar", "Full");

%>