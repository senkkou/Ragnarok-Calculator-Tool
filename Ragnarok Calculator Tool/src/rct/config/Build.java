package rct.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import rct.view.StatView;

public class Build {
	
	private ObservableList<String> buildslot;
	
	public Build() throws IOException {
		File buildAch = new File("builds.sav");	
		if(!buildAch.exists()) {
			buildAch.createNewFile();
			FileWriter fw = new FileWriter(buildAch, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Slot 1;Slot 2;Slot 3;Slot 4;Slot 5;Slot 6;Slot 7;Slot 8;Slot 9");
			bw.close();
			fw.close();
		}
	}
	
	public void save(int slot, String lvl, String str, String agi, String dex, String ints, String vit, String luk, String points) throws IOException {
		File buildsav = new File("builds.sav");
		FileReader fr = new FileReader(buildsav);
		BufferedReader br = new BufferedReader(fr);
		String[] save = br.readLine().split(";");
		br.close();
		fr.close();
		
		save[slot-1] ="Slot "+slot+"*"+","+lvl+","+str+","+agi+","+dex+","+ints+","+vit+","+luk+","+points;
		String saveF = save[0];
		
		for(int i=1;i<9;i++) {
			saveF=saveF+";"+save[i];		
		}
			
		FileWriter fw = new FileWriter(buildsav, false);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(saveF);
		bw.close();
		fw.close();
		System.out.println("Build saved");
	}

	public void load(int slot, StatView statV) throws IOException {
		try {
		File buildsav = new File("builds.sav");
		FileReader fr = new FileReader(buildsav);
		BufferedReader br = new BufferedReader(fr);
		
		String[] save = br.readLine().split(";");
		
		String[] stats = save[slot-1].split(",");
		
		statV.getLevel_tx().setText(stats[1]);
		statV.getStr_tx().setText(stats[2]);
		statV.getAgi_tx().setText(stats[3]);
		statV.getDex_tx().setText(stats[4]);
		statV.getInt_tx().setText(stats[5]);
		statV.getVit_tx().setText(stats[6]);
		statV.getLuk_tx().setText(stats[7]);
		statV.getPoints_tx().setText(stats[8]);		
		br.close();
		fr.close();
		System.out.println("Build Loaded");
		} catch(Exception e) {
			System.out.println("No build found");
			
		}
	}
	
	private void updateList() throws IOException {
		List<String> slotList = new ArrayList<>();
		File buildsav = new File("builds.sav");
		FileReader fr = new FileReader(buildsav);
		BufferedReader br = new BufferedReader(fr);
		
		String[] slot = br.readLine().split(";");
		for(int i=0;i<9;i++) {
			if(slot[i].length()>6) {
				slotList.add(slot[i].substring(0, 7));
			} else {
				slotList.add(slot[i].substring(0,6));
			}
			
		}
		buildslot = FXCollections.observableArrayList(slotList);

	}
	

	public ObservableList<String> getList() throws IOException{
		updateList();
		return buildslot;
	}
	


}
