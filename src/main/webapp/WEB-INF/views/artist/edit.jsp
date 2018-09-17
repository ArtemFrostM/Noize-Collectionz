<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Edit ARTIST</h3>
					<form:form method="POST" action="/artist/${artistModel.id }/edit"
						modelAttribute="artistModel" enctype="multipart/form-data">
						<div class="form-group">

							<form:errors path="*" cssClass="error" />
						</div>
						<div class="form-group">
							<label class="control-label">Artist name</label>
							<form:input path="name" cssClass="form-control"
								title="First Name" />

							<label class="control-label">Description</label>
							<form:input path="description" cssClass="form-control" />


							<label class="control-label">Genre</label>
							<form:select path="genre" cssClass="form-control">
								<c:forEach items="${genreModel}" var="genre">
									<form:option value="${genre }">${genre}</form:option>
								</c:forEach>
							</form:select>

							<%-- <div class="form-group">
								<label for="exampleSelect2">Album</label>
								<form:select multiple="true" path="albums"
									items="${albumsModel}" itemLabel="title"
									cssClass="form-control" id="exampleSelect2">
								</form:select>
							</div> --%>

							<div class="form-group">
								<label for="exampleSelect2">Song</label>
								<form:select multiple="true" path="songs" items="${songsModel}"
									itemLabel="name" cssClass="form-control" id="exampleSelect2">
								</form:select>
							</div>

						</div>
						<div class="form-group">
							<span class="input-group-btn"> <input type="submit"
								class="btn btn-primary" value="Edit">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>