<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/persons/list" />

<div class="container">
	<div class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
		<a class="btn btn-outline-info my-2 my-sm-0 m-2 w-75 mx-auto" href="${list}">--- Return to People List ---</a>
		<hr class="mx-auto"/>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend">
		    <span class="input-group-text bg-info text-white border-info" id="firstName">First Name</span>
		  </div>
		  <p class="form-control border-bottom border-info" aria-label="firstName" aria-describedby="firstName"><c:out value="${pr.firstName}" /></p>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend">
		    <span class="input-group-text bg-info text-white border-info" id="lastName">Last Name</span>
		  </div>
		  <p class="form-control border-bottom border-info" aria-label="lastName" aria-describedby="lastName"><c:out value="${pr.lastName}" /></p>
		</div>
		
		<c:if test = "${user.getFirstName().length() > 0}">
			<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend">
				    <span class="input-group-text bg-info text-white border-info" id="mailAddress">Mail Address</span>
				  </div>
				  <p class="form-control border-bottom border-info" aria-label="mailAddress" aria-describedby="mailAddress"><c:out value="${pr.mailAddress}" /></p>
				</div>
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend">
				    <span class="input-group-text bg-info text-white border-info" id="webAddress">Web Address</span>
				  </div>
				  <p class="form-control border-bottom border-info" aria-label="webAddress" aria-describedby="webAddress"><c:out value="${pr.webAddress}" /></p>
				</div>
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend">
				    <span class="input-group-text bg-info text-white border-info" id="birthDay">BirthDay</span>
				  </div>
				  <p class="form-control border-bottom border-info" aria-label="birthDay" aria-describedby="birthDay"><c:out value="${pr.birthDay}" /></p>
			</div>
		</c:if>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>