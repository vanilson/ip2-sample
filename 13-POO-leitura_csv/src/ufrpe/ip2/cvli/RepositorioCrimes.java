package ufrpe.ip2.cvli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RepositorioCrimes {

	Map<String, List<Crime>> crimesMap = new HashMap();

	public List<Crime> listAll() {
		List<Crime> todosCrimes = new ArrayList<Crime>();

		crimesMap.values().forEach(listaCrimes -> todosCrimes.addAll(listaCrimes));

		return todosCrimes;
	}

	public void add(Crime c) {
		
		if (c == null) {
			return;
		}

		List<Crime> crimesNoMunicipio = crimesMap.get(c.getMunicipio());

		if (crimesNoMunicipio == null) {

			crimesNoMunicipio = new ArrayList<Crime>();
			crimesNoMunicipio.add(c);

			crimesMap.put(c.getMunicipio(), crimesNoMunicipio);

		} else {
			crimesNoMunicipio.add(c);
		}
	}

	public List<Crime> listByCrimeType(String natureza) {

		return this.listAll().stream()
				.filter(c -> natureza.equals(c.getNatureza()))
				.collect(Collectors.toList());

	}
	
	public List<CityTotalCrimes> top3CitiesWithMoreCrimes() {
		
		List<String> municipios = listAllCities();
		List<CityTotalCrimes> topMunicipios = new ArrayList<CityTotalCrimes>();
		
		municipios
			.forEach(m -> topMunicipios.add(new CityTotalCrimes(m, listCrimesByCity(m).size())));
		
		Collections.sort(topMunicipios);
		Collections.reverse(topMunicipios);
		
		return topMunicipios.subList(0, 3);
	}

	public List<Crime> listCrimesByCity(String city) {
		return crimesMap.get(city);
	}
	
	public List<String> listAllCities() {
		return new ArrayList<String>(crimesMap.keySet());
	}
}
