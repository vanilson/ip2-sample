package ufrpe.ip2.cvli;

public class MunicipioTotalCrimes implements Comparable<MunicipioTotalCrimes>{
	
	private String municipio;
	private Integer totalCrimes;
	
	public MunicipioTotalCrimes(String municipio, int totalCrimes) {
		this.municipio = municipio;
		this.totalCrimes = totalCrimes;
	}
	
	

	public String getMunicipio() {
		return municipio;
	}



	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public Integer getTotalCrimes() {
		return totalCrimes;
	}



	public void setTotalCrimes(Integer totalCrimes) {
		this.totalCrimes = totalCrimes;
	}



	@Override
	public int compareTo(MunicipioTotalCrimes o) {
		return this.totalCrimes.compareTo(o.totalCrimes);
	}

}
