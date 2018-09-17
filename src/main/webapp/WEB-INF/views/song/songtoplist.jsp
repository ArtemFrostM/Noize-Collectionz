<%@ include file="/WEB-INF/taglib.jsp"%>
<h5>Songs</h5>
<%-- <p>
	<c:forEach items="${songModel}" var="song">
		
		<c:forEach items="${song.artists}" var="artist">
			<a href="/artist/${artist.id}"> ${artist.name }</a>  --
			</c:forEach>
		<a href="/song/${song.id}"> ${song.name }</a> -- (album)
		<a href="/album/${song.album.id}">${song.album.title } <br></a>
	</c:forEach>
</p> --%>

<table class="table">
	<thead class="thead-dark">
		<tr>

			<th scope="col">Artist</th>
			<th scope="col">Song</th>
			<th scope="col">Album</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${songModel}" var="song">
			<tr>
				<td><c:forEach items="${song.artists}" var="artist">
						<a href="/artist/${artist.id}"> ${artist.name }</a>
					</c:forEach></td>
				<td><a href="/song/${song.id}"> ${song.name }</a></td>
				<td><a href="/album/${song.album.id}">${song.album.title }
				</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>