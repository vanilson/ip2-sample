/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BancoView extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        URL arquivoFXML = getClass().getResource("./bancoView.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        
        palco.setScene(new Scene(fxmlParent));
        palco.setTitle("Cadastro de Clientes");
        palco.setResizable(false);  
        
        palco.show();
    }
}
