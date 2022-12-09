package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.AbastecidasDao;
import br.edu.caua.projetotransportadora.trasportadora.dao.VeiculoDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Abastecidas;
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

public class ControllerTelaAbastecimento implements Initializable {

	@FXML
	private TableColumn<Abastecidas, Float> tableColumnValor;

	@FXML
	private TableColumn<Abastecidas, String> tableColumnTipo;

	@FXML
	private TableColumn<Veiculo, Integer> tableColumnIdVeiculoId;

	@FXML
	private TextField textFieldTipo;

	@FXML
	private TableView<Abastecidas> tableViewAbastecimenoto;

	@FXML
	private Button buttonNovo;

	@FXML
	private TextField textFieldId;

	@FXML
	private TextField textFieldValor;

	@FXML
	private TableColumn<Abastecidas, Integer> tableColumnId;

	@FXML
	private TextField textFieldQtd;

	@FXML
	private TextField textFieldIdVeiculo;

	@FXML
	private Button buttonSalvar;

	@FXML
	private Button buttonExcluir;

	@FXML
	private TableColumn<Veiculo, String> tableColumnVeiculoPlaca;

	@FXML
	private TableView<Veiculo> tableViewVeiculo;

	@FXML
	private TableColumn<Abastecidas, Float> tableColumnQtd;

	private AbastecidasDao abastecidasDao;

	private ObservableList<Abastecidas> observableTable;

	private Abastecidas abastecidasSelecionado;

	private VeiculoDao veiculoDao;

	private ObservableList<Veiculo> observableTableVeiculo;


	@FXML
	void handlerSalvar(ActionEvent event) {
try {
    		
			String strId = textFieldId.getText();
			Integer id = null;
			
			if (strId != null && strId.length() > 0) {

				id = Integer.valueOf(Integer.parseInt(strId));
			}
			
			String valor = textFieldValor.getText();
			String tipo = textFieldTipo.getText();
			String qtd = textFieldQtd.getText();
			String viculo = textFieldIdVeiculo.getText();

			Abastecidas a = new Abastecidas();

			a.setValor(Float.parseFloat(valor));
			a.setTipoProduto(tipo);
			a.setQuantidade(Float.parseFloat(qtd));
			a.setVeiculoId(Integer.parseInt(viculo));

			if (id != null) {
				a.setId(id);
				abastecidasDao.alterar(a);
			} else {
				abastecidasDao.inserir(a);
				System.out.println("Alguma cadastrou!");
				limpar();
			}

			popularTabelaAbastecidas();
			
		} catch (NumberFormatException e) {
			
			System.out.println("Alguma coisa errada!");
			
		}
	}

	@FXML
	void handlerExcluirCliente(ActionEvent event) {
		if (abastecidasSelecionado != null) {
			abastecidasDao.remover(abastecidasSelecionado );
			popularTabelaAbastecidas();
		}
	}

	@FXML
	void handlerNovoCliente(ActionEvent event) {
		limpar();
	}

	private void limpar() {
		textFieldId.setText(null);
		textFieldValor.setText(null);
		textFieldTipo.setText(null);
		textFieldQtd.setText(null);
		textFieldIdVeiculo.setText(null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		abastecidasDao = new AbastecidasDao();
		popularTabelaAbastecidas();
		tableViewAbastecimenoto.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarAbastecidas(newValue));
		veiculoDao = new VeiculoDao();
		popularTabelaVeiculo();
	}

	private void popularTabelaAbastecidas() {
		List<Abastecidas> lst = abastecidasDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("TipoProduto"));
		tableColumnQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewAbastecimenoto.setItems(observableTable);
	}

	private void selecionarAbastecidas(Abastecidas abastecidas) {
		abastecidasSelecionado = abastecidas;
		textFieldId.setText(String.valueOf(abastecidas.getId()));
		textFieldValor.setText(String.valueOf(abastecidas.getValor()));
		textFieldTipo.setText(String.valueOf(abastecidas.getTipoProduto()));
		textFieldQtd.setText(String.valueOf(abastecidas.getQuantidade()));
		textFieldIdVeiculo.setText(String.valueOf(abastecidas.getVeiculoId()));
	}

	private void popularTabelaVeiculo() {
		List<Veiculo> lst = veiculoDao.listar();
		tableColumnIdVeiculoId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnVeiculoPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		observableTableVeiculo = FXCollections.observableArrayList(lst);
		tableViewVeiculo.setItems(observableTableVeiculo);
	}

}
