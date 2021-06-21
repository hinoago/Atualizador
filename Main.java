package aplicacao.atualizador;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException{
		TamanhoAtual tamanhoAtual = new TamanhoAtual();
		long ta = tamanhoAtual.getTamanho();
		
		Verificador verificador = new Verificador();
		if(verificador.verificar(ta).equalsIgnoreCase("Baixado menor")) {
			while(verificador.verificar(ta).equalsIgnoreCase("Baixado menor")) {
				ProcessBuilder pb = new ProcessBuilder("cmd.exe","SET PATH=%PATH%;c:\\Program Files\\7-Zip\\", "/c", "java -jar c:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\Downloader.jar");
				pb.start();
				Thread.sleep(2000);
			}
		}else if(verificador.verificar(ta).equalsIgnoreCase("Baixado igual")){
			JOptionPane.showMessageDialog(null, "Sem atualizacao");
		}else if(verificador.verificar(ta).equalsIgnoreCase("Baixado maior")){
			GeradorDeLink gl = new GeradorDeLink();
			List<String> links = gl.gerar();
			for(String link : links) {
				Atualizador atualizador = new Atualizador();
				atualizador.atualizar(link);
			}
		}	
	}
}
