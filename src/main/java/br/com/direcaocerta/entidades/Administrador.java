package br.com.direcaocerta.entidades;

public class Administrador {

	/**
	 * 
	 */
	
	private Integer id_administrador;
	private String nome_administrador;
	private String login_administrador;
	private String senha_administrador;
	private String cpf_administrador;

	public Integer getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(Integer id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getNome_administrador() {
		return nome_administrador;
	}

	public void setNome_administrador(String nome_administrador) {
		this.nome_administrador = nome_administrador;
	}

	public String getLogin_administrador() {
		return login_administrador;
	}

	public void setLogin_administrador(String login_administrador) {
		this.login_administrador = login_administrador;
	}

	public String getSenha_administrador() {
		return senha_administrador;
	}

	public void setSenha_administrador(String senha_administrador) {
		this.senha_administrador = senha_administrador;
	}

	public String getCpf_administrador() {
		return cpf_administrador;
	}

	public void setCpf_administrador(String cpf_administrador) {
		this.cpf_administrador = cpf_administrador;
	}

	@Override
	public String toString() {
		return "Administrador [id_administrador=" + id_administrador
				+ ", nome_administrador=" + nome_administrador
				+ ", login_administrador=" + login_administrador
				+ ", senha_administrador=" + senha_administrador
				+ ", cpf_administrador=" + cpf_administrador + "]";
	}

}
