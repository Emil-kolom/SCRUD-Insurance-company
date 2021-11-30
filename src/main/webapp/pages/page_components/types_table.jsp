<%--
  Created by IntelliJ IDEA.
  User: emil
  Date: 29.11.2021
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-body">
    <div class="card text-dark">
        <table class="table table-striped table-sm table-hover" id="insurance-type">
            <thead>
            <th><button class="sort" data-sort="id">ID</button></th>
            <th><button class="sort" data-sort="name">Name</button></th>
            <th><button class="sort" data-sort="agent-percentage">Agent percentage</button></th>
            <th>action</th>
            </thead>
            <tbody align="center" class="list">
            <c:forEach var="typeInsurance" items="${listModel}" varStatus="status">
                <tr>
                    <td class="id">${typeInsurance.id}</td>
                    <td class="name">${typeInsurance.name}</td>
                    <td class="agent-percentage">${typeInsurance.agent_percentage}</td>
                    <td class="action">
                        <a href="/${page}/edit-brand/${typeInsurance.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/${page}/delete-brand/${typeInsurance.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="card-footer"><a class="btn btn-info" role="button" href="/${page}/newType">Add new type of insurance</a></div>
    </div>
</div>
