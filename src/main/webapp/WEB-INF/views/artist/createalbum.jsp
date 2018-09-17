<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create ALBUM</h3>
					<form:form  method="POST" action="/artist/${albumModel.artist.id}/add_album" modelAttribute="albumModel" enctype="multipart/form-data">
						<div class="form-group">
					
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
						<label class="control-label">Album name</label>
							<form:input path="title" cssClass="form-control" title="title" />
							
							<%-- <label class="control-label">Year</label>
							<form:input path="year" cssClass="form-control"  /> --%>
							
							<label class="control-label">Album image</label>
							<form:input path="file" type="file" cssClass="form-control"  />
							
							 <label class="control-label">Year</label>
							<form:select path="year" cssClass="form-control">
								<c:forEach items="${yearsModel}" var="genre">
									<form:option value="${genre }">${genre}</form:option>
								</c:forEach>
							</form:select>
							 <label class="control-label">Genre</label>
							<form:select path="genre" cssClass="form-control">
								<c:forEach items="${ genresA}" var="genre">
									<form:option value="${genre }">${genre}</form:option>
								</c:forEach>
							</form:select>
							
							<label class="control-label">Type</label>
							<form:select path="albumType" cssClass="form-control">
								<c:forEach items="${alType}" var="alType">
									<form:option value="${alType }">${alType}</form:option>
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