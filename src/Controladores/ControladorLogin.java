package Controladores;

import Persistencia.BancoDeDados;

public class ControladorLogin {

	public static boolean login(boolean isGerente, int id, String senha) {
		if (isGerente) {
			if (BancoDeDados.verifySenhaG(id, senha)) {
				return true;
			} else {
				return false;
				// id ou senha incorreta
			}
		} else {
			if (BancoDeDados.verifySenhaM(id, senha)) {
				return true;
			} else {
				return false;
				// id ou senha incorreta
			}
		}
	}

}
