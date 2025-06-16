package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Persistencia.BancoDeDados;

public class TelaRemoveRemedio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfID;
	private JTextField tfSenhaGerente;
	
	public TelaRemoveRemedio(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remover Registro de Medicamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 11, 278, 33);
		add(lblNewLabel);

		tfID = new JTextField();
		tfID.setBounds(40, 97, 96, 20);
		add(tfID);
		tfID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(50, 78, 49, 14);
		add(lblNewLabel_1);

		JLabel lblNomeRemedio = new JLabel("Digite o ID para procurar.");
		lblNomeRemedio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeRemedio.setBounds(50, 48, 225, 26);
		add(lblNomeRemedio);

		JLabel lblNotID = new JLabel("");
		lblNotID.setBounds(85, 77, 206, 14);
		add(lblNotID);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(233, 96, 87, 23);
		btnProcurar.addActionListener(e -> {
			if (!tfID.getText().isEmpty()) {
				int id = Integer.parseInt(tfID.getText());
				if (BancoDeDados.verifyIDRemedio(id)) {
					lblNomeRemedio.setText(BancoDeDados.getNomeRemedio(id));
				} else {
					lblNotID.setText("Medicamento não encontrado.");
				}
			} else {
				lblNotID.setText("Preencha o campo primeiro.");
			}

		});
		add(btnProcurar);

		JLabel lblNewLabel_4 = new JLabel("Senha de Administrador:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(50, 141, 155, 20);
		add(lblNewLabel_4);

		tfSenhaGerente = new JTextField();
		tfSenhaGerente.setBounds(40, 165, 208, 20);
		add(tfSenhaGerente);
		tfSenhaGerente.setColumns(10);
		
		JLabel lblNotRemove = new JLabel("");
		lblNotRemove.setBounds(50, 200, 120, 14);
		add(lblNotRemove);

		JButton btnExcluir = new JButton("Excluir Login");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExcluir.setBounds(210, 190, 110, 29);
		btnExcluir.addActionListener(e -> {
			int id = Integer.parseInt(tfID.getText());
			if (BancoDeDados.verifySenhaG(LoginDados.getId(), tfSenhaGerente.getText())) {
				if (!tfID.getText().isEmpty()) {
					if (BancoDeDados.verifyIDRemedio(id)) {
						BancoDeDados.removeRemedioDB(id);
						tfID.setText("");
						tfSenhaGerente.setText("");
						lblNotRemove.setText("Registro Excluído.");
					} else {
						lblNotRemove.setText("Medicamento não encontrado.");
					}
				} else {
					lblNotRemove.setText("Preencha o campo ID");
				}

			} else {
				lblNotRemove.setText("Senha incorreta.");
			}
		});
		add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(337, 225, 79, 28);
		btnVoltar.addActionListener(e -> {
			tfID.setText("");
			tfSenhaGerente.setText("");
			cardLayout.show(cardPanel, "medicamentos");
		});
		add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(30, 44, 301, 80);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(213, 213, 213));
		panel_1.setBounds(30, 135, 301, 89);
		add(panel_1);

	}

}
