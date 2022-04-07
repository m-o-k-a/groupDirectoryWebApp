<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<div class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
		<hr class="mx-auto"/>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend">
		    <span class="input-group-text bg-info text-white border-info" id="firstName">First Name</span>
		  </div>
		  <p class="form-control border-bottom border-info" aria-label="firstName" aria-describedby="firstName"><c:out value="${user.firstName}" /></p>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend">
		    <span class="input-group-text bg-info text-white border-info" id="lastName">Last Name</span>
		  </div>
		  <p class="form-control border-bottom border-info" aria-label="lastName" aria-describedby="lastName"><c:out value="${user.lastName}" /></p>
		</div>
		
		<c:if test = "${user.getFirstName().length() > 0}">
			<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend">
				    <span class="input-group-text bg-info text-white border-info" id="mailAddress">Mail Address</span>
				  </div>
				  <p class="form-control border-bottom border-info" aria-label="mailAddress" aria-describedby="mailAddress"><c:out value="${user.mailAddress}" /></p>
				</div>
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend">
				    <span class="input-group-text bg-info text-white border-info" id="webAddress">Web Address</span>
				  </div>
				  <p class="form-control border-bottom border-info" aria-label="webAddress" aria-describedby="webAddress"><c:out value="${user.webAddress}" /></p>
				</div>
				<div class="input-group m-2 w-75 mx-auto">
				  <div class="input-group-prepend">
				    <span class="input-group-text bg-info text-white border-info" id="birthDay">BirthDay</span>
				  </div>
				  <p class="form-control border-bottom border-info" aria-label="birthDay" aria-describedby="birthDay"><c:out value="${user.birthDay}" /></p>
			</div>
		</c:if>
		<a class="btn btn-outline-info my-2 my-sm-0 m-2 mx-auto" href="${updateUser}">Update Informations</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>