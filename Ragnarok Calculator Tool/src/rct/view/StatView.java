package rct.view;



import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import rct.config.Build;

public class StatView extends Stage {
	
	private GridPane pane;
	private Label str_L,agi_L,int_L,dex_L,luk_L,vit_L, level_L, points_L, slot_L;
	private TextField str_tx, agi_tx, int_tx, dex_tx, luk_tx, vit_tx, level_tx,points_tx;
	private Button Save_B, Load_B;
	private ComboBox slot_CB;
	private CheckBox autolevel_CHB;
	private HBox stats_HB, lower_HB, level_HB, str_HB, agi_HB, int_HB, vit_HB, dex_HB, luk_HB;
	private VBox Button_VB, all_VB, statpair1_VB, statpair2_VB, statpair3_VB;
	private ObservableList builds;
	
	
	
	
	public StatView(boolean trans, ObservableList builds ){
		this.builds = builds;
		init();
		Scene scene = new Scene(pane, 420, 120, Color.GRAY);
		this.setScene(scene);
		this.resizableProperty().set(false);
		this.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
		if(trans) {
			this.setTitle("Stats Calculator - Transcendental Character");
		} else {
			this.setTitle("Stats Calculator - Normal Character");
		}
		this.show();
		
	}
	

	private void init(){
		pane = new GridPane();
		pane.setPadding(new Insets(10,10,10,10));
				
		initBox();
		top();
		lower();
		
		pane.add(lower_HB, 0, 1);
		pane.add(level_HB, 0, 0);
		pane.add(Button_VB, 1, 1);
		
			
	}
	
	private void lower(){

		str_L = new Label("STR");
		agi_L = new Label ("AGI");
		int_L = new Label("INT");
		dex_L = new Label("DEX");
		luk_L = new Label("LUK");
		vit_L = new Label("VIT");
		slot_L = new Label("Save Slot");
		
		str_tx = new TextField("1");
		agi_tx = new TextField("1");
		int_tx = new TextField("1");
		dex_tx = new TextField("1");
		luk_tx = new TextField("1");
		vit_tx = new TextField("1");
		
		str_tx.setPrefSize(40,20);
		agi_tx.setPrefSize(40,20);
		int_tx.setPrefSize(40,20);
		dex_tx.setPrefSize(40,20);
		luk_tx.setPrefSize(40,20);
		vit_tx.setPrefSize(40,20);

		slot_CB = new ComboBox(builds);
		
		Save_B = new Button("Save");
		Load_B = new Button("Load");
		
		
		
		str_HB.getChildren().addAll(str_L, str_tx);
		agi_HB.getChildren().addAll(agi_L,agi_tx);
		int_HB.getChildren().addAll(int_L,int_tx);
		dex_HB.getChildren().addAll(dex_L,dex_tx);
		vit_HB.getChildren().addAll(vit_L,vit_tx);
		luk_HB.getChildren().addAll(luk_L,luk_tx);
		
		statpair1_VB.getChildren().addAll(str_HB, agi_HB);
		statpair2_VB.getChildren().addAll(int_HB, vit_HB);
		statpair3_VB.getChildren().addAll(dex_HB, luk_HB);
		
		Button_VB.getChildren().addAll(slot_L, slot_CB, Save_B, Load_B);
		
		stats_HB.getChildren().addAll(statpair1_VB,statpair2_VB,statpair3_VB);
		
		lower_HB.getChildren().addAll(stats_HB);
		lower_HB.setPadding(new Insets(10,3,3,3));
	}

	private void initBox() {
		stats_HB = new HBox(10);
		lower_HB = new HBox();
		level_HB = new HBox(10);
		str_HB = new HBox(5);
		agi_HB = new HBox(5);
		int_HB = new HBox(5);
		dex_HB = new HBox(5);
		vit_HB = new HBox(7);
		luk_HB = new HBox(6);
		
		Button_VB = new VBox();
		
		all_VB = new VBox();
		
		statpair1_VB = new VBox();
		statpair2_VB = new VBox();
		statpair3_VB = new VBox();
	}
	
	private void top() {
		
		level_L = new Label("Level");
		points_L = new Label("Remaining");
		points_L.setPadding(new Insets(0,0,0,20));
		
		level_tx = new TextField("1");
		level_tx.setPrefSize(40,20);
		points_tx = new TextField();
		points_tx.setPrefSize(70, 20);
		points_tx.setDisable(true);
		
		
		
		autolevel_CHB = new CheckBox("Auto Level");
		
		level_HB.getChildren().addAll(level_L, level_tx,autolevel_CHB,points_L,points_tx);
		
		
	}

	public TextField getPoints_tx() {
		return points_tx;
	}

	public void setPoints_tx(TextField points_tx) {
		this.points_tx = points_tx;
	}
	
	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Label getStr_L() {
		return str_L;
	}

	public void setStr_L(Label str_L) {
		this.str_L = str_L;
	}

	public Label getAgi_L() {
		return agi_L;
	}

	public void setAgi_L(Label agi_L) {
		this.agi_L = agi_L;
	}

	public Label getInt_L() {
		return int_L;
	}

	public void setInt_L(Label int_L) {
		this.int_L = int_L;
	}

	public Label getDex_L() {
		return dex_L;
	}

	public void setDex_L(Label dex_L) {
		this.dex_L = dex_L;
	}

	public Label getLuk_L() {
		return luk_L;
	}

	public void setLuk_L(Label luk_L) {
		this.luk_L = luk_L;
	}

	public Label getVit_L() {
		return vit_L;
	}

	public void setVit_L(Label vit_L) {
		this.vit_L = vit_L;
	}

	public Label getLevel_L() {
		return level_L;
	}

	public void setLevel_L(Label level_L) {
		this.level_L = level_L;
	}

	public Label getPoints_L() {
		return points_L;
	}

	public void setPoints_L(Label points_L) {
		this.points_L = points_L;
	}

	public Label getSlot_L() {
		return slot_L;
	}

	public void setSlot_L(Label slot_L) {
		this.slot_L = slot_L;
	}

	public TextField getStr_tx() {
		return str_tx;
	}

	public void setStr_tx(TextField str_tx) {
		this.str_tx = str_tx;
	}

	public TextField getAgi_tx() {
		return agi_tx;
	}

	public void setAgi_tx(TextField agi_tx) {
		this.agi_tx = agi_tx;
	}

	public TextField getInt_tx() {
		return int_tx;
	}

	public void setInt_tx(TextField int_tx) {
		this.int_tx = int_tx;
	}

	public TextField getDex_tx() {
		return dex_tx;
	}

	public void setDex_tx(TextField dex_tx) {
		this.dex_tx = dex_tx;
	}

	public TextField getLuk_tx() {
		return luk_tx;
	}

	public void setLuk_tx(TextField luk_tx) {
		this.luk_tx = luk_tx;
	}

	public TextField getVit_tx() {
		return vit_tx;
	}

	public void setVit_tx(TextField vit_tx) {
		this.vit_tx = vit_tx;
	}

	public TextField getLevel_tx() {
		return level_tx;
	}

	public void setLevel_tx(TextField level_tx) {
		this.level_tx = level_tx;
	}

	public Button getSave_B() {
		return Save_B;
	}

	public void setSave_B(Button save_B) {
		Save_B = save_B;
	}

	public Button getLoad_B() {
		return Load_B;
	}

	public void setLoad_B(Button load_B) {
		Load_B = load_B;
	}

	public ComboBox getSlot_CB() {
		return slot_CB;
	}

	public void setSlot_CB(ComboBox slot_CB) {
		this.slot_CB = slot_CB;
	}

	public CheckBox getAutolevel_CHB() {
		return autolevel_CHB;
	}

	public void setAutolevel_CHB(CheckBox autolevel_CHB) {
		this.autolevel_CHB = autolevel_CHB;
	}

	public HBox getStats_HB() {
		return stats_HB;
	}

	public void setStats_HB(HBox stats_HB) {
		this.stats_HB = stats_HB;
	}

	public HBox getLower_HB() {
		return lower_HB;
	}

	public void setLower_HB(HBox lower_HB) {
		this.lower_HB = lower_HB;
	}

	public HBox getLevel_HB() {
		return level_HB;
	}

	public void setLevel_HB(HBox level_HB) {
		this.level_HB = level_HB;
	}

	public HBox getStr_HB() {
		return str_HB;
	}

	public void setStr_HB(HBox str_HB) {
		this.str_HB = str_HB;
	}

	public HBox getAgi_HB() {
		return agi_HB;
	}

	public void setAgi_HB(HBox agi_HB) {
		this.agi_HB = agi_HB;
	}

	public HBox getInt_HB() {
		return int_HB;
	}

	public void setInt_HB(HBox int_HB) {
		this.int_HB = int_HB;
	}

	public HBox getVit_HB() {
		return vit_HB;
	}

	public void setVit_HB(HBox vit_HB) {
		this.vit_HB = vit_HB;
	}

	public HBox getDex_HB() {
		return dex_HB;
	}

	public void setDex_HB(HBox dex_HB) {
		this.dex_HB = dex_HB;
	}

	public HBox getLuk_HB() {
		return luk_HB;
	}

	public void setLuk_HB(HBox luk_HB) {
		this.luk_HB = luk_HB;
	}

	public VBox getButton_VB() {
		return Button_VB;
	}

	public void setButton_VB(VBox button_VB) {
		Button_VB = button_VB;
	}

	public VBox getAll_VB() {
		return all_VB;
	}

	public void setAll_VB(VBox all_VB) {
		this.all_VB = all_VB;
	}

	public VBox getStatpair1_VB() {
		return statpair1_VB;
	}

	public void setStatpair1_VB(VBox statpair1_VB) {
		this.statpair1_VB = statpair1_VB;
	}

	public VBox getStatpair2_VB() {
		return statpair2_VB;
	}

	public void setStatpair2_VB(VBox statpair2_VB) {
		this.statpair2_VB = statpair2_VB;
	}

	public VBox getStatpair3_VB() {
		return statpair3_VB;
	}

	public void setStatpair3_VB(VBox statpair3_VB) {
		this.statpair3_VB = statpair3_VB;
	}

	
	

}
