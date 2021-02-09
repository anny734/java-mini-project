<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category detail page</title>
<!-- <link href="webjars/bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
<script defer src="webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
<script defer src="webjars/jquery/3.5.1/jquery.js"></script>  --> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>  
</head>
<body>
<!-- here category name -->
	<% int n=0; %>
	<h2 class="category">Category name</h2> 
	<c:forEach var="u" items="${course}">
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="${u.course_image}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${u.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/start-course">
	        	<input type="hidden" value="${u.id}" name="course_id">
	        	<input type="submit" value="Enroll now" class="btn btn-primary mycard">
	        </form>
	       <%--  <a href="<%=request.getContextPath()%>/UserController/start-course" class="btn btn-primary mycard">Enroll now</a> --%>
	        <%-- <c:if test=""></c:if> --%>
	        <%-- <% session.setAttribute("${u.name}", "+${u.id}+"); %>  --%>
	      <%-- 	<c:set var="<%=n%>" value="${u.id}" scope="session" />  --%>
			<c:set var="course_name" value="${u.name}" scope="session" />
	      </div>
	    </div>
	</c:forEach>
	
</body>
</html>