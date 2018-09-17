<%@ include file="/WEB-INF/taglib.jsp"%>

<h1 class="text-center">TOP ALBUMS</h1>


<%-- <ul>


	<c:forEach items="${albumsModel}" var="albums">
		<li><img alt="albums"
			src="data:image/png;base64, ${albums.albumImage }" width="250px" lang="400px">
			|<a href="/album/${albums.id }"> ${albums.title } </a></li> <br>
	</c:forEach>

</ul> --%>

<c:forEach items="${albumsModel}" var="albums">
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div align="center">
				
		<img alt="albums"
			src="data:image/png;base64,${albums.albumImage }" width="200px" class="img-circle img-responsive">
			<a href="/album/${albums.id }"><h2> ${albums.title } </h2> </a> <br>
	
			</div>

		</div>
	</div>
</div>
</c:forEach>