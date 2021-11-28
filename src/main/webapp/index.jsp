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
<c:import url="pages/page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <div class="container-fluid" id="index_jumbotron">
                <div class="text-center"><h1>CRUD operations</h1></div>
                <p class="lead text-center text-wrap">CRUD is the 4 basic operations of data management: create, read, update, delete</p>
            </div>
            <div class="cols">
                <div class="row">
                    <div class="col-md">
                        <img class="img-rounded" src="/resources/img/hiber.png" alt="hibernate logo" width="140" height="140">
                        <p>Main table containing all insurance contracts of the company.</p>
                        <p><a class="btn btn-primary" href="/contracts" role="button">View contracts</a></p>
                    </div>
                    <div class="col-md">
                        <img class="img-rounded" src="/resources/img/hiber.png" alt="hibernate logo" width="140" height="140">
                        <p>A table containing a list of all insurance agents working for the company.</p>
                        <p><a class="btn btn-primary" href="/agents" role="button" >View agents</a></p>
                    </div>
                    <div class="col-md">
                        <img class="img-rounded" src="/resources/img/branch_office.png" alt="Office img" width="140" height="140">
                        <p>A table containing data on all branches of the company.</p>
                        <p><a class="btn btn-primary" href="/branches" role="button" >View branches</a></p>
                    </div>
                    <div class="col-md">
                        <img class="img-rounded" src="/resources/img/type_insurance.jpg" alt="Type insurance img" width="140" height="140">
                        <p>A table containing the types of insurance provided by the company.</p>
                        <p><a class="btn btn-primary" href="/type" role="button"  >View types of insurance</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>