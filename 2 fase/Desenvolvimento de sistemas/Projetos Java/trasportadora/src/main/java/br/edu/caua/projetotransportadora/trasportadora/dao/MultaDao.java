package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Multa;


public class MultaDao {
	
	private Connection connection;

	public MultaDao() {
		this.connection = MysqlSingleton.getConnection();
	}

	public boolean inserir(Multa multa) {
		String sql = "INSERT INTO multa (lo, dataMulta, Id_veiculo, valor, ContaId) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, multa.getLocal());
			stmt.setDate(2,  (Date) multa.getData());
			stmt.setInt(3, multa.getVeiculoId());
			stmt.setFloat(4, multa.getValor());
			stmt.setInt(5, multa.getContaId());
			stmt.execute();
			return true;
			
		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<Multa> listar() {
		String sql = "SELECT * FROM  multa";
		List<Multa> listaMulta = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Multa multa = new Multa();
				multa.setId(resultado.getInt("id"));
				multa.setLocal(resultado.getString("lo"));
				multa.setData(resultado.getDate("dataMulta"));
				multa.setVeiculoId(resultado.getInt("id_veiculo"));
				multa.setValor(resultado.getFloat("valor"));
				listaMulta.add(multa);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaMulta;
	}

	public boolean alterar(Multa multa) {
		String sql = "UPDATE multa SET lo=?, dataMulta=?, id_veiculo=?, valor=?, contaId=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, multa.getLocal());
			stmt.setDate(2, (Date) multa.getData());
			stmt.setInt(3, multa.getVeiculoId());
			stmt.setFloat(4, multa.getValor());
			stmt.setInt(4, multa.getContaId());
			stmt.setInt(6, multa.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Multa multa) {
		String sql = "DELETE FROM multa WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, multa.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public Multa buscar(Integer id) {
		String sql = "SELECT * FROM multa WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			Multa multa = new Multa();
			if (resultado.next()) {
				multa.setId(resultado.getInt("id"));
				multa.setLocal(resultado.getString("lo"));
				multa.setData(resultado.getDate("dataMulta"));
				multa.setVeiculoId(resultado.getInt("id_veiculo"));
				multa.setValor(resultado.getFloat("valor"));
				multa.setContaId(resultado.getInt("contaId"));
				return multa;
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
