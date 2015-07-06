<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar</title>
</head>
<body>
<h2 align="center"> Atualizar contato</h2>

<form action="update">
<fieldset>
<legend> Dados do novo contato </legend>
	<table>
		<tr>
			<td> ID: <input type="text" name="contato.id" value="${contato.id}" > </td>
		</tr>
		<tr>			
			<td> Nome: <input type="text" name="contato.nome" value="${contato.nome}"> </td>
		</tr>	
	</table>
</fieldset>


<fieldset>
<legend> Telefones</legend>
	<table>		
		<tr> 
		<td> ID: <input type="text" name="contato.telefones[0].id" value="${contato.telefones[0].id}"></td>
		<td> Tipo de telefone: <input type="text" name="contato.telefones[0].tipo" value="${contato.telefones[0].tipo}"></td> 
		<td> Numero:  <input type="text" name="contato.telefones[0].numero" value="${contato.telefones[0].numero}"> </td>
		</tr>		
	</table>	


	<table>		
		<tr> 
		<td> ID: <input type="text" name="contato.telefones[1].id" value="${contato.telefones[1].id}"></td>
		<td> Tipo de telefone: <input type="text" name="contato.telefones[1].tipo" value="${contato.telefones[1].tipo}"></td> 
		<td> Numero:  <input type="text" name="contato.telefones[1].numero" value="${contato.telefones[1].numero}"> </td>
		</tr>		
	</table>	

	<table>		
		<tr> 
		<td> ID: <input type="text" name="contato.telefones[2].id" value="${contato.telefones[2].id}"></td>
		<td> Tipo de telefone: <input type="text" name="contato.telefones[2].tipo" value="${contato.telefones[2].tipo}"></td> 
		<td> Numero:  <input type="text" name="contato.telefones[2].numero" value="${contato.telefones[2].numero}"> </td>
		</tr>		
	</table>	

</fieldset>

<table align="center">
	<tr>
		<td>
		<input type="SUBMIT" value="Atualizar">
		</td>
	</tr>
</table>
</form>

</body>
</html>