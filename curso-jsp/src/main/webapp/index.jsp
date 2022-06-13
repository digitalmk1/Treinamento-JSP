<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso JSP</title>
</head>
<body>
	<h1>BEM VINDO AO PROJETO JSP AGORA VAMOS PROGRAMAR DE VERDADE</h1>

	<!-- <TR> LinhA 
        <TD> Celula
    -->


	<form action="serveletLogin" method="Post">
		<table>
			<tr>
			   <td><label>Login: </label></td>
				<td><input name="login" type="text"></td>
			</tr>

			<tr>
			    <td><label>Senha: </label>
				<td><input name="senha" type="password"></td>
			</tr>
			<tr>
			<td> <!-- Espaço no botao salvar -->
			
		     <td><input type="Submit" value="Enviar"></td>
			
			</tr>
		</table>

	</form>
	<h4>${msg}</h4>
</body>
</html>