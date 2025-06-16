package Entidades;

import java.util.ArrayList;
import java.util.List;

import Persistencia.BancoDeDados;

//metodos ja feitos: cadastrarMedico, cadastrarRemedio, searchRemedio, addRemedio, searcId, alterarSenha

public class Gerente extends Usuario {
	private Estoque est = new Estoque();
	private List<Medico> equipeMedica = new ArrayList<>();

	public String addMedico(String nome, String sobrenome, String senha, int id, String crm, boolean backup) {
		boolean approve = true;
		for (int i = 0; i < equipeMedica.size(); i++) {
			if (id == equipeMedica.get(i).getId()) {
				approve = false;
			}
		}
		if (approve) {
			equipeMedica.add(new Medico(nome, sobrenome, senha, id, crm));
			if(!backup) {
				BancoDeDados.addMedicoDB(nome, sobrenome, senha, crm, id);
			}
			return "Cadastro realizado com sucesso!";
		} else {
			return "ID já utilizado, tente novamente.";
		}
	}

	/*public String addRemedio(String nome, int qtdEstoque, boolean backup) {
		boolean approve = true;
		for (int i = 0; i < est.getEstoque().size(); i++) {
			if (nome.equals(est.getEstoque().get(i).getNome())) {
				approve = false;
			}
		}
		if (approve) {
			est.getEstoque().add(new Remedio(nome, qtdEstoque));
			if(!backup) {
				BancoDeDados.addRemedioDB(nome, qtdEstoque);
			}
			return "Registro adicionado.";
		} else {
			return "Registro já existente, tente novamente.";
		}
	}*/

	public int searchRemedio(String nome) {
		int index = -1;
		for (int i = 0; i < est.getEstoque().size(); i++) {
			if (nome.equals(est.getEstoque().get(i).getNome())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	/*public String removeRemedio(int index) {
		if(index != -1) {
			String nome = est.getEstoque().get(index).getNome();
			est.getEstoque().remove(index);
			BancoDeDados.removeRemedioDB(nome);
			return "Remédio Removido";	
		} else {
			System.out.println("Não foi encontrado");
			return "Remédio não encontrado";
		}
		

	}*/

	/*public String increaseRemedio(int index, int qtd) {
		est.getEstoque().get(index).setQtdEstoque(est.getEstoque().get(index).getQtdEstoque() + qtd);
		String nome = est.getEstoque().get(index).getNome();
		BancoDeDados.increaseRemedioDB(nome, qtd);
		return "Estoque adicionado.";

	}*/

	
	public int searchId(int id) {
		int index = -1;
		for (int i = 0; i < equipeMedica.size(); i++) {
			if (id == equipeMedica.get(i).getId()) {
				index = i;
				break;
			}
		}
		// no codigo principal haverá uma certificação se o index é igual a -1,
		// declarando-o como inexistente
		return index;
	}

	// esse codigo é usado em conjunto com o searchId
	public String alterarSenha(int index, String senhaAtual, String senhaNova) {
		if (senhaAtual.equals(equipeMedica.get(index).getSenha())) {
			equipeMedica.get(index).setSenha(senhaNova);
			return "Senha alterada com sucesso!";
		} else {
			return "Senha incorreta. Tente novamente.";
		}
	}

	public Gerente(String nome, String sobrenome, String senha, int id) {
		super(nome, sobrenome, senha, id);
	}

	public Estoque getEst() {
		return est;
	}

	public void setEst(Estoque est) {
		this.est = est;
	}

	public List<Medico> getEquipeMedica() {
		return equipeMedica;
	}

	public void setEquipeMedica(List<Medico> equipeMedica) {
		this.equipeMedica = equipeMedica;
	}
	
	

}
