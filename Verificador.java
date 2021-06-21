package aplicacao.atualizador;

import java.io.File;
import java.io.IOException;

public class Verificador {
	public String verificar(long tamanhoAtual) throws IOException{
		File file = new File("C:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\dn.txt");
		long tamanhoBaixado = file.length();
		String comp;
		if(tamanhoBaixado == tamanhoAtual) {
			comp = "Baixado igual";
		}else if(tamanhoBaixado < tamanhoAtual) {
			comp = "Baixado menor";
		}else {
			comp = "Baixado maior";
		}
		return comp;
	}
}
