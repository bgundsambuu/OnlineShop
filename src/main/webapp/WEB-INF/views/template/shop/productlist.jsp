<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>

<div class="container product_section_container">
    <div class="row">
        <div class="col product_section clearfix">

        <!-- Breadcrumbs -->

        <div class="breadcrumbs d-flex flex-row align-items-center">
            <ul>
                <li><a href="#">Home</a></li>
                <li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
            </ul>
        </div>

        <%@include file="/WEB-INF/views/template/shop/inc/_sidebarfilter.jsp" %>

        <!-- Main Content -->

        <div class="main_content">

            <!-- Products -->

            <div class="products_iso">
                <div class="row">
                    <div class="col">

                        <!-- Product Sorting -->

                        <div class="product_sorting_container product_sorting_container_top">
                            <ul class="product_sorting">
                                <li>
                                    <span class="type_sorting_text">Default Sorting</span>
                                    <i class="fa fa-angle-down"></i>
                                    <ul class="sorting_type">
                                        <li class="type_sorting_btn"
                                            data-isotope-option='{ "sortBy": "original-order" }'><span>Default Sorting</span>
                                        </li>
                                        <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'>
                                            <span>Price</span></li>
                                        <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'>
                                            <span>Product Name</span></li>
                                    </ul>
                                </li>
                                <li>
                                    <span>Show</span>
                                    <span class="num_sorting_text">6</span>
                                    <i class="fa fa-angle-down"></i>
                                    <ul class="sorting_num">
                                        <li class="num_sorting_btn"><span>6</span></li>
                                        <li class="num_sorting_btn"><span>12</span></li>
                                        <li class="num_sorting_btn"><span>24</span></li>
                                    </ul>
                                </li>
                            </ul>
                            <div class="pages d-flex flex-row align-items-center">
                                <div class="page_current">
                                    <span>1</span>
                                    <ul class="page_selection">
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                    </ul>
                                </div>
                                <div class="page_total"><span>of</span> 3</div>
                                <div id="next_page" class="page_next"><a href="#"><i class="fa fa-long-arrow-right"
                                                                                     aria-hidden="true"></i></a>
                                </div>
                            </div>
                        </div>

                        <!-- Product Grid -->

                        <div class="product-grid">

                            <!-- Product 1 -->

                            <c:forEach items="${products}" var="product">
                                <div class="product-item ${product.category.categoryID}">
                                <div class="product discount product_filter">
                                    <div class="product_image">
                                        <img src="<c:url value="/resources/images/product_1.png"/>" alt="">
                                    </div>
                                    <div class="product_info">
                                        <h6 class="product_name"><a
                                                href="/product/${product.productId}">${product.productName}</a>
                                        </h6>
                                        <div class="product_price">$${product.productPrice}</div>
                                    </div>
                                </div>
                                <div class="red_button add_to_cart_button"><a href="#"
                                                                              data-addcart="${product.productId}">Add
                                    to cart</a>
                                </div>
                                    </c:forEach>

                                <div class="product_sorting_container product_sorting_container_bottom clearfix">
                                    <ul class="product_sorting">
                                        <li>
                                            <span>Show:</span>
                                            <span class="num_sorting_text">04</span>
                                            <i class="fa fa-angle-down"></i>
                                            <ul class="sorting_num">
                                                <li class="num_sorting_btn"><span>01</span></li>
                                                <li class="num_sorting_btn"><span>02</span></li>
                                                <li class="num_sorting_btn"><span>03</span></li>
                                                <li class="num_sorting_btn"><span>04</span></li>
                                            </ul>
                                        </li>
                                    </ul>
                                    <span class="showing_results">Showing 1–3 of 12 results</span>
                                    <div class="pages d-flex flex-row align-items-center">
                                        <div class="page_current">
                                            <span>1</span>
                                            <ul class="page_selection">
                                                <li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                            </ul>
                                        </div>
                                        <div class="page_total"><span>of</span> 3</div>
                                        <div id="next_page_1" class="page_next"><a href="#"><i
                                                class="fa fa-long-arrow-right" aria-hidden="true"></i></a></div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
