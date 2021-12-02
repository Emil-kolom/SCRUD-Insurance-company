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
                        <h1>Salary for ${curMonth}</h1> <%-- Текущий месяц--%>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-sm table-hover" id="agent">
                        <thead>
                        <th><button class="sort" data-sort="id">ID</button></th>
                        <th><button class="sort" data-sort="firstName">First name</button></th>
                        <th><button class="sort" data-sort="secondName">Second name</button></th>
                        <th><button class="sort" data-sort="salary">Salary</button> </th>
                        </thead>
                        <tbody align="center" class="list">
                        <c:forEach var="agentMap" items="${agentSalaryMap}" varStatus="status">
                            <tr>
                                <td class="id">${agentMap.key.id}</td>
                                <td class="firstName">${agentMap.key.firstName}</td>
                                <td class="secondName">${agentMap.key.secondName}</td>
                                <td class="salary">${agentMap.value}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>