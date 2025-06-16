package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private List<Remedio> estoque = new ArrayList<>();

	public List<Remedio> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Remedio> estoque) {
		this.estoque = estoque;
	}

}
