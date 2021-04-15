<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do List</title>
</head>
<body>
	<h1>New To Do List</h1>

	<form action="/ObjectToDoList/todo_list" method="get">
		<label>Insert task </label> <input type="text" name="insertTask">
		<input type="submit" value="Add">
	</form>
	
	
	<div id=list>
		<h3>List</h3>
		<div>
			<c:forEach items="${listTodo}" var="todo">
				<p>${todo.id} | ${todo.name} | <input type="checkbox" value="done"> | <a href="/ObjectToDoList/delete?deleteId=${todo.id}">Delete</a></p>
			</c:forEach>
		</div>
	</div>


	

</body>
</html>