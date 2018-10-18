<%--
  Project Management class - Somesh Rao
  Developer: Bayarjargal
  Date: 10/16/2018 /October/
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- content -->
<div>
    <div>
        <h2>
            <strong>Card details</strong>
        </h2>
        <c:forEach items="${cards}" var="card">
            <label>
                <input type="radio" id="cards" value="${card.cardNumber}" >
                    ${card.cardNumber}
            </label>
            <br/>
        </c:forEach>
        <form:form role="form" method="post" action="addCardDetail"
                   modelAttribute="cardDetail">
            <fieldset>
                <div>
                    <div >
                        <form:input type="hidden" path="cardId" />
                        <form:errors path="cardId" />
                        <br>
                    </div>
                </div>

                <div class="form-group">

                    <label for="cardHolderName" >Card Holder Name:
                    </label>
                    <div>
                        <form:input type="text" path="cardHolderName" />
                        <form:errors path="cardHolderName" />
                        <br>
                    </div>
                </div>


                <div>
                    <label for="cardType">Card
                        type: </label>
                    <div>
                        <form:select path="cardType">
                            <form:option value="Visa" label="Visa" />
                            <form:option value="Master" label="Master" />
                        </form:select>
                    </div>
                </div>

                <div>

                    <label for="cardNumber">Card
                        number: </label>
                    <div>
                        <form:input type="text"
                                    path="cardNumber" />
                        <form:errors path="cardNumber"/>
                    </div>
                </div>
                <div>

                    <label for="cardExp">Expiry
                        date </label>
                    <div>
                        <form:input type="Date" path="cardExp" />
                        <form:errors path="cardExp" />
                    </div>
                </div>
                <div>
                    <label for="securityNumber">CVV
                    </label>
                    <div>
                        <form:input type="text" path="securityNumber" />
                        <form:errors path="securityNumber" />
                    </div>
                </div>
                <div class="form-group">


                    <label for="zipCode">Zip code:
                    </label>
                    <div>
                        <form:input type="text"
                                    path="zipCode" />

                        <form:errors path="zipCode"/>
                    </div>
                </div>

                <div>
                    <div>
                        <input type="submit" id="btnSumbit"
                               value="Submit" />
                    </div>
                </div>
            </fieldset>
        </form:form>
    </div>
</div>



