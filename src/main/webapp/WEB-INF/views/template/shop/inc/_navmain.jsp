<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/11/2018
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="main_nav_container">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-right">
                <div class="logo_container">
                    <a href="#">colo<span>shop</span></a>
                </div>
                <nav class="navbar">
                    <ul class="navbar_menu">
                        <li><a href="<c:url value="/" />">home</a></li>
                        <li><a href="#">shop</a></li>
                        <li><a href="#">promotion</a></li>
                        <li><a href="#">pages</a></li>
                        <li><a href="#">blog</a></li>
                        <li><a href="contact.html">contact</a></li>
                    </ul>
                    <ul class="navbar_user">
                        <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                        <li class="checkout">
                            <a href="#">
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                <span id="checkout_items" class="checkout_items">2</span>
                            </a>
                        </li>
                    </ul>
                    <div class="hamburger_container">
                        <i class="fa fa-bars" aria-hidden="true"></i>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>

<%--<ul class="nav navbar-nav pull-right">--%>
    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
        <%--<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>--%>
        <%--<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>--%>
        <%--<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">--%>
            <%--<li><a href="<c:url value="/customerBackup/cart" />">Cart</a></li>--%>
        <%--</c:if>--%>
        <%--<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">--%>
            <%--<li><a href="<c:url value="/admin" />">Admin</a></li>--%>
        <%--</c:if>--%>
    <%--</c:if>--%>
    <%--<c:if test="${pageContext.request.userPrincipal.name  == null}">--%>
        <%--<li><a href="<c:url value="/login/" />">Login</a></li>--%>
        <%--<li><a href="<c:url value="/register" />">Register</a></li>--%>
    <%--</c:if>--%>
<%--</ul>--%>
