package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Filme;

public class FilmeDAO {
	
	private Connection bd;
	
	public FilmeDAO(Connection bd){
		this.bd = bd;
	}
	
	public void excluir(Filme filme) throws SQLException{
		String sql = "delete from filme where codigo=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setInt(1, filme.getCodigo());
		comando.execute();		
	}
	
	public void alterar(Filme filme) throws SQLException{
		String sql = "update filme set valor=?, disponivel=?, genero=? where codigo=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setDouble(1, filme.getValor());
		comando.setString(2, filme.getDisponivel());
		comando.setString(3, filme.getGenero());
		comando.setInt(4, filme.getCodigo());
		comando.execute();		
	}
	
	public void inserir(Filme filme) throws SQLException{
		String sql = "insert into filme (nome, valor, disponivel, genero) values (?,?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, filme.getNome());
		comando.setDouble(2, filme.getValor());
		comando.setString(3, filme.getDisponivel());
		comando.setString(4, filme.getGenero());
		comando.execute();
	}

	public List<Filme> buscarTodos() throws SQLException{
		String sql = "select * from filme order by codigo";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Filme> listaFilme = new ArrayList<Filme>();
		
		while (cursor.next()) {
			Filme filme = new Filme();
			filme.setCodigo(Integer.parseInt(cursor.getString("codigo")));
			filme.setNome(cursor.getString("nome"));
			filme.setValor(Double.parseDouble(cursor.getString("valor")));
			filme.setDisponivel(cursor.getString("disponivel"));
			filme.setGenero(cursor.getString("genero"));
			
			listaFilme.add(filme);
		}
		return listaFilme;
	}
	
}//fim da classe