<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Best Bakery in Town - Customers List</h2>
		</div>
	</div>

	<hr>

	<p>
		User: <security:authentication property="principal.username" />
	</p>

	<hr>

	<div id="container">
	
		<div id="content">

			<!-- put new button: Add Customer -->


			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<input type="button" value="Products list"
				   onclick="window.location.href='${pageContext.request.contextPath}/product/list'; return false;"
				   class="add-button"
			/>

			<security:authorize access="hasRole('MANAGER')">
			<input type="button" value="Orders list"
				   onclick="window.location.href='${pageContext.request.contextPath}/order/list'; return false;"
				   class="add-button"
			/>

			<input type="button" value="Make Order"
				   onclick="window.location.href='${pageContext.request.contextPath}/order/make'; return false;"
				   class="add-button"
			/>
			</security:authorize>

			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout"
					   class="add-button"
				/>
			</form:form>

            <form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />

                <input type="submit" value="Search" class="add-button" />
            </form:form>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>

						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>
	
	</div>
	

</body>

</html>









