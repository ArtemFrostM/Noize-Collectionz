<%@ include file="/WEB-INF/taglib.jsp" %>
<%-- <div>
Your artists library:
<p>
		<c:forEach items="${artistModel}" var="album"> -
			<a href="/artist/${album.id}">${album.name } <br></a>
		</c:forEach>
	</p>
	</div>
	 --%>


<table class="table">
  <thead class="thead-light">
  
    <tr>
      <th scope="col">Artists</th>

    </tr>
   
  </thead>
  <tbody>
  <c:forEach items="${artistModel}" var="album">
    <tr>
      <th scope="row"><a href="/artist/${album.id}">${album.name } <br></a></th>
    </tr>
   </c:forEach>
  </tbody>
</table>