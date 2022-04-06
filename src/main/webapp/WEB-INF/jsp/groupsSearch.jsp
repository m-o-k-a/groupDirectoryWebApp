<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="searchGroup" value="/groups/list" />

<form:form method="GET" modelAttribute="group" class="form-inline m-2 justify-content-md-center" action="${searchGroup}">
   	<form:errors path="*" cssClass="alert alert-danger" element="div" />
 	<div class="input-group form-inline m-2 justify-content-md-center">
		<div class="input-group-prepend"></div>
		<form:input path="name" class="form-control" type="search" placeholder="Search by Name" aria-label="Search by Name"/>
	</div>
	<button class="btn btn-outline-info my-2 my-sm-0 ml-2 mr-2" type="submit">Search</button>
</form:form>