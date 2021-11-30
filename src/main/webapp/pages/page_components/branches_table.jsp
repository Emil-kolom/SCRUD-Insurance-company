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
        <table class="table table-striped table-sm table-hover" id="branch-office">
            <thead>
            <th><button class="sort" data-sort="id">ID</button></th>
            <th><button class="sort" data-sort="name">Name</button></th>
            <th><button class="sort" data-sort="address">Address</button></th>
            <th><button class="sort" data-sort="phone-number">Phone number</button></th>
            <th>action</th>
            </thead>
            <tbody align="center" class="list">
            <c:forEach var="branch" items="${listModel}" varStatus="status">
                <tr>
                    <td class="id">${branch.id}</td>
                    <td class="name">${branch.name}</td>
                    <td class="address">${branch.address}</td>
                    <td class="phone-number">${branch.phoneNumber}</td>
                    <td class="action">
                        <a href="/${page}/edit-branch/${branch.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/${page}/delete-branch/${branch.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="card-footer"><a class="btn btn-info" role="button" href="/${page}/newBranch">Add new branch office</a></div>
    </div>
</div>

