<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 25.02.18
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error site</title>


    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>



<div id="wrapper">
    <div id="header" style="background-color: red">
        <h2>Sorry you have commited an error. </h2>
    </div>


    <input type="button" value="Try again"
    onclick="window.location.href='${pageContext.request.contextPath}/order/make'; return false;"
    class="add-button-error"
    />

</div>


</body>
</html>
