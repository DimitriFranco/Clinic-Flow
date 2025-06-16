package Fronteira;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controladores.ControladorLogin;

public class LoginDados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfID;
	private JPasswordField pfSenha;
	private static boolean isGerente;
	private static int id = -1;

	public LoginDados(CardLayout cardLayout, JPanel cardPanel) {
		setLayout(null);

		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(164, 26, 88, 60);
		add(lblTitulo);

		JLabel lblConfirmacao = new JLabel("");
		lblConfirmacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmacao.setBounds(32, 207, 177, 20);
		add(lblConfirmacao);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(30, 84, 90, 20);
		add(lblID);

		tfID = new JTextField();
		tfID.setBounds(30, 108, 189, 20);
		add(tfID);
		tfID.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(30, 139, 90, 20);
		add(lblSenha);

		pfSenha = new JPasswordField();
		pfSenha.setColumns(10);
		pfSenha.setBounds(30, 160, 189, 20);
		add(pfSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEntrar.setBounds(327, 207, 90, 35);
		btnEntrar.addActionListener(e -> {
			String password = new String(pfSenha.getPassword());

			if (!password.isEmpty() && !tfID.getText().isEmpty()) {
				if (isGerente && ControladorLogin.login(isGerente, Integer.parseInt(tfID.getText()), password)) {
					id = Integer.parseInt(tfID.getText());
					TelaGerente gerentePanel = new TelaGerente(cardLayout, cardPanel);
					cardPanel.add(gerentePanel, "gerente");
					cardLayout.show(cardPanel, "gerente");
				} else if (!isGerente
						&& ControladorLogin.login(isGerente, Integer.parseInt(tfID.getText()), password)) {
					id = Integer.parseInt(tfID.getText());
					TelaMedico medicoPanel = new TelaMedico(cardLayout, cardPanel);
					cardPanel.add(medicoPanel, "medico");
					cardLayout.show(cardPanel, "medico");
				} else {
					lblConfirmacao.setText("ID/Senha incorreto(s)!");
				}
			} else {
				lblConfirmacao.setText("Preencha todos os campos.");
			}

			tfID.setText("");
			pfSenha.setText("");
		});
		add(btnEntrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBounds(223, 207, 90, 35);
		btnVoltar.addActionListener(e -> {
			cardLayout.show(cardPanel, "login");
		});
		add(btnVoltar);

	}

	public static boolean isGerente() {
		return isGerente;
	}

	public static void setGerente(boolean gerente) {
		isGerente = gerente;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		LoginDados.id = id;
	}

}
