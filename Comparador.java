package aplicacao.atualizador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.io.Files;

public class Comparador {
	public void comparar(File atual, File baixado) throws IOException{
		List<String> atualList = Files.readLines(atual, Charset.forName("UTF-8"));
		List<String> baixadoList = Files.readLines(baixado, Charset.forName("UTF-8"));
		String at = "";
		String dn = "";
		for(String linha : atualList) {
			at += linha + "\n";
		}
		for(String linha : baixadoList) {
			dn += linha + "\n";
		}
		FileWriter fw = new FileWriter("C:\\Users\\Administrador\\Documents\\Sabi\\diff.txt");
		fw.write(StringUtils.difference(at, dn));
		fw.close();
	}
}
