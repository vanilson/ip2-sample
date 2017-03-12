package br.com.banco.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class Cliente implements Serializable {
    
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;

    public Cliente() {
    }
    
    public Cliente(String nome, String cpf, Date dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getIdade(Date dataNascimento) {
        LocalDate dataNasc = LocalDateTime.ofInstant(dataNascimento.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.getYear() - dataNasc.getYear();
    }
}
