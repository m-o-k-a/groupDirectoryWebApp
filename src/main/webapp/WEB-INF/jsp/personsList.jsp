<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="show" value="/persons/show" />

<div class="container">
	<form class="form-inline m-2 justify-content-md-center">
	  <input class="form-control w-50 mr-2" type="search" placeholder="Search Person" aria-label="Search Person">
	  <button class="btn btn-outline-info my-2 my-sm-0 ml-2 mr-2" type="submit">Search</button>
	</form>
	<div class="row justify-content-md-center">
		<c:forEach items="${persons}" var="pr">
			<div class="col m-2">
				<div class="card" style="width: 10rem;">
				  <div class="card-body">
				    <h6 class="card-title"><c:out value="${pr.firstName} ${pr.lastName}" /></h6>
				    <p class="card-subtitle small mb-2 text-muted"><c:out value="${pr.mailAddress}"/></p>
				    <hr>
				    <a href="${show}?id=${pr.id}" class="btn btn-outline-info">Informations</a>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>