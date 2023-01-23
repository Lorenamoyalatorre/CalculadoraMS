<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Calculadora</title>
</head>
<body>
	<div class="container m-3">
		<h1>Calculadora</h1>
		<form action="/" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Dato 1</label> <input
					type="text" class="form-control" id="a" name="a" value="${param.a }">
			</div>
			<div class="mb-3">
				<select class="form-select" aria-label="Operacion" name="operacion">
					<option  ${param.operacion == "+"?"SELECTED":"" }>+</option>
					<option ${param.operacion == "-"?"SELECTED":"" }>-</option>
					<option ${param.operacion == "*"?"SELECTED":"" }>*</option>
					<option ${param.operacion == "/"?"SELECTED":"" }>/</option>
					<option ${param.operacion == "**"?"SELECTED":"" }>**</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Dato 2</label> <input
					type="text" class="form-control" id="b" name="b"  value="${param.b }">
			</div>
			<button type="submit" class="btn btn-primary">Calcular</button>
			
		</form>
	</div>
	<c:if test="${! empty resp }">
		<div class="row m-3">
		<h3>Resultado : <fmt:formatNumber value="${resp }"></fmt:formatNumber> </h3>
	</c:if>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>