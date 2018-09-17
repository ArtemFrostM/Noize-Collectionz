<%@ include file="/WEB-INF/taglib.jsp"%>
<div >
	<h1 class="text-center">Artists</h1>
	<form action="/artist/list/search" method="get">
		<input type="text" name="search" placeholder="Enter Title"> <input
			type="submit" value="Search">
	</form>
	<br>
	<div id="myTable">
		<c:forEach items="${artistsModel}" var="artists">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div align="center">

							<img alt="artists"
								src="data:image/png;base64, ${artists.artistImage }"
								width="200px" class="img-circle img-responsive"> <a
								href="/artist/${artists.id }"><h2>${artists.name }</h2></a>

						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	

</div>

<div class="col-md-12 text-center">
		<ul class="pagination pagination-lg pager" id="myPager">
		</ul>
	</div>


<%-- <tbody id="myTable">



	<c:forEach items="${artistsModel}" var="artists">
		<img alt="artists"
			src="data:image/png;base64, ${artists.artistImage }" width="250px" lang="400px">
			|<a href="/artist/${artists.id }"> ${artists.name } </a> <br>
	</c:forEach>


</tbody> --%>



