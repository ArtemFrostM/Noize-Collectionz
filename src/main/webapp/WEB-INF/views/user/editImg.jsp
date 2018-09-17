<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form modelAttribute="editImgModel" method="POST" action="/user/editImg/${editImgModel.id }" enctype="multipart/form-data">
	<form:input path="file" type="file"/>
	
	<input type="submit" class="btn btn-primary btn-block" value="Edit">
</form:form>