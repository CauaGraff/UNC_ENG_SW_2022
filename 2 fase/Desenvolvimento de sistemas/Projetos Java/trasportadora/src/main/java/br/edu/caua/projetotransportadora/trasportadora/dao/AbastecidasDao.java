package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Abastecidas;

public class AbastecidasDao {
	private Connection connection;

	public AbastecidasDao() {
		this.connection = MysqlSingleton.getConnection();
	}

	public boolean inserir(Abastecidas abastecida) {
		String sql = "INSERT INTO abastecidas (valor, TipoProduto, quantidade, id_veiculo) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setFloat(1, abastecida.getValor());
			stmt.setString(2, abastecida.getTipoProduto());
			stmt.setFloat(3, abastecida.getQuantidade());
			stmt.setInt(4, abastecida.getVeiculoId());
			stmt.execute();
			return true;

		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<Abastecidas> listar() {
		String sql = "SELECT * FROM  abastecidas";
		List<Abastecidas> listaAbastecidas = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Abastecidas abastecidas = new Abastecidas();
				abastecidas.setId(resultado.getInt("id"));
				abastecidas.setValor(resultado.getFloat("valor"));
				abastecidas.setTipoProduto(resultado.getString("TipoProduto"));
				abastecidas.setQuantidade(resultado.getFloat("quantidade"));
				abastecidas.setVeiculoId(resultado.getInt("id_veiculo"));
				listaAbastecidas.add(abastecidas);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaAbastecidas;
	}

	public boolean alterar(Abastecidas abastecidas) {
		String sql = "UPDATE abastecidas SET valor=?, TipoProduto=?, quantidade=?, id_veiculo=?, cnh=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setFloat(1, abastecidas.getValor());
			stmt.setString(2, abastecidas.getTipoProduto());
			stmt.setFloat(3, abastecidas.getQuantidade());
			stmt.setInt(4, abastecidas.getVeiculoId());
			stmt.setInt(5, abastecidas.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Abastecidas motorista) {
		String sql = "DELETE FROM abastecidas WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, motorista.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public Abastecidas buscar(Integer id) {
		String sql = "SELECT * FROM abastecidas WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			Abastecidas abastecidas = new Abastecidas();
			if (resultado.next()) {
				abastecidas.setId(resultado.getInt("id"));
				abastecidas.setValor(resultado.getFloat("valor"));
				abastecidas.setTipoProduto(resultado.getString("TipoProduto"));
				abastecidas.setQuantidade(resultado.getFloat("quantidade"));
				abastecidas.setVeiculoId(resultado.getInt("id_veiculo"));
				return abastecidas;
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
