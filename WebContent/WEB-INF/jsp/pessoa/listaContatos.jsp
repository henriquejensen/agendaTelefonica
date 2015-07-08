<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <title>Agenda Online</title>
  </head>
  <body>
    <h1>Nomes cadastrados</h1>
    <c:forEach var="contato" items="${stringList}">
    	<td> ${contato} </td>
    	<br>
    </c:forEach>
    <br>
    <p><i>@JensenWeb</i></p>
  </body>
</html>