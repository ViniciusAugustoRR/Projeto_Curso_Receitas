package controller;

import model.ListaReceita;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.CadastroReceita;
import model.ListaIngrediente;
import model.QuadroProdução;
import model.Relatório;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;


public class IntroduçãoController implements Initializable {

    @FXML private JFXButton btnQuadroProdução;
    @FXML private JFXButton btnRelatorio;
    @FXML private JFXButton btnListaIngrediente;
    @FXML private JFXButton btnListaReceita;  
    @FXML private JFXButton btnCadastroReceita;

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
            System.out.println("C@");
            Stage stage = (Stage) btnListaIngrediente.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
            try {
                fx1.start(new Stage());
                System.out.println("1@");
            } catch (Exception ex) {
                System.out.println("A@");
                Logger.getLogger(IntroduçãoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnListaReceita.setOnMouseClicked((MouseEvent) -> {
            ListaReceitaController c1 = new ListaReceitaController();
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
    }    
   
    
}
