package aplicacao.atualizador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Atualizador {
	public String atualizar(String linkLocal) throws MalformedURLException, IOException{
		String prefixo = "http://www-sabi/";
		String caminho = "";
		String versao = "";
		int arquivo = linkLocal.lastIndexOf("/");
		String arquivoNome = linkLocal.substring(arquivo + 1);
		String linkExterno = prefixo + linkLocal;
		URL url = new URL(linkExterno);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {
			BufferedInputStream bis = new BufferedInputStream(http.getInputStream());
			if(arquivoNome.contains("Apoio")) {
				versao = arquivoNome.substring(5, 11);
				arquivoNome = arquivoNome.substring(0, 5);
				caminho = "C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Apoio\\";
				FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Apoio\\versao.txt");
				fw.write(versao);
				fw.close();
				
			}else if(arquivoNome.contains("Atendimento")) {
				versao = arquivoNome.substring(11, 17);
				arquivoNome = arquivoNome.substring(0, 11);
				caminho = "C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Atendimento\\";
				FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Atendimento\\versao.txt");
				fw.write(versao);
				fw.close();
				
			}else if(arquivoNome.contains("Clinica")) {
				versao = arquivoNome.substring(7, 13);
				arquivoNome = arquivoNome.substring(0, 7);
				caminho = "C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Clinca\\";
				FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Clinica\\versao.txt");
				fw.write(versao);
				fw.close();
				
			}else if(arquivoNome.contains("Controle")) {
				versao = arquivoNome.substring(8, 14);
				arquivoNome = arquivoNome.substring(0, 8);
				caminho = "C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Controle\\";
				FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Controle\\versao.txt");
				fw.write(versao);
				fw.close();
				
			}else if(arquivoNome.contains("Sads")) {
				versao = arquivoNome.substring(4, 10);
				arquivoNome = arquivoNome.substring(0, 4);
				caminho = "C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Sads\\";
				FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\SABI\\Sads\\versao.txt");
				fw.write(versao);
				fw.close();
				
			}else {
				JOptionPane.showMessageDialog(null, "Error");
				System.exit(0);
			}
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(caminho + arquivoNome +".exe"));
			int dados;
			while((dados = bis.read()) != -1) {
				bos.write(dados);
			}
			bos.close();
			FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\att-version.txt", true);
			Calendar c = Calendar.getInstance();
			String m = Integer.toString(c.get(Calendar.MINUTE));
			String mf;
			if(m.length() == 1) {
				mf = "0"+m;
			} else {
				mf = Integer.toString(c.get(Calendar.MINUTE));
			}
			String d = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR) + " - " + c.get(Calendar.HOUR_OF_DAY) + ":" +  mf;
			fw.write("App atualizado: " + arquivoNome + "\nVersão: " + versao + "\n" + d + "\n\n");
			fw.close();
			return arquivoNome;
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
