package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Reboque;

public class ReboqueDao {
	private Connection connection;

	public ReboqueDao() {
		this.connection = MysqlSingleton.getConnection();
	}

	public boolean inserir(Reboque reboque) {
		String sql = "INSERT INTO reboque (placa, renavam, ano, capacidade) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, reboque.getPlaca());
			stmt.setString(2,  reboque.getRenavam());
			stmt.setString(3, reboque.getAno());
			stmt.setString(4, reboque.getCapacidade());
			stmt.execute();
			return true;
			
		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<Reboque> listar() {
		String sql = "SELECT * FROM  reboque";
		List<Reboque> listaClientes = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Reboque reboque = new Reboque();
				reboque.setId(resultado.getInt("id"));
				reboque.setPlaca(resultado.getString("placa"));
				reboque.setRenavam(resultado.getString("renavam"));
				reboque.setAno(resultado.getString("ano"));
				reboque.setCapacidade(resultado.getString("capacidade"));
				listaClientes.add(reboque);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaClientes;
	}

	public boolean alterar(Reboque reboque) {
		String sql = "UPDATE parceiros SET placa=?, renavam=?, ano=?, capacidade=?  WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, reboque.getPlaca());
			stmt.setString(2, reboque.getRenavam());
			stmt.setString(3, reboque.getAno());
			stmt.setString(4, reboque.getCapacidade());
			stmt.setInt(6, reboque.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Reboque reboque) {
		String sql = "DELETE FROM reboque WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reboque.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public Reboque buscar(Integer id) {
		String sql = "SELECT * FROM reboque WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			Reboque reboque = new Reboque();
			if (resultado.next()) {
				reboque.setId(resultado.getInt("id"));
				reboque.setPlaca(resultado.getString("placa"));
				reboque.setRenavam(resultado.getString("renavam"));
				reboque.setAno(resultado.getString("ano"));
				reboque.setCapacidade(resultado.getString("capacidade"));
				return reboque;
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
