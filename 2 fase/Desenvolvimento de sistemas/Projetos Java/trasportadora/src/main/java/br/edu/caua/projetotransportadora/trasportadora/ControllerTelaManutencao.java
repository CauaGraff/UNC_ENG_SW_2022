package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.ManutecaoDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Manutencao;
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

public class ControllerTelaManutencao implements Initializable {

    @FXML
    private Button buttonNovo;

    @FXML
    private TableColumn<Manutencao, Float> tableColumnValor;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldValor;

    @FXML
    private TableView<Manutencao> tableViewManutencao;

    @FXML
    private TableColumn<Manutencao, Integer> tableColumnId;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonExcluir;

    @FXML
    private TableColumn<Manutencao, Date> tableColumnData;

    @FXML
    private DatePicker datePickerManutencao;

	private ManutecaoDao manutecaoDao;

	private Manutencao manutecaoSelecionado;

	private ObservableList<Manutencao> observableTable;


    @FXML
    void handlerSalvar(ActionEvent event) {

    }

    @FXML
    void handlerExcluirCliente(ActionEvent event) {

    }

    @FXML
    void handlerNovoCliente(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manutecaoDao = new ManutecaoDao(); popularTabelaManutencao();
		  tableViewManutencao.getSelectionModel().selectedItemProperty()
		  .addListener((observable, oldValue, newValue)->selecionarManutencao(newValue));		
	}

	private void selecionarManutencao(Manutencao manutecao) {
		manutecaoSelecionado = manutecao;
		textFieldId.setText(String.valueOf(manutecao.getId()));
		textFieldValor.setText(String.valueOf(manutecao.getValor()));
		datePickerManutencao.setValue(manutecao.getData());

	}

	private void popularTabelaManutencao() {
		List<Manutencao> lst = manutecaoDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableColumnData.setCellValueFactory(new PropertyValueFactory<>("dataManutencao"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewManutencao.setItems(observableTable);		
	}

}
