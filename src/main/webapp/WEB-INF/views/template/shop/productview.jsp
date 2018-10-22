<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/16/2018
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>

<div class="container single_product_container">

    <%@include file="/WEB-INF/views/template/shop/inc/_breadcrumb.jsp" %>

    <div class="row">
        <div class="col-lg-7">
            <div class="single_product_pics">
                <div class="row">
                    <div class="col-lg-3 thumbnails_col order-lg-1 order-2">
                        <div class="single_product_thumbnails">
                            <ul>
                                <li><img src="<c:url value="/resources/images/single_1_thumb.jpg"/>" alt="" data-image="<c:url value="/resources/images/single_1.jpg"/>"></li>
                                <li class="active"><img src="<c:url value="/resources/images/single_2_thumb.jpg"/>" alt="" data-image="<c:url value="/resources/images/single_2.jpg"/>"></li>
                                <li><img src="<c:url value="/resources/images/single_3_thumb.jpg"/>" alt="" data-image="<c:url value="/resources/images/single_3.jpg"/>"></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9 image_col order-lg-2 order-1">
                        <div class="single_product_image">
                            <div class="single_product_image_background" style="background-image:url(<c:url value="/resources/images/single_2.jpg"/>)"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="product_details">
                <div class="product_details_title">
                    <h2>Pocket cotton sweatshirt</h2>
                    <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                </div>
                <div class="product_price">$495.00</div>
                <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
                    <span>Quantity:</span>
                    <div class="quantity_selector">
                        <span class="minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
                        <span id="quantity_value">1</span>
                        <span class="plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Tabs -->

<div class="tabs_section_container">

    <div class="container">
        <div class="row">
            <div class="col">

                <!-- Tab Description -->
                <div class="mt-5">
                    <div class="row">
                        <div class="col-lg-5 desc_col">
                            <div class="tab_title">
                                <h4>Description</h4>
                            </div>
                            <div class="tab_text_block">
                                <h2>Pocket cotton sweatshirt</h2>
                                <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                            </div>
                            <div class="tab_image">
                                <img src="<c:url value="/resources/images/desc_1.jpg"/>" alt="">
                            </div>
                            <div class="tab_text_block">
                                <h2>Pocket cotton sweatshirt</h2>
                                <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                            </div>
                        </div>
                        <div class="col-lg-5 offset-lg-2 desc_col">
                            <div class="tab_image">
                                <img src="<c:url value="/resources/images/desc_2.jpg"/>" alt="">
                            </div>
                            <div class="tab_text_block">
                                <h2>Pocket cotton sweatshirt</h2>
                                <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>
                            </div>
                            <div class="tab_image desc_last">
                                <img src="<c:url value="/resources/images/desc_3.jpg"/>" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
