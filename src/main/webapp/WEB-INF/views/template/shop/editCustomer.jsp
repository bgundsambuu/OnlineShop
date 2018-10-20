<%--
  Created by IntelliJ IDEA.
  User: Mingwei
  Date: 10/19/2018
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="inc/header.jsp"/>
<div class="section_container">
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <jsp:include page="inc/profile/_profilenav.jsp" />
            <div class="col-lg-5 col-md-7">
                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-muted mb-4">
                            Profile settings
                        </div>
                        <form:form action="edit" method="post" modelAttribute="user">
                            <form:input path="userId" value="${user.userId}" type="hidden"/>
                            <form:input path="role" value="${user.role}" type="hidden"/>
                            <form:input path="isActive" value="${user.isActive}" type="hidden"/>
                            <form:input path="customer.customerId" value="${user.customer.customerId}" type="hidden"/>
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <form:input path="customer.firstName" value="${user.customer.firstName}"
                                                cssClass="form-control is-invalid" placeholder="First name" type="text"/>
                                </div>
                                <div class="invalid-feedback d-block">Please insert your first name</div>
                            </div>
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <form:input path="customer.lastName" value="${user.customer.lastName}"
                                                cssClass="form-control" placeholder="Last name" type="text"/>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <form:input path="customer.phoneNumber" value="${user.customer.phoneNumber}"
                                                cssClass="form-control" placeholder="Phone Number" type="tel"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <form:input path="userName" value="${user.userName}"
                                                cssClass="form-control" placeholder="Username" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <form:input path="oldPassword"
                                                cssClass="form-control" placeholder="Old Password" type="password"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <form:input path="newPassword"
                                                cssClass="form-control" placeholder="New Password" type="password"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <form:input path="reEnterPassword"
                                                cssClass="form-control" placeholder="Re-enter password" type="password"/>
                                </div>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary my-4">Save Changes</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="inc/footer.jsp" />