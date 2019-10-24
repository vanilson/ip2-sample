package banco.sistema.conta.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import banco.sistema.conta.Conta;
import banco.sistema.conta.exceptions.ContaNaoExisteException;

public class RepositorioContasFile implements IRepositorioContas, Serializable {

    private List<Conta> contas;

    private static RepositorioContasFile instance;

    private RepositorioContasFile(int tamanho) {
        this.contas = new ArrayList<Conta>();
    }

    public static IRepositorioContas getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioContasFile lerDoArquivo() {
        RepositorioContasFile instanciaLocal = null;

        File in = new File("contas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioContasFile) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioContasFile(100);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }

        return instanciaLocal;
    }

    public void salvarNoArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("contas.dat");
        if(!out.exists()) {
        	try {
				out.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { oos.close(); } catch (IOException e) {/*Silent*/}
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.ufrpe.sistema_bancario.dados.IRepositorio#cadastrar(br.ufrpe.
     * sistema_bancario.negocio.classes_basicas.Conta)
     */
    public void inserir(Conta c) {
      contas.add(c);
      this.salvarNoArquivo();
    }

    public Conta consultar(String num) {
        return contas.stream()
        		.filter(c -> c.getNumero().equals(num))
        		.findFirst()
        		.orElse(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.ufrpe.sistema_bancario.dados.IRepositorio#existe(java.lang.String)
     */
    public boolean existe(String numConta) {
        return this.consultar(numConta) != null;
    }

    public void remover(String num) throws ContaNaoExisteException {
    	this.contas.remove(this.consultar(num));
    	this.salvarNoArquivo();
    }

	@Override
	public void atualizar(Conta c) {
		int posicaoContaExistente = this.contas.indexOf(this.consultar(c.getNumero()));
		this.contas.set(posicaoContaExistente, c); // TODO Levantar excecao de conta nao existente
		this.salvarNoArquivo();
	}

	@Override
	public List<Conta> listarTodas() {
		return this.contas;
	}

    /**
     * Retorna a lista de contas cujo saldo é maior do que 
     * o valor informado
     * 
     */
	@Override
	public List<Conta> listar(double valor) {
		List<Conta> contasRicas = new ArrayList<Conta>();
		for(Conta c : this.contas) 
		{
			if(c.getSaldo() > valor) 
			{
				contasRicas.add(c);
			}
		}
		return contasRicas; 
	}

	public List<Conta> listarComStream(double valor) {
		return this.contas.stream()
				.filter(c -> c.getSaldo() > valor)
				.collect(Collectors.toList()); 
	}
	
	public double somarContas() {
		return this.contas.stream()
				.mapToDouble(c -> c.getSaldo())
				.sum();
	}
}
