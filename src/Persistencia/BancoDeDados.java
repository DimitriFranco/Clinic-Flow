package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Entidades.Medico;
import Entidades.Remedio;

public class BancoDeDados {
	private static String url = "jdbc:mysql://localhost:3306/hospital";
	private static String usuario = "root";
	private static String senha = "root";
	
	static Statement stmt = null;
	static ResultSet rst = null;
	static Connection conexao = null;
	static PreparedStatement intro = null;
	
	
	public static void addMedicoDB(String nome, String sobrenome, String senhaM, String crm, int id) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "INSERT INTO medicos(nome, sobrenome, senha, crm, id) VALUES(?, ?, ?, ?, ?)";
			intro = conexao.prepareStatement(sql);
			intro.setString(1, nome);
			intro.setString(2, sobrenome);
			intro.setString(3, senhaM);
			intro.setString(4, crm);
			intro.setInt(5, id);
			
			intro.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
		
	}
	
	public static boolean verifySenhaG(int id, String password) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM gerentes WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			String passwordTrue = rst.getString("senha");
			if(password.equals(passwordTrue)) {
				return true;
			}
			
			}
			
			return false;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return false;
		}
	}
	
	public static boolean verifySenhaM(int id, String password) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			String passwordTrue = rst.getString("senha");
			if(password.equals(passwordTrue)) {
				return true;
			}
			
			}
			
			return false;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return false;
		}
	}
	
	public static int searchIDM(int i) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return rst.getInt("id");
			
			}
			
			return -1;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return -1;
		}
	}
	
	public static boolean verifyIDM(int id) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return true;
			
			}
			
			return false;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return false;
		}
	}
	
	
	public static String searchSenhaM(int i) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return rst.getString("senha");
			
			}
			
			return null;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}
	}
	
	
	public static int searchIDG(int i) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM gerentes LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return rst.getInt("id");
			
			}
			
			return -1;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return -1;
		}
	}
	
	public static String searchSenhaG(int i) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM gerentes LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return rst.getString("senha");
			
			}
			
			return null;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}
	}
	
	public static String getNomeMedico(int id) {
		String nomeCompleto = "Não Encontrado";
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			
			if(rst.next()) {
			nomeCompleto = rst.getString("nome");
			nomeCompleto += " " + rst.getString("sobrenome");
			}
			
			return nomeCompleto;
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return nomeCompleto;
		}
	}
	
	public static String getCRM(int id) {
		String crm = "Não Encontrado";
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			
			if(rst.next()) {
			crm = rst.getString("crm");
			}
			
			return crm;
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return crm;
		}
	}
	
	public static String getNomeGerente(int id) {
		String nomeCompleto = "Não Encontrado";
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM gerentes WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			
			if(rst.next()) {
			nomeCompleto = rst.getString("nome");
			nomeCompleto += " " + rst.getString("sobrenome");
			}
			
			return nomeCompleto;
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return nomeCompleto;
		}
	}
	
	
	
	public static void removeMedicoDB(int id) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "DELETE FROM medicos WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			
			intro.executeUpdate();
			
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
	}
	
	//PASSIVEL DE EXCLUSAO
	
	public static Medico backupMedicoDB(int i) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return new Medico(rst.getString("nome"), rst.getString("sobrenome"), rst.getString("senha"), rst.getInt("id"),  rst.getString("crm"));
			
			}
			
			return null;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}
	}
	
	public static int sizeMedicoDB() {
		try {
			int size = 0;
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos";
			stmt = conexao.createStatement();
			rst = stmt.executeQuery(sql);
			while(rst.next()) {
				size++;
			}
			return size;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return 0;
		}
	}
	
	public static int sizeGerenteDB() {
		try {
			int size = 0;
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM gerentes";
			stmt = conexao.createStatement();
			rst = stmt.executeQuery(sql);
			while(rst.next()) {
				size++;
			}
			return size;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return 0;
		}
	}
	
	public static Object[] createTable(int i){
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM medicos LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return new Object[] {rst.getString("nome"), rst.getString("sobrenome"), rst.getString("crm"),  rst.getString("id")};
			
			}
			
			return null;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}

	}
	
	public static void newSenhaM(int id, String senhaNova) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "UPDATE medicos SET senha = ? WHERE id = ? ";
			intro = conexao.prepareStatement(sql);
			intro.setString(1, senhaNova);
			intro.setInt(2, id);
			intro.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
	}
	
	public static void newSenhaG(int id, String senhaNova) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "UPDATE gerentes SET senha = ? WHERE id = ? ";
			intro = conexao.prepareStatement(sql);
			intro.setString(1, senhaNova);
			intro.setInt(2, id);
			intro.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
	}
	
	

	
	
	
	
	
	
	public static void addRemedioDB(int id, String nome, int qtd) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "INSERT INTO remedios(id, nome, qtd) VALUES(?, ?, ?)";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			intro.setString(2, nome);
			intro.setInt(3, qtd);
			
			intro.executeUpdate();
			
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
		
	}
	
	public static boolean verifyIDRemedio(int id) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return true;
			
			}
			
			return false;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return false;
		}
	}
	
	public static String getNomeRemedio(int id) {
		String nome = "Não Encontrado";
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			
			if(rst.next()) {
			nome = rst.getString("nome");
			}
			
			return nome;
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return nome;
		}
	}
	
	public static void removeRemedioDB(int id) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "DELETE FROM remedios WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			
			intro.executeUpdate();
			
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
	}
	
	public static Remedio backupRemedioDB(int i) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return new Remedio(rst.getString("nome"), rst.getInt("qtd"));
			}
			
			return null;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}
	}
	
	public static int sizeRemedioDB() {
		try {
			int size = 0;
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios";
			stmt = conexao.createStatement();
			rst = stmt.executeQuery(sql);
			while(rst.next()) {
				size++;
			}
			return size;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return 0;
		}
	}
	
	public static void increaseRemedioDB(int id, int qtd) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			int qtdNova = 0;
			while(rst.next()) {
				qtdNova = rst.getInt("qtd");
			}
			qtdNova += qtd;
			sql = "UPDATE remedios SET qtd = ? WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, qtdNova);
			intro.setInt(2, id);
			
			intro.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
	}
	
	public static void decreaseRemedioDB(int id, int qtd) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			int qtdNova = 0;
			while(rst.next()) {
				qtdNova = rst.getInt("qtd");
			}
			qtdNova -= qtd;
			sql = "UPDATE remedios SET qtd = ? WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, qtdNova);
			intro.setInt(2, id);
			
			intro.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}
	}
	
	public static String listRemediosDB() {
		try {
			String lista = "";
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios";
			intro = conexao.prepareStatement(sql);
			rst = intro.executeQuery();
			
			int i = 1;
			while(rst.next()) {
				lista = lista + "\n" + i +  " - " + rst.getString("nome") + "........... " + rst.getInt("qtd") + " und.";
				i++;
			}
			return lista;
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}
	}
	
	public static int amountRemedio(int id) {
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios WHERE id = ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, id);
			rst = intro.executeQuery();
			
			int qtd = 0;
			while(rst.next()) {
				qtd = rst.getInt("qtd");
			}
			return qtd;
			
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return -1;
		}
	}
	
	public static Object[] createTableRemedio(int i){
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios LIMIT 1 OFFSET ?";
			intro = conexao.prepareStatement(sql);
			intro.setInt(1, i);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return new Object[] {rst.getString("nome"), rst.getString("id"), rst.getString("qtd")};
			
			}
			
			return null;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return null;
		}

	}
	
	public static int getIDRemedio(String nome){
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "SELECT * FROM remedios WHERE nome = ?";
			intro = conexao.prepareStatement(sql);
			intro.setString(1, nome);
			rst = intro.executeQuery();
			
			if(rst.next()) {
			return rst.getInt("id");
			
			}
			
			return 0;
		} catch(Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
			return 0;
		}

	}
	
	
	
	
}
