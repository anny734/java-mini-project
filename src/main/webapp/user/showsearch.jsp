<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="landing.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Landing Page</title>
<style>
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: 1px solid #ccc;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}
@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  
}
</style>
</head>
<body>

<div class="topnav">
  <div class="search-container">
    <form action="<%=request.getContextPath()%>/UserController/search">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>
 <c:if test = "${searchresult == 0}">
 	<h3>No categories or courses found</h3>
 	<a href="<%=request.getContextPath()%>/UserController/main">Go Back</a>
 </c:if> 

 	<c:forEach var="s" items="${searchedcategories}">
 		<h2>Available categories</h2>
			<!-- card -->
		    <div class="card" style="width:400px">
		      <img class="card-img-top" src="${s.category_url}" alt="Card image" style="width:100%">
		      <div class="card-body">
		        <h4 class="card-title"><c:out value="${s.name}"></c:out></h4>
		        <form action="<%=request.getContextPath()%>/UserController/show-courses" method="post">
					<input type="hidden" value="${s.id}" name="category_id">
					<input type="hidden" value="${s.name}" name="category_name">
					<input type="submit" value="Explore more" class="btn btn-primary">
				</form>
		      </div>
		    </div>
	</c:forEach>
<c:if test="${searchedcourses != null}"><h2>Available courses</h2></c:if>
 <c:forEach var="u" items="${enrolledcoursesearch}">
 	
 	
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="${u.course_image}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${u.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/continue-course" method="post">
	        	<input type="hidden" value="${u.id}" name="course_id">
	        	<input type="hidden" value="${u.name}" name="course_name">
	        	<input type="submit" value="Continue" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
	</c:forEach>
	<c:forEach var="n" items="${newcoursesearch}">
	
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="${n.course_image}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${n.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${n.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/start-course" method="post">
	        	<input type="hidden" value="${n.id}" name="course_id">
	        	<input type="hidden" value="${n.name}" name="course_name">
	        	<input type="submit" value="Enroll Now" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
	</c:forEach>

</body>
</html>