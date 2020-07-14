package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.IngredienteReceita_Dao;
import dao.Receita_Dao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.shard.Ingrediente_Receita;
import model.shard.Receita;

/**
 * FXML Controller class
 *
 * @author Carvalho
 */

public class CadastroReceitasController implements Initializable {

    @FXML private JFXButton btnAtualizarLista;
    @FXML private JFXButton btnDeletarReceita;
    @FXML private JFXButton BtnSalvarReceita;
    
    @FXML private TableView<Receita> tvListaReceitas;
    @FXML private TableColumn<Receita, String> tableColumnNomeReceita;
    @FXML private TableColumn<Receita, Float> tableColumnCustoReceita;
    
    @FXML private JFXTextField txtNomeReceita;
    @FXML private JFXTextField txtTempoReceita;
    @FXML private JFXTextField txtRendimentoReceita;
    @FXML private JFXTextField txtLucroReceita;
    
    @FXML private JFXButton btnQuadroProdução;
    @FXML private JFXButton btnRelatorio;
    @FXML private JFXButton btnListaReceita;
    @FXML private JFXButton btnCadastroReceita;
    
    @FXML void atualizarLista(){
        atualizarTbReceitas();
    }
    
    @FXML public String pegarSelecionadoReceita(){
        Receita receita = (Receita) tvListaReceitas.getSelectionModel().getSelectedItem();
        return receita.getNome();
    }
    
   /* @FXML void excluirReceita(Receita receita){
        Receita_Dao recD = new Receita_Dao();
        recD.deletarReceita(recD.puxarIDReceita(pegarSelecionadoReceita()));
    }*/

    @FXML void cadastrarReceita(ActionEvent event){
        Receita_Dao recD = new Receita_Dao();
        Receita receita = new Receita();
        receita.setNome(txtNomeReceita.getText());
        receita.setMargem(Float.parseFloat(txtLucroReceita.getText()));
        receita.setRendimento(Float.parseFloat(txtRendimentoReceita.getText()));
        receita.setTempo(Integer.parseInt(txtTempoReceita.getText()));
        recD.InserirReceita(receita);
    }
    @FXML public void initTbv(){
        tableColumnNomeReceita.setCellValueFactory(new PropertyValueFactory("nome"));
        tvListaReceitas.setItems(atualizarTbReceitas());
    }
    
    @FXML public ObservableList<Receita> atualizarTbReceitas(){
        Receita_Dao receita_dao = new Receita_Dao();
        return FXCollections.observableArrayList(receita_dao.listarReceita());
    }
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTbv();
    }    

}
