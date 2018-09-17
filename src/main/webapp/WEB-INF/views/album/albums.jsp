<%@ include file="/WEB-INF/taglib.jsp"%>

<h1 class="text-center">Albums</h1>

<form action="/album/list/search" method="get">
	<input type="text" name="search" placeholder="Enter Title">
	<input type="submit" value="Search">
</form>
<br>
<%-- 

<ul>


	<c:forEach items="${albumsModel}" var="albums">
		<li><img alt="albums"
			src="data:image/png;base64,${albums.albumImage }" width="250px" lang="400px">
			|<a href="/album/${albums.id }"> ${albums.title } </a></li> <br>
	</c:forEach>

</ul> --%>
<div id="myTable">
<c:forEach items="${albumsModel}" var="albums">
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div align="center">
				
		<img alt="albums"
			src="data:image/png;base64,${albums.albumImage }" width="200px" >
			<a href="/album/${albums.id }"><h2> ${albums.title } </h2> </a> <br>
	
			</div>

		</div>
	</div>
</div>
</c:forEach>
</div>

<div class="col-md-12 text-center">
		<ul class="pagination pagination-lg pager" id="myPager">
		</ul>
	</div>