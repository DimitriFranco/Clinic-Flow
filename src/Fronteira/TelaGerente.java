package Fronteira;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Persistencia.BancoDeDados;

public class TelaGerente extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaGerente(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		
		String nomeGerente = BancoDeDados.getNomeGerente(LoginDados.getId());
		JLabel lblNewLabel = new JLabel("Olá, " + nomeGerente);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 11, 229, 41);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Selecione o que gostaria de fazer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 74, 251, 46);
		add(lblNewLabel_1);

		JButton btnMedicamentos = new JButton("Gerenciador de Medicamentos");
		btnMedicamentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMedicamentos.setBounds(89, 120, 251, 41);
		btnMedicamentos.addActionListener(e -> {
			cardLayout.show(cardPanel, "medicamentos");
		});
		add(btnMedicamentos);

		JButton btnEquipe = new JButton("Gerenciador de Equipe Médica");
		btnEquipe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEquipe.setBounds(89, 172, 251, 41);
		btnEquipe.addActionListener(e -> {
			cardLayout.show(cardPanel, "equipe");
		});
		add(btnEquipe);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(327, 227, 90, 29);
		btnSair.addActionListener(e -> {
			cardLayout.show(cardPanel, "login");
			LoginDados.setId(-1);
		});
		add(btnSair);

	}

}
