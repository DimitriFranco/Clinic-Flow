package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Persistencia.BancoDeDados;

public class TelaMedico extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaMedico(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		String nomeMedico = BancoDeDados.getNomeMedico(LoginDados.getId());
		JLabel lblNewLabel = new JLabel("Olá, Dr(a). " + nomeMedico);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 32, 307, 29);
		add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(328, 227, 89, 29);
		btnSair.addActionListener(e -> {
			cardLayout.show(cardPanel, "login");
			LoginDados.setId(-1);
		});
		add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(221, 97, 185, 119);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 22, 58, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CRM:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 53, 58, 18);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 82, 58, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(nomeMedico);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(65, 22, 110, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(BancoDeDados.getCRM(LoginDados.getId()));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(65, 53, 110, 19);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel(String.valueOf(LoginDados.getId()));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(65, 82, 79, 19);
		panel.add(lblNewLabel_2_2);
		
		JButton btnReceita = new JButton("Gerar Receita Nova");
		btnReceita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReceita.setBounds(25, 135, 171, 53);
		btnReceita.addActionListener(e -> {
			TelaReceita receitaPanel = new TelaReceita(cardLayout, cardPanel);
			cardPanel.add(receitaPanel, "receita");
			cardLayout.show(cardPanel, "receita");
		});
		add(btnReceita);

	}
}
