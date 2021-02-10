<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="landing.css">
<script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> -->
<title>Landing Page</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/UserController/show-courses" method="post">
	  <input type="hidden" value=1 name="category_id">
	  <input type="hidden" value="photography" name="category_name">
	  <input type="submit" value="View all courses in this category" class="btn btn-primary">
</form> 
<%-- <c:forEach var="u" items="${newcourse}">
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="${u.course_image}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${u.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/continue-course" method="post">
	        	<input type="hidden" value="${u.id}" name="course_id">
	        	<input type="hidden" value="${u.name}" name="course_name">
	        	<input type="submit" value="Enroll Now" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
</c:forEach> --%>
<%-- <a href="<%=request.getContextPath()%>/UserController/show-courses">View all courses in this category</a> --%>

<%-- <a href="<c:url value="/UserController/show-courses"/>">View Category details</a> --%>
    
</body>
</html>