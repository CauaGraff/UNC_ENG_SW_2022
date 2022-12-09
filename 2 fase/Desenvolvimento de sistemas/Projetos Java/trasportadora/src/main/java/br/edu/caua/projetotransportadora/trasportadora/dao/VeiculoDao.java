package br.edu.caua.projetotransportadora.trasportadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.caua.projetotransportadora.trasportadora.database.MysqlSingleton;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Veiculo;

public class VeiculoDao {
	private Connection connection;

	public VeiculoDao() {
		this.connection = MysqlSingleton.getConnection();
	}

	public boolean inserir(Veiculo veiculo) {
		String sql = "INSERT INTO `veiculo`(`placa`, `kilometragem`, `cor`, `ano`, `marca`, `numChassi`, `id_motorista`, `id_reboque`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, veiculo.getPlaca());
			stmt.setFloat(2, veiculo.getKilometragem());
			stmt.setString(3, veiculo.getCor());
			stmt.setInt(4, veiculo.getAno());
			stmt.setString(5, veiculo.getMarca());
			stmt.setString(6, veiculo.getNumChassi());
			stmt.setInt(7, veiculo.getMotoristaId());
			stmt.setInt(8, veiculo.getReboqueId());
			stmt.execute();
			return true;
			
		} catch (Exception e) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public List<Veiculo> listar() {
		String sql = "SELECT * FROM veiculo";
		List<Veiculo> listaVeiculo = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setId(resultado.getInt("id"));
				veiculo.setPlaca(resultado.getString("placa"));
				veiculo.setKilometragem(resultado.getFloat("kilometragem"));
				veiculo.setCor(resultado.getString("cor"));
				veiculo.setAno(resultado.getInt("ano"));
				veiculo.setMarca(resultado.getString("marca"));
				veiculo.setNumChassi(resultado.getString("numChassi"));
				veiculo.setMotoristaId(resultado.getInt("id_motorista"));
				veiculo.setReboqueId(resultado.getInt("id_reboque"));
				listaVeiculo.add(veiculo);
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaVeiculo;
	}

	public boolean alterar(Veiculo veiculo) {
		String sql = "UPDATE veiculo SET placa=?, kilometragem=?, cor=?, ano=?, marca=?, numChassi=?, id_motorista=?, id_reboque=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, veiculo.getPlaca());
			stmt.setFloat(2, veiculo.getKilometragem());
			stmt.setString(3, veiculo.getCor());
			stmt.setInt(4, veiculo.getAno());
			stmt.setString(5, veiculo.getMarca());
			stmt.setString(6, veiculo.getNumChassi());
			stmt.setInt(7, veiculo.getMotoristaId());
			stmt.setInt(8, veiculo.getReboqueId());
			stmt.setInt(9, veiculo.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean remover(Veiculo veiculo) {
		String sql = "DELETE FROM veiculo WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, veiculo.getId());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public Veiculo buscar(Integer id) {
		String sql = "SELECT * FROM veiculo WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			Veiculo veiculo = new Veiculo();
			if (resultado.next()) {
				veiculo.setId(resultado.getInt("id"));
				veiculo.setPlaca(resultado.getString("placa"));
				veiculo.setKilometragem(resultado.getFloat("kilometragem"));
				veiculo.setCor(resultado.getString("cor"));
				veiculo.setAno(resultado.getInt("ano"));
				veiculo.setMarca(resultado.getString("marca"));
				veiculo.setNumChassi(resultado.getString("numChassi"));
				veiculo.setMotoristaId(resultado.getInt("id_motorista"));
				veiculo.setReboqueId(resultado.getInt("id_reboque"));
				return veiculo;
			}
		} catch (SQLException ex) {
//			Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
