<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*, dao.*, util.*, java.sql.*, java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>..:: Lista de Filmes ::..</title>
	</head>
	<body>
		<%
			Connection bd = ConnectionFactory.getConnection();
			FilmeDAO dao = new FilmeDAO(bd);
		%>
		<a href="index.html">Página principal</a>
		<h1>Listagem de Filmes</h1>
		<table border="1">
			<tr>
				<td>Código</td>
				<td>Nome</td>
				<td>Valor</td>			
			</tr>
			<% for(Filme f : dao.buscarTodos()){ %>
			<tr>
				<td><%= f.getCodigo() %></td>
				<td><%= f.getNome() %></td>
				<td><%= String.format("%, 7.2f", f.getValor()) %></td>
			</tr>
			<% } %>
		</table>
	</body>
</html>