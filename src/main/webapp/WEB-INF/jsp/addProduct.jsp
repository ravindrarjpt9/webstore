<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
		<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">logout</a>  
			<div class="container">
				<h1><spring:message code="products"></spring:message></h1>
				<p><spring:message code="AddProducts"></spring:message></p>
			</div>
		</div>
	</section>

	<section class="container">
		<form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">

			<fieldset>
				<legend>Add new product</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code="addProduct.form.name"></spring:message></label>
					<div class="col-lg-10">
						<form:input path="name" id="name" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit
						Price</label>
					<div class="col-lg-10">
						<form:input path="unitPrice" id="unitPrice" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea path="description" id="description" rows="2" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
					<div class="col-lg-10">
						<form:input path="manufacturer" id="manufacturer"
							name="manufacturer" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
					<div class="col-lg-10">
						<form:input path="category" id="category" name="category"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Unit
						In Stock</label>
					<div class="col-lg-10">
						<form:input path="unitsInStock" id="unitsInStock"
							name="unitsInStock" class="form:input-large" />
					</div>
				</div>


				

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Condition</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						New
						<form:radiobutton path="condition" value="Old" />
						Old
						<form:radiobutton path="condition" value="Refurbished" />
						Refurbished
					</div>
				</div>

				<div class="form-group">
				  <label class="control-label col-lg-2" for="productImage"><spring:message code="addProdcut.form.productImage.label"/></label>
				  <div class="col-lg-10">
				    <form:input id="productImage" path="productImage"type="file" class="form:input-large" />
				  </div>
			</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>
				</div>
			</fieldset>

		</form:form>
	</section>
</body>
</html>
