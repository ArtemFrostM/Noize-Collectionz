<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create ALBUM</h3>
					<form:form  method="POST" action="/admin/create_album" modelAttribute="albumModel" enctype="multipart/form-data">
						<div class="form-group">
						
						
						
						
						
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
						<label class="control-label">Album name</label>
							<form:input path="title" cssClass="form-control" title="title" />
							
							<label class="control-label">Year</label>
							<form:input path="year" cssClass="form-control"  />
						
  							<%-- <label class="control-label">model year</label>
							<form:input path="modelYear" cssClass="form-control"  />
							
							<label class="control-label">price</label>
							<form:input path="price" cssClass="form-control"  /> --%>
							
							<label class="control-label">Album image</label>
							<form:input path="file" type="file" cssClass="form-control"  />
							
						<%-- 	< <form:hidden path="user"/> --%>
							<%-- <label>artist</label>
 						 <form:select path="artist" cssClass="form-control">							
 						 <c:forEach items="${artistsN}" var="artistsN">
									<form:option value="${artistsN}">${artistsN}</form:option>
								</c:forEach>
							</form:select>  --%>
							
							<label for="exampleSelect2">Artist</label>
				<form:select multiple="true" path="artist" items="${artistsN}" itemLabel="id"  cssClass="form-control" id="exampleSelect2">
				</form:select>
			
						
							
							 <label class="control-label">genre</label>
							<form:select path="genre" cssClass="form-control">
								<c:forEach items="${genresA}" var="genre">
									<form:option value="${genre.name }">${genre.name}</form:option>
								</c:forEach>
							</form:select>
							
						
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Add">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>