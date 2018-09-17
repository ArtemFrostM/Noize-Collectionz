<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>EDIT PROFILE</h3>
					<form:form action="/user/edit/${editModel.id}"
						modelAttribute="editModel" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">





							<form:errors path="*" cssClass="error" />
						</div>
						<div class="form-group">
							<label class="control-label">First Name</label>
							<form:input path="firstName" cssClass="form-control"
								title="First Name" />

							<label class="control-label">Last Name</label>
							<form:input path="lastName" cssClass="form-control"
								title="Last Name" />

							<label class="control-label">E-mail address</label>
							<form:input path="email" cssClass="form-control"
								title="E-mail address" disabled="true" />

							<label class="control-label">nickname</label>
							<form:input path="nickname" cssClass="form-control"
								title="Last Name" />


							<%-- <label class="control-label">age</label>
							<form:input path="age" cssClass="form-control" title="Last Name" /> --%>
							
							<label class="control-label">Age</label>
							<form:select path="age" cssClass="form-control">
								<c:forEach items="${yearsModel}" var="genre">
									<form:option value="${genre }">${genre}</form:option>
								</c:forEach>
							</form:select>

							<%-- <label class="control-label">Profile image</label>
							<form:input path="file" type="file" cssClass="form-control"
								title="Image" /> --%>


						</div>
						<div class="form-group">
							<span class="input-group-btn"> <input type="submit"
								class="btn btn-primary" value="EDIT">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>