package ufrpe.ip2.cvli;

public class Crime {
	
	// used to define the order of data in CSV file
	private final static int DATA = 0;
	private final static int NOME = 1;
	private final static int SEXO = 2;
	private final static int OBJETO = 3;
	private final static int MUNICIPIO = 4;
	private final static int IDADE = 5;
	private final static int NATUREZA = 6;
	private final static int TOTAL_VITIMAS = 7;
	
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
	
	public static Crime of(String csvLine) {

		// 0 1 2 ... 3 4 5 6 7
		// data, nome, sexo, objeto_utilizado,municipio,idade,natureza,total_vitimas
		String[] dados = csvLine.split(",");

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
//			System.err.println("Erro ao converter linha do CSV em um crime! | Linha lida: " + linha);
//			e.printStackTrace();
			
			return null;
		}

		return c;
	}
	
	
	
	

}
