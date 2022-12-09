package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.MotoristaDao;
import br.edu.caua.projetotransportadora.trasportadora.dao.ReboqueDao;
import br.edu.caua.projetotransportadora.trasportadora.dao.VeiculoDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Motorista;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Reboque;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerTelaVeiculo implements Initializable {

	 @FXML
	    private TextField textFieldPlaca;

	    @FXML
	    private TableColumn<Veiculo, String> tableColumnCor;

	    @FXML
	    private TextField textFieldMotoristaId;

	    @FXML
	    private TableView<Veiculo> tableViewCliente;

	    @FXML
	    private TableColumn<Veiculo, String> tableColumnPlaca;

	    @FXML
	    private Button buttonNovo;

	    @FXML
	    private TextField textFieldId;

	    @FXML
	    private TableColumn<Motorista, Integer> tableColumnMotoristaId;

	    @FXML
	    private TextField textFieldKm;

	    @FXML
	    private TableColumn<Veiculo, Integer> tableColumnId;

	    @FXML
	    private Button buttonSalvar;

	    @FXML
	    private Button buttonExcluir;

	    @FXML
	    private TextField textFieldCor;

	    @FXML
	    private TableColumn<Veiculo, Integer> tableColumnAno;

	    @FXML
	    private TextField textFieldReboqueId;

	    @FXML
	    private TableColumn<Veiculo, Integer> tableColumnChassi;

	    @FXML
	    private TableColumn<Reboque, Integer> tableColumnIdReboqueId;

	    @FXML
	    private TextField textFieldMarca;

	    @FXML
	    private TableColumn<Veiculo, Float> tableColumnKm;

	    @FXML
	    private TableColumn<Motorista, String> tableColumnMotoristaNome;

	    @FXML
	    private TableView<Motorista> tableViewMotorista;

	    @FXML
	    private TextField textFieldChassi;

	    @FXML
	    private TableColumn<Veiculo, String> tableColumnReboquePlaca;

	    @FXML
	    private TextField textFieldAno;

	    @FXML
	    private TableColumn<Veiculo, String> tableColumnMarca;

	    @FXML
	    private TableView<Reboque> tableViewReboque;

		private VeiculoDao veiculoDao;

		private Veiculo veiculoSelecionado;

		private ObservableList<Veiculo> observableTable;

		private MotoristaDao motoristaDao;

		private ObservableList<Motorista> observableTableMotorista;

		private ReboqueDao reboqueDao;

		private ObservableList<Reboque> observableTableReboque;
	

	@FXML
	void handlerSalvar(ActionEvent event) {
		try {

			String strId = textFieldId.getText();
			String id = null;

			if (strId != null && strId.length() > 0) {

				id = String.valueOf(Integer.parseInt(strId));
			}

			
			String placa =textFieldPlaca.getText();
			String km = textFieldKm.getText();
			String marca = textFieldMarca.getText();
			String chassi = textFieldChassi.getText();
			String cor = textFieldCor.getText();
			String ano = textFieldAno.getText();
			String mId = textFieldMotoristaId.getText();
			String rId = textFieldReboqueId.getText();
			
			Veiculo v = new Veiculo();

			v.setPlaca(placa);
			v.setKilometragem(Float.parseFloat(km));
			v.setMarca(marca);
			v.setNumChassi(chassi);
			v.setCor(cor);
			v.setAno(Integer.parseInt(ano));
			v.setMotoristaId(Integer.parseInt(mId));
			v.setReboqueId(Integer.parseInt(rId));
			

			if (id != null) {
				v.setId(Integer.parseInt(id));
				veiculoDao.alterar(v);
			} else {
				veiculoDao.inserir(v);
				System.out.println("Alguma cadastrou!");
				limpar();
			}

			popularTabelaVeiculo();

		} catch (NumberFormatException e) {

			System.out.println("Alguma coisa errada!");

		}
	}

	@FXML
	void handlerExcluirCliente(ActionEvent event) {
		if (veiculoSelecionado != null) {
			veiculoDao.remover(veiculoSelecionado);
			popularTabelaVeiculo();
		}
	}

	@FXML
	void handlerNovoCliente(ActionEvent event) {
		limpar();

	}

	private void limpar() {
		textFieldId.setText(null);
		textFieldPlaca.setText(null);
		textFieldKm.setText(null);
		textFieldMarca.setText(null);
		textFieldChassi.setText(null);
		textFieldCor.setText(null);
		textFieldAno.setText(null);
		textFieldMotoristaId.setText(null);
		textFieldReboqueId.setText(null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		veiculoDao = new VeiculoDao();
		popularTabelaVeiculo();
		tableViewCliente.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarVeiculo(newValue));
		motoristaDao = new MotoristaDao();
		popularTabelaMotorista();
		reboqueDao = new ReboqueDao();
		popularTabelaReboque();
		

		
	}

	private void popularTabelaReboque() {
		List<Reboque> lst = reboqueDao.listar();
		tableColumnIdReboqueId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnReboquePlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		observableTableReboque = FXCollections.observableArrayList(lst);
		tableViewReboque.setItems(observableTableReboque);		
	}

	private void popularTabelaMotorista() {
		List<Motorista> lst = motoristaDao.listar();
		tableColumnMotoristaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnMotoristaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		observableTableMotorista = FXCollections.observableArrayList(lst);
		tableViewMotorista.setItems(observableTableMotorista);		
	}

	private void selecionarVeiculo(Veiculo veiculo) {
		veiculoSelecionado = veiculo;
		textFieldId.setText(String.valueOf(veiculo.getId()));
		textFieldPlaca.setText(String.valueOf(veiculo.getPlaca()));
		textFieldKm.setText(String.valueOf(veiculo.getKilometragem()));
		textFieldMarca.setText(String.valueOf(veiculo.getMarca()));
		textFieldChassi.setText(String.valueOf(veiculo.getNumChassi()));
		textFieldCor.setText(String.valueOf(veiculo.getCor()));
		textFieldAno.setText(String.valueOf(veiculo.getAno()));
		textFieldMotoristaId.setText(String.valueOf(veiculo.getMotoristaId()));
		textFieldReboqueId.setText(String.valueOf(veiculo.getReboqueId()));
	}

	private void popularTabelaVeiculo() {
		List<Veiculo> lst = veiculoDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tableColumnKm.setCellValueFactory(new PropertyValueFactory<>("kilometragem"));
		tableColumnCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
		tableColumnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		tableColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		tableColumnChassi.setCellValueFactory(new PropertyValueFactory<>("numChassi"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewCliente.setItems(observableTable);
	}
	
	

}
