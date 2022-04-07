<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="input-group">
<form:form method="GET" modelAttribute="person" class="form-inline m-2 justify-content-md-center mx-auto" action="${searchPerson}">
   	<form:errors path="*" cssClass="alert alert-danger" element="div" />
   	<div class="input-group form-inline m-2 justify-content-md-center">
   		<div class="input-group-prepend"></div>
   		<form:input path="firstName" class="form-control" type="search" placeholder="Search by First Name" aria-label="Search by First Name"/>
   		<form:input path="lastName" class="form-control" type="search" placeholder="Search by Last Name" aria-label="Search by Last Name"/>
   	</div>
	<button class="btn btn-outline-info my-2 my-sm-0 ml-2 mr-2" type="submit">Search</button>
</form:form>
</div>