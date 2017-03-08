package banco.gui.conta.controller;

import banco.sistema.conta.Conta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContaEditDialogController {
	@FXML private TextField tfNumero;
	@FXML private TextField tfCliente;
	@FXML private TextField tfSaldo;
    
    private Stage dialogStage;
    private Conta conta;
    private boolean okClicked = false;
    
    
    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setConta(Conta c) {
    	this.conta = c;
    	tfNumero.setText(c.getNumero());;
    	tfCliente.setText(c.getCliente());;
    	tfSaldo.setText(c.getSaldo()+"");
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        
    	// so seta a conta se a mesma estiver valida
    	if (isContaValida()) {
            conta.setNumero(tfNumero.getText());
            conta.setCliente(tfCliente.getText());
            conta.setSaldo(Double.parseDouble(tfSaldo.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void cancelar(ActionEvent ae) {
    	  this.dialogStage.close();
    }
    
    private boolean isContaValida() {
    	String msgErro = "";

        if (tfNumero.getText() == null || tfNumero.getText().length() == 0) {
            msgErro += "Número Inválido!\n"; 
        }
        if (tfCliente.getText() == null || tfCliente.getText().length() == 0) {
            msgErro += "Nome do cliente inválido!\n"; 
        }
        
        try {
        	if(Double.parseDouble(tfSaldo.getText()) < 0) {
        		msgErro += "Saldo inválido!\n";	
        	}
        
        } catch(NumberFormatException nfe){ 
        	msgErro += "Saldo precisa ser um número válido!\n";
        }
        
        if (msgErro.length() == 0) {
            return true;
        } else {

        	// Apresenta mensagem de erro num alerta
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Compos Inválidos");
            alert.setHeaderText("Por favor, corrija os valores informados.");
            alert.setContentText(msgErro);

            alert.showAndWait();

            return false;
        }
    }
}
