<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="section_container">
    <div class="container mt--8 pb-5">

        <div class="row justify-content-center">
            <div class="col-lg-3 col-md-3">
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action active">
                        Profile settings
                    </a>
                    <a href="#" class="list-group-item list-group-item-action">Payment settings</a>
                    <a href="#" class="list-group-item list-group-item-action">Address settings</a>
                </div>
            </div>
            <div class="col-lg-5 col-md-7">
                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-muted mb-4">
                           Profile settings
                        </div>
                        <form role="form">
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control is-invalid" placeholder="First name" type="text">
                                </div>
                                <div class="invalid-feedback d-block">Please insert your first name</div>
                            </div>
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control" placeholder="Last name" type="text">
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control" placeholder="Email" type="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control" placeholder="Password" type="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <input class="form-control" placeholder="Re-enter password" type="password">
                                </div>
                            </div>
                            <div class="text-center">
                                <button type="button" class="btn btn-primary my-4">Save Changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
