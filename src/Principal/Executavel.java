package Principal;

import javax.swing.SwingUtilities;

import Fronteira.MainFrame;

//GERENTE: nome sobrenome senha id
//MEDICO: nome sobrenome senha id crm

public class Executavel {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
		
		/*
		Gerente g1 = new Gerente("Gregor", "House", "macarrao", 123);
		Scanner sc = new Scanner(System.in);

		// Backup
		int sizeRDB = BancoDeDados.sizeRemedioDB();
		for (int i = 0; i < sizeRDB; i++) {
			String nomeBackup = BancoDeDados.backupRemedioDB(i).getNome();
			int qtdBackup = BancoDeDados.backupRemedioDB(i).getQtdEstoque();

			g1.addRemedio(nomeBackup, qtdBackup, true);
		}

		int sizeMDB = BancoDeDados.sizeMedicoDB();
		for (int i = 0; i < sizeMDB; i++) {
			String nomeBackup = BancoDeDados.backupMedicoDB(i).getNome();
			String sobrenomeBackup = BancoDeDados.backupMedicoDB(i).getSobrenome();
			String senhaBackup = BancoDeDados.backupMedicoDB(i).getSenha();
			int idBackup = BancoDeDados.backupMedicoDB(i).getId();
			String crmBackup = BancoDeDados.backupMedicoDB(i).getCrm();

			g1.addMedico(nomeBackup, sobrenomeBackup, senhaBackup, idBackup, crmBackup, true);
		}
		// fim do Backup

		// testes
		while (true) {
			System.out.println("\nSeja bem-vindo, senhor " + g1.getSobrenome());
			System.out.println(
					"O que gostaria de fazer? \n - Gerenciar Profissionais (1) \n - Gerenciar Estoque (2) \n - Sair (3)");
			int resposta = sc.nextInt();
			if (resposta == 1) {
				String nome, sobrenome, senha, crm;
				int id;
				boolean loop = true;
				while (loop) {
					loop = true;
					System.out.println("\n- - - - MENU - - - - ");
					System.out.println("- Cadastrar novo Médico (1)");
					System.out.println("- Remover Médico (2)");
					System.out.println("- Ver Equipe Médica (3)");
					System.out.println("- Voltar (4)");
					resposta = sc.nextInt();
					switch (resposta) {
					case 1:
						System.out.println("Nome do Médico:");
						nome = sc.next();
						System.out.println("Sobrenome do Médico:");
						sobrenome = sc.next();
						System.out.println("ID do novo Login:");
						id = sc.nextInt();
						System.out.println("Senha do novo Login:");
						senha = sc.next();
						System.out.println("CRM do Médico:");
						crm = sc.next();
						g1.addMedico(nome, sobrenome, senha, id, crm, false);
						break;
					case 2:
						System.out.println("ID do Cadastro a ser removido:");
						id = sc.nextInt();
						System.out.println("Tem certeza que deseja remover esse Cadastro: \n - Sim (1) \n - Não (2)");
						resposta = sc.nextInt();
						if (resposta == 1) {
							System.out.println("Removido. haha... confia vai...");
						} else {
							System.out.println("Voltando...");
						}
						break;
					case 3:
						System.out.println("\n- - - - EQUIPE MÉDICA - - - -");

						break;
					case 4:
						System.out.println("Voltando...");
						loop = false;
						break;
					}
				}
			} else if (resposta == 2) {
				String nome;
				int qtdAdd, qtd;
				boolean loop = true;
				while (loop) {
					loop = true;
					System.out.println("\n- - - - MENU - - - - ");
					System.out.println("- Cadastrar novo Medicamento (1)");
					System.out.println("- Remover registro de Medicamento (2)");
					System.out.println("- Adicionar estoque de Medicamento (3)");
					System.out.println("- Ver lista de Medicamentos (4)");
					System.out.println("- Voltar (5)");
					resposta = sc.nextInt();
					switch (resposta) {
					case 1:
						System.out.println("Nome do Medicamento:");
						nome = sc.next();
						System.out.println("Quantidade em Estoque:");
						qtd = sc.nextInt();
						g1.addRemedio(nome, qtd, false);
						break;
					case 2:
						System.out.println("Nome do Medicamento a ser removido:");
						nome = sc.next();
						System.out
								.println("Tem certeza que deseja remover esse Medicamento: \n - Sim (1) \n - Não (2)");
						resposta = sc.nextInt();
						if (resposta == 1) {
							g1.removeRemedio(g1.searchRemedio(nome));
							System.out.println("Medicamento removido.");
						} else {
							System.out.println("Voltando...");
						}
						break;
					case 3:
						System.out.println("Nome do Medicamento a ser incrementado:");
						nome = sc.next();
						System.out.println("Quantidade a ser incrementada:");
						qtdAdd = sc.nextInt();
						g1.increaseRemedio(g1.searchRemedio(nome), qtdAdd);
						break;
					case 4:
						System.out.println("\n- - - - LISTA DE MEDICAMENTOS - - - -");
						System.out.println(BancoDeDados.listRemediosDB());
						break;
					case 5:
						System.out.println("Voltando...");
						loop = false;
						break;
					}
				}
			} else {
				System.out.println("Saindo...");
				break;
			}

		}
		

		sc.close();  
		*/
	}

}
