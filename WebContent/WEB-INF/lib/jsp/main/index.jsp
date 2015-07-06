<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>====== Agenda ======</title>
	</head>
		<body>
		
		
<table align="center">
<tr>
<td>
	<h2 align="center"> Menu </h2>
</td>
</tr>
	<tr>
	<td><h3><a href="../contato/cadastra" > Cadastrar novo contato </a></h3></td>
	</tr>
	<tr>
	<td><h3><a href="../contato/seleciona"> Atualizar telefone de contato </a></h3></td>
	</tr>
	<tr>
	<td><h3><a href="../contato/remover"> Remover contato </a></h3></td>
	</tr>
	<tr>
	<tr>
	<td><h3><a href="../contato/ocultar"> Ocultar contato </a></h3></td>
	</tr>
	<tr>
	<td><h3><a href="../contato/lista"> Listar Contatos Ativos </a></h3></td>
	</tr>
	<tr>
	<td><h3><a href="../contato/listaBanco"> Listar todos contatos do Banco </a></h3></td>
	</tr>
</table>

<form action="../contato/buscaContato">
<table align="center">
	<h3 align="center"> Buscar Contato </h3>
	<tr>
	<td><input type="text" name="nome"> Nome do contato</td>
	<td><input type="submit" value="buscar">
	</tr>
</table>
</form>


		
</body>
</html>