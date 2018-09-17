<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<nav class="navbar navbar-default" background-color="black">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Noize Collections</a>
      
      <ul class="nav navbar-nav">
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Top-30 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/artist/top_list">Artists</a></li>
            <li class="divider"></li>
            <li><a href="/album/top_list">Albums</a></li>
            <li class="divider"></li>
            <li><a href="/song/top-30_list">Songs</a></li>
          </ul>
        </li>
      </ul> 
      

    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
        <li class="dropdown">
          <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Create <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/admin/create_artist">Create Artist</a></li>
            <li class="divider"></li>
            <li><a href="/artist/list">Create album</a></li>
            <li class="divider"></li>
            <li><a href="/album/list">Create song</a></li>
          </ul>
        </li>
        </sec:authorize>
      </ul> 
      
      
     <%--  <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> --%>
      
      
      <ul class="nav navbar-nav navbar-right" style="width: 300px;">
			<sec:authorize access="!isAuthenticated()">
		            <li><a href="/login">Login</a></li>
		            <li class="divider"></li>
		            <li><a href="/register">Register</a></li>		
		     </sec:authorize>
		     
		     <sec:authorize access="isAuthenticated()">
		     		<sec:authentication property="principal.username" var="username"/>
	     			<li><a href="/user">${username}</a></li>

					<c:url var="logoutUrl" value="/logout" />
					<form:form action="${logoutUrl}" method="post" cssStyle="padding-top: 7px;">
						<li><input class="btn " type="submit" value="logout" /></li>
					</form:form>
			</sec:authorize>
      </ul>
    </div>
  </div>
</nav>

