package banco.gui;

import java.io.IOException;

import banco.gui.conta.controller.ContaEditDialogController;
import banco.gui.conta.controller.ContaPaneController;
import banco.sistema.FachadaBanco;
import banco.sistema.conta.Conta;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BancoApp extends Application {

	private Stage primaryStage;
	private BorderPane rootScene;

	@Override
	public void start(Stage primaryStage) {
		
		// configura titulo da janela e defini um BorderPane como root scene
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sistema Bancario");
		this.rootScene = new BorderPane();
		
		// define tamanho da janela (stage) principal
		Scene scene = new Scene(rootScene, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// carrega e apresenta o painel de contas
		carregarContaPane();
	}

	public void carregarContaPane() {
		try {
			
			// carrega o panel de contas no centro da tela principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(BancoApp.class.getResource("conta/view/ContaPane.fxml"));
			AnchorPane contaView = (AnchorPane) loader.load();
			
			// seta a tela de conta no centro da tela principal
			this.rootScene.setCenter(contaView);
						
	        // seta uma referencia do bancoApp no ContaController
	        ContaPaneController contaController = loader.getController();
	        contaController.setBancoApp(this);
	        
	        // seta a lista de contas
	        ObservableList<Conta> dados = FXCollections.observableArrayList();
	        FachadaBanco.getInstance().listar().stream().forEach(c -> dados.add(c));
	        contaController.setDados(dados);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public boolean abrirContaEditDialog(Conta conta) {
	    try {
	    
	    	// carrega o conteudo da caixa de dialogo
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(BancoApp.class.getResource("conta/view/ContaEditDialog.fxml"));
	        AnchorPane conteudoDialog = (AnchorPane) loader.load();

	        // Cria o dialog Stage (janela de dialgo em que o conteudo ira aparecer)
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edição");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(conteudoDialog);
	        dialogStage.setScene(scene);

	        // Seta a conta no controller.
	        ContaEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setConta(conta);

	        // Apresenta o dialog e aguarda o usuario fechá-lo
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}