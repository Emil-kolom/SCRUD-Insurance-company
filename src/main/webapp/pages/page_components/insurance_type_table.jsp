<%--
  Created by IntelliJ IDEA.
  User: emil
  Date: 29.11.2021
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-body">
    <div class="card bg-info text-dark">
        <table class="table table-striped table-sm table-hover" id="typeInstance">
            <thead>
            <th><button class="sort" data-sort="id">ID</button></th>
            <th><button class="sort" data-sort="name">Name</button></th>
            <th><button class="sort" data-sort="agent-percentage">Agent percentage</button></th>
            <th>action</th>
            </thead>
            <tbody align="center" class="list">
            <c:forEach var="agent" items="${listModel}" varStatus="status">
                <tr>
                    <td class="id">${agent.id}</td>
                    <td class="firstName">${agent.firstName}</td>
                    <td class="secondName">${agent.secondName}</td>
                    <td class="patronymic">${agent.patronymic}</td>
                    <td class="address">${agent.address}</td>
                    <td class="phoneNumber">${agent.phoneNumber}</td>
                    <td class="branch-name">${agent.officeModel.name}</td>
                    <td class="action">
                        <a href="/${page}/edit-brand/${agent.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/${page}/delete-brand/${agent.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="card-footer"><a class="btn btn-info" role="button" href="/${page}/newAgent">Add new agent</a></div>
    </div>
</div>
