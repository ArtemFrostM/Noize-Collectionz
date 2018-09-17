<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Search result:</h3>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div>
				<ul>
				<c:forEach items="${albumsModel}" var="lll">
				<li>	<a href="/album/${lll.id }">${lll.title } </a> 
					(<a href="/artist/${lll.artist.id }">${lll.artist.name }  </a>)</li> <br>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>