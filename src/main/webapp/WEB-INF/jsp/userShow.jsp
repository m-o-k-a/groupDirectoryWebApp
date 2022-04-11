<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<div class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="firstName">First Name</span>
		  </div>
		  <p class="form-control border-bottom border-info rounded" aria-label="firstName" aria-describedby="firstName"><c:out value="${user.firstName}" /></p>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="lastName">Last Name</span>
		  </div>
		  <p class="form-control border-bottom border-info rounded" aria-label="lastName" aria-describedby="lastName"><c:out value="${user.lastName}" /></p>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
			  <div class="input-group-prepend col-5">
			    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="mailAddress">Mail</span>
			  </div>
			  <p class="form-control border-bottom border-info rounded" aria-label="mailAddress" aria-describedby="mailAddress"><c:out value="${user.mailAddress}" /></p>
			</div>
			<div class="input-group m-2 w-75 mx-auto">
			  <div class="input-group-prepend col-5">
			    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="webAddress">Web</span>
			  </div>
			  <p class="form-control border-bottom border-info rounded" aria-label="webAddress" aria-describedby="webAddress"><c:out value="${user.webAddress}" /></p>
			</div>
			<div class="input-group m-2 w-75 mx-auto">
			  <div class="input-group-prepend col-5">
			    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="birthDay">BirthDay</span>
			  </div>
			  <p class="form-control border-bottom border-info rounded" aria-label="birthDay" aria-describedby="birthDay"><c:out value="${user.birthDay}" /></p>
			</div>
			<div class="input-group m-2 w-75 mx-auto">
			  <div class="input-group-prepend col-5">
			    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="actions">Actions</span>
			  </div>
		  		<div class="btn-group my-2 my-sm-0 m-2 mx-auto" role="group" aria-label="Actions Group">
					<a class="btn btn-outline-info" href="${updateUser}">Update Informations</a>
		  		</div>
		  		<div class="btn-group my-2 my-sm-0 m-2 mx-auto" role="group" aria-label="Actions Group">
					<a class="btn btn-outline-info" href="${updateUserPassword}">Update Password</a>
		  		</div>
			</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>