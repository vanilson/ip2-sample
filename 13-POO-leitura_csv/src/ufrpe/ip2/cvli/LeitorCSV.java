package ufrpe.ip2.cvli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeitorCSV {

	public final static int DATA = 0;
	public final static int NOME = 1;
	public final static int SEXO = 2;
	public final static int OBJETO = 3;
	public final static int MUNICIPIO = 4;
	public final static int IDADE = 5;
	public final static int NATUREZA = 6;
	public final static int TOTAL_VITIMAS = 7;

	public static void main(String[] args) {

		RepositorioCrimes crimes = carregarCrimesNoRepositorio("cvli_pernambuco_dezembro-2015.csv");
		
		List<Crime> homicidios = crimes.listarCrimesPorNatureza("HOMICIDIO");
		System.out.println("Total de HOMICIDIOS registrados em Nov/2015: " + homicidios.size());
		
		List<Crime> crimesRegistrados = crimes.listarTodos();
		System.out.println("Total geral de crimes registrados em Nov/2015: " + crimesRegistrados.size());
		
		System.out.println("Top 3 municipios com mais crimes");
		List<MunicipioTotalCrimes> top3Municipios = top3MunicipiosComMaisCrimes(crimes);
		top3Municipios.forEach(e -> System.out.println(e.getMunicipio() + ": " + e.getTotalCrimes()));
	}

	private static List<MunicipioTotalCrimes> top3MunicipiosComMaisCrimes(RepositorioCrimes crimes) {
		List<String> municipios = crimes.listarMunicipios();
		List<MunicipioTotalCrimes> topMunicipios = new ArrayList();
		
		municipios
			.forEach(m -> topMunicipios.add(new MunicipioTotalCrimes(m, crimes.listarCrimesPorMunicipio(m).size())));
		
		Collections.sort(topMunicipios);
		Collections.reverse(topMunicipios);
		
		return topMunicipios.subList(0, 3);
	}

	private static RepositorioCrimes carregarCrimesNoRepositorio(String nomeArquivo) {
		RepositorioCrimes crimes = new RepositorioCrimes();
		BufferedReader csvReader = null;
		String linha = null;
		try {
			csvReader = new BufferedReader(new FileReader(nomeArquivo));
			csvReader.readLine(); // ignorar header!

			while ((linha = csvReader.readLine()) != null) {

				// cria objeto crime e adiciona no repositorio
				crimes.adicionar(criarCrime(linha));
			}

		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo!!");

			System.out.println("Linha lida: " + linha);
			e.printStackTrace();

		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar arquivo!!");
				e.printStackTrace();
			}
		}
		
		return crimes;
	}

	private static Crime criarCrime(String linha) {

		// 0 1 2 ... 3 4 5 6 7
		// data, nome, sexo, objeto_utilizado,municipio,idade,natureza,total_vitimas
		String[] dados = linha.split(",");

		Crime c = new Crime();
		try {
		
			c.setData(dados[DATA]);
			c.setNome(dados[NOME]);
			c.setNome(dados[SEXO]);
			c.setMunicipio(dados[MUNICIPIO]);
			c.setNatureza(dados[NATUREZA]);
			c.setObjetoUtilizado(dados[OBJETO]);
			
			c.setIdade(Integer.valueOf(dados[IDADE]));
			c.setTotalVitimas(Integer.valueOf(dados[TOTAL_VITIMAS]));

		} catch (Exception e) {
//			System.err.println("Erro ao converter linha do CSV em um crime!");
//			System.out.println("Linha lida: " + linha);
			
//			e.printStackTrace();
			
			return null;
		}

//		System.out.println(c);

		return c;
	}

}
