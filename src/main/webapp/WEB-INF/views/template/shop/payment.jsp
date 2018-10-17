<%--
  Project Management class - Somesh Rao
  Developer: Bayarjargal
  Date: 10/16/2018 /October/
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    var rad = document.getElementById('cards');
    for(var i = 0; i < rad.length; i++) {
        rad[i].onclick = function() {
            document.getElementById('te').value = i;
        };
    }
</script>
<form name="payment">
    <div class="page-header">
        <h1>Choose card</h1>
    </div>
    <c:forEach items="${cards}" var="card">
        <label>
            <input type="radio" id="cards" value="${card.cardNumber}" >
                ${card.cardNumber}
        </label>
        <br/>
    </c:forEach>
    <input type="text" id="te" readonly="true"/>
    <input type="text" readonly="true"/>
    <input type="text" readonly="true"/>
</form>
