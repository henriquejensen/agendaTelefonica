<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <!-- Taglib -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Agenda - Selecionar contato </title>
</head>
<body>

<h3 align="center"> Selecione contato para atualizar</h3>

<form action="atualizar">
<fieldset>
	<legend> Contatos </legend>
	<table>
	<thead>
    <tr>
    	<th></th>
      <th>ID</th>
      <th>NOME</th>
      <th>Telefone(s)</th>
      
    </tr>
  	</thead>	
		<tbody>
	    	<c:forEach items="${contatoList}" var="contato">
		      <tr>
		      <td> <input type="radio" name="id" value="${contato.id}"></td>
		      <td> ${contato.id} </td>  
		      <td> ${contato.nome} </td>
		      <td> 
		      	<c:forEach items="${contato.telefones}" var="telefone">
		      		 ${telefone.tipo} - ${telefone.numero}  <br>     		
		      	</c:forEach>      
		      </td>       
		      </tr>          
	    </c:forEach>
	  </tbody>
	</table>
</fieldset>
<table align="center">
	<tr>
		<td>
		<input type="SUBMIT" value="Selecionar">
		</td>
	</tr>
</table>
</form>

</body>
</html>