<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*, dao.*, util.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gravando Filme</title>
</head>
<body>
<%
	Connection bd = ConnectionFactory.getConnection();
	Filme filme = new Filme();
	filme.setNome(request.getParameter("nomeDoFilme"));
	filme.setValor(Double.parseDouble(request.getParameter("valorDoFilme")));
	filme.setDisponivel(request.getParameter("disponivelDoFilme"));
	filme.setGenero(request.getParameter("generoDoFilme"));
	
	try {
		FilmeDAO dao = new FilmeDAO(bd);
		dao.inserir(filme);
		bd.close();%>
		<h1>Filme gravado com sucesso!</h1>
		<%response.sendRedirect("listaFilme.jsp");
	} catch (SQLException e) {
		e.printStackTrace();
	}
%>
</body>
</html>