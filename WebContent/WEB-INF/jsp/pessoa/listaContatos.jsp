<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <title>Agenda Online</title>
  </head>
  <body>
   <table>
  <thead>
    <tr>
      <th>Nome</th>
      <th>ID</th>
      <th>Endereco</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${pessoaList}" var="pessoa">
      <tr>
        <td>${pessoa.nome }</td>
        <td>${pessoa.id }</td>
        <td>${pessoa.endereco.rua}</td>
      </tr>          
    </c:forEach>
  </tbody>
</table>
    <p><i>@JensenWeb</i></p>
  </body>
</html>