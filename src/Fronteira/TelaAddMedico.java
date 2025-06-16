package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Persistencia.BancoDeDados;

public class TelaAddMedico extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfCRM;
	private JTextField tfID;
	private JTextField tfSenha;

	
	public TelaAddMedico(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Novo Membro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 9, 225, 42);
		add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(30, 74, 225, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 55, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sobrenome:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(40, 103, 98, 14);
		add(lblNewLabel_1_1);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setColumns(10);
		tfSobrenome.setBounds(30, 121, 225, 20);
		add(tfSobrenome);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CRM:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(302, 55, 49, 14);
		add(lblNewLabel_1_1_1);
		
		tfCRM = new JTextField();
		tfCRM.setColumns(10);
		tfCRM.setBounds(287, 74, 109, 20);
		add(tfCRM);
		
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(30, 184, 109, 20);
		add(tfID);
		
		JLabel lblConfirmacao = new JLabel("");
		lblConfirmacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmacao.setBounds(32, 238, 177, 20);
		add(lblConfirmacao);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ID: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(40, 168, 49, 14);
		add(lblNewLabel_1_1_1_1);
		
		
		JButton btnCriar = new JButton("Criar ");
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCriar.setBounds(339, 230, 78, 29);
		btnCriar.addActionListener(e -> {
			if(!tfNome.getText().isEmpty() && !tfSobrenome.getText().isEmpty() && !tfSenha.getText().isEmpty() && !tfCRM.getText().isEmpty() && !tfID.getText().isEmpty()) {
				if(!BancoDeDados.verifyIDM(Integer.parseInt(tfID.getText()))) {
					BancoDeDados.addMedicoDB(tfNome.getText(), tfSobrenome.getText(), tfSenha.getText() , tfCRM.getText(), Integer.parseInt(tfID.getText()));
					tfID.setText("");
					tfSenha.setText("");
					tfSobrenome.setText("");
					tfNome.setText("");
					tfCRM.setText("");
					lblConfirmacao.setText("Cadastro Criado!");
				} else {
					lblConfirmacao.setText("ID já utilizado.");
				}
				
			} else {
				lblConfirmacao.setText("Preencha todos os campos.");
			}
			
		});
		add(btnCriar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(22, 44, 383, 113);
		add(panel);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Senha: ");
		lblNewLabel_1_1_1_1_1.setBounds(205, 168, 48, 17);
		add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfSenha = new JTextField();
		tfSenha.setBounds(200, 184, 177, 20);
		add(tfSenha);
		tfSenha.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(213, 213, 213));
		panel_1.setBounds(22, 161, 383, 58);
		add(panel_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBounds(249, 230, 78, 29);
		btnVoltar.addActionListener(e -> {
			tfID.setText("");
			tfSenha.setText("");
			tfSobrenome.setText("");
			tfNome.setText("");
			tfCRM.setText("");
			lblConfirmacao.setText("");
			cardLayout.show(cardPanel, "equipe");
		});
		add(btnVoltar);
		
		

	}
}
