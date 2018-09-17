<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>EDIT ALBUM IMAGE</h3>
					<form:form method="POST"
						action="/artist/${artistModel.id }/edit_image"
						modelAttribute="artistModel" enctype="multipart/form-data">
						<div class="form-group">

							<form:errors path="*" cssClass="error" />
						</div>
						<div class="form-group">


							<label class="control-label">Artist image</label>
							<form:input path="file" type="file" cssClass="form-control" />

						</div>
						<br>
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