<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>

<html>

<head>
    <title>List Products</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Best Bakery in Town - Products List</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button: Add Customer -->

        <input type="button" value="Customers List"
               onclick="window.location.href='${pageContext.request.contextPath}/customer/list'; return false;"
               class="add-button"
        />


        <!--  add our html table here -->

        <table>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempProduct" items="${products}">


                <tr>
                    <td> ${tempProduct.productName} </td>
                    <td> ${tempProduct.price} $</td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









