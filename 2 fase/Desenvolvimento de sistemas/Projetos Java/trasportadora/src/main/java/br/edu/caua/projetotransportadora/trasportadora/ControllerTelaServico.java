package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.ParceirosDao;
import br.edu.caua.projetotransportadora.trasportadora.dao.ServicoDao;
import br.edu.caua.projetotransportadora.trasportadora.dao.VeiculoDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.OrdemSercos;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Parceiros;
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

public class ControllerTelaServico implements Initializable {

	@FXML
	private TableColumn<OrdemSercos, Float> tableColumnValor;

	@FXML
	private TextField textFieldKmTotal;

	@FXML
	private TextField textFieldDestino;

	@FXML
	private TableColumn<Veiculo, Integer> tableColumnIdVeiculoId;

	@FXML
	private TableColumn<Parceiros, String> tableColumnParceiroRazao;

	@FXML
	private TableColumn<OrdemSercos, String> tableColumnDestino;

	@FXML
	private TableView<Parceiros> tableViewRazao;

	@FXML
	private TableColumn<OrdemSercos, Float> tableColumnKm;

	@FXML
	private Button buttonNovo;

	@FXML
	private TextField textFieldId;

	@FXML
	private TextField textFieldValor;

	@FXML
	private TextField textFieldParceiro;

	@FXML
	private TableView<OrdemSercos> tableViewServico;

	@FXML
	private TableColumn<OrdemSercos, Integer> tableColumnId;

	@FXML
	private TextField textFieldVeiculo;

	@FXML
	private Button buttonSalvar;

	@FXML
	private Button buttonExcluir;

	@FXML
	private TableColumn<Veiculo, String> tableColumnVeiculoPlaca;

	@FXML
	private TableView<Veiculo> tableViewVeiculo;

	@FXML
	private TableColumn<Parceiros, Integer> tableColumnParceiroId;

	private ServicoDao servicoDao;

	private ObservableList<OrdemSercos> observableTable;

	private OrdemSercos servicoSelecionado;

	private ParceirosDao parceirosDao;

	private ObservableList<Parceiros> observableTableParceiros;
	
	private VeiculoDao veiculoDao;

	private ObservableList<Veiculo> observableTableVeiculo;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		servicoDao = new ServicoDao();
		popularTabelaServico();
		tableViewServico.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarServico(newValue));
		parceirosDao = new ParceirosDao() ;
		popularTabelaParceiros();
		veiculoDao = new VeiculoDao();
		popularTabelaVeiculo();
	}

	private void popularTabelaVeiculo() {
		List<Veiculo> lst = veiculoDao.listar();
		tableColumnIdVeiculoId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnVeiculoPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		observableTableVeiculo = FXCollections.observableArrayList(lst);
		tableViewVeiculo.setItems(observableTableVeiculo);		
	}

	private void popularTabelaParceiros() {
		List<Parceiros> lst = parceirosDao.listar();
		tableColumnParceiroId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnParceiroRazao.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
		observableTableParceiros = FXCollections.observableArrayList(lst);
		tableViewRazao.setItems(observableTableParceiros);
	}

	private void selecionarServico(OrdemSercos s) {
		servicoSelecionado = s;
		textFieldId.setText(String.valueOf(s.getId()));
		textFieldDestino.setText(String.valueOf(s.getDestino()));
		textFieldKmTotal.setText(String.valueOf(s.getKmViagem()));
		textFieldValor.setText(String.valueOf(s.getValor()));
		textFieldVeiculo.setText(String.valueOf(s.getVeiculoId()));
		textFieldParceiro.setText(String.valueOf(s.getParceiroId()));
	}

	private void popularTabelaServico() {
		List<OrdemSercos> lst = servicoDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
		tableColumnKm.setCellValueFactory(new PropertyValueFactory<>("kmViagem"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewServico.setItems(observableTable);

	}

	@FXML
	void handlerSalvar(ActionEvent event) {
		try {

			String strId = textFieldId.getText();
			Integer id = null;

			if (strId != null && strId.length() > 0) {

				id = Integer.valueOf(Integer.parseInt(strId));
			}

			String destino = textFieldDestino.getText();
			String km = textFieldKmTotal.getText();
			String valor = textFieldValor.getText();
			String parceiroId = textFieldParceiro.getText();
			String veiculoId = textFieldVeiculo.getText();

			OrdemSercos s = new OrdemSercos();

			s.setDestino(destino);
			s.setKmViagem(Float.parseFloat(km));
			s.setValor(Float.parseFloat(valor));
			s.setParceiroId(Integer.parseInt(parceiroId));
			s.setVeiculoId(Integer.parseInt(veiculoId));

			if (id != null) {
				s.setId(id);
				servicoDao.alterar(s);
			} else {
				servicoDao.inserir(s);
				System.out.println("Alguma cadastrou!");
				limpar();
			}

			popularTabelaServico();

		} catch (NumberFormatException e) {

			System.out.println("Alguma coisa errada!");

		}
	}

	@FXML
	void handlerExcluirCliente(ActionEvent event) {
		if (servicoSelecionado != null) {
			servicoDao.remover(servicoSelecionado);
			popularTabelaServico();
		}
	}

	@FXML
	void handlerNovoCliente(ActionEvent event) {
		limpar();
	}

	private void limpar() {
		textFieldId.setText(null);
		textFieldDestino.setText(null);
		textFieldKmTotal.setText(null);
		textFieldValor.setText(null);
		textFieldVeiculo.setText(null);
		textFieldParceiro.setText(null);

	}

}
