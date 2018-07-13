package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Filme;
import dao.FilmeDAO;
import util.ConnectionFactory;

public class GravarFilme extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Connection bd = ConnectionFactory.getConnection();
		Filme filme = new Filme();
		filme.setNome(req.getParameter("nomeDoFilme"));
		filme.setValor(Double.parseDouble(req.getParameter("valorDoFilme")));
		filme.setDisponivel(req.getParameter("disponivelDoFilme"));
		filme.setGenero(req.getParameter("generoDoFilme"));

		try {
			FilmeDAO dao = new FilmeDAO(bd);
			dao.inserir(filme);
			bd.close();
			PrintWriter gravador = resp.getWriter();
			gravador.println("<html>");
			gravador.println("<head><title>Filme Gravado</title></head>");
			gravador.println("<body>");
			gravador.println("<h1>Filme gravado com sucesso!</h1><br/><br/>");
			gravador.println("<a href='http://localhost:8080/LocadoraBD'>Voltar</a>");
			gravador.println("</body>");
			gravador.println("</body>");
		} catch (SQLException e) {
			PrintWriter gravador = resp.getWriter();
			gravador.println("<html>");
			gravador.println("<head><title>Erro de Gravação</title></head>");
			gravador.println("<body>");
			gravador.println("<h1>Falha ao gravar o filme!</h1><br/><br/>");
			gravador.println("<a href='http://localhost:8080/LocadoraBD'>Voltar</a>");
			gravador.println("</body>");
			gravador.println("</body>");
			e.printStackTrace();
		}
	}
}