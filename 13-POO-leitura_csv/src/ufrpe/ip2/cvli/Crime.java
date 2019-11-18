package ufrpe.ip2.cvli;

public class Crime {
	
	private String data;
	private String nome;
	private String sexo;
	private String objetoUtilizado;
	private String municipio;
	private int idade;
	private String natureza;
	private int totalVitimas;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getObjetoUtilizado() {
		return objetoUtilizado;
	}
	public void setObjetoUtilizado(String objetoUtilizado) {
		this.objetoUtilizado = objetoUtilizado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNatureza() {
		return natureza;
	}
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	public int getTotalVitimas() {
		return totalVitimas;
	}
	public void setTotalVitimas(int totalVitimas) {
		this.totalVitimas = totalVitimas;
	}
	@Override
	public String toString() {
		return "Crime [data=" + data + ", nome=" + nome + ", sexo=" + sexo + ", objetoUtilizado=" + objetoUtilizado
				+ ", municipio=" + municipio + ", idade=" + idade + ", natureza=" + natureza + ", totalVitimas="
				+ totalVitimas + "]";
	}
	
	
	
	

}
