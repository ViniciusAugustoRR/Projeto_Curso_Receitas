package controller;

import dao.Receita_Dao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import dao.IngredienteReceita_Dao;
import dao.Ingrediente_Dao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.CadastroReceita;
import model.ListaIngrediente;
import model.QuadroProdução;
import model.Relatório;
import model.shard.Ingrediente;
import model.shard.Ingrediente_Receita;
import model.shard.Receita;
/**
 * FXML Controller class
 *
 * @author Carvalho
 */
public class ListaReceitaController implements Initializable {
    
    @FXML private JFXButton BtnSalvarReceita;
    @FXML private JFXComboBox<String> cbReceita;
    @FXML private JFXButton btnAdicionar;
    @FXML private JFXButton btnDeletar;
    @FXML private JFXButton btnCarregar;
    
    @FXML private TableView<Ingrediente_Receita> tvIngredientesReceita;
    @FXML private TableColumn<Ingrediente, String> tableColumnReceitaIngrediente;
    @FXML private TableColumn<Ingrediente_Receita, Integer> tableColumnReceitaQuantidade;
    
    @FXML private JFXComboBox<String> cbIngredientes1;
    @FXML private JFXButton btnQuadroProdução;
    @FXML private JFXButton btnRelatorio;
    @FXML private JFXButton btnListaIngrediente;
    @FXML private JFXButton btnCadastroReceita;
    
    @FXML public void on(){
        btnCarregar.setOnMouseClicked((MouseEvent)->{
           initTbv();
           menu();
           carregarComboBox();
        });
    }
    
    
    @FXML public void carregarComboBox(){
        Ingrediente_Dao dao2 = new Ingrediente_Dao();
        combox_obsIngrediente = FXCollections.observableArrayList(dao2.listarNomes());
        cbIngredientes1.setItems(combox_obsIngrediente);
        Receita_Dao dao1 = new Receita_Dao();
        combox_obsReceitas = FXCollections.observableArrayList();
        cbReceita.setItems(combox_obsReceitas);
    }
    
    @FXML public String pegarSelecionadoR(){
        String selecionadoReceita = cbReceita.getSelectionModel().getSelectedItem();
        return selecionadoReceita;
    }
    @FXML public String pegarSelecionadoI(){
        String selecionadoIngrediente = cbIngredientes1.getSelectionModel().getSelectedItem();
        return selecionadoIngrediente;
    }
    
    @FXML public void adicionarIngrediente(){
        IngredienteReceita_Dao dao = new IngredienteReceita_Dao();
        Receita_Dao daoR = new Receita_Dao();
        Ingrediente_Dao daoI = new Ingrediente_Dao();
        int quant_ing = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do ingrediente nessa receita."));
        dao.inserirIngredienteNaReceita(daoR.puxarIDReceita(pegarSelecionadoR()), daoI.puxarIDIngrediente(pegarSelecionadoI()), quant_ing, pegarSelecionadoI());
    }
    
    @FXML public Ingrediente_Receita clickMouseListViewReceita(){
        Ingrediente_Receita ing_receita = (Ingrediente_Receita) tvIngredientesReceita.getSelectionModel().getSelectedItem();
        return ing_receita;
    }
 
    /**
     * Initializes the controller class.
     */
    @FXML private ObservableList<String> combox_obsReceitas;
    @FXML private List<String> combox_receitas = new ArrayList();
    @FXML private ObservableList<String> combox_obsIngrediente; 
    @FXML private List<String> combox_listIngrediente = new ArrayList<>();
    ///////////////////////
    @FXML private ObservableList<Ingrediente_Receita> tbv_obsTableIngrediente; 
    @FXML private List<Ingrediente_Receita> tbv_listIngredientesReceitas = new ArrayList<>(); 
    /////////////////////
    
    @FXML public void initTbv(){
        tableColumnReceitaIngrediente.setCellValueFactory(new PropertyValueFactory("nome_ing"));
        tableColumnReceitaQuantidade.setCellValueFactory(new PropertyValueFactory("quantia_ing"));
        tvIngredientesReceita.setItems(atualizarTbvrec());
    }
    
    @FXML public ObservableList<Ingrediente_Receita> atualizarTbvrec(){
        IngredienteReceita_Dao ingrecdao = new IngredienteReceita_Dao();
        Receita_Dao receit1 = new Receita_Dao();
        return FXCollections.observableArrayList(ingrecdao.listarIngredientesReceita(receit1.puxarIDReceita(this.pegarSelecionadoR())));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTbv();
        menu();
        carregarComboBox();
    }    
    @FXML public void menu(){
        btnCarregar.setOnMouseClicked((MouseEvent) -> {
            atualizarTbvrec();
        });
        
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
    }
}
