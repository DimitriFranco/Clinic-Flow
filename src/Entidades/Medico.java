package Entidades;

import java.util.ArrayList;
import java.util.List;

import Persistencia.BancoDeDados;

public class Medico extends Usuario {
	private String crm;
	private List<Receita> receitas = new ArrayList<>();

	public Medico(String nome, String sobrenome, String senha, int id, String crm) {
		super(nome, sobrenome, senha, id);
		this.crm = crm;
	}

	public void addReceita(String nomePaciente, int id) {
		receitas.add(new Receita(nomePaciente, id));
	}

	/*public String increaseRemedioReceita(int id, String nomeRemedio, int qtd) {
		int index = -1;
		for (int i = 0; i < receitas.size(); i++) {
			if (id == receitas.get(i).getId()) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			if (qtd <= BancoDeDados.amountRemedio(nomeRemedio)) {
				receitas.get(index).addPedidoRemedio(nomeRemedio, qtd);
				BancoDeDados.decreaseRemedioDB(nomeRemedio, qtd);
				return "Remédio adicionado.";
			} else {
				return "Estoque insuficiente";
			}
		} else {
			return "ID de Receita inválido";
		}

	}*/

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

}
