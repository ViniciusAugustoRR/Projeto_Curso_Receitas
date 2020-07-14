package controller;

import model.ListaReceita;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.CadastroReceita;
import model.ListaIngrediente;
import model.QuadroProdução;
/**
 * FXML Controller class
 *
 * @author Carvalho
 */
public class RelatorioController implements Initializable {
    
    @FXML private JFXDatePicker dpRelatorio;
    @FXML private JFXButton btnAtualizarRelatorio;
    @FXML private JFXListView<?> lvRelatorio;
    
    @FXML private JFXButton btnCadastroReceita;
    @FXML private JFXButton btnQuadroProdução;
    @FXML private JFXButton btnListaIngrediente;
    @FXML private JFXButton btnListaReceita;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
