package ufrpe.ip2.cvli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVReader {

	public static void main(String[] args) {

		RepositorioCrimes crimes = loadCrimesFromCSVFile("cvli_pernambuco_dezembro-2015.csv");
		
		List<Crime> homicidios = crimes.listByCrimeType("HOMICIDIO");
		System.out.println("Total de HOMICIDIOS registrados em Nov/2015: " + homicidios.size());
		
		List<Crime> crimesRegistrados = crimes.listAll();
		System.out.println("Total geral de crimes registrados em Nov/2015: " + crimesRegistrados.size());
		
		System.out.println("Top 3 municipios com mais crimes");
		List<CityTotalCrimes> top3Municipios = crimes.top3CitiesWithMoreCrimes();
		top3Municipios.forEach(e -> System.out.println(e.getMunicipio() + ": " + e.getTotalCrimes()));
	}

	private static RepositorioCrimes loadCrimesFromCSVFile(String nomeArquivo) {
		
		RepositorioCrimes crimes = new RepositorioCrimes();
		BufferedReader csvReader = null;
		String csvLine = null;
		
		try {
			csvReader = new BufferedReader(new FileReader(nomeArquivo));
			csvReader.readLine(); // ignore header!

			while ((csvLine = csvReader.readLine()) != null) {
				crimes.add(Crime.of(csvLine)); // create crime object and add to repository
			}

		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo!! | Linha lida: " + csvLine);
			e.printStackTrace();

		} finally {
			closeFile(csvReader);
		}
		
		return crimes;
	}

	private static void closeFile(BufferedReader csvReader) {
		try {
			csvReader.close();
		} catch (IOException e) {
			System.out.println("Erro ao fechar arquivo!!");
			e.printStackTrace();
		}
	}

}
