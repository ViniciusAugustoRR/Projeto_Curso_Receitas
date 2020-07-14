package controller;

import model.ListaReceita;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import model.QuadroProdução;
import model.Relatório;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.IngredienteReceita_Dao;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import dao.Ingrediente_Dao;
import dao.Receita_Dao;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CadastroReceita;
import model.shard.Ingrediente;
import model.shard.Ingrediente_Receita;
import model.shard.Receita;

public class ListaIngredienteController implements Initializable {
    
    @FXML private JFXTextField txtNomeIngrediente;
    @FXML private JFXTextField txtPreçoIngrediente;
    @FXML private JFXTextField txtQuantFardo;
    @FXML private JFXButton btnSalvarIngrediente;
    @FXML private JFXButton btnDeletar;
    @FXML private JFXButton btnAtualizar;
    
    @FXML private JFXButton btnQuadroProdução;
    @FXML private JFXButton btnListaReceita;
    @FXML private JFXButton btnCadastroReceita;
    @FXML private JFXButton btnRelatorio;

    @FXML private TableView<Ingrediente> tvListaIngredientes;
    @FXML private TableColumn<Ingrediente, String> tableColumnNomeIngrediente;
    @FXML private TableColumn<Ingrediente, Integer> tableColumnFardoIngrediente;
    @FXML private TableColumn<Ingrediente, Float> tableColumnPreçoIngrediente;
    
    @FXML private JFXButton btnDeletarIngrediente;
    @FXML private JFXButton btnAtualizarIngrediente;
    
    @FXML public void cadastrarIngrediente(){
        Ingrediente_Dao ingD = new Ingrediente_Dao();
        Ingrediente ing = new Ingrediente();
        ing.setNome(txtNomeIngrediente.getText());
        ing.setCusto_fardo(Float.parseFloat(txtPreçoIngrediente.getText()));
        ing.setFardo(Integer.parseInt(txtQuantFardo.getText()));
        ingD.InserirIngrediente(ing);
        btnDeletarIngrediente.setDisable(false);
        atualizarLista();
    }
    
    @FXML public void atualizarLista(){
        initTVB_Ingredientes();
    }
    
    @FXML public ObservableList<Ingrediente> atualizarTbvIngrediente(){
        Ingrediente_Dao ingrediente_dao = new Ingrediente_Dao();
        return FXCollections.observableArrayList(ingrediente_dao.listarIngrediente());
    }
    
    @FXML public void excluirDaLista(){
        Ingrediente_Dao ingD = new Ingrediente_Dao();
        Ingrediente ingrediente = tvListaIngredientes.getSelectionModel().getSelectedItem();
        ingD.deletarIngrediente(ingrediente);
        atualizarLista();
    }
    /*
        Initializes the controller class.
    */
    private List<Ingrediente> listIngrediente = new ArrayList<>();
    private ObservableList<Ingrediente> observableIngrediente; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnDeletarIngrediente.setDisable(false);
        initTVB_Ingredientes();
        menu();
    } 
    public void menu(){   
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
        btnQuadroProdução.setOnMouseClicked((MouseEvent) -> {
            QuadroProdução fx1 = new QuadroProdução();
            Stage stage = (Stage) btnQuadroProdução.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
            try {
                fx1.start(new Stage());
            } 
            catch(Exception ex){
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
    
    public void initTVB_Ingredientes(){
        tableColumnNomeIngrediente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnFardoIngrediente.setCellValueFactory(new PropertyValueFactory<>("fardo"));
        tableColumnPreçoIngrediente.setCellValueFactory(new PropertyValueFactory<>("custo_fardo"));
        tvListaIngredientes.setItems(atualizarTbvIngrediente());
    }
    
    public void selecionarItemTableViewIngredientes(Ingrediente ingrediente){
        tvListaIngredientes.getSelectionModel().selectedItemProperty().addListener( 
        (observable, oldValue, newValue) -> selecionarItemTableViewIngredientes(newValue)); 
    }
    
}
