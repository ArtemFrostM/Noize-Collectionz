<%@ include file="/WEB-INF/taglib.jsp" %>
<div class="list-group">

	<h4 class="list-group-item-heading">YOUR PROFILE</h4>
	<p class="list-group-item-text">
		<img alt="Profile" src="data:image/png; base64, ${imageSrc }"
			width="300px">
	</p>
	<p class="list-group-item-text">
		<a href="/user/editImg/${userProfile.id}"
			class="btn btn-warning">Edit user image</a>
	</p>
	<br>
	<h4 class="list-group-item-heading">User name</h4>
	<p class="list-group-item-text">${userProfile.firstName }
		${userProfile.lastName }</p>
	<br>
	<h4 class="list-group-item-heading">Nickname</h4>
	<p class="list-group-item-text">${userProfile.nickname }</p>
	<br>
	<h4 class="list-group-item-heading">Age</h4>
	<p class="list-group-item-text">${userProfile.age }</p>
	<br>
	<h4 class="list-group-item-heading">Email</h4>
	<p class="list-group-item-text">${userProfile.email }</p>
<br>

	<p class="list-group-item-text">
		<a href="/user/edit/${userProfile.id}"
			class="btn btn-warning ">Edit user profile</a>
	</p>
	
	<br>
	
	
	<p class="list-group-item-text">
		<a href="/user/artists_collection" class="btn btn-primary">Show my artist library</a>
	</p>
	
	<p class="list-group-item-text">
		<a href="/user/add_artist" class="btn btn-primary">Add artist to
			my Collection</a>
	</p>
	<br>
	
	
	<p class="list-group-item-text">
		<a href="/user/albums_collection" class="btn btn-primary">Show my albums library</a>
	</p>
	
	<p class="list-group-item-text">
		<a href="/user/add_album" class="btn btn-primary">Add album to my
			Collection</a>
	</p>
	<br>
	
	<p class="list-group-item-text">
		<a href="/user/songs_collection" class="btn btn-primary">Show my songs library</a>
	</p>

	<p class="list-group-item-text">
		<a href="/user/add_song" class="btn btn-primary">Add song to my
			Collection</a>
	</p>
	
	
</div>
