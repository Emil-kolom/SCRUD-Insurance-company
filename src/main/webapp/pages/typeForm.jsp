<%--
  Created by IntelliJ IDEA.
  User: emil
  Date: 28.11.2021
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-6 offset-lg-3">
            <div class="card">
                <div class="card-header">
                    <div class="text-center">
                        <h1>${action} type of insurance</h1>
                    </div>
                </div>
                <div class="card-body">
                    <form:form method="POST" modelAttribute="type" class="form-horizontal">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Name:</label>
                            <div class="col-sm-4">
                                <form:input path="name" class="form-control" />
                            </div>
                        <div class="form-group">
                            <label for="agent_percentage" class="col-sm-3 control-label">Agent percentage:</label>
                            <div class="col-sm-4">
                                <form:input path="agent_percentage" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-3">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>