<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/shop/inc/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">This is the customerBackup management page.</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th>Enabled</th>

            </tr>
            </thead>
            <c:forEach items="${customerBackupList}" var="customerBackup">
                <tr>
                    <td>${customerBackup.customerName}</td>
                    <td>${customerBackup.customerEmail}</td>
                    <td>${customerBackup.customerPhone}</td>
                    <td>${customerBackup.username}</td>
                    <td>${customerBackup.enabled}</td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
