package aplicacao.atualizador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.google.common.io.Files;

public class GeradorDeLink {
	public List<String> gerar() throws IOException{
		File atual = new File("C:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\nw.txt");
		File baixado = new File("C:\\Users\\Administrador\\Documents\\Sabi\\Atualizador\\dn.txt");
		List<String> atualList = Files.readLines(atual, StandardCharsets.UTF_8);
		List<String> baixadoList = Files.readLines(baixado, StandardCharsets.UTF_8);
		
		String a1 = "";
		String a2 = "";
		for(String linha : atualList) {
			a1 += linha + "\n";
		}
		for(String linha : baixadoList) {
			a2 += linha + "\n";
		}
		StringBuilder sb1 = new StringBuilder(a1);
		StringBuilder sb2 = new StringBuilder(a2);
		String dif = "";
		while(sb2.length() != a1.length()) {
			int index = StringUtils.indexOfDifference(sb1, sb2);
			dif += sb2.charAt(index);
			sb2.deleteCharAt(index);
		}
		int linkIniPos = dif.indexOf("/download/");
		String linkIni = dif.substring(linkIniPos + 1);
		int linkEndPos = linkIni.indexOf("\"");
		String link = linkIni.substring(0, linkEndPos);
		List<String> links = new ArrayList<>();
		links.add(link);
		String subSequence = linkIni.substring(linkEndPos);
		while(subSequence.contains("/download/")) {
			int linkIniPos1 = subSequence.indexOf("/download/");
			String linkIni1 = subSequence.substring(linkIniPos1 + 1);
			int linkEndPos1 = linkIni1.indexOf("\"");
			String link1 = linkIni1.substring(0, linkEndPos1);
			links.add(link1);
			subSequence = linkIni1.substring(linkEndPos1);
		}
		
		FileInputStream fis = new FileInputStream(baixado);
		FileOutputStream fos = new FileOutputStream(atual);
		int dados;
		while((dados = fis.read()) != -1) {
			fos.write(dados);
		}
		fos.close();
		fis.close();
		
		return links;
	}
}