package Entidades;

public class Remedio {
	private String nome;
	private int qtdEstoque;
	
	
	public Remedio(String nome, int qtdEstoque) {
		this.nome = nome;
		this.qtdEstoque = qtdEstoque;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
}
