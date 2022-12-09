package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Manutencao;
import br.edu.caua.projetotransportadora.trasportadora.dao.MotoristaDao;


public class ManutecaoDao {
	private Connection connection;

	public ManutecaoDao() {
		this.connection = MysqlSingleton.getConnection();
	}
	
	@SuppressWarnings("deprecation")
	public Date converteLocalDateParaDate(LocalDate data) {
		return new Date(data.getYear()-1900, data.getMonthValue()-1, data.getDayOfMonth()) ; 
	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public boolean inserir(Manutencao manutencao) {
		String sql = "INSERT INTO manutencao (valro, dataManutencao, contaId) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setFloat(1, manutencao.getValor());
			stmt.setDate(2, converteLocalDateParaDate(manutencao.getData()));
			stmt.setFloat(3, manutencao.getContaId());
			stmt.execute();
			return true;

		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<Manutencao> listar() {
		String sql = "SELECT * FROM  manutencao";
		List<Manutencao> listaManutencao = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Manutencao manutencao = new Manutencao();
				manutencao.setId(resultado.getInt("id"));
				manutencao.setValor(resultado.getFloat("valro"));
				manutencao.setData(asLocalDate(resultado.getDate("dataManutencao")));
				manutencao.setContaId(resultado.getInt("contaId"));
			
				listaManutencao.add(manutencao);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaManutencao;
	}

	public boolean alterar(Manutencao abastecidas) {
		String sql = "UPDATE manutecao SET valro=?, dataManutencao=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setFloat(1, abastecidas.getValor());
			stmt.setDate(2,converteLocalDateParaDate(abastecidas.getData()));
			stmt.setInt(3, abastecidas.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Manutencao motorista) {
		String sql = "DELETE FROM manutecao WHERE id=?";
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

	

}
