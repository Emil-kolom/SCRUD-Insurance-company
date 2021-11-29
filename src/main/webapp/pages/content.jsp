<%--
  Created by IntelliJ IDEA.
  User: emil
  Date: 28.11.2021
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/5.1.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/5.1.1/js/bootstrap.js"  />"></script>
    <title>CRUD operations</title>
</head>
</tab>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-10 offset-lg-1">
            <div class="card">
                <div class="card-header">
                    <div class="text-center">
                        <h1>${title}<small> table</small></h1>
                    </div>
                </div>
                <div class="alert alert-info" role="alert">
                    <a class="btn btn-primary" role="button" href="/${page}/pdfReport?view=pdfView" target="_blank">Download PDF report</a>
                    <a class="btn btn-primary" role="button" href="/${page}/xlsxReport.xlsx?view=excelView" target="_blank">Download Excel report</a>
                </div>
                <%--Таблицу отдельно в page_component--%>
                <c:import url="page_components/${page}_table.jsp"></c:import>
                <%-- --%>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/list.min.js"></script>
<script src="/resources/js/content-list.js"></script>
</body>
</html>