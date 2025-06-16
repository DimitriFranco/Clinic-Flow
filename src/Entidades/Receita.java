package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	private String nomePaciente;
	private List<PedidoRemedio> remedios = new ArrayList<>();
	private int id;

	public void addPedidoRemedio(String nomeRemedio, int qtd) {
		remedios.add(new PedidoRemedio(nomeRemedio, qtd));
	}

	public String showRemedios() {
		String lista = "";
		String add;
		for (int i = 0; i < remedios.size(); i++) {
			add = (i+1) + " - " + remedios.get(i).getNomeRemedio() + "..........." + remedios.get(i).getQtd() + " doses\n";
			lista = lista + add;
		}
		return "Lista de Remédios\n" + lista;
	}

	public Receita(String nomePaciente, int id) {
		this.nomePaciente = nomePaciente;
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
