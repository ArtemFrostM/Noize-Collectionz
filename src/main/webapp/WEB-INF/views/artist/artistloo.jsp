<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Search result:</h3>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div>
				<ul>
				<c:forEach items="${artistsModel}" var="lll">
				<li>	<a href="/artist/${lll.id }">${lll.name } </a> 
					
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>