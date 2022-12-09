package br.edu.caua.projetotransportadora.trasportadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class ControllerTelaPrincipal implements Initializable {

    @FXML
    private MenuItem menuItemCadastrarPaciente11;

    @FXML
    private MenuItem menuItemCadastrarMedico1;

    @FXML
    private MenuItem menuItemRelatorioMedico21;

    @FXML
    private MenuItem menuItemCadastrarMedico2;

    @FXML
    private MenuItem menuTeste111;

    @FXML
    private MenuItem menuItemCadastrarMulta;

    @FXML
    private MenuItem menuTeste1;

    @FXML
    private MenuItem menuTeste;

    @FXML
    private MenuItem menuItemRelatorioMedico;

    @FXML
    private MenuItem menuTeste11;

    @FXML
    private MenuItem menuItemCadastrarMedico;

    @FXML
    private MenuItem menuItemRelatorioMedico2;

    @FXML
    private MenuItem menuItemCadastrarMedico21;

    @FXML
    private MenuItem menuItemRelatorioMedico1;

    @FXML
    private MenuItem menuItemCadastrarPaciente;

    @FXML
    private AnchorPane anchorPaneFundo;

    @FXML
    private MenuItem menuItemCadastrarPaciente111;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    @FXML
    void handlerTelaServico(ActionEvent event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaServico.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }
  

    @FXML
    void handlerRelatorioServico(ActionEvent event) {

    }

    @FXML
    void handlerRelatorioParceiros(ActionEvent event) {

    }

    @FXML
    void handlerTelaCliente(ActionEvent event) throws IOException {
    	 AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaParceiros.fxml"));
         anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    void handlerRelatorioMotorista(ActionEvent event) {

    }

    @FXML
    void handlerTelaMotorista(ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaMotorista.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }


    @FXML
    void handlerTelaVeiculo(ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaVeiculo.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    void handlerRelatorioVeiculo(ActionEvent event) {

    }

    @FXML
    void handlerRelatorioReboque(ActionEvent event) {

    }

    @FXML
    void handlerTelaReboque(ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaReboque.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    void handlerRelatorioMulta(ActionEvent event) {

    }

    @FXML
    void handlerTelaMulta(ActionEvent event) throws IOException {
    	 AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaMulta.fxml"));
         anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    void handlerRelatorioManutencao(ActionEvent event) {

    }

    @FXML
    void handlerTelaManutencao(ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaManutencao.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    void handlerRelatorioContas(ActionEvent event) {

    }

    @FXML
    void handlerTelaContas(ActionEvent event) {

    }

    @FXML
    void handlerTelaAjuda(ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/caua/projetotransportadora/trasportadora/TelaAbastecimento.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }
}
