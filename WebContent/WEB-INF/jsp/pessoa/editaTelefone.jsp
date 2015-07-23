<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="alteraTelefone">
  <fieldset>
    <legend>Editar telefones de um contato</legend>

	<c:forEach items="${numeroTelefoneList}" var="telefone">
    		      
	    <input type="hidden" name="telefone.pessoa.id" 
	      value="${telefone.pessoa.id }" />
	    
	    <input type="hidden" name="telefone.idTelefone" 
	      value="${telefone.idTelefone }" />
	    
	    
	    <label for="rua">DDD:</label>
	    <input id="ddd" type="text" name="telefone.ddd" value="${telefone.ddd }"/>
	  	
	  	<label for="rua">Numero:</label>  
    	<input id="numero" type="text" name="telefone.numero" value="${telefone.numero }"/>
      		      
	    <button type="submit">Confirmar</button>
	    <br>
	</c:forEach>
  </fieldset>
</form>           
    