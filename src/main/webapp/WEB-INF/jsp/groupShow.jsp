<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<div class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
		<a class="btn btn-outline-info my-2 my-sm-0 m-2 w-50 mx-auto" href="${listGroup}">--- Return to Group List ---</a>
		<hr class="mx-auto"/>
		<c:choose>
			<c:when test="${gr ne null}">
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend col-5">
				    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="groupName">Group Name</span>
				  </div>
				  <p class="form-control border-bottom border-info rounded" aria-label="groupName" aria-describedby="groupName"><c:out value="${gr.name}" /></p>
				</div>
				<%@ include file="/WEB-INF/jsp/personsListArray.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/jsp/alertNoGroups.jsp"%>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>