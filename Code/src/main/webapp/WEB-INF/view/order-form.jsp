<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Make Order</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

    <style>
        .error {color:red}
    </style>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Add order</h3>

    <form:form action="saveOrder" modelAttribute="orderHelper" method="POST">
        Who is ordering?
        <form:select path="customer_id" >
            <c:forEach var="tempCustomer" items="${customers}">
                <form:option value="${tempCustomer.id}" label="${tempCustomer.firstName} ${tempCustomer.lastName}"/>
                <form:errors path="customer_id" cssClass="error" value="You have commited an Error"/>
            </c:forEach>
        </form:select>
        <br>
        What product do you want to order?
        <br>
        <c:forEach var="tempProduct" items="${products}">
            <form:input path="quantities" type="text" placeholder="Quantity of ${tempProduct.productName}" />
            <form:errors path="quantities" cssClass="error" value="You have commited an Error"/>
        </c:forEach>

        <input type="submit" value="Save" class="save" />

    </form:form>


    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>

</div>

</body>

</html>










