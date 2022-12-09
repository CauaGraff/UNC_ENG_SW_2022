package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.ReboqueDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Reboque;
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

public class ControllerTelaReboque implements Initializable {

	@FXML
	private TextField textFieldPlaca;

	@FXML
	private TableColumn<Reboque, String> tableColumnPlaca;

	@FXML
	private TableColumn<Reboque, Integer> tableColumnRenavam;

	@FXML
	private TextField textFieldRenavam;

	@FXML
	private Button buttonNovo;

	@FXML
	private TextField textFieldId;

	@FXML
	private TableColumn<Reboque, Float> tableColumnCapacidade;

	@FXML
	private TextField textFieldAno;

	@FXML
	private TableColumn<Reboque, Integer> tableColumnId;

	@FXML
	private Button buttonSalvar;

	@FXML
	private TextField textFieldCapacidade;

	@FXML
	private Button buttonExcluir;
	private ObservableList<Reboque> observableTable;

	private Reboque reboqueSelecionado;

	@FXML
	private TableView<Reboque> tableViewReboque;

	@FXML
	private TableColumn<Reboque, Integer> tableColumnAno;

	private ReboqueDao reboqueDao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		reboqueDao = new ReboqueDao();
		popularTabelaReboque();
		tableViewReboque.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarReboque(newValue));

	}

	@FXML
	void handlerSalvar(ActionEvent event) {
		try {

			String strId = textFieldId.getText();
			Integer id = null;

			if (strId != null && strId.length() > 0) {

				id = Integer.valueOf(Integer.parseInt(strId));
			}

			String placa = textFieldPlaca.getText();
			String renavam = textFieldRenavam.getText();
			String ano = textFieldAno.getText();
			String capacidade = textFieldCapacidade.getText();

			Reboque r = new Reboque();

			r.setPlaca(placa);
			r.setRenavam(renavam);
			r.setAno(ano);
			r.setCapacidade(capacidade);

			if (id != null) {
				r.setId(id);
				reboqueDao.alterar(r);
			} else {
				reboqueDao.inserir(r);
				System.out.println("Alguma cadastrou!");
				limpar();
			}

			popularTabelaReboque();

		} catch (NumberFormatException e) {

			System.out.println("Alguma coisa errada!");

		}
	}

	private void selecionarReboque(Reboque reboque) {
		reboqueSelecionado = reboque;
		textFieldId.setText(String.valueOf(reboque.getId()));
		textFieldPlaca.setText(String.valueOf(reboque.getPlaca()));
		textFieldRenavam.setText(String.valueOf(reboque.getRenavam()));
		textFieldAno.setText(String.valueOf(reboque.getAno()));
		textFieldCapacidade.setText(String.valueOf(reboque.getCapacidade()));
	}

	private void popularTabelaReboque() {
		// fazer export das entidadades do projeto no module-info.java. ex: exports
		// br.edu.cassio.projetoJavaFx.entidades;
		List<Reboque> lst = reboqueDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tableColumnRenavam.setCellValueFactory(new PropertyValueFactory<>("renavam"));
		tableColumnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		tableColumnCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewReboque.setItems(observableTable);
	}

	@FXML
	void handlerExcluirCliente(ActionEvent event) {
		if (reboqueSelecionado != null) {
			reboqueDao.remover(reboqueSelecionado );
			popularTabelaReboque();
		}
	}

	@FXML
	void handlerNovoCliente(ActionEvent event) {
		limpar();
	}

	private void limpar() {
		textFieldId.setText(null);
		textFieldAno.setText(null);
		textFieldCapacidade.setText(null);
		textFieldPlaca.setText(null);
		textFieldRenavam.setText(null);
	}

}
