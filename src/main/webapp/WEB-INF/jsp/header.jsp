<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url var="bootstrap_css"
	value="/webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" />
<c:url var="bootstrap_js"
	value="/webjars/bootstrap/4.6.0-1/js/bootstrap.min.js" />
<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js" />
<c:url var="css" value="/style.css" />
<%@ include file="/WEB-INF/jsp/links.jsp"%>

<html>
	<head>
	<meta charset="UTF-8">
	<title>Spring boot application</title>
	<link rel="stylesheet" href="${css}">
	<link rel="stylesheet" href="${bootstrap_css}">
	<script src="${jquery_js}"></script>
	<script src="${bootstrap_js}"></script>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp"%>