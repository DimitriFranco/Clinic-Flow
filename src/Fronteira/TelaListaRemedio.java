package Fronteira;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Persistencia.BancoDeDados;

public class TelaListaRemedio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	
	public TelaListaRemedio(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Estoque de Medicamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(23, 18, 315, 29);
		add(lblNewLabel);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("ID");
		model.addColumn("Qtd");
		for(int i = 0; i < BancoDeDados.sizeRemedioDB(); i++) {
			model.addRow(BancoDeDados.createTableRemedio(i));
		}
		
		table = new JTable(model);
		
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(22, 62, 365, 165);
        add(scrollPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(330, 234, 75, 23);
		btnVoltar.addActionListener(e -> {
			cardLayout.show(cardPanel, "medicamentos");
		});
		add(btnVoltar);
	}

}
