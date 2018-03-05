<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .failed {
            margin-bottom: 10px;
            margin-top: 10px;
            padding: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            color: red;
        }
    </style>
</head>

<body>

<div id="top">
    <h1>Welcome To Best Bakery in Town. </h1>
    <h2>*Every pastry made with Spring, Hibernate and Java.</h2>
</div>

<div class="container">
    <img src="${pageContext.request.contextPath}/resources/images/logo.jpg"/>



    <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
               modelAttribute="bakeryUser">

        <c:if test="${registrationError != null}">
                  ${registrationError}
        </c:if>

    <div class="form-input">
        <form:input path="userName" placeholder="username" />
    </div>
    <div class="form-input">
        <form:password path="password" placeholder="password" />
    </div>
        <input class="btn-login" type="submit" value="Register">

    </form:form>

    <c:if test="${param.error != null}">

        <i class="failed">Sorry! You entered invalid username/password.</i>

    </c:if>


    <c:if test="${param.logout != null}">

        <i class="failed">You have been logged out.</i>

    </c:if>
</div>




</body>

</html>