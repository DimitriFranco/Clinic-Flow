package Entidades;

public class PedidoRemedio {
	private String nomeRemedio;
	private int qtd;
	
	public PedidoRemedio(String nomeRemedio, int qtd) {
		this.nomeRemedio = nomeRemedio;
		this.qtd = qtd;
	}

	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	
	
	
	
}
