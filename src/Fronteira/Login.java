package Fronteira;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;

	public Login(CardLayout cardLayout, JPanel cardPanel) {
		
		JLabel lblTitulo = new JLabel("CLINICFLOW");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(135, 47, 168, 44);
		add(lblTitulo);
		
		JLabel lblSelecione = new JLabel("Selecione o seu tipo de Usuário");
		lblSelecione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecione.setBounds(108, 114, 223, 34);
		add(lblSelecione);
		
		JButton btnGerente = new JButton("Gerente");
		btnGerente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGerente.setBounds(63, 173, 127, 45);
		btnGerente.addActionListener(e -> {
			LoginDados.setGerente(true);
			cardLayout.show(cardPanel, "dados");
		});
		add(btnGerente);
		
		JButton btnMedico = new JButton("Médico");
		btnMedico.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMedico.setBounds(234, 173, 127, 45);
		btnMedico.addActionListener(e -> {
			LoginDados.setGerente(false);
			cardLayout.show(cardPanel, "dados");
		});
		add(btnMedico);
		
		setLayout(null);

	}
}
