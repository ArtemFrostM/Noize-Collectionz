<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create SONG</h3>
					<form:form  method="POST" action="/album/${songModel.album.id}/add_song" modelAttribute="songModel" enctype="multipart/form-data">
						<div class="form-group">
					
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
						<label class="control-label">Song name</label>
							<form:input path="name" cssClass="form-control" title="title" />
							
							<div class="form-group">
				<label for="exampleSelect2">Artist</label>
				<form:select multiple="true" path="artists" items="${artistModel}" itemLabel="name"  cssClass="form-control" id="exampleSelect2">
				</form:select>
			</div>
						
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