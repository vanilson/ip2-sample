package ufrpe.ip2.cvli;

public class CityTotalCrimes implements Comparable<CityTotalCrimes>{
	
	private String city;
	private Integer totalCrimes;
	
	public CityTotalCrimes(String city, int totalCrimes) {
		this.city = city;
		this.totalCrimes = totalCrimes;
	}
	
	

	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Integer getTotalCrimes() {
		return totalCrimes;
	}



	public void setTotalCrimes(Integer totalCrimes) {
		this.totalCrimes = totalCrimes;
	}



	@Override
	public int compareTo(CityTotalCrimes o) {
		return this.totalCrimes.compareTo(o.totalCrimes);
	}

}
