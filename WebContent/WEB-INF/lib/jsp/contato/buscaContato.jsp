<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<h3 align="center"> Busca Contatos </h3>

<fieldset>
	<legend> Contatos encontrados </legend>
	<table>
	<thead>
    <tr>
      <th>ID</th>
      <th>NOME</th>
      <th>TIPO</th>
      <th>TELEFONE</th>      
    </tr>
  </thead>	
		<tbody>
	    	<c:forEach items="${contatoList}" var="contato">	     
		      	<c:forEach items="${contato.telefones}" var="telefone">
		      		<tr>
				      <td> ${contato.id} </td>  
				      <td> ${contato.nome} </td>
		      		  <td> ${telefone.tipo} </td>
					  <td> ${telefone.numero}  </td>
				   	</tr> 
		      	</c:forEach>      		             
		               
	    </c:forEach>
	  </tbody>
	</table>
</fieldset>


</body>
</html>