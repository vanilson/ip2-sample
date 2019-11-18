package ufrpe.ip2.cvli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RepositorioCrimes {

	Map<String, List<Crime>> crimesMap = new HashMap();

	public List<Crime> listarTodos() {
		List<Crime> todosCrimes = new ArrayList<Crime>();

		crimesMap.values().forEach(listaCrimes -> todosCrimes.addAll(listaCrimes));

		return todosCrimes;
	}

	public void adicionar(Crime c) {
		
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

	public List<Crime> listarCrimesPorNatureza(String natureza) {

		return this.listarTodos().stream()
				.filter(c -> natureza.equals(c.getNatureza()))
				.collect(Collectors.toList());

	}

	public List<Crime> listarCrimesPorMunicipio(String municipio) {
		return crimesMap.get(municipio);
	}
	
	public List<String> listarMunicipios() {
		return new ArrayList<String>(crimesMap.keySet());
	}
}
