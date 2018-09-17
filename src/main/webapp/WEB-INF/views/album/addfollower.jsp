

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">

					<form:form action="/album/${albumModel.id}/add_follower"
						modelAttribute="addModel" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">

							${albumModel.title} added!

							<p class="list-group-item-text">
								<a href="/album/${albumModel.id}" class="btn btn-primary">Ok</a>
							</p>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>