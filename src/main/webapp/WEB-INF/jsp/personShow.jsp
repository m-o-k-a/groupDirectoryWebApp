<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<div class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
		<a class="btn btn-outline-info my-2 my-sm-0 m-2 w-50 mx-auto" href="${listPerson}">--- Return to People List ---</a>
		<hr class="mx-auto"/>
		<c:choose>
			<c:when test="${pr ne null}">
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend col-5">
				    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="firstName">First Name</span>
				  </div>
				  <p class="form-control border-bottom border-info rounded" aria-label="firstName" aria-describedby="firstName"><c:out value="${pr.firstName}" /></p>
				</div>
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend col-5">
				    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="lastName">Last Name</span>
				  </div>
				  <p class="form-control border-bottom border-info rounded" aria-label="lastName" aria-describedby="lastName"><c:out value="${pr.lastName}" /></p>
				</div>
				
				<c:if test = "${user.getFirstName().length() > 0}">
					<div class="input-group m-2 w-75 mx-auto">
						  <div class="input-group-prepend col-5">
						    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="mailAddress">Mail</span>
						  </div>
						  <p class="form-control border-bottom border-info rounded" aria-label="mailAddress" aria-describedby="mailAddress"><c:out value="${pr.mailAddress}" /></p>
						</div>
						<div class="input-group m-2 w-75 mx-auto">
						  <div class="input-group-prepend col-5">
						    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="webAddress">Web</span>
						  </div>
						  <p class="form-control border-bottom border-info rounded" aria-label="webAddress" aria-describedby="webAddress"><c:out value="${pr.webAddress}" /></p>
						</div>
						<div class="input-group m-2 w-75 mx-auto">
						  <div class="input-group-prepend col-5">
						    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="birthDay">BirthDay</span>
						  </div>
						  <p class="form-control border-bottom border-info rounded" aria-label="birthDay" aria-describedby="birthDay"><c:out value="${pr.birthDay}" /></p>
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/jsp/alertNoPeople.jsp"%>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>