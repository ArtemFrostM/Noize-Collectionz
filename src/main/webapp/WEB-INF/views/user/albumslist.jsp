<%@ include file="/WEB-INF/taglib.jsp"%>
<div>
	Your albums library:
	<%-- <p>
		<c:forEach items="${albumModel}" var="album">

			<a href="/album/${album.id}"> ${album.title } </a>
			(<a href="/artist/${album.artist.id}">${album.artist.name }</a>)<br>
		</c:forEach>
	</p> --%>
</div>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Album</th>
			<th scope="col">Artist</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${albumModel}" var="album">
			<tr>
				<td><a href="/album/${album.id}"> ${album.title } </a></td>
				<td><a href="/artist/${album.artist.id}">${album.artist.name }</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

