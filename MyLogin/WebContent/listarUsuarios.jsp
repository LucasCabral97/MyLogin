<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
<h1>Lista de Clientes</h1>
<br>
<form action="/MyLogin/Listar" method="post">
<c:choose>
         <c:when test="${not empty listaClientes}">
           <table  class="table table-striped">
              <tr>
                 <th>#</th>
                 <th>Nome</th>
                 <th>CPF</th>
                 <th>Email</th>
                 <th>Senha</th>
                 <th>Ação</th>
               </tr>
               <c:forEach var="cliente" items="${listaClientes}">
	               <tr>
	               	 <td>
	                	<a href="/MyLogin/ObterClienteServlet?id=${cliente.id}">${cliente.id}</a>
	                 </td>
	                 <td>${cliente.nome}</td>
	                 <td>${cliente.cpf}</td>
	                 <td>${cliente.email}</td>
	                 <td>${cliente.senha}</td>
	                 
	               </tr>
               </c:forEach>
             	<tr>
					<td><a href="http://localhost:8080/MyLogin/cadastro.jsp"><button type="button" >Cadastrar</button></a></td>
					<td><a href="http://localhost:8080/MyLogin/Listar"><button type="button" >Listar</button></a></td>
				</tr>               
           </table>  
         </c:when>               
         <c:otherwise>
            <br>           
            <div class="alert alert-info">
                  No people found matching your search criteria
             </div>
         </c:otherwise>
 </c:choose>

 
 </form>
</body>
</html>