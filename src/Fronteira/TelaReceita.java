package Fronteira;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import Persistencia.BancoDeDados;

public class TelaReceita extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public TelaReceita(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Receita Médica");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(32, 23, 123, 31);
		add(lblNewLabel);
		
		JLabel lblNotif = new JLabel("lorem ipsum lorem ipsum");
		lblNotif.setBounds(36, 240, 165, 16);
		add(lblNotif);

		JComboBox<String> cmbMedicamento = new JComboBox<>();
		cmbMedicamento.setBounds(40, 86, 149, 20);
		add(cmbMedicamento);

		for (int i = 0; i < BancoDeDados.sizeRemedioDB(); i++) {
			cmbMedicamento.addItem(String.valueOf(BancoDeDados.createTableRemedio(i)[0]));
		}
		
		String itemSelecionado = (String) cmbMedicamento.getSelectedItem();
		int id = BancoDeDados.getIDRemedio(itemSelecionado);
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, BancoDeDados.amountRemedio(id), 1);
		JSpinner spQtd = new JSpinner(spinnerModel);
		spQtd.setBounds(125, 110, 64, 20);
		add(spQtd);
		
		cmbMedicamento.addActionListener(e -> {
		    String selecionado = (String) cmbMedicamento.getSelectedItem();
		    int novoID = BancoDeDados.getIDRemedio(selecionado);
		    int novoMaximo = BancoDeDados.amountRemedio(novoID);
		
		    spinnerModel.setMaximum(novoMaximo);
		    spQtd.setValue(0);
		});

		JLabel lblNewLabel_1 = new JLabel("Qtd:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 105, 45, 26);
		add(lblNewLabel_1);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("Qtd");

		table = new JTable(model);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(100, 135, 89, 23);
		btnAdicionar.addActionListener(e -> {
			int qtd = (int)spQtd.getValue();
			if(qtd > 0) {
				String nome = (String) cmbMedicamento.getSelectedItem();
			    model.addRow(new Object[] {nome, qtd});
			} else {
				lblNotif.setText("Adicione a quantidade.");
			}
		});
		add(btnAdicionar);

		

		JLabel lblNewLabel_2 = new JLabel("Medicamento:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 65, 143, 20);
		add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(199, 62, 205, 165);
		scrollPane.setBackground(new Color(213, 213, 213));
		add(scrollPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(330, 234, 75, 23);
		btnVoltar.addActionListener(e -> {
			cardLayout.show(cardPanel, "medico");
		});
		add(btnVoltar);
		
		JButton btnGerarReceita = new JButton("Gerar Receita");
		btnGerarReceita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGerarReceita.setBounds(50, 180, 129, 37);
		btnGerarReceita.addActionListener(e -> {
			String nome;
			int idRemedio, qtd;
			int linhas = table.getRowCount();
			if(linhas > 0) {
				for(int i = 0; i < linhas; i++) {
					nome = (String) table.getValueAt(i, 0);
					idRemedio = BancoDeDados.getIDRemedio(nome);
					qtd = (int) table.getValueAt(i, 1);
					BancoDeDados.decreaseRemedioDB(idRemedio, qtd);
					lblNotif.setText("Receita Gerada!");
					spQtd.setValue(0);
				}
				model.setRowCount(0);
			} else {
				lblNotif.setText("Adicione um Medicamento.");
			}
		});
		add(btnGerarReceita);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(213, 213, 213));
		panel.setBounds(25, 62, 176, 165);
		add(panel);

		
		
		

	}

}
