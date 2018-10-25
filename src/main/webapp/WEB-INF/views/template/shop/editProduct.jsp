<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>

            <p class="lead">Please update the product information here:</p>
        </div>

        <form:form action="/vendore/product/edit" method="post"
                   commandName="product" enctype="multipart/form-data"/>

        <div class="form-group">
            <label for="productName">Name</label>
            <form:input path="productName" id="productName" class="form-Control" value="${product.productName}"/>
        </div>



        <div class="form-group">
            <label for="productDescription">Description</label>
            <form:textarea path="productDescription" id="productDescription" class="form-Control" value="${product.productDescription}"/>
        </div>

        <div class="form-group">
            <label for="productPrice">Price</label>
            <form:input path="productPrice" id="productPrice" class="form-Control" value="${product.productPrice}"/>
        </div>


        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control" value="${product.unitInStock}"/>
        </div>
        <div class="form-group">
            <label for="flag">flag: </label>
            <form:input path="flag" id="flag" class="form-Control" value="${product.flag}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>



        <%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
