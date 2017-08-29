<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<form action="/MyLogin/CadastrarUsuario" method="post">
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" id="nome" name="nome" value=""></td>
		</tr>
		<tr>
			<td>CPF:</td>
			<td><input type="text" id="cpf" name="cpf" value=""></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" id="email" name="email" value=""></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" id="senha" name="senha" value=""></td>
		</tr>
		<tr>
			<td><input type="submit" value="Cadastrar"></td>
			<td><input type="reset" value="Limpar"></td>
		</tr>
	</table>
	<hr>
</form>
</body>
</html>