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
import javafx.scene.Parent;
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
                bo.setText("-");
                bo.setId(i + "," + j);
                bo.setOnAction(e->{
                
                String id = bo.getId();
                String[] pos = id.split(",");
                int ii = Integer.parseInt(pos[0]);
                int jj = Integer.parseInt(pos[1]);
                b.abrirCasilla(ii, jj);
                bo.setText(b.mostrarCasilla(ii, jj));
                
                    if (b.darCasillas()[ii][jj].esMina() == true) {
                        
                        try{
                            
                            Stage sta = new Stage();
                            Parent gameOver = FXMLLoader.load(getClass().getResource("/buscaminasinterfaz/VentanaOver.fxml"));
                            Scene gameO = new Scene(gameOver);
                            sta.setScene(gameO);
                            sta.show();
                        }catch (IOException ex) {
                            
                            ex.printStackTrace();
                        }
                        
                        
                    }if (b.gano()==false) {
                       
                        try{
                            Stage stag = new Stage();
                            Parent win = FXMLLoader.load(getClass().getResource("/buscaminasinterfaz/VentanaWin.fxml"));
                            Scene winW = new Scene(win);
                            stag.setScene(winW);
                            stag.show();   
                            
                        }catch (IOException ex) {
                        
                            ex.printStackTrace();
                        }    
                    }
                       
                
                });
                            
            }
        }       
    }
    
    private void inicio(ActionEvent event){
        
        
    }
     
    
    @FXML
    private void handleButtonActionI(ActionEvent event) {
                
        dificultad = 2;
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
                bo.setText("-");
                bo.setId(i + "," + j);
                bo.setOnAction(e->{
                
                String id = bo.getId();
                String[] pos = id.split(",");
                int ii = Integer.parseInt(pos[0]);
                int jj = Integer.parseInt(pos[1]);
                b.abrirCasilla(ii, jj);
                bo.setText(b.mostrarCasilla(ii, jj));
                
                    if (b.darCasillas()[ii][jj].esMina() == true) {
                        
                        try{
                            
                            Stage sta = new Stage();
                            Parent gameOver = FXMLLoader.load(getClass().getResource("/buscaminasinterfaz/VentanaOver.fxml"));
                            Scene gameO = new Scene(gameOver);
                            sta.setScene(gameO);
                            sta.show();
                        }catch (IOException ex) {
                            
                            ex.printStackTrace();
                        }
                        
                        
                    }if (b.gano()==false) {
                       
                        try{
                            Stage stag = new Stage();
                            Parent win = FXMLLoader.load(getClass().getResource("/buscaminasinterfaz/VentanaWin.fxml"));
                            Scene winW = new Scene(win);
                            stag.setScene(winW);
                            stag.show();   
                            
                        }catch (IOException ex) {
                        
                            ex.printStackTrace();
                        }    
                    }
                       
                
                });
                            
            }
        }
        
    }
    
    @FXML
    private void handleButtonActionE(ActionEvent event) {
        
        dificultad = 3;
        System.out.println("EXPERTO");
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
                bo.setText("-");
                bo.setId(i + "," + j);
                bo.setOnAction(e->{
                
                String id = bo.getId();
                String[] pos = id.split(",");
                int ii = Integer.parseInt(pos[0]);
                int jj = Integer.parseInt(pos[1]);
                b.abrirCasilla(ii, jj);
                bo.setText(b.mostrarCasilla(ii, jj));
                
                    if (b.darCasillas()[ii][jj].esMina() == true) {
                        
                        try{
                            
                            Stage sta = new Stage();
                            Parent gameOver = FXMLLoader.load(getClass().getResource("/buscaminasinterfaz/VentanaOver.fxml"));
                            Scene gameO = new Scene(gameOver);
                            sta.setScene(gameO);
                            sta.show();
                        }catch (IOException ex) {
                            
                            ex.printStackTrace();
                        }
                        
                        
                    }if (b.gano()==false) {
                       
                        try{
                            Stage stag = new Stage();
                            Parent win = FXMLLoader.load(getClass().getResource("/buscaminasinterfaz/VentanaWin.fxml"));
                            Scene winW = new Scene(win);
                            stag.setScene(winW);
                            stag.show();   
                            
                        }catch (IOException ex) {
                        
                            ex.printStackTrace();
                        }    
                    }
                       
                
                });
                            
            }
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
