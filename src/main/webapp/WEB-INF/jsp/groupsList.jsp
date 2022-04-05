<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="show" value="/groups/show" />

<div class="container">
	<form class="form-inline m-2 justify-content-md-center">
	  <input class="form-control w-50 mr-2" type="search" placeholder="Search Group" aria-label="Search Group">
	  <button class="btn btn-outline-info my-2 my-sm-0 ml-2 mr-2" type="submit">Search</button>
	</form>
	<div class="row justify-content-md-center">
		<c:forEach items="${groups}" var="gr">
			<div class="col m-2">
				<div class="card" style="width: 10rem;">
				  <div class="card-body">
				    <h5 class="card-title"><c:out value="${gr.name}" /></h5>
				    <h6 class="card-subtitle mb-2 text-muted"><c:out value="${gr.persons.size()} people"/></h6>
				    <hr>
				    <a href="${show}?id=${gr.id}" class="btn btn-outline-info">Show Group</a>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>