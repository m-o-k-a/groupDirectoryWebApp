<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/course/list" />

<div class="container">	
	<div class="card bg-outline-info m-4 text-center">
	  <div class="card-header">People</div>
	  <div class="card-body">
	    <p class="card-text">As of today, there are <c:out value="${peopleAmount}"/> people registered.</p>
	    <hr/>
	    <%@ include file="/WEB-INF/jsp/personsSearch.jsp"%>
	  </div>
	</div>
	<div class="card bg-outline-info m-4 text-center">
	  <div class="card-header">Groups</div>
	  <div class="card-body">
	    <p class="card-text">As of today, there are <c:out value="${groupAmount}"/> groups registered.</p>
	    <hr/>
	    <%@ include file="/WEB-INF/jsp/groupsSearch.jsp"%>
	  </div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
