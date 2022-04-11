<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<form:form method="POST" modelAttribute="person" class="justify-content-md-center m-2 d-flex flex-column justify-content-center">
       <form:errors path="*" cssClass="alert alert-danger" element="div" />
		<div class="input-group m-2 w-75 mx-auto">
		 	<div class="input-group-prepend col-5">
			    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="firstName">First Name</span>
		  	</div>
		  	<form:input required="true" path="firstName" type="text" class="form-control border-bottom border-info rounded" aria-label="firstName" aria-describedby="firstName" value="${user.firstName}"/>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="lastName">Last Name</span>
		  </div>
		  <form:input required="true" path="lastName" type="text" class="form-control border-bottom border-info rounded" aria-label="lastName" aria-describedby="lastName" value="${user.lastName}"/>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="mailAddress">Mail</span>
		  </div>
		  <form:input required="true" path="mailAddress" type="email" class="form-control border-bottom border-info rounded" aria-label="mailAddress" aria-describedby="mailAddress" value="${user.mailAddress}"/>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="webAddress">Web</span>
		  </div>
		  <form:input required="true" path="webAddress" type="text" class="form-control border-bottom border-info rounded" aria-label="webAddress" aria-describedby="webAddress" value="${user.webAddress}"/>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="birthDay">BirthDay</span>
		  </div>
		  <form:input required="true" path="birthDay" type="date" class="form-control border-bottom border-info rounded" aria-label="birthDay" aria-describedby="birthDay" value="${user.birthDay}"/>
		</div>
		<div class="input-group m-2 w-75 mx-auto">
		  <div class="input-group-prepend col-5">
		    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="actions">Actions</span>
		  </div>
	  		<div class="btn-group my-2 my-sm-0 m-2 mx-auto" role="group" aria-label="Actions Group">
				<button class="btn btn-outline-info" type="submit">Update Informations</button>
	  		</div>
	  		<div class="btn-group my-2 my-sm-0 m-2 mx-auto" role="group" aria-label="Actions Group">
				<a class="btn btn-outline-info" href="${showUser}">Cancel</a>
	  		</div>
		</div>
    </form:form>
</div>