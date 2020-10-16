package banco.gui.conta.controller;

import banco.gui.BancoApp;
import banco.sistema.FachadaBanco;
import banco.sistema.conta.Conta;
import banco.sistema.conta.exceptions.ContaNaoExisteException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContaPaneController {
	
	private BancoApp bancoApp;
	
	private FachadaBanco fachada = FachadaBanco.getInstance();
	
	// lado esquerdo
	@FXML
	private TableView<Conta> tabelaContas;
	
	@FXML
	private TableColumn<Conta, String> colunaNumero;

	@FXML
	private TableColumn<Conta, String> colunaCliente;
	

	// lado direito
	@FXML private Label labelNumero;
	@FXML private Label labelCliente;
	@FXML private Label labelSaldo;
	
	
	
	public void setBancoApp(BancoApp app) {
		this.bancoApp = app;
	}
	
    @FXML
    private void initialize() {
        // Inicializa a tabela de contas com duas colunas
        colunaNumero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero()));
        colunaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente()));
        
        
        // limpa as informacoes na tela.
        mostrarDetalhesConta(null);

        // Listen for selection changes and show the person details when changed.
        tabelaContas.getSelectionModel().selectedItemProperty()
        .addListener(
                (observable, oldValue, newValue) -> mostrarDetalhesConta(newValue));
    }
    
    public void setDados(ObservableList<Conta> dadosConta) {
    	tabelaContas.setItems(dadosConta);
    }
	
    
    private void mostrarDetalhesConta(Conta conta) {
        if (conta != null) {

        	// preenche os labels com os dados da conta
        	labelNumero.setText(conta.getNumero());
        	labelCliente.setText(conta.getCliente());
        	labelSaldo.setText(conta.getSaldo() + "");

        } else {
        	
        	// conta nula
        	labelNumero.setText("");
        	labelCliente.setText("");
        	labelSaldo.setText("");
        }
    }
    
    @FXML
    private void handleEditarConta() {
        
    	Conta contaSelecionada = tabelaContas.getSelectionModel().getSelectedItem();
        int indiceSelecionado = tabelaContas.getSelectionModel().getSelectedIndex();
        
        if (contaSelecionada != null) {
            boolean okClicked = bancoApp.abrirContaEditDialog(contaSelecionada);
            if (okClicked) {
            	
            	// TODO: Chamar fachada
            	
            	mostrarDetalhesConta(contaSelecionada);

            	// atualizar tabela
            	atualizarTabela();
            }

        } else {

        	// nada selecionado
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(bancoApp.getPrimaryStage());
            alert.setTitle("Sem seleção");
            alert.setHeaderText("Nenhuma conta selecionada");
            alert.setContentText("Por favor, selecione uma conta na tabela.");

            alert.showAndWait();
        }
    }
    
    void atualizarTabela() {
    	tabelaContas.refresh();
//        final List<Conta> items = tabelaContas.getItems();
//        if( items == null || items.size() == 0) return;
//
//        final Conta item = tabelaContas.getItems().get(0);
//        items.remove(0);
//        Platform.runLater(new Runnable(){
//            @Override
//            public void run() {
//                items.add(0, item);
//            }
//        });
     }
    
    
}
