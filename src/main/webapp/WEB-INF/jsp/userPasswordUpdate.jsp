<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/course/list" />

<div class="container">	
	<c:if test="${requestSent}">
		<div id="errorSignIn" class="alert alert-success m-4 text-center" role="alert">
			A mail will be sent to you to change your password if the mail is registered
		</div>	
	</c:if>
	<c:if test="${request}">
		<div id="errorSignIn" class="alert alert-info m-4 text-center" role="alert">
			Request a password change
		</div>	
		<form:form method="POST" modelAttribute="person" class="form-inline m-2 justify-content-md-center mx-auto" action="${updateUserPassword}">
		  	<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<div class="input-group m-2 w-75 mx-auto">
			  <div class="input-group-prepend col-5">
			    <span class="input-group-text bg-info text-white border-info col-12 rounded" id="mailAddress">Mail</span>
			  </div>
			  <form:input required="true" path="mailAddress" type="email" class="form-control border-bottom border-info rounded" aria-label="mailAddress" aria-describedby="mailAddress"/>
			</div>
		<button class="btn btn-outline-info my-2 my-sm-0 ml-2 mr-2" type="submit">Request</button>
		</form:form>
	</c:if>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
