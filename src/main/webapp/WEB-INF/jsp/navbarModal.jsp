<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  Modals -->
<div class="modal fade" id="signInModal" tabindex="-1" role="dialog" aria-labelledby="signInModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="signInModalLabel">Sign In</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <c:url var="searchGroup" value="/groups/list" />
      <form:form id="signIn" method="POST" modelAttribute="person" class="form-inline d-flex flex-column" action="${signInPath}">
	      <div class="modal-body justify-content-center">
	      <c:if test='${errorSignIn eq true}'>
	      	<script>$('#signInModal').modal('toggle'); $('#signInModal').on('hidden.bs.modal', () => document.getElementById('signInError').remove());</script>
		   	<div id="signInError" class="alert alert-danger">
		   		Wrong Mail or Password.
		   	</div>
	      </c:if>
			<div class="input-group m-2">
			  <div class="input-group-prepend">
			    <span class="input-group-text bg-info text-white border-info" id="mailAddress">Mail Address</span>
			  </div>
			  <form:input required="true" type="email" path="mailAddress" class="form-control border-bottom border-info" aria-label="mailAddress" aria-describedby="mailAddress" placeholder="John@Doe.com"/>
			</div>
			<div class="input-group m-2">
			  <div class="input-group-prepend">
			    <span class="input-group-text bg-info text-white border-info" id="password">Password</span>
			  </div>
			  <form:input required="true" path="password" type="password" class="form-control border-bottom border-info" aria-label="password" aria-describedby="password"/>
			</div>
	      </div>
	      <div class="modal-footer w-100 justify-content-center">
        	<button class="btn btn-outline-info" type="submit">Sign In</button>
	      </div>
	   </form:form>
    </div>
  </div>
</div>
<!--  Modals End -->