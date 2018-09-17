<%@ include file="/WEB-INF/taglib.jsp"%>

<h1 class="text-center">RAP Artists</h1>


<%-- <ul>


	 <c:forEach items="${artistsRapModel}" var="artists">
		<li><img alt="artists"
			src="data:image/png;base64, ${artists.artistImage }" width="250px" lang="400px">
			|<a href="/artist/${artists.id }"> ${artists.name } </a></li> <br>
	</c:forEach> 


</ul> --%>

<c:forEach items="${artistsRapModel}" var="artists">
<div class="panel panel-default" id="myTable">
	<div class="panel-body">
		<div class="row">
			<div align="center">
				
		<img alt="artists"
			src="data:image/png;base64, ${artists.artistImage }" width="200px" class="img-circle img-responsive">
			<a href="/artist/${artists.id }"><h2> ${artists.name } </h2></a>
	
			</div>

		</div>
	</div>
</div>
</c:forEach>