<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="gravaFilme.jsp">
		<h2>Cadastro de Filme</h2>
		<table border="0">
			<tr>
				<td>
					Nome:
				</td>
				<td>
					<input type="text" name="nomeDoFilme"/>
				</td>
			</tr>
			<tr>
				<td>
					Valor:
				</td>
				<td>
					<input type="text" name="valorDoFilme"/>
				</td>
			</tr>	
			<tr>
				<td>
					Dispon�vel:
				</td>
				<td>
					<input type="radio" name="disponivelDoFilme" value="SIM" checked/>SIM
					<input type="radio" name="disponivelDoFilme" value="NAO" checked/>N�O
				</td>
			</tr>	
			<tr>
				<td>
					G�nero:
				</td>
				<td>
					<input type="text" name="generoDoFilme"/>
				</td>
			</tr>
			<tr>
			<tr>
			</tr>
				<td>
					<input type="submit" value="Salvar dados">
				</td>
			</tr>
		</table>
		<h4><a href="http://localhost:8080/LocadoraBD">P�gina Inicial</a></h4>
		</form>
	</body>
</html>