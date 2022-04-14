<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="groupsCat" value="groups"/>
<c:url var="groupsPath" value="/groups/list"/>
<c:url var="personsCat" value="persons"/>
<c:url var="personsPath" value="/persons/list"/>
<c:url var="userCat" value="user"/>
<c:url var="userPath" value="/user/show"/>
<c:url var="signInPath" value="/user/signIn"/>
<c:url var="signOutPath" value="/user/signOut"/>
<c:url var="homePath" value="/"/>

<%@ include file="/WEB-INF/jsp/navbarModal.jsp"%>

<nav class="navbar navbar-expand-md navbar-light bg-light">
	<a class="navbar-brand" href="${homePath}">Group Directory App</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class=<c:choose><c:when test="${cat eq personsCat}">"nav-link active"</c:when><c:otherwise>"nav-link"</c:otherwise></c:choose> href="${personsPath}">People</a>
	      </li>
	      <li class="nav-item">
	        <a class=<c:choose><c:when test="${cat eq groupsCat}">"nav-link active"</c:when><c:otherwise>"nav-link"</c:otherwise></c:choose> href="${groupsPath}">Groups</a>
	      </li>
	    </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse">
        <ul class="navbar-nav ml-auto">
        	<c:choose>
		        <c:when test = "${user.getFirstName().length() > 0}">
			      <li class="nav-item">
			        <a class=<c:choose><c:when test="${cat eq userCat}">"nav-link active"</c:when><c:otherwise>"nav-link"</c:otherwise></c:choose> href="${userPath}">About Me</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="${signOutPath}">Sign Out</a>
			      </li>
		        </c:when>
		         <c:otherwise>
			      <li class="nav-item">
			      	<a type="button" class="nav-link" data-toggle="modal" data-target="#signInModal">Sign In</a>
			      </li>
		         </c:otherwise>
	      </c:choose>
        </ul>
    </div>
</nav>
