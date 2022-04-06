<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/groups/list" />

<div class="container">
	<div class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
		<a class="btn btn-outline-info my-2 my-sm-0 m-2 w-75 mx-auto" href="${list}">--- Return to Group List ---</a>
		<hr class="mx-auto"/>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend">
		    <span class="input-group-text bg-info text-white border-info" id="groupName">Group Name</span>
		  </div>
		  <p class="form-control border-bottom border-info" aria-label="groupName" aria-describedby="groupName"><c:out value="${gr.name}" /></p>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/personsListArray.jsp"%>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>