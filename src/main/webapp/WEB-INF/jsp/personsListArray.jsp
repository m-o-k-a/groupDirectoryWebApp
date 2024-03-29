<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row justify-content-md-center mx-auto">
	<c:choose>
		<c:when test="${persons.size() > 0}">
			<c:forEach items="${persons}" var="pr">
				<div class="col m-2 col-md-auto">
					<div class="card" style="width: 10rem;">
					  <div class="card-body">
					    <h6 class="card-title"><c:out value="${pr.firstName}"/></h6>
					    <p class="card-subtitle mb-2 text-muted"><c:out value="${pr.lastName}"/></p>
					    <hr>
					    <a href="${showPerson}/${pr.id}" class="btn btn-outline-info">Informations</a>
					  </div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/jsp/alertNoPeople.jsp"%>
		</c:otherwise>
	</c:choose>
</div>