package br.ufrpe.sistema_bancario.gui;

import br.ufrpe.sistema_bancario.negocio.ServidorBanco;
import br.ufrpe.sistema_bancario.negocio.beans.Conta;

public class TelaMobile {

    public TelaMobile() {
    }

    public void pintarTela() {
        // Usando a inst�ncia da Fachada
        String num = "1234-5"; // N�mero deve vir da tela
        double saldo = 50.0; // N�mero deve vir da tela
        Conta c = new Conta(num, saldo);
        ServidorBanco.getInstance().cadastrarConta(c);
    }
}
