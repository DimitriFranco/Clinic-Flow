package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Persistencia.BancoDeDados;

public class TelaAddRemedio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfID;

	public TelaAddRemedio(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Adicionar novo Medicamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 21, 253, 30);
		add(lblNewLabel);

		JSpinner spQtd = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
		spQtd.setBounds(207, 156, 73, 30);
		add(spQtd);

		JLabel lblNewLabel_1 = new JLabel("Nome do Medicamento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 103, 161, 24);
		add(lblNewLabel_1);

		tfNome = new JTextField();
		tfNome.setBounds(47, 128, 233, 20);
		add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNotif = new JLabel("");
		lblNotif.setBounds(34, 215, 161, 14);
		add(lblNotif);

		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(129, 158, 86, 22);
		add(lblNewLabel_2);

		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(47, 85, 115, 20);
		add(tfID);

		JLabel lblNewLabel_1_1 = new JLabel("ID do Medicamento:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(37, 62, 161, 24);
		add(lblNewLabel_1_1);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.setBounds(203, 207, 89, 27);
		btnCadastrar.addActionListener(e -> {
			if (!tfID.getText().isEmpty() && !tfNome.getText().isEmpty()) {
				int id = Integer.parseInt(tfID.getText());
				if (!BancoDeDados.verifyIDRemedio(id)) {
					BancoDeDados.addRemedioDB(id, tfNome.getText(), (int) spQtd.getValue());
					tfID.setText("");
					tfNome.setText("");
					spQtd.setValue(0);
					lblNotif.setText("Cadastro Realizado.");
				} else {
					lblNotif.setText("ID já existente.");
				}
			} else {
				lblNotif.setText("Preencha os campos.");
			}
			
		});
		add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(344, 228, 75, 30);
		btnVoltar.addActionListener(e -> {
			tfID.setText("");
			tfNome.setText("");
			spQtd.setValue(0);
			cardLayout.show(cardPanel, "medicamentos");
		});
		add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(22, 55, 280, 185);
		add(panel);

	}
}
