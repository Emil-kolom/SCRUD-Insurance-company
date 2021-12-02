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
                        <h1>${action} contract</h1>
                    </div>
                </div>
                <div class="card-body">
                    <form:form method="POST" modelAttribute="contract" class="form-horizontal">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <label for="sum_insured" class="col-sm-6 control-label">Sum insured:</label>
                            <div class="col-sm-3">
                                <form:input path="sum_insured" class="form-control" type="number" min="0" max="2000000000"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="insurance_type" class="col-sm-6 control-label">Insurance type:</label>
                            <div class="col-sm-3">
                                <form:select path="insurance_type" multiple="false" class="form-control">
                                    <c:forEach var="insurance_type_model" items="${listType}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${insurance_type_model.id == contract.insurance_type}">
                                                <option selected value="${insurance_type_model.id}">${insurance_type_model.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${insurance_type_model.id}">${insurance_type_model.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tariff_rate" class="col-sm-6 control-label">Tariff rate:</label>
                            <div class="col-sm-3">
                                <form:input path="tariff_rate" class="form-control" type="number" min="0" max="99.99" step="0.01"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="agent_id" class="col-sm-10 control-label">Agent name:</label>
                            <div class="col-sm-6">
                                <form:select path="agent_id" multiple="false" class="form-control">
                                    <c:forEach var="agent" items="${listAgent}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${agent.id == contract.agent_id}">
                                                <option selected value="${agent.id}">${agent.firstName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${agent.id}">${agent.firstName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6">
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
