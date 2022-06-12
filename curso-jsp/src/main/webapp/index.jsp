<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso JSP</title>
</head>
<body>
<h1> BEM VINDO AO PROJETO JSP AGORA VAMOS PROGRAMAR DE VERDADE</h1>
    <% out.print("Seu sucessor garantido 0"); 	%>
    <form action="serveletLogin" method="Post">
    
    <input name="Login" type="text">
    <input name="Senha" type="password">
    
    <input type="Submit" value="Enviar">
     
    </form>
    
</body>
</html>