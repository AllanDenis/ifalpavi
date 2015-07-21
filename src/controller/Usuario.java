package controller;

public class Usuario {
	protected long id;
	private String nome;
	private String usuario;
	private String senha;
	private boolean status;

	public Usuario(String nome, String usuario, String senha) {
		setNome(nome);
		setUsuario(usuario);
		setSenha(senha);
		setStatus(true);
	}

	public Usuario(){
		this("[SEM NOME]", "user", "pass");
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
