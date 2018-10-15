<%--
  Created by IntelliJ IDEA.
  User: Mingwei
  Date: 10/13/18
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.onlineShop.Constant" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    input:read-only {
      background-color: #D8D8D8;
    }
</style>
<body>
<form:form action="${pageContext.request.contextPath}/user/edit" method="post" modelAttribute="user">
    <c:if test="${not empty user}">
        <c:set var="ADMIN" value="<%=Constant.Role.ADMIN%>"/>
        <c:set var="VENDOR" value="<%=Constant.Role.VENDOR%>"/>
        <c:set var="CUSTOMER" value="<%=Constant.Role.CUSTOMER%>"/>
        <c:if test="${ADMIN eq user.role}">
            <h2>admin</h2>
        </c:if>
        <c:if test="${VENDOR eq user.role}">
            <h2>vendor</h2>
        </c:if>
        <c:if test="${CUSTOMER eq user.role}">
            <h2>customer</h2>
        </c:if>
        <ul>
            <li>userId:<form:input path="userId" type="text" value="${user.userId}" readonly="true"/></li>
            <li>userName:<form:input path="userName" type="text" value="${user.userName}"/></li>
            <li>password:<form:input path="password" type="text" value="${user.password}"/></li>
            <li>role:<form:input path="role" type="text" value="${user.role}" readonly="true" /></li>
            <li>isActive:<form:input path="isActive" type="text" value="${user.isActive}" readonly="true"/></li>
        </ul>
        <c:if test="${not empty user.administrator}">
            <c:set var="a" value="${user.administrator}"/>
            <ul>
                <li>adminId:<form:input type="text" value="${a.adminId}" path="administrator.adminId" readonly="true"/></li>
                <li>userId:<form:input type="text" value="${a.userId}" path="administrator.userId" readonly="true"/></li>
                <li>firstName:<form:input type="text" value="${a.firstName}" path="administrator.firstName"/></li>
                <li>lastName:<form:input type="text" value="${a.lastName}" path="administrator.lastName"/></li>
                <li>phoneNumber:<form:input type="text" value="${a.phoneNumber}" path="administrator.phoneNumber"/></li>
            </ul>
        </c:if>
        <c:if test="${not empty user.vendor}">
            <c:set var="v" value="${user.vendor}"/>
            <ul>
                <li>vendorId:<form:input type="text" value="${v.vendorId}" path="vendor.vendorId" readonly="true"/></li>
                <li>firstName:<form:input type="text" value="${v.firstName}" path="vendor.firstName"/></li>
                <li>lastName:<form:input type="text" value="${v.lastName}" path="vendor.lastName"/></li>
                <li>name:<form:input type="text" value="${v.name}" path="vendor.name"/></li>
                <li>phoneNumber:<form:input type="text" value="${v.phoneNumber}" path="vendor.phoneNumber"/></li>
                <li>userId:<form:input type="text" value="${v.userId}" path="vendor.userId" readonly="true"/></li>
                <li>status:<form:input type="text" value="${v.status}" path="vendor.status"/></li>
            </ul>
        </c:if>
        <c:if test="${not empty user.customer}">
            <c:set var="c" value="${user.customer}"/>
            <ul>
                <li>customerId:<form:input type="text" value="${c.customerId}" path="customer.customerId" readonly="true"/></li>
                <li>userId:<form:input type="text" value="${c.userId}" path="customer.userId" readonly="true"/></li>
                <li>firstName:<form:input type="text" value="${c.firstName}" path="customer.firstName"/></li>
                <li>lastName:<form:input type="text" value="${c.lastName}" path="customer.lastName"/></li>
                <li>phoneNumber:<form:input type="text" value="${c.phoneNumber}" path="customer.phoneNumber"/></li>
                <li>orderId:<form:input type="text" value="${c.orderId}" path="customer.orderId"/></li>
            </ul>
        </c:if>
        <c:if test="${not empty user.address}">
            <h2>address</h2>
            <c:set var="adr" value="${user.address}"/>
            <ul>
                <li>addressId:<form:input type="text" value="${adr.addressId}" path="address.addressId" readonly="true"/></li>
                <li>street:<form:input type="text" value="${adr.street}" path="address.street"/></li>
                <li>city:<form:input type="text" value="${adr.city}" path="address.city"/></li>
                <li>state:<form:input type="text" value="${adr.state}" path="address.state"/></li>
                <li>zipCode:<form:input type="text" value="${adr.zipCode}" path="address.zipCode"/></li>
                <li>country:<form:input type="text" value="${adr.country}" path="address.country"/></li>
                <li>userId:<form:input type="text" value="${adr.userId}" path="address.userId" readonly="true"/></li>
            </ul>
        </c:if>
        <input type="submit" value="SUBMIT">
    </c:if>
</form:form>
</body>
</html>
