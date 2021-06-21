package aplicacao.atualizador;

import java.io.File;

public class TamanhoAtual {
	public long getTamanho() {
		File arquivo = new File("C:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\nw.txt");
		long tamanhoAtual = arquivo.length();
		
		return tamanhoAtual;
	}
}
