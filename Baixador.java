package aplicacao.atualizador;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Baixador {
	public static void main(String[] args) throws IOException{
		Document doc = Jsoup.connect("http://www-sabi/versao.asp").data("query", "Java")
				.userAgent("Mozilla")
				.cookie("auth", "token")
				.timeout(3000)
				.post();
		BufferedReader br = new BufferedReader(new StringReader(doc.html()));
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\dn.txt");
		int dados;
		while((dados = br.read()) != -1) {
			fos.write(dados);
		}
		fos.close();
	}
}
