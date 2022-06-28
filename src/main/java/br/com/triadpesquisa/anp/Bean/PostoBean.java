package br.com.triadpesquisa.anp.Bean;

public class PostoBean {
	
	private Long codigo;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String endereco;
	private String complemento;
	private String bairro;
	private String cidade;
	private Long estadoId; 
	private float latitude;
	private float longitude;
	private Long situacaoId;
	private Long bandeiraId;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Long getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public Long getSituacaoId() {
		return situacaoId;
	}
	public void setSituacaoId(Long situacaoId) {
		this.situacaoId = situacaoId;
	}
	public Long getBandeiraId() {
		return bandeiraId;
	}
	public void setBandeiraId(Long bandeiraId) {
		this.bandeiraId = bandeiraId;
	}
	
	
}
