package rct.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import rct.calc.StatCalc;
import rct.config.Build;
import rct.config.DirectoryM;
import rct.view.StatView;

public class StatController {
	
	private StatView statV;
	private StatCalc statcalc;
	private Build build;
	private static DirectoryM path;
	private static int printCount=1;

	StatController (StatView statV, Boolean trans, Build build, DirectoryM path) throws IOException{
		this.statV = statV;
		this.statcalc = new StatCalc(trans);
		this.build = build;
		this.path = path;
		statV.getPoints_tx().setText(String.valueOf(statcalc.getBstat()));
		clearField();
		statV.getSave_B().setOnAction(e -> {try {
			doSave();
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}});
		statV.getLoad_B().setOnAction(e -> {try {
			doLoad();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		});
		statV.getPane().setOnKeyReleased(e -> {if(e.getCode() == KeyCode.ENTER) {
			if(doCheck()) {
				doCalculate();
			}else {
				statV.getPoints_tx().setText("???");
			}
			} if(e.getCode() == KeyCode.F2) {
				doPrint();
			}
		
		
		});
		statV.getAutolevel_CHB().setOnAction(e -> {doCheckBox();});
		
		
	}
	
	private void doSave() throws NumberFormatException, IOException{
		build.save(Integer.parseInt(String.valueOf(statV.getSlot_CB().getValue()).substring(5,6)),  statV.getLevel_tx().getText(), statV.getStr_tx().getText(), statV.getAgi_tx().getText(),statV.getDex_tx().getText(), statV.getInt_tx().getText(), statV.getVit_tx().getText(), statV.getLuk_tx().getText(),statV.getPoints_tx().getText());
		statV.getSlot_CB().setItems(build.getList());
	}
	
	private void doLoad() throws NumberFormatException, IOException {
		build.load(Integer.parseInt(String.valueOf(statV.getSlot_CB().getValue()).substring(5,6)), statV);
		
	}
	private void doCalculate(){
		
		statcalc.StatSpent(Integer.parseInt(statV.getStr_tx().getText()));
		statcalc.StatSpent(Integer.parseInt(statV.getAgi_tx().getText()));
		statcalc.StatSpent(Integer.parseInt(statV.getDex_tx().getText()));
		statcalc.StatSpent(Integer.parseInt(statV.getInt_tx().getText()));
		statcalc.StatSpent(Integer.parseInt(statV.getVit_tx().getText()));
		statcalc.StatSpent(Integer.parseInt(statV.getLuk_tx().getText()));
		if(!statV.getAutolevel_CHB().isSelected()) {
			statcalc.PointsR(Integer.parseInt(statV.getLevel_tx().getText()));
			statV.getPoints_tx().setText((String.valueOf(statcalc.getBstat()+statcalc.getPointsR()-statcalc.getPointsS())));
		} else {
			statcalc.AutoLevel(statcalc.getPointsS());
			statV.getLevel_tx().setText(String.valueOf(statcalc.getAutoLvl()));
			statV.getPoints_tx().setText((String.valueOf(statcalc.getALP()-statcalc.getPointsS())));
		}
		statcalc.clearPS();
		statcalc.clearPR();
	}
	
	private void doCheckBox() {
		if(statV.getAutolevel_CHB().isSelected()) {
			statV.getLevel_tx().setDisable(true);
		} else {
			statV.getLevel_tx().setDisable(false);
		}		
	}
	
	private Boolean doCheck() {
		try {
		if(Integer.parseInt(statV.getLevel_tx().getText()) < 1 || Integer.parseInt(statV.getLevel_tx().getText()) > 185) {
			System.out.println("Level out of range, must be between 1~185");
			return false;
			
		}
		else if(Integer.parseInt(statV.getStr_tx().getText()) < 1 || Integer.parseInt(statV.getStr_tx().getText()) >130) {
			System.out.println("Str out of range, must be between 1~130");
			return false;
			
		} else if(Integer.parseInt(statV.getAgi_tx().getText()) < 1 || Integer.parseInt(statV.getAgi_tx().getText()) >130) {
			System.out.println("Agi out of range, must be between 1~130");
			return false;
			
		} else if(Integer.parseInt(statV.getDex_tx().getText()) < 1 || Integer.parseInt(statV.getDex_tx().getText()) >130) {
			System.out.println("Dex out of range, must be between 1~130");
			return false;
			
		} else if(Integer.parseInt(statV.getVit_tx().getText()) < 1 || Integer.parseInt(statV.getVit_tx().getText()) >130) {
			System.out.println("Vit out of range, must be between 1~130");
			return false;
			
		} else if(Integer.parseInt(statV.getInt_tx().getText()) < 1 || Integer.parseInt(statV.getInt_tx().getText()) >130) {
			System.out.println("Int out of range, must be between 1~130");
			return false;
			
		} else if(Integer.parseInt(statV.getLuk_tx().getText()) < 1 || Integer.parseInt(statV.getLuk_tx().getText()) >130) {
			System.out.println("Luk out of range, must be between 1~130");
			return false;
			
		} else {
			return true;
		}
		} catch(Exception e) {
			System.out.println("Null value detected");
			return false;
		}
	}
	
	private void clearField() {
		statV.getAgi_tx().setOnMouseClicked(e -> {statV.getAgi_tx().clear();});
		statV.getDex_tx().setOnMouseClicked(e -> {statV.getDex_tx().clear();});
		statV.getVit_tx().setOnMouseClicked(e -> {statV.getVit_tx().clear();});
		statV.getInt_tx().setOnMouseClicked(e -> {statV.getInt_tx().clear();});
		statV.getLuk_tx().setOnMouseClicked(e -> {statV.getLuk_tx().clear();});
		statV.getStr_tx().setOnMouseClicked(e -> {statV.getStr_tx().clear();});
		statV.getLevel_tx().setOnMouseClicked(e -> {statV.getLevel_tx().clear();});
	}
	
	private void doPrint() {
		WritableImage screen = statV.getPane().getScene().snapshot(null);
			File file = new File(path.getPath()+"Build_"+printCount+".jpg");
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(screen, null), "png", file);
			System.out.println("Screen Saved");
			printCount++;
		} catch (Exception e) {
			System.out.println("Error during screeshot action");
		}
	}
}
