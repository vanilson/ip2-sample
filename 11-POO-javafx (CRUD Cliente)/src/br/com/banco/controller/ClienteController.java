package br.com.banco.controller;

import br.com.banco.model.domain.Cliente;
import br.com.banco.model.facade.ClienteFacade;
import br.com.banco.model.facade.impl.ClienteFacadeImpl;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.xml.bind.ValidationException;

public class ClienteController implements Initializable {

    private final ClienteFacade clienteFacade;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtDataNascimento;
    @FXML
    private Label lblValidationError;

    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn<Cliente, String> clNome;
    @FXML
    private TableColumn<Cliente, String> clCpf;
    @FXML
    private TableColumn<Cliente, String> clTelefone;
    @FXML
    private TableColumn<Cliente, String> clDataNascimento;

    private ObservableList<Cliente> data;

    public static SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public ClienteController() {
        clienteFacade = new ClienteFacadeImpl();
    }
    
    /*@FXML
    public void salvar() {
        try {
            Cliente c = new Cliente();
            setClienteFilds(c);
            validateAttributes(c);
            clienteFacade.salvar(c);
            limparForm();
            refreshTable();
        } catch (ValidationException ex) {
            validationError(ex.getMessage());
        } catch (ParseException ex) {
            validationError("Erro no formato da data");
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    @FXML
    public void imprimirMensagem() {
    	System.out.println("Imprimindo mensagem!!");
    	lblValidationError.setText("Imprimindo nome do cliente: " + txtNome.getText());
    	
    }
    
    @FXML
    public void salvar() throws ParseException {
            Cliente c = new Cliente();
            c.setNome(txtNome.getText());
            c.setCpf(txtCPF.getText());
            c.setTelefone(txtTelefone.getText());

        if (!txtDataNascimento.getText().isEmpty()) {
            Date releaseDate = dataFormatter.parse(txtDataNascimento.getText());
            c.setDataNascimento(releaseDate);
        }
            clienteFacade.salvar(c);
            txtNome.clear();
            txtCPF.clear();
            txtTelefone.clear();
            txtDataNascimento.clear();
            lblValidationError.setText("");
            tblClientes.getItems().setAll(clienteFacade.listarTodos());
        } 

    @FXML
    public void editar() {
        Cliente c = tblClientes.getSelectionModel().getSelectedItem();
        if (c != null) {
            try {
                setClienteFilds(c);
                validateAttributes(c);
                clienteFacade.editar(c);
                limparForm();
                refreshTable();
            } catch (ValidationException ex) {
                validationError("Erro no formato da data");
                validationError(ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            validationError("Por favor selecione um cliente na tabela");
        }
    }

    @FXML
    public void remover() {
        Cliente c = tblClientes.getSelectionModel().getSelectedItem();
        if (c != null) {
            clienteFacade.remover(c);
            limparForm();
            refreshTable();
        } else {
            validationError("Por favor selecione um cliente na tabela");
        }
    }

    @FXML
    public List<Cliente> listarTodos() {
        return clienteFacade.listarTodos();
    }
  
    @FXML
    public void selecionarCliente(MouseEvent arg0) {
        Cliente c = tblClientes.getSelectionModel().getSelectedItem();
        txtNome.setText(c.getNome());
        txtCPF.setText(c.getCpf());
        txtTelefone.setText(c.getTelefone());
        txtDataNascimento.setText(dataFormatter.format(c.getDataNascimento()));
    }

    @FXML
    public void pesquisar() {
        String valueFilterText = txtNome.getText();
        if (!valueFilterText.trim().isEmpty()) {
            tblClientes.getItems().setAll(clienteFacade.listarPeloNome(valueFilterText));
        } else {
            refreshTable();
        }
    }

    @FXML
    public void limparForm() {
        txtNome.clear();
        txtCPF.clear();
        txtTelefone.clear();
        txtDataNascimento.clear();
        lblValidationError.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        clCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        clTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        clDataNascimento.setCellValueFactory(new PropertyValueFactory<Cliente, String>("dataNascimento"));
        
        data = FXCollections.observableArrayList();
        tblClientes.setItems(data);
        data.addAll(clienteFacade.listarTodos());
    }

    private void setClienteFilds(Cliente cliente) throws ParseException {
        cliente.setNome(txtNome.getText());
        cliente.setCpf(txtCPF.getText());
        cliente.setTelefone(txtTelefone.getText());

        if (!txtDataNascimento.getText().isEmpty()) {
            Date releaseDate = dataFormatter.parse(txtDataNascimento.getText());
            cliente.setDataNascimento(releaseDate);
        }
    }

    private void validateAttributes(Cliente cliente) throws ValidationException {
        String returnMs = "";

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            returnMs += "'Nome' ";
        }

        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            returnMs += "'CPF' ";
        }

        if (cliente.getDataNascimento() == null) {
            returnMs += "'DataNascimento' ";
        }

        if (!returnMs.isEmpty()) {
            throw new ValidationException(
                    String.format(
                            "Os argumentos [%s] obrigatorios estao nulos ou com valores invalidos",
                            returnMs));
        }
    }

    private void refreshTable() {
        tblClientes.getItems().setAll(clienteFacade.listarTodos());
    }

    private void validationError(String value) {
        lblValidationError.setText(value);
    }

}
