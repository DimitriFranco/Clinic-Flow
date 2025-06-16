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

public class TelaAddEstoque extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfID;

	
	public TelaAddEstoque(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Estoque de Medicamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 11, 289, 38);
		add(lblNewLabel);
		
		JLabel lblNomeMedicamento = new JLabel("Nome: Digite o ID");
		lblNomeMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeMedicamento.setBounds(49, 76, 179, 23);
		add(lblNomeMedicamento);
		
		JLabel lblQtd = new JLabel("Qtd: ");
		lblQtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQtd.setBounds(235, 76, 75, 23);
		add(lblQtd);
		
		JLabel lblEntradaDeEstoque = new JLabel("Entrada de Estoque:");
		lblEntradaDeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntradaDeEstoque.setBounds(49, 155, 136, 23);
		add(lblEntradaDeEstoque);
		
		JSpinner spAddQtd = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
		spAddQtd.setBounds(248, 155, 52, 25);
		add(spAddQtd);
		
		tfID = new JTextField();
		tfID.setBounds(49, 123, 96, 20);
		add(tfID);
		tfID.setColumns(10);
		
		JLabel lblNotif = new JLabel("");
		lblNotif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNotif.setBounds(49, 200, 138, 14);
		add(lblNotif);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(210, 195, 95, 28);
		btnAdicionar.addActionListener(e -> {
			if(!tfID.getText().isEmpty() && (int)spAddQtd.getValue() > 0) {
				if(BancoDeDados.verifyIDRemedio(Integer.parseInt(tfID.getText()))) {
					BancoDeDados.increaseRemedioDB(Integer.parseInt(tfID.getText()), (int)spAddQtd.getValue());
					lblNotif.setText("Estoque adicionado.");
					lblNomeMedicamento.setText("Nome: ");
					lblQtd.setText("Qtd: ");
					tfID.setText("");
					spAddQtd.setValue(0);
				} else {
					lblNotif.setText("ID não encontrado.");
				}
			} else {
				lblNotif.setText("Preencha os campos.");
			}
		});
		add(btnAdicionar);
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(328, 225, 85, 30);
		btnVoltar.addActionListener(e -> {
			lblNomeMedicamento.setText("Nome: ");
			lblQtd.setText("Qtd: ");
			tfID.setText("");
			spAddQtd.setValue(0);
			cardLayout.show(cardPanel, "medicamentos");
		});
		add(btnVoltar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(53, 100, 32, 23);
		add(lblId);
		
		
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(215, 120, 89, 25);
		btnProcurar.addActionListener(e -> {
			if(!tfID.getText().isEmpty()) {
				int id = Integer.parseInt(tfID.getText());
				if(BancoDeDados.verifyIDRemedio(id)) {
					lblNomeMedicamento.setText("Nome: " + BancoDeDados.getNomeRemedio(id));
					lblQtd.setText("Qtd: " + BancoDeDados.amountRemedio(id));
				} else {
					lblNomeMedicamento.setText("Nome: Não Encontrado.");
					lblQtd.setText("Qtd: ");
				}
			}
		});
		add(btnProcurar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(34, 66, 279, 163);
		add(panel);

	}

}
