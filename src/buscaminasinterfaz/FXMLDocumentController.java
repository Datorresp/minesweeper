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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private  int dificultad;    
    
    @FXML
    private void handleButtonActionP(ActionEvent event) {
       
        dificultad = 1;
        int i = 0;
        int j = 0;
        System.out.println("PRINCIPIANTES" + dificultad);
        b = new Buscamina(dificultad);
        VBox root = new VBox();
        GridPane gp = new GridPane();
        root.getChildren().add(gp);
        Scene s = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(s);
        newStage.show();
        for ( i = 0; i < b.getCasillas().length; i++) {
            for ( j = 0; j < b.getCasillas()[0].length; j++) {
                Button bo = new Button();
                gp.add(bo, i, j);
                bo.setId(i + "," + j);
                bo.setOnAction(e->{
                
                String id = bo.getId();
                String[] pos = id.split(",");
                int ii = Integer.parseInt(pos[0]);
                int jj = Integer.parseInt(pos[1]);
                b.abrirCasilla(ii, jj);
                bo.setText(b.mostrarCasilla(ii, jj));
                
                    if (b.darCasillas()[ii][jj].esMina() == true) {
                        
                        VBox root2 = new VBox();
                        Label l = new Label("Perdio");
                        root2.getChildren().remove(0);
                        root2.getChildren().add(l);
                        Scene s2 = new Scene(root2);                        
                        newStage.setScene(s);
                        newStage.show();
                    }
                
                   
                        
                        
                        
                
                });
                            
            }
        }       
    }
     
    
    @FXML
    private void handleButtonActionI(ActionEvent event) {
                
        dificultad = 2;
        System.out.println("INTERMEDIO" + dificultad);
        b = new Buscamina(dificultad);
        
        VBox root = new VBox();
        GridPane gp = new GridPane();
        for (int i = 0; i < b.getCasillas().length; i++) {
            for (int j = 0; j < b.getCasillas()[0].length; j++) {
                Button b = new Button();
                gp.add(b, i, j);
                        
            }            
        }
        root.getChildren().add(gp);
        Scene s = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(s);
        newStage.show();
        
    }
    
    @FXML
    private void handleButtonActionE(ActionEvent event) {
        
        dificultad = 3;
        System.out.println("EXPERTO");
        b = new Buscamina(dificultad);
        VBox root = new VBox();
        GridPane gp = new GridPane();
        for (int i = 0; i < b.getCasillas().length; i++) {
            for (int j = 0; j < b.getCasillas()[0].length; j++) {
                Button b = new Button();
                gp.add(b, i, j);
                
            }            
        }
        root.getChildren().add(gp);
        Scene s = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(s);
        newStage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
