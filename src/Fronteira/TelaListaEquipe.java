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

public class TelaListaEquipe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	
	public TelaListaEquipe(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Equipe Médica");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(22, 11, 193, 40);
		add(lblNewLabel);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("Sobrenome");
		model.addColumn("CRM");
		model.addColumn("ID");
		for(int i = 0; i < BancoDeDados.sizeMedicoDB(); i++) {
			model.addRow(BancoDeDados.createTable(i));
		}
		
		table = new JTable(model);
		
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(22, 62, 365, 165);
        add(scrollPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(330, 234, 75, 23);
		btnVoltar.addActionListener(e -> {
			cardLayout.show(cardPanel, "equipe");
		});
		add(btnVoltar);

	}
}
