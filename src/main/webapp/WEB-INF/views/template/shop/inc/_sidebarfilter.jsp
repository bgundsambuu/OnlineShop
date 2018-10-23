<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar">
    <div class="sidebar_section">
        <div class="sidebar_title">
            <h5>Product Category</h5>
        </div>
        <ul class="sidebar_categories">
            <li><a href="#">Men</a></li>
            <li class="active"><a href="#"><span><i class="fa fa-angle-double-right" aria-hidden="true"></i></span>Women</a></li>
            <li><a href="#">Accessories</a></li>
            <li><a href="#">New Arrivals</a></li>
            <li><a href="#">Collection</a></li>
            <li><a href="#">Shop</a></li>
        </ul>
    </div>

    <!-- Price Range Filtering -->
    <div class="sidebar_section">
        <div class="sidebar_title">
            <h5>Filter by Price</h5>
        </div>
        <p>
            <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
        </p>
        <div id="slider-range"></div>
        <div class="filter_button"><span>filter</span></div>
    </div>

</div>
