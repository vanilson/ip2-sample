package application;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Note that we load the panes with the FXMLLoader
 * on every use. This allows us to manipulate the
 * CSS between loads and have it take affect. 
 * 
 * Also, the panes should not save state internally.
 * Reloading the FXML forces better programming
 * design, because it is impossible to get lazy
 * and expect the panes to save their own state.
 */
public class MyMenusControl {

  @FXML // fx:id="displayOne"
  private MenuItem displayOne; // Value injected by FXMLLoader

  @FXML // fx:id="displayTwo"
  private MenuItem displayTwo; // Value injected by FXMLLoader

  /**
   * Event handler for MenuItem one
   */
  @FXML
  void switchToOne(ActionEvent event) {
    
    try {
      
      URL paneOneUrl = getClass().getResource("PaneOne.fxml");
      AnchorPane paneOne = FXMLLoader.load( paneOneUrl );
      
      BorderPane border = Main.getRoot();
      border.setCenter(paneOne);
      
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  /**
   * Event handler for MenuItem two
   */
  @FXML
  void switchToTwo(ActionEvent event) {

    try {
      
      URL paneTwoUrl = getClass().getResource("PaneTwo.fxml");
      AnchorPane paneTwo = FXMLLoader.load( paneTwoUrl );
      
      BorderPane border = Main.getRoot();
      border.setCenter(paneTwo);
    
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}