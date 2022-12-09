package br.edu.caua.projetotransportadora.trasportadora;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.caua.projetotransportadora.trasportadora.dao.ParceirosDao;
import br.edu.caua.projetotransportadora.trasportadora.entidades.Parceiros;
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

public class ControllerTelaParceiros implements Initializable{

    @FXML
    private TextField textFieldRazaoSocial;

    @FXML
    private TableView<Parceiros> tableViewCliente;

    @FXML
    private TableColumn<Parceiros, Integer> tableColumnCnpf;

    @FXML
    private Button buttonNovo;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldSercoPrestado;

    @FXML
    private TableColumn<Parceiros, String> tableColumnRazaoSocial;

    @FXML
    private TextField textFieldCnpj;

    @FXML
    private TableColumn<Parceiros, Integer> tableColumnId;

    @FXML
    private Button buttonSalvar;

    @FXML
	private Button buttonExcluir;
	private ObservableList<Parceiros> observableTable;
	
	private Parceiros parceiroSelecionado;
	
    @FXML
    private TableColumn<Parceiros, String> tableColumnSercicoPrestado;

    @FXML
    private TableColumn<Parceiros, String> tableColumnProduto;

    @FXML
    private TextField textFieldProduto;
    
	private ParceirosDao parceirosDao;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		  parceirosDao = new ParceirosDao(); popularTabelaCliente();
		  tableViewCliente.getSelectionModel().selectedItemProperty()
		  .addListener((observable, oldValue, newValue)->selecionarParceiro(newValue));
		 
	}

    

	@FXML
    void handlerSalvar(ActionEvent event) {
    	try {
    		
			String strId = textFieldId.getText();
			Integer id = null;
			
			if (strId != null && strId.length() > 0) {

				id = Integer.valueOf(Integer.parseInt(strId));
			}
			
			String razaoSocial = textFieldRazaoSocial.getText();
			String servicoPrestado = textFieldSercoPrestado.getText();
			String cnpj = textFieldCnpj.getText();
			String produto = textFieldProduto.getText();

			Parceiros p = new Parceiros();

			p.setRazaoSocial(razaoSocial);
			p.setServicoPrestado(servicoPrestado);
			p.setCnpj(cnpj);
			p.setProduto(produto);

			if (id != null) {
				p.setId(id);
				parceirosDao.alterar(p);
			} else {
				parceirosDao.inserir(p);
				System.out.println("Alguma cadastrou!");
				limpar();
			}

			popularTabelaCliente();
			
		} catch (NumberFormatException e) {
			
			System.out.println("Alguma coisa errada!");
			
		}
    }
	
	public void popularTabelaCliente() {
		// fazer export das entidadades do projeto no module-info.java. ex: exports br.edu.cassio.projetoJavaFx.entidades;
		List<Parceiros> lst = parceirosDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
		tableColumnSercicoPrestado.setCellValueFactory(new PropertyValueFactory<>("servicoPrestado"));
		tableColumnCnpf.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		tableColumnProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
		observableTable = FXCollections.observableArrayList(lst);
		tableViewCliente.setItems(observableTable);
	}

	
	private void selecionarParceiro(Parceiros parceiro) {
		parceiroSelecionado = parceiro;
		textFieldId.setText(String.valueOf(parceiro.getId()));
		textFieldCnpj.setText(String.valueOf(parceiro.getCnpj()));
		textFieldRazaoSocial.setText(String.valueOf(parceiro.getRazaoSocial()));
		textFieldSercoPrestado.setText(String.valueOf(parceiro.getServicoPrestado()));
		textFieldProduto.setText(String.valueOf(parceiro.getProduto()));
	}

  

	@FXML
    void handlerExcluirCliente(ActionEvent event) {
		if (parceiroSelecionado != null) {
			parceirosDao.remover(parceiroSelecionado );
			popularTabelaCliente();
		}
    }

    @FXML
    void handlerNovoCliente(ActionEvent event) {
		limpar();
    }
    
    private void limpar() {
    	textFieldId.setText(null);
		textFieldCnpj.setText(null);
		textFieldRazaoSocial.setText(null);
		textFieldSercoPrestado.setText(null);
		textFieldProduto.setText(null);
	}
    



}
