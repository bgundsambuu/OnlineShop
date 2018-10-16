<%--
  Project Management class - Somesh Rao
  Developer: Bayarjargal
  Date: 10/16/2018 /Octoberca/
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10,-1], [1,2,3,5,10, "All"]],
            "oSearch": {"sSearch": searchCondition}
        });
    });

</script>

<div class="page-header">
    <h1>Choose card</h1>
</div>
<c:forEach items="${cardDetail}" var="carddetail">
    <input type="radio" name=${cardDetail.cardNumber} value=${cardDetail.cardNumber} >
</c:forEach>


