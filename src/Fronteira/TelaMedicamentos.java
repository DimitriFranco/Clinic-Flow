package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMedicamentos extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaMedicamentos(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estoque de Medicamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(31, 11, 309, 49);
		add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(330, 231, 85, 25);
		btnVoltar.addActionListener(e -> {
			cardLayout.show(cardPanel, "gerente");
		});
		add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(41, 54, 358, 81);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gerenciador de Registros");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 11, 186, 20);
		panel.add(lblNewLabel_1);
		
		JButton btnRegistrar = new JButton("Adicionar");
		btnRegistrar.setBounds(160, 45, 89, 23);
		btnRegistrar.addActionListener(e -> {
			cardLayout.show(cardPanel, "addRemedio");
		});
		panel.add(btnRegistrar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(259, 45, 89, 23);
		btnRemover.addActionListener(e -> {
			cardLayout.show(cardPanel, "removeRemedio");
		});
		panel.add(btnRemover);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(213, 213, 213));
		panel_1.setBounds(41, 139, 358, 81);
		add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gerenciador de Estoque");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 11, 186, 20);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnVerLista = new JButton("Ver Lista");
		btnVerLista.setBounds(160, 45, 89, 23);
		btnVerLista.addActionListener(e -> {
			TelaListaRemedio listaRemedioPanel = new TelaListaRemedio(cardLayout, cardPanel);
			cardPanel.add(listaRemedioPanel, "listaRemedios");
			cardLayout.show(cardPanel, "listaRemedios");
		});
		panel_1.add(btnVerLista);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(259, 45, 89, 23);
		btnAdicionar.addActionListener(e -> {
			cardLayout.show(cardPanel, "addEstoque");
		});
		panel_1.add(btnAdicionar);

	}
}
