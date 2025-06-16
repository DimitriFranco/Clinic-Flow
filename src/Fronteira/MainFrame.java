package Fronteira;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	CardLayout cardLayout;
	JPanel cardPanel;

	public MainFrame() {
		setTitle("CLINICFLOW");
		setSize(440, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        Login loginPanel = new Login(cardLayout, cardPanel);
        LoginDados dadosPanel = new LoginDados(cardLayout, cardPanel);
        TelaMedicamentos medicamentosPanel = new TelaMedicamentos(cardLayout, cardPanel);
        TelaEquipe equipePanel = new TelaEquipe(cardLayout, cardPanel);
        TelaAddMedico addMedPanel = new TelaAddMedico(cardLayout, cardPanel);
        TelaRemoveMedico removeMedPanel = new TelaRemoveMedico(cardLayout, cardPanel);
        TelaAddRemedio addRemedPanel = new TelaAddRemedio(cardLayout, cardPanel);
        TelaRemoveRemedio removeRemedPanel = new TelaRemoveRemedio(cardLayout, cardPanel);
        TelaAddEstoque addEstoquePanel = new TelaAddEstoque(cardLayout, cardPanel);
        TelaAlterarSenha alterarSenhaPanel = new TelaAlterarSenha(cardLayout, cardPanel);
        
        cardPanel.add(loginPanel, "login");
        cardPanel.add(dadosPanel, "dados");
        cardPanel.add(medicamentosPanel, "medicamentos");
        cardPanel.add(equipePanel, "equipe");
        cardPanel.add(addMedPanel, "addMedico");
        cardPanel.add(removeMedPanel, "removeMedico");
        cardPanel.add(addRemedPanel, "addRemedio");
        cardPanel.add(removeRemedPanel, "removeRemedio");
        cardPanel.add(addEstoquePanel, "addEstoque");
        cardPanel.add(alterarSenhaPanel, "alterarSenha");

        add(cardPanel);
        
        cardLayout.show(cardPanel, "login");

	}

}
