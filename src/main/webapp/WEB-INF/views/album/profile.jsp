<%@ include file="/WEB-INF/taglib.jsp"%>

<div class="list-group">

	<h6 class="list-group-item-heading">ALBUM PROFILE</h6>
	<p class="list-group-item-text">
		<img alt="Profile" src="data:image/png;base64, ${imageSrc}"
			width="300px">
	</p>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/album/${ss.id}/edit_image" class="btn btn-primary">Edit
				image</a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_USER')">
		<p class="list-group-item-text">
			<a href="/album/${ss.id}/add_follower" class="btn btn-primary">Add
				to my Collection</a>
		</p>
	</sec:authorize>
	<br>

	<h6 class="list-group-item-heading">Album title</h6>
	<p class="list-group-item-text">${ss.title }</p>
	<br>
	<h6 class="list-group-item-heading">Type</h6>
	<p class="list-group-item-text">${ss.albumType }</p>
	<br>
	<h6 class="list-group-item-heading">Year</h6>
	<p class="list-group-item-text">${ss.year }</p>
	<br>
	<h6 class="list-group-item-heading">Artist</h6>
	<p class="list-group-item-text">
		<a href="/artist/${ss.artist.id}">${ss.artist.name } <br></a>
	</p>
	<br>


	<h6 class="list-group-item-heading">Genre</h6>
	<p class="list-group-item-text">${ss.genre }</p>
	<br>

	<h6 class="list-group-item-heading">Songs:</h6>
	<p>

		<c:forEach items="${ss.songs}" var="song">
			<a href="/song/${song.id}">${song.name } <br></a>
		</c:forEach>

	</p>
	
	<br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/album/${ss.id}/add_song" class="btn btn-primary">Add
				song</a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/album/${ss.id}/edit" class="btn btn-primary">Edit</a>
		</p>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<p class="list-group-item-text">
			<a href="/album/${ss.id}/delete_album" class="btn btn-primary">Delete</a>
		</p>
	</sec:authorize>
	

</div>