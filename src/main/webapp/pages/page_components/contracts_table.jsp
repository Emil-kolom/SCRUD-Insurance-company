<%--
  Created by IntelliJ IDEA.
  User: emil
  Date: 29.11.2021
  Time: 09:54
  To change this template use File | Settings | File Templates.
  valueNames: ['id', 'date', 'sum-insured', 'insured-type', 'tariff-rate', 'agent-surname', 'branch' ]
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-body">
    <div class="card text-dark">
        <table class="table table-striped table-sm table-hover" id="contract">
            <thead>
            <th><button class="sort" data-sort="id">ID</button></th>
            <th><button class="sort" data-sort="date">Date</button></th>
            <th><button class="sort" data-sort="sum-insured">Sum insured</button></th>
            <th><button class="sort" data-sort="insured-type">Insured type</button></th>
            <th><button class="sort" data-sort='tariff-rate'>Tariff rate</button></th>
            <th><button class="sort" data-sort='agent-surname'>Agent surname</button></th>
            <th><button class="sort" data-sort="branch">Branch office name</button></th>
            <th>action</th>
            </thead>
            <tbody align="center" class="list">
            <c:forEach var="contract" items="${listModel}" varStatus="status">
                <tr>
                    <td class="id">${contract.id}</td>
                    <td class="date">${contract.date}</td>
                    <td class="sum-insured">${contract.sum_insured}</td>
                    <td class="insured-type">${contract.insurance_type_model.name}</td>
                    <td class="tariff-rate">${contract.tariff_rate}</td>
                    <td class="agent-surname">${contract.agent.secondName}</td>
                    <td class="branch">${contract.agent.officeModel.name}</td>
                    <td class="action">
                        <a href="/${page}/edit-brand/${contract.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/${page}/delete-brand/${contract.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="card-footer"><a class="btn btn-info" role="button" href="/${page}/newContract">Add new contract</a></div>
    </div>
</div>
