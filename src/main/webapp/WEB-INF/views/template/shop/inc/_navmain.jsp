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
                    <a href="#"></a>
                </div>
                <nav class="navbar">
                    <ul class="navbar_menu">
                        <li><a href="<c:url value="/" />">home</a></li>
                        <li><a href="#">shop</a></li>
                        <li><a href="#">men's</a></li>
                        <li><a href="#">women's</a></li>
                        <li><a href="#">kids'</a></li>
                    </ul>
                    <ul class="navbar_user">
                        <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                        <li class="account">
                            <a href="#"><i class="fa fa-user" aria-hidden="true"></i></a>
                            <ul class="account_selection">
                                <li><a href="/loginpage"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign In</a></li>
                                <li><a href="/registerpage"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a></li>
                            </ul>
                        </li>
                        <li class="account">
                            <a href="#" class="acc-profile">You <i class="fa fa-user" aria-hidden="true"></i></a>
                            <ul class="account_selection">
                                <li class="account_selection_text"><span>Hello Kenzo!</span></li>
                                <li><a href="/profilepage"><i class="fa fa-cog" aria-hidden="true"></i> Profile</a></li>
                                <li><a href="/signout"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign out</a></li>
                            </ul>
                        </li>
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
            <%--<li><a href="<c:url value="/customer/cart" />">Cart</a></li>--%>
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
