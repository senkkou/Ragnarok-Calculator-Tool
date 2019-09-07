package rct.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import rct.calc.MainCalc;
import rct.config.Build;
import rct.config.DirectoryM;
import rct.view.ElementView;
import rct.view.MainView;
import rct.view.StatView;
import rct.config.Build;

public class MainController {
	
	private static MainView main;
	private static int mode;
	private static MainCalc calculator;
	private static int printCount=1;
	private static DirectoryM path;
	
	public MainController(MainView main) throws IOException{
		this.main = main;
		path = new DirectoryM();
		main.getCalcs().setOnAction(e ->{doSelect();});
		main.getPane().setOnKeyReleased(e ->{if(e.getCode() == KeyCode.ENTER){doCalculate();}
		if(e.getCode() == KeyCode.F2){doPrint();}
		if(e.getCode() == KeyCode.F3){
		try {
			doDirectory();
		} catch (IOException e1) {
			System.out.println("Canceled");
		}}});
	}
	
	private void doSelect(){
		
		if(main.getCalcs().getValue().equals("Cast")){
			main.clear();
			main.Cast();
			mode = 1;
			main.getCast_dextx().setOnMouseClicked(e ->{main.getCast_dextx().clear();});
			main.getCast_inttx().setOnMouseClicked(e ->{main.getCast_inttx().clear();});
			main.getCast_equiptx().setOnMouseClicked(e ->{main.getCast_equiptx().clear();});
		} else if(main.getCalcs().getValue().equals("MDef")) {
			main.clear();
			main.MDef();
			mode = 2;
			main.getMdef_foetx().setOnMouseClicked(e ->{main.getMdef_foetx().clear();});
			main.getMdef_mptx().setOnMouseClicked(e ->{main.getMdef_mptx().clear();});
		} else if(main.getCalcs().getValue().equals("Def")) {
			main.clear();
			main.Def();
			mode = 3;
			main.getDef_foetx().setOnMouseClicked(e ->{main.getDef_foetx().clear();});
			main.getDef_ptx().setOnMouseClicked(e ->{main.getDef_ptx().clear();});
		} else if(main.getCalcs().getValue().equals("Refine")) {
			main.clear();
			main.Refine();
			mode = 4;
			main.getRef_watx().setOnMouseClicked(e ->{main.getRef_watx().clear();});
		} else if(main.getCalcs().getValue().equals("Element")){
			main.clear();
			main.Element();
			mode = 5;
		} else if(main.getCalcs().getValue().equals("Stats")) {
			main.clear();
			main.Stats();
			mode = 6;
			main.getStat_t().setOnAction(e -> {
				try {
					doStatCalc(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			main.getStat_nt().setOnAction(e -> {try {
				doStatCalc(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}});

		}
	}
	
	private void doStatCalc(Boolean trans) throws IOException {
		Build build = new Build();
		StatView statview = new StatView(trans, build.getList());
		new StatController(statview, trans, build, path);
	
	}
	
	//JOptionPane.showMessageDialog(null,"");
	private void doCalculate(){
		calculator = new MainCalc();
		try{
		switch(mode){
		case 1:
				
			int cast_dex = Integer.parseInt(main.getCast_dextx().getText());
			int cast_int = Integer.parseInt(main.getCast_inttx().getText());
			int cast_equip = Integer.parseInt(main.getCast_equiptx().getText());
			main.getCast_reductx().setText(String.valueOf(calculator.cast(cast_dex, cast_int, cast_equip)).substring(0,4));	
			break;
			
		case 2:
			int mdef_foe = Integer.parseInt(main.getMdef_foetx().getText());
			int mdef_mp = Integer.parseInt(main.getMdef_mptx().getText());
			main.getMdef_damagetx().setText(String.valueOf(calculator.mdef(mdef_foe, mdef_mp)).substring(0,4));
			break;
			
		case 3:
			int def_foe = Integer.parseInt(main.getDef_foetx().getText());
			int def_p = Integer.parseInt(main.getDef_ptx().getText());
			main.getDef_damagetx().setText(String.valueOf(calculator.def(def_foe, def_p)).substring(0,4));
			break;
			
		case 4:
			int refine_lvl = Integer.parseInt(String.valueOf(main.getRef_wlC().getValue()));
			int refine_over = Integer.parseInt(String.valueOf(main.getRef_wrC().getValue()).substring(1));
			int refine_atk = Integer.parseInt(String.valueOf(main.getRef_watx().getText()));
		
			main.getRef_wbtx().setText(calculator.refine(refine_lvl, refine_over, refine_atk ));
			main.getRef_watx2().setText(String.valueOf(calculator.getAtk1())+"~"+String.valueOf(calculator.getAtk2()));
			break;
			
		case 5:
			int table = Integer.parseInt(String.valueOf(main.getElement_ts().getValue()).substring(6));
			new ElementView(table);
			break;
		case 6:
			break;
			
		default:
			break;
		}
		} catch (Exception e) {
			System.out.println("Invalid Input");
			
		}
	}
	
	private void doPrint() {
		WritableImage screen = main.getStage().getScene().snapshot(null);
			File file = new File(path.getPath()+"screen_"+printCount+".jpg");
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(screen, null), "png", file);
			System.out.println("Screen Saved");
			printCount++;
		} catch (Exception e) {
			System.out.println("Error during screeshot action");
		}
	}
	
	private void doDirectory() throws IOException {
		JFileChooser directory = new JFileChooser();
        directory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        directory.showSaveDialog(null);
        try{
        path.setDirectory(directory.getSelectedFile().toString());
        System.out.println("New directory saved");
        } catch(Exception e){
        	System.out.println("Directory selection canceled");
        }
        //System.out.println(f.getCurrentDirectory());
        //System.out.println(f.getSelectedFile());
	}

}
