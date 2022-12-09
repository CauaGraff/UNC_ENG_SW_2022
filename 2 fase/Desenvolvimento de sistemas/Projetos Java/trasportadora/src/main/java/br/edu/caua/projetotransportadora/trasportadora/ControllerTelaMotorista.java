package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.MotoristaDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Motorista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerTelaMotorista implements Initializable {

	@FXML
	private TableColumn<Motorista, String> tableColumnNome;

	@FXML
	private TableColumn<Motorista, Date> tableColumnDataNasc;

	@FXML
	private DatePicker datePickerNascimento;

	@FXML
	private TableColumn<Motorista, String> tableColumnEndereço;

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldCpf;

	@FXML
	private Button buttonNovo;

	@FXML
	private TextField textFieldId;

	@FXML
	private TableView<Motorista> tableViewMotorista;

	@FXML
	private TextField textFieldCnh;

	@FXML
	private TableColumn<Motorista, Integer> tableColumnCpf;

	@FXML
	private TextField textFieldTelefone;

	@FXML
	private TableColumn<Motorista, Integer> tableColumnId;

	@FXML
	private Button buttonSalvar;

	@FXML
	private TableColumn<Motorista, Integer> tableColumnCnh;

	@FXML
	private Button buttonExcluir;

	private ObservableList<Motorista> observableTable;

	private Motorista motoristaSelecionado;

	@FXML
	private TextField textFieldEndereco;

	private MotoristaDao motoristaDao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		motoristaDao = new MotoristaDao();
		popularTabelaMotorista();
		tableViewMotorista.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarMotorista(newValue));

	}

	@FXML
	void handlerSalvar(ActionEvent event) {
		try {

			String strId = textFieldId.getText();
			Integer id = null;

			if (strId != null && strId.length() > 0) {

				id = Integer.valueOf(Integer.parseInt(strId));
			}

			String nome = textFieldNome.getText();
			String cnh = textFieldCnh.getText();
			String cpf = textFieldCpf.getText();
			String endereco = textFieldEndereco.getText();
	    	LocalDate data = datePickerNascimento.getValue();
		

			Motorista m = new Motorista();

			m.setNome(nome);
			m.setCnh(cnh);
			m.setCpf(cpf);
			m.setEndereco(endereco);
 			m.setDataNasc(data);

			if (id != null) {
				m.setId(id);
				motoristaDao.alterar(m);
			} else {
				motoristaDao.inserir(m);
				System.out.println("Alguma cadastrou!");
				limpar();
			}

			popularTabelaMotorista();

		} catch (NumberFormatException e) {

			System.out.println("Alguma coisa errada!");

		}
	}

	public void popularTabelaMotorista() {
		// fazer export das entidadades do projeto no module-info.java. ex: exports
		// br.edu.cassio.projetoJavaFx.entidades;
		List<Motorista> lst = motoristaDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnCnh.setCellValueFactory(new PropertyValueFactory<>("cnh"));
		tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnEndereço.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tableColumnDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewMotorista.setItems(observableTable);
	}

	private void selecionarMotorista(Motorista motorista) {
		motoristaSelecionado = motorista;
		textFieldId.setText(String.valueOf(motorista.getId()));
		textFieldNome.setText(String.valueOf(motorista.getNome()));
		textFieldCnh.setText(String.valueOf(motorista.getCnh()));
		textFieldCpf.setText(String.valueOf(motorista.getCpf()));
		textFieldEndereco.setText(String.valueOf(motorista.getEndereco()));
		datePickerNascimento.setValue(motorista.getDataNasc());
	}

	@FXML
	void handlerExcluirCliente(ActionEvent event) {
		if (motoristaSelecionado != null) {
			motoristaDao.remover(motoristaSelecionado);
			popularTabelaMotorista();
		}
	}

	@FXML
	void handlerNovoCliente(ActionEvent event) {
		limpar();
	}

	private void limpar() {
		textFieldId.setText(null);
		textFieldId.setText(null);
		textFieldNome.setText(null);
		textFieldCnh.setText(null);
		textFieldCpf.setText(null);
		textFieldEndereco.setText(null);
		datePickerNascimento.setValue(null);
	}

}
