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
                        <h1>${action} agent</h1>
                    </div>
                </div>
                <div class="card-body">
                    <form:form method="POST" modelAttribute="agent" class="form-horizontal">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <label for="firstName" class="col-sm-7 control-label">First name:</label>
                            <div class="col-sm-7">
                                <form:input path="firstName" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="secondName" class="col-sm-7 control-label">Second name:</label>
                            <div class="col-sm-7">
                                <form:input path="secondName" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="patronymic" class="col-sm-7 control-label">Patronymic:</label>
                            <div class="col-sm-7">
                                <form:input path="patronymic" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-7 control-label">Address:</label>
                            <div class="col-sm-7">
                                <form:input path="address" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber" class="col-sm-7 control-label">Phone number:</label>
                            <div class="col-sm-7">
                                <form:input path="phoneNumber" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="branch_office_id" class="col-sm-7 control-label">Branch name:</label>
                            <div class="col-sm-7">
                                <form:select path="branch_office_id" multiple="false" class="form-control">
                                    <c:forEach var="branch" items="${listBranches}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${branch.id == agent.branch_office_id}">
                                                <option selected value="${branch.id}">${branch.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${branch.id}">${branch.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-7">
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