<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create ARTIST</h3>
					<form:form  method="POST" action="/admin/create_artist" modelAttribute="artistModel" enctype="multipart/form-data">
						<div class="form-group">
						
						
						
						
						
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
						<label class="control-label">Artist name</label>
							<form:input path="name" cssClass="form-control" title="First Name" />
							
							<label class="control-label">Description</label>
							<form:input path="description" cssClass="form-control"  />
							
							<label class="control-label">Artist image</label>
							<form:input path="file" type="file" cssClass="form-control"  />
						
							 <label class="control-label">genre</label>
							<form:select path="genre" cssClass="form-control">
								<c:forEach items="${genres}" var="genre">
									<form:option value="${genre }">${genre}</form:option>
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