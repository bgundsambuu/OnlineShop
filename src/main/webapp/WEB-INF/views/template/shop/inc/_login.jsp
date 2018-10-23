<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="login-wrapper">
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-7">
                <div class="card-title mt-4 mb-3">
                    <h1 class="d-none">Onshop login</h1>
                    <p class="text-center">
                        <a href="#"><img src="<c:url value="/resources/images/logo.jpg"/>" /></a>
                    </p>
                </div>

                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-center text-muted mb-4">
                            Sign in:
                        </div>
                        <form role="form">
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control is-invalid" placeholder="Email" type="email">
                                </div>
                                <div class="invalid-feedback d-block">Please insert your email!</div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control" placeholder="Password" type="password">
                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                                <%--<input type="checkbox" id="customCheck1">--%>
                                <%--<label class="custom-control-label" for="customCheck1">Remember me</label>--%>
                            <%--</div>--%>
                            <div class="text-center">
                                <button type="button" class="btn btn-primary my-4">Sign in</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-6">
                        <a href="/forgotpage">Forgot password?</a>
                    </div>
                    <div class="col-6 text-right">
                        <a href="/registerpage">Create new account</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
