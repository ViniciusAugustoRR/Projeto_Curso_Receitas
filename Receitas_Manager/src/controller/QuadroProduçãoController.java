package controller;

import model.ListaReceita;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import model.CadastroReceita;
import model.ListaIngrediente;
import model.Relatório;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import dao.Ingrediente_Dao;
import dao.Producao_Dao;
import dao.Receita_Dao;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.shard.Ingrediente;
import model.shard.Ingrediente_Receita;
import model.shard.Produção;

public class QuadroProduçãoController implements Initializable {

    @FXML private JFXDatePicker dpCalendario;
    @FXML private JFXButton btnAdicionar;
    @FXML private JFXButton btnDeletar;
    @FXML private JFXButton btnAtualizar;
    
    @FXML private TableView<Produção> tvReceitasProdução;
    @FXML private TableColumn<Produção, String> TableColumnReceitas;
    @FXML private TableColumn<Produção, Float> TableColumnCustoReceita;
    @FXML private TableColumn<Produção, Float> TableColumnVendaReceita;
    @FXML private TableColumn<Produção, Integer> TableColumnRemeças;
    
    @FXML private JFXButton btnCadastroReceita;
    @FXML private JFXButton btnRelatorio;
    @FXML private JFXButton btnListaIngrediente;
    @FXML private JFXButton btnListaReceita;
    @FXML private JFXComboBox<String> cbReceita;

    @FXML void adicionarProducao(ActionEvent event) {

    }

    @FXML void atualizarProducao() {
        initTVProducao();
    }
    
    @FXML int clickMouseListViewProduçao(){
        Produção producao = (Produção) tvReceitasProdução.getSelectionModel().getSelectedItem();
        return producao.getId_receita();
    }

    @FXML void deletarProducao(ActionEvent event) {
        Producao_Dao ingD = new Producao_Dao();
        Receita_Dao daoR = new Receita_Dao();
        
        Produção produção = tvReceitasProdução.getSelectionModel().getSelectedItem();
        ingD.deletarReceitaNaProdução(clickMouseListViewProduçao(),dataPicker());
        atualizarProducao();
    }
    
    @FXML String dataPicker(){
        String data = dpCalendario.getValue().toString();
        return data;
    }
    
    @FXML public ObservableList<Produção> atualizarTVProducao(){
        Producao_Dao dao = new Producao_Dao();
        return FXCollections.observableArrayList(dao.listarReceita(dataPicker()));
    }
    
    @FXML public void carregarComboBox(){
        Receita_Dao dao1 = new Receita_Dao();
        combox_obsReceitas = FXCollections.observableArrayList(dao1.listarNomes());
        cbReceita.setItems(combox_obsReceitas);
    }
    
    @FXML public void initTVProducao(){
        TableColumnVendaReceita.setCellValueFactory(new PropertyValueFactory("nome_ing"));
        TableColumnCustoReceita.setCellValueFactory(new PropertyValueFactory("nome_ing"));
        TableColumnRemeças.setCellValueFactory(new PropertyValueFactory("nome_ing"));
        TableColumnReceitas.setCellValueFactory(new PropertyValueFactory("quantia_ing"));
        tvReceitasProdução.setItems(atualizarTVProducao());
    }
    
    //////////
    @FXML private ObservableList<String> combox_obsReceitas;
    @FXML private List<String> combox_receitas = new ArrayList();
    ////////////
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        menu();
        initTVProducao();
        
        dpCalendario.setOnAction((ActionEvent event) -> {
            dataPicker();
            cbReceita.setDisable(false);
            carregarComboBox();
            atualizarProducao();
        });
    }
    @FXML public void menu(){
        btnCadastroReceita.setOnMouseClicked((MouseEvent) -> {
            CadastroReceita fx1 = new CadastroReceita();
            Stage stage = (Stage) btnCadastroReceita.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
            try {
                fx1.start(new Stage());
            } 
            catch(Exception ex){
                System.out.println("A@");
                Logger.getLogger(IntroduçãoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnAtualizar.setOnMouseClicked((MouseEvent) -> {
            try{    
                if(!dpCalendario.getValue().toString().isEmpty()){
                } else {
                    btnAdicionar.setDisable(false);
                    btnDeletar.setDisable(false);
                }    
            }catch(Exception e){
                System.out.println("ERRADO, NÃO PODE"); 
            }
        });
        
        btnRelatorio.setOnMouseClicked((MouseEvent) -> {
            Relatório fx1 = new Relatório();
            Stage stage = (Stage) btnRelatorio.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
            try {
                fx1.start(new Stage());
            } 
            catch(Exception ex){
                System.out.println("A@");
                Logger.getLogger(IntroduçãoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnListaIngrediente.setOnMouseClicked((MouseEvent) -> {
            ListaIngrediente fx1 = new ListaIngrediente();
            Stage stage = (Stage) btnListaIngrediente.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
            try {
                fx1.start(new Stage());
            } catch (Exception ex) {
                System.out.println("A@");
                Logger.getLogger(IntroduçãoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnListaReceita.setOnMouseClicked((MouseEvent) -> {
            ListaReceita fx1 = new ListaReceita();
            Stage stage = (Stage) btnListaReceita.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
            try {
                fx1.start(new Stage());
            } catch (Exception ex) {
                System.out.println("A@");
                Logger.getLogger(IntroduçãoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
