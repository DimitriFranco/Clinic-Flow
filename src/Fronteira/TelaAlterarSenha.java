package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Persistencia.BancoDeDados;

public class TelaAlterarSenha extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfID;
	private JTextField tfSenhaAtual;
	private JTextField tfSenhaNova;

	
	public TelaAlterarSenha(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Senha de Membro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 21, 240, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Usuário:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(183, 56, 103, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(65, 62, 49, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha Atual: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(65, 104, 103, 26);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Senha Nova:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(65, 150, 103, 26);
		add(lblNewLabel_1_2);
		
		tfID = new JTextField();
		tfID.setBounds(62, 82, 96, 20);
		add(tfID);
		tfID.setColumns(10);
		
		tfSenhaAtual = new JTextField();
		tfSenhaAtual.setBounds(62, 130, 171, 20);
		add(tfSenhaAtual);
		tfSenhaAtual.setColumns(10);
		
		tfSenhaNova = new JTextField();
		tfSenhaNova.setColumns(10);
		tfSenhaNova.setBounds(62, 177, 171, 20);
		add(tfSenhaNova);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBackground(new Color(213, 213, 213));
		rdbtnGerente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnGerente.setBounds(178, 81, 75, 23);
		add(rdbtnGerente);
		
		JRadioButton rdbtnMedico = new JRadioButton("Médico");
		rdbtnMedico.setBackground(new Color(213, 213, 213));
		rdbtnMedico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMedico.setBounds(257, 81, 65, 23);
		add(rdbtnMedico);
		
		ButtonGroup usuario = new ButtonGroup();
		usuario.add(rdbtnMedico);
		usuario.add(rdbtnGerente);
		
		JLabel lblNotif = new JLabel("");
		lblNotif.setBounds(65, 208, 168, 14);
		add(lblNotif);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(233, 204, 89, 23);
		btnAlterar.addActionListener(e -> {
			if(!tfID.getText().isEmpty() && !tfSenhaNova.getText().isEmpty() && !tfSenhaAtual.getText().isEmpty()) {
				int id = Integer.parseInt(tfID.getText());
				if(rdbtnGerente.isSelected()) {
					if(BancoDeDados.verifySenhaG(id, tfSenhaAtual.getText())) {
						BancoDeDados.newSenhaG(id, tfSenhaNova.getText());
						lblNotif.setText("Senha Alterada!");
						tfID.setText("");
						tfSenhaNova.setText("");
						tfSenhaAtual.setText("");
					} else {
						lblNotif.setText("ID/Senha incorreto.");
					}
				} else if(rdbtnMedico.isSelected()) {
					if(BancoDeDados.verifySenhaM(id, tfSenhaAtual.getText())) {
						BancoDeDados.newSenhaM(id, tfSenhaNova.getText());
						lblNotif.setText("Senha Alterada!");
						tfID.setText("");
						tfSenhaNova.setText("");
						tfSenhaAtual.setText("");
					} else {
						lblNotif.setText("ID/Senha incorreto.");
					}
				} else {
					lblNotif.setText("Selecione o tipo de Usuário");
				}
			} else {
				lblNotif.setText("Preencha os campos.");
			}
		});
		add(btnAlterar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(44, 50, 293, 187);
		add(panel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(340, 233, 80, 28);
		btnVoltar.addActionListener(e -> {
			tfID.setText("");
			tfSenhaNova.setText("");
			tfSenhaAtual.setText("");
			lblNotif.setText("");
			cardLayout.show(cardPanel, "equipe");
		});
		add(btnVoltar);

	}
}
