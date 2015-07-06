<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar novo contato</title>
</head>
<body>
	<h2 align="center"> Cadastrar contato</h2>

<form action="inserirContato">
<fieldset>
<legend> Dados do novo contato </legend>
	<table">
		<tr>
			<td> Nome: <input type="text" name="contato.nome"> </td>
		</tr>	
	</table>
</fieldset>


<fieldset>
<legend> Telefones</legend>
	<table>
		<tr> 
			<td>Tipo de telefone: <select name="telefones[0].tipo">
								<option>
								<option value="Residencial">Residencial
								<option value="Comercial">Comercial
								<option value="Fax">Fax
								<option value="Celular">Celular	
								<option value="Outro">Outro													
								</option>								
								</select>
			 Numero: <input type:="text" name ="telefones[0].numero"> </td>
		</tr>	
				
	</table>
	<table>
		<tr> 
			<td>Tipo de telefone: <select name="telefones[1].tipo">
								<option>
								<option value="Residencial">Residencial
								<option value="Comercial">Comercial
								<option value="Fax">Fax
								<option value="Celular">Celular	
								<option value="Outro">Outro													
								</option>								
								</select>
			 Numero: <input type:="text" name ="telefones[1].numero"> </td>
		</tr>	
				
	</table>
	<table>
		<tr> 
			<td>Tipo de telefone: <select name="telefones[2].tipo">
								<option>
								<option value="Residencial">Residencial
								<option value="Comercial">Comercial
								<option value="Fax">Fax
								<option value="Celular">Celular	
								<option value="Outro">Outro													
								</option>								
								</select>
			 Numero: <input type:="text" name ="telefones[2].numero"> </td>
		</tr>	
				
	</table>	
</fieldset>

<table align="center">
	<tr>
		<td>
		<input type="SUBMIT" value="salvar">
		</td>
	</tr>
</table>

</form>
</body>
</html>