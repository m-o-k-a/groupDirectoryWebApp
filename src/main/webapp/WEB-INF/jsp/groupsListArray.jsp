<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row justify-content-md-center mx-auto">
	<c:forEach items="${groups}" var="gr">
		<div class="col m-2 col-md-auto">
			<div class="card" style="width: 10rem;">
			  <div class="card-body">
			    <h6 class="card-title"><c:out value="${gr.name}" /></h6>
			    <p class="card-subtitle small mb-2 text-muted"><c:out value="${gr.getPersons().size()} people"/></p>
			    <hr>
			    <a href="${showGroup}/${gr.id}" class="btn btn-outline-info">Show Group</a>
			  </div>
			</div>
		</div>
	</c:forEach>
</div>