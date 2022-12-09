package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.OrdemSercos;


public class ServicoDao {
	
	private Connection connection;

	public ServicoDao() {
		this.connection = MysqlSingleton.getConnection();
	}

	public boolean inserir(OrdemSercos s) {
		String sql = "INSERT INTO ordemservico (destino, kmViagem, valor, id_veiculo, id_parceiro) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getDestino());
			stmt.setFloat(2, s.getKmViagem());
			stmt.setFloat(3, s.getValor());
			stmt.setInt(4, s.getVeiculoId());
			stmt.setInt(5, s.getParceiroId());
			stmt.execute();
			return true;
			
		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<OrdemSercos> listar() {
		String sql = "SELECT * FROM  ordemservico";
		List<OrdemSercos> listaServico = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				OrdemSercos s = new OrdemSercos();
				s.setId(resultado.getInt("id"));
				s.setDestino(resultado.getString("destino"));
				s.setKmViagem(resultado.getFloat("kmViagem"));
				s.setValor(resultado.getFloat("valor"));
				s.setVeiculoId(resultado.getInt("id_veiculo"));
				s.setParceiroId(resultado.getInt("id_parceiro"));

				listaServico.add(s);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaServico;
	}

	public boolean alterar(OrdemSercos s) {
		String sql = "UPDATE ordemservico SET destino=?, kmViagem=?, valor=?, id_veiculo=?, id_parceiro=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getDestino());
			stmt.setFloat(2, s.getKmViagem());
			stmt.setFloat(3, s.getValor());
			stmt.setInt(4, s.getVeiculoId());
			stmt.setInt(5, s.getParceiroId());
			stmt.setInt(6, s.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(OrdemSercos s) {
		String sql = "DELETE FROM ordemservico WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, s.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public OrdemSercos buscar(Integer id) {
		String sql = "SELECT * FROM ordemservico WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			OrdemSercos s = new OrdemSercos();
			if (resultado.next()) {
				s.setId(resultado.getInt("id"));
				s.setDestino(resultado.getString("destino"));
				s.setKmViagem(resultado.getFloat("kmViagem"));
				s.setValor(resultado.getFloat("valor"));
				s.setVeiculoId(resultado.getInt("id_veiculo"));
				s.setParceiroId(resultado.getInt("id_parceiro"));
				return s;
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
