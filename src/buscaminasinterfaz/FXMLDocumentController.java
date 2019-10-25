/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasinterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Buscamina;
import static model.Buscamina.PRINCIPIANTE;


/**
 *
 * @author diegoa.torres
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button Principiante;
    
    @FXML
    private Button Intermedio;
    
    @FXML
    private Button Experto;    
    
    private Buscamina b;
    
    @FXML
    private void handleButtonActionP(ActionEvent event) {
        
        try{
            
            b = new Buscamina(1);
            System.out.println("PRINCIPIANTES");
            Stage s = new Stage();
            FXMLLoader loader = new FXMLLoader();

            Pane root = loader.load(getClass().getResource("2Stage.fxml").openStream());
            s.setScene(new Scene(root));
            s.showAndWait();
            
        }catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void handleButtonActionI(ActionEvent event) {
        
         b = new Buscamina(2);
         System.out.println("INTERMEDIO");
    }
    
    @FXML
    private void handleButtonActionE(ActionEvent event) {
        
         b = new Buscamina(3);
         System.out.println("EXPERTO");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void elegirNivelP(){
        
       
    }
    
    public void mostrarTablero(){
        
        
    }
}
