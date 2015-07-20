<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Cadastro de Aluno</title>
</head>
<body>
	<form method="POST" action="../../novo-usuario">
		Nome: <input name="nome" type="text" /><br>
		Usuário: <input	name="usuario" type="text" /><br>
		Senha: <input name="senha" type="password" /><br>
		<input type="submit" value=">" />
		<input name="action" type="hidden" value="register" />
	</form>
</body>
</html>