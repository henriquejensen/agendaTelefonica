<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contatos</title>
</head>
<body>
	<h3> Atualizar dados do contato </h3>
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
        <td><a href="edita?id=${pessoa.id }"> Atualizar </a></td>
      </tr>          
    </c:forEach>
  </tbody>
 </table>
</body>
</html>