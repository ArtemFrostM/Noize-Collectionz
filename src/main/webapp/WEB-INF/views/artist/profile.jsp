<%@ include file="/WEB-INF/taglib.jsp"%>
<div class="list-group">

	<h6 class="list-group-item-heading">ARTIST PROFILE</h6>
	<p class="list-group-item-text">
		<img alt="Profile" src="data:image/png;base64, ${imageSrc}"
			width="300px">
	</p>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/artist/${ss.id}/edit_image" class="btn btn-primary">Edit image
			</a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_USER')">
		<p class="list-group-item-text">
			<a href="/artist/${ss.id}/add_follower" class="btn btn-primary">Add
				to my Collection</a>
		</p>
	</sec:authorize>
	<br>
	<h6 class="list-group-item-heading">Artist name</h6>
	<p class="list-group-item-text">${ss.name }</p>
	<br>
	
	<h6 class="list-group-item-heading">Genre</h6>
	<p class="list-group-item-text">${ss.genre }</p>
	<br>
	<h6 class="list-group-item-heading">Description</h6>
	<p>${ss.description }</p>
	<br>
	<h6 class="list-group-item-heading">Albums</h6>
	<p>
		<c:forEach items="${ss.albums}" var="album">
			<a href="/album/${album.id}">${album.title } <br></a>
		</c:forEach>
	</p>
	<br>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/artist/${ss.id}/add_album" class="btn btn-primary">Add
				album</a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/artist/${ss.id}/edit" class="btn btn-primary">Edit </a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a
				href="${pageContext.request.contextPath}/artist/${ss.id}/delete_artist"
				class="btn btn-primary">Delete </a>
		</p>
	</sec:authorize>


</div>