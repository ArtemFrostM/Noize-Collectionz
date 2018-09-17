<%@ include file="/WEB-INF/taglib.jsp"%>

<div class="list-group">

	<h6 class="list-group-item-heading">SONG PROFILE</h6>
	<p class="list-group-item-text">
		<img alt="Profile" src="data:image/png;base64, ${imageSrc}"
			width="300px">
	</p>
	<sec:authorize access="hasAnyRole('ROLE_USER')">
		<p class="list-group-item-text">
			<a href="/song/${ss.id}/add_follower" class="btn btn-primary">Add
				to my Collection</a>
		</p>
	</sec:authorize>
	<br>
	<h6 class="list-group-item-heading">Song name</h6>
	<p class="list-group-item-text">${ss.name }</p>
	<br>
	<h6 class="list-group-item-heading">Artist</h6>
	<p>
		<c:forEach items="${ss.artists}" var="song">
			<a href="/artist/${song.id}">${song.name } <br></a>
		</c:forEach>
	</p>
	<br>
	<h6 class="list-group-item-heading">Album</h6>
	<p class="list-group-item-text">
		<a href="/album/${ss.album.id}">${ss.album.title } <br></a>
	</p>
	<br>
	<h6 class="list-group-item-heading">Year</h6>
	<p class="list-group-item-text">${ss.album.year }</p>
	<br>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/song/${ss.id}/edit" class="btn btn-primary">Edit </a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/song/${ss.id}/delete_song" class="btn btn-primary">Delete
			</a>
		</p>
	</sec:authorize>
</div>