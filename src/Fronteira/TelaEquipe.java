package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEquipe extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaEquipe(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipe Médica");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(22, 21, 302, 29);
		add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(345, 228, 73, 29);
		btnVoltar.addActionListener(e -> {
			cardLayout.show(cardPanel, "gerente");
		});
		add(btnVoltar);
		 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(32, 61, 352, 83);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPainelMembros = new JLabel("Gerenciador de Membros");
		lblPainelMembros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPainelMembros.setBounds(22, 11, 182, 20);
		panel.add(lblPainelMembros);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(252, 49, 90, 23);
		btnAdicionar.addActionListener(e -> {
			cardLayout.show(cardPanel, "addMedico");
		});
		panel.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(149, 49, 90, 23);
		btnRemover.addActionListener(e -> {
			cardLayout.show(cardPanel, "removeMedico");
		});
		panel.add(btnRemover);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.setBounds(10, 49, 120, 23);
		btnAlterarSenha.addActionListener(e -> {
			cardLayout.show(cardPanel, "alterarSenha");
		});
		panel.add(btnAlterarSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(213, 213, 213));
		panel_1.setBounds(32, 151, 352, 71);
		add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Visualização de Equipe");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(22, 11, 182, 20);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnVerLista = new JButton("Ver Lista");
		btnVerLista.setBounds(250, 37, 92, 23);
		btnVerLista.addActionListener(e -> {
			TelaListaEquipe listaEquipePanel = new TelaListaEquipe(cardLayout, cardPanel);
			cardPanel.add(listaEquipePanel, "listaEquipe");
			cardLayout.show(cardPanel, "listaEquipe");
		});
		panel_1.add(btnVerLista);

	}

}
