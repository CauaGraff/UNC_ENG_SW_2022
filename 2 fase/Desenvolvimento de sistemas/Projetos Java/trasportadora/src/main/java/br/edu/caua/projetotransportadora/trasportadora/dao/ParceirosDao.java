package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Parceiros;


public class ParceirosDao {
	
	private Connection connection;

	public ParceirosDao() {
		this.connection = MysqlSingleton.getConnection();
	}

	public boolean inserir(Parceiros parceiros) {
		String sql = "INSERT INTO parceiros (razaoSocial, servicoPrestado, cnpj, produto) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, parceiros.getRazaoSocial());
			stmt.setString(2, parceiros.getServicoPrestado());
			stmt.setString(3, parceiros.getCnpj());
			stmt.setString(4, parceiros.getProduto());
			stmt.execute();
			return true;
			
		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<Parceiros> listar() {
		String sql = "SELECT * FROM  Parceiros";
		List<Parceiros> listaClientes = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Parceiros parceiros = new Parceiros();
				parceiros.setId(resultado.getInt("id"));
				parceiros.setRazaoSocial(resultado.getString("razaoSocial"));
				parceiros.setServicoPrestado(resultado.getString("servicoPrestado"));
				parceiros.setCnpj(resultado.getString("cnpj"));
				parceiros.setProduto(resultado.getString("produto"));
				listaClientes.add(parceiros);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaClientes;
	}

	public boolean alterar(Parceiros parceiros) {
		String sql = "UPDATE parceiros SET razaoSocial=?, servicoPrestado=?, cnpj=?, produto=?  WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, parceiros.getRazaoSocial());
			stmt.setString(2, parceiros.getServicoPrestado());
			stmt.setString(3, parceiros.getCnpj());
			stmt.setString(4, parceiros.getProduto());
			stmt.setInt(5, parceiros.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Parceiros parceiros) {
		String sql = "DELETE FROM parceiros WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, parceiros.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public Parceiros buscar(Integer id) {
		String sql = "SELECT * FROM parceiros WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			Parceiros parceiros = new Parceiros();
			if (resultado.next()) {
				parceiros.setId(resultado.getInt("id"));
				parceiros.setRazaoSocial(resultado.getString("razaoSocial"));
				parceiros.setServicoPrestado(resultado.getString("servicoPrestado"));
				parceiros.setCnpj(resultado.getString("cnpj"));
				parceiros.setProduto(resultado.getString("produto"));
				return parceiros;
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
