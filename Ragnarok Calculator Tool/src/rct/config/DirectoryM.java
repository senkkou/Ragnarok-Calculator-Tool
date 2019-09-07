package rct.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class DirectoryM {
	private static String directoryfolder;
	
	public DirectoryM() throws IOException {
		File rct = new File("Config.ini");
		if(!rct.exists()) {
			rct.createNewFile();
			FileWriter fw = new FileWriter(rct, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(";");
			bw.close();
			fw.close();
		}
		
		FileReader fr = new FileReader(rct);
		BufferedReader br = new BufferedReader(fr);

		String auxDF = br.readLine();
		System.out.println("\n     ------------\n    |COMMAND LIST|\n     ------------\n ---------------------\n|ENTER = Execute      |\n|F2 = Screenshot      |\n|F3 = Screen directory|\n ---------------------\n");
		if(auxDF.equals(";")) {
			directoryfolder = "";
			System.out.println("No custom screen directory");
		} else {
			directoryfolder = auxDF;
			System.out.println("\nCurrently screen directory "+directoryfolder);

		}
	
	}
		
	
	public void setDirectory(String path) throws IOException {
		directoryfolder = path+"\\";
		File rct = new File("Config.ini");
		FileWriter fw = new FileWriter(rct, false);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(directoryfolder+"\\");
		bw.close();
		fw.close();
	}
	
	public String getPath() {
		return directoryfolder;
	}
	
	

}
