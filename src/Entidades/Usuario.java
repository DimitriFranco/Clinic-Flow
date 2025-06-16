package Entidades;

public abstract class Usuario {
	private String nome , sobrenome, senha;
	private int id;
	
	public boolean login(int id, String senha) {
		if(id == this.id && senha.equals(this.senha)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	public Usuario(String nome, String sobrenome, String senha, int id) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
