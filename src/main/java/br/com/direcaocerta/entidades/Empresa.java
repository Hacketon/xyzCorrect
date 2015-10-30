package br.com.direcaocerta.entidades;

public class Empresa {
	
	/**
	 * 
	 */
	
	private String nome_empresa;
	private String cnpj_empresa;
	private String login_empresa;
	private String senha_empresa;
	private String telefone_empresa;
	private Integer id_empresa;

	public String getNome_empresa() {
		return nome_empresa;
	}

	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}

	public String getCnpj_empresa() {
		return cnpj_empresa;
	}

	public void setCnpj_empresa(String cnpj_empresa) {
		this.cnpj_empresa = cnpj_empresa;
	}

	public String getLogin_empresa() {
		return login_empresa;
	}

	public void setLogin_empresa(String login_empresa) {
		this.login_empresa = login_empresa;
	}

	public String getSenha_empresa() {
		return senha_empresa;
	}

	public void setSenha_empresa(String senha_empresa) {
		this.senha_empresa = senha_empresa;
	}

	public String getTelefone_empresa() {
		return telefone_empresa;
	}

	public void setTelefone_empresa(String telefone_empresa) {
		this.telefone_empresa = telefone_empresa;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	@Override
	public String toString() {
		return "Empresa [nome_empresa=" + nome_empresa + ", cnpj_empresa="
				+ cnpj_empresa + ", login_empresa=" + login_empresa
				+ ", senha_empresa=" + senha_empresa + ", telefone_empresa="
				+ telefone_empresa + ", id_empresa=" + id_empresa + "]";
	}

}
