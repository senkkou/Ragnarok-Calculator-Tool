package rct.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainView {
	private static Stage stage;
	private GridPane pane;
	private ComboBox calcs;
	private VBox vbox, vbox2;
	private Label version, credit;
	private HBox hbox;
	
	private Label mdef_foe, mdef_mp, mdef_damage;
	private TextField mdef_foetx, mdef_mptx, mdef_damagetx;
	private HBox mdef_set;
	private VBox mdef_c1, mdef_c2;
	
	private Label cast_dex, cast_int, cast_equip, cast_reduc;
	private TextField cast_dextx, cast_inttx, cast_equiptx, cast_reductx;
	private HBox cast_set;
	private VBox cast_c1, cast_c2;
	
	private ComboBox ref_wlC, ref_wrC;
	private Label ref_wl, ref_wr, ref_wb, ref_wa;
	private TextField ref_wbtx, ref_watx, ref_watx2;
	private HBox ref_set, atk_box;
	private VBox ref_c1, ref_c2;
	
	private ComboBox element_ts;
	
	private Label def_foe, def_p, def_damage;
	private TextField def_foetx, def_ptx, def_damagetx;
	private HBox def_set;
	private VBox def_c1, def_c2;
	
	private VBox stat_c1;
	private Button stat_t;
	private Button stat_nt;
	
	
	public MainView(Stage stage){
		init();
		Scene scene = new Scene(pane, 160, 160, Color.GRAY);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("RCT");
		this.stage = stage;
		this.stage.show();
	}
	
	private void init(){
		pane = new GridPane();
		pane.setVgap(10);
		
		calcs = new ComboBox();
		calcs.getItems().addAll("Cast", "MDef","Def", "Refine", "Element", "Stats");

		vbox = new VBox(10);
		vbox2 = new VBox(10);
		hbox = new HBox(110);
		version = new Label("v0.8.0");
		credit = new Label("Rvmj");
		
		hbox.getChildren().addAll(version, credit);
		vbox.getChildren().addAll(calcs);
		vbox2.getChildren().addAll(hbox);
		pane.add(vbox, 0, 0);
		pane.add(vbox2, 0, 13);
		
		
	}
	
	public void clear(){
		pane.getChildren().remove(1);
		vbox2.getChildren().remove(0);
	}
	
	public void Cast(){
		cast_dex= new Label("Dexterity");
		cast_int= new Label("Intelligence");
		cast_equip= new Label("Equipaments %");
		cast_reduc= new Label("Cast Reduction");
		
		cast_dextx= new TextField("0");
		cast_dextx.setMaxSize(45, 2);
		cast_inttx= new TextField("0");
		cast_inttx.setMaxSize(45, 2);
		cast_equiptx= new TextField("0");
		cast_equiptx.setMaxSize(45, 2);
		cast_reductx= new TextField();
		cast_reductx.setMaxSize(45, 2);
		cast_reductx.editableProperty().set(false);
		
		cast_set = new HBox(10);
		cast_c1 = new VBox(20);
		cast_c2 = new VBox(10);
		
		cast_c1.getChildren().addAll(cast_dex, cast_int, cast_equip, cast_reduc);
		cast_c2.getChildren().addAll(cast_dextx, cast_inttx, cast_equiptx, cast_reductx);
		cast_set.getChildren().addAll(cast_c1,cast_c2);
		
		vbox2.getChildren().addAll(cast_set);
		pane.add(vbox2, 0, 1);
		
		
	}
	
	public void MDef(){
		mdef_foe = new Label("Magic Def");
		mdef_mp = new Label("Magic Pen %");
		mdef_damage = new Label("Damage %");
		
		mdef_foetx = new TextField("0");
		mdef_foetx.setMaxSize(45, 2);
		mdef_mptx = new TextField("0");
		mdef_mptx.setMaxSize(45, 2);
		mdef_damagetx = new TextField();
		mdef_damagetx.setMaxSize(45, 2);
		mdef_damagetx.editableProperty().set(false);
		
		mdef_set = new HBox(10);
		mdef_c1 = new VBox(20);
		mdef_c2 = new VBox(10);
		
		mdef_c1.getChildren().addAll(mdef_foe,mdef_mp,mdef_damage);
		mdef_c2.getChildren().addAll(mdef_foetx,mdef_mptx,mdef_damagetx);
		mdef_set.getChildren().addAll(mdef_c1,mdef_c2);
		
		vbox2.getChildren().addAll(mdef_set);
		pane.add(vbox2, 0, 1);
		
		
	}
	
	public void Def(){
		def_foe = new Label("Defense");
		def_p = new Label("Def Pen %");
		def_damage = new Label("Damage %");
		
		def_foetx = new TextField("0");
		def_foetx.setMaxSize(45, 2);
		def_ptx = new TextField("0");
		def_ptx.setMaxSize(45, 2);
		def_damagetx = new TextField();
		def_damagetx.setMaxSize(45, 2);
		def_damagetx.editableProperty().set(false);
		
		def_set = new HBox(10);
		def_c1 = new VBox(20);
		def_c2 = new VBox(10);
		
		def_c1.getChildren().addAll(def_foe,def_p,def_damage);
		def_c2.getChildren().addAll(def_foetx,def_ptx,def_damagetx);
		def_set.getChildren().addAll(def_c1,def_c2);
		
		vbox2.getChildren().addAll(def_set);
		pane.add(vbox2, 0, 1);
		
		
	}
	
	public void Refine(){
	
	ref_wl = new Label("Level");
	ref_wr = new Label("Refine");
	ref_wb = new Label("Bonus");
	ref_wa = new Label("Atk/rAtk");
	
	ref_wlC = new ComboBox();
	ref_wlC.getItems().addAll("1","2","3","4");
	ref_wlC.setMaxSize(10, 2);
	ref_wrC = new ComboBox();
	ref_wrC.getItems().addAll("+1","+2","+3","+4","+5","+6","+7","+8","+9","+10","+11","+12","+13","+14","+15","+16","+17","+18","+19","+20");
	ref_wrC.setMaxSize(64, 2);
	
	ref_wbtx = new TextField();
	ref_wbtx.setMaxSize(80, 2);
	ref_wbtx.editableProperty().set(false);
	
	ref_watx = new TextField();
	ref_watx.setMaxSize(40, 2);
	
	ref_watx2 = new TextField();
	ref_watx2.setMaxSize(70, 2);
	ref_watx2.editableProperty().set(false);
	
	atk_box = new HBox(1);
	ref_set = new HBox(10);
	ref_c1 = new VBox(20);
	ref_c2 = new VBox(10);
	
	atk_box.getChildren().addAll(ref_watx, ref_watx2);
	ref_c1.getChildren().addAll(ref_wl, ref_wr, ref_wa, ref_wb);
	ref_c2.getChildren().addAll(ref_wlC, ref_wrC, atk_box, ref_wbtx);
	ref_set.getChildren().addAll(ref_c1, ref_c2);
	
	vbox2.getChildren().addAll(ref_set);
	pane.add(vbox2, 0, 1);
	ref_watx.setText("0");
	}
	
	public void Element(){
		
	element_ts = new ComboBox();
	element_ts.getItems().addAll("Level 1", "Level 2", "Level 3", "Level 4");
	vbox2.getChildren().addAll(element_ts);
	pane.add(vbox2, 0, 1);
		
	}
	
	public void Stats() {
		/*
	private VBox stat_c1;
	private Button stat_t;
	private Button stat_nt;
		 */
	stat_t = new Button("Transcendental");
	stat_t.setPrefSize(170, 60);
	stat_nt = new Button ("Normal");
	stat_nt.setPrefSize(170, 60);
	stat_c1 = new VBox(10);
	stat_c1.getChildren().addAll(stat_t,stat_nt);
	vbox2.getChildren().addAll(stat_c1);
	pane.add(vbox2, 0, 1);	
	}

	public VBox getStat_c1() {
		return stat_c1;
	}

	public void setStat_c1(VBox stat_c1) {
		this.stat_c1 = stat_c1;
	}

	public Button getStat_t() {
		return stat_t;
	}

	public void setStat_t(Button stat_t) {
		this.stat_t = stat_t;
	}

	public Button getStat_nt() {
		return stat_nt;
	}

	public void setStat_nt(Button stat_nt) {
		this.stat_nt = stat_nt;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		MainView.stage = stage;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public ComboBox getCalcs() {
		return calcs;
	}

	public void setCalcs(ComboBox calcs) {
		this.calcs = calcs;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public VBox getVbox2() {
		return vbox2;
	}

	public void setVbox2(VBox vbox2) {
		this.vbox2 = vbox2;
	}

	public Label getVersion() {
		return version;
	}

	public void setVersion(Label version) {
		this.version = version;
	}

	public Label getMdef_foe() {
		return mdef_foe;
	}

	public void setMdef_foe(Label mdef_foe) {
		this.mdef_foe = mdef_foe;
	}

	public Label getMdef_mp() {
		return mdef_mp;
	}

	public void setMdef_mp(Label mdef_mp) {
		this.mdef_mp = mdef_mp;
	}

	public Label getMdef_damage() {
		return mdef_damage;
	}

	public void setMdef_damage(Label mdef_damage) {
		this.mdef_damage = mdef_damage;
	}

	public TextField getMdef_foetx() {
		return mdef_foetx;
	}

	public void setMdef_foetx(TextField mdef_foetx) {
		this.mdef_foetx = mdef_foetx;
	}

	public TextField getMdef_mptx() {
		return mdef_mptx;
	}

	public void setMdef_mptx(TextField mdef_mptx) {
		this.mdef_mptx = mdef_mptx;
	}

	public TextField getMdef_damagetx() {
		return mdef_damagetx;
	}

	public void setMdef_damagetx(TextField mdef_damagetx) {
		this.mdef_damagetx = mdef_damagetx;
	}

	public HBox getMdef_set() {
		return mdef_set;
	}

	public void setMdef_set(HBox mdef_set) {
		this.mdef_set = mdef_set;
	}

	public VBox getMdef_c1() {
		return mdef_c1;
	}

	public void setMdef_c1(VBox mdef_c1) {
		this.mdef_c1 = mdef_c1;
	}

	public VBox getMdef_c2() {
		return mdef_c2;
	}

	public void setMdef_c2(VBox mdef_c2) {
		this.mdef_c2 = mdef_c2;
	}

	public Label getCast_dex() {
		return cast_dex;
	}

	public void setCast_dex(Label cast_dex) {
		this.cast_dex = cast_dex;
	}

	public Label getCast_int() {
		return cast_int;
	}

	public void setCast_int(Label cast_int) {
		this.cast_int = cast_int;
	}

	public Label getCast_equip() {
		return cast_equip;
	}

	public void setCast_equip(Label cast_equip) {
		this.cast_equip = cast_equip;
	}

	public Label getCast_reduc() {
		return cast_reduc;
	}

	public void setCast_reduc(Label cast_reduc) {
		this.cast_reduc = cast_reduc;
	}

	public TextField getCast_dextx() {
		return cast_dextx;
	}

	public void setCast_dextx(TextField cast_dextx) {
		this.cast_dextx = cast_dextx;
	}

	public TextField getCast_inttx() {
		return cast_inttx;
	}

	public void setCast_inttx(TextField cast_inttx) {
		this.cast_inttx = cast_inttx;
	}

	public TextField getCast_equiptx() {
		return cast_equiptx;
	}

	public void setCast_equiptx(TextField cast_equiptx) {
		this.cast_equiptx = cast_equiptx;
	}

	public TextField getCast_reductx() {
		return cast_reductx;
	}

	public void setCast_reductx(TextField cast_reductx) {
		this.cast_reductx = cast_reductx;
	}

	public HBox getCast_set() {
		return cast_set;
	}

	public void setCast_set(HBox cast_set) {
		this.cast_set = cast_set;
	}

	public VBox getCast_c1() {
		return cast_c1;
	}

	public void setCast_c1(VBox cast_c1) {
		this.cast_c1 = cast_c1;
	}

	public VBox getCast_c2() {
		return cast_c2;
	}

	public void setCast_c2(VBox cast_c2) {
		this.cast_c2 = cast_c2;
	}

	public ComboBox getRef_wlC() {
		return ref_wlC;
	}

	public void setRef_wlC(ComboBox ref_wlC) {
		this.ref_wlC = ref_wlC;
	}

	public ComboBox getRef_wrC() {
		return ref_wrC;
	}

	public void setRef_wrC(ComboBox ref_wrC) {
		this.ref_wrC = ref_wrC;
	}

	public Label getRef_wl() {
		return ref_wl;
	}

	public void setRef_wl(Label ref_wl) {
		this.ref_wl = ref_wl;
	}

	public Label getRef_wr() {
		return ref_wr;
	}

	public void setRef_wr(Label ref_wr) {
		this.ref_wr = ref_wr;
	}

	public Label getRef_wb() {
		return ref_wb;
	}

	public void setRef_wb(Label ref_wb) {
		this.ref_wb = ref_wb;
	}

	public TextField getRef_wbtx() {
		return ref_wbtx;
	}

	public void setRef_wbtx(TextField ref_wbtx) {
		this.ref_wbtx = ref_wbtx;
	}

	public HBox getRef_set() {
		return ref_set;
	}

	public void setRef_set(HBox ref_set) {
		this.ref_set = ref_set;
	}

	public VBox getRef_c1() {
		return ref_c1;
	}

	public void setRef_c1(VBox ref_c1) {
		this.ref_c1 = ref_c1;
	}

	public VBox getRef_c2() {
		return ref_c2;
	}

	public void setRef_c2(VBox ref_c2) {
		this.ref_c2 = ref_c2;
	}

	public ComboBox getElement_ts() {
		return element_ts;
	}

	public void setElement_ts(ComboBox element_ts) {
		this.element_ts = element_ts;
	}

	public TextField getRef_watx() {
		return ref_watx;
	}
	
	public TextField getRef_watx2() {
		return ref_watx2;
	}

	public Label getRef_wa() {
		return ref_wa;
	}

	public void setRef_wa(Label ref_wa) {
		this.ref_wa = ref_wa;
	}

	public HBox getAtk_box() {
		return atk_box;
	}

	public void setAtk_box(HBox atk_box) {
		this.atk_box = atk_box;
	}

	public Label getDef_foe() {
		return def_foe;
	}

	public void setDef_foe(Label def_foe) {
		this.def_foe = def_foe;
	}

	public Label getDef_p() {
		return def_p;
	}

	public void setDef_p(Label def_p) {
		this.def_p = def_p;
	}

	public Label getDef_damage() {
		return def_damage;
	}

	public void setDef_damage(Label def_damage) {
		this.def_damage = def_damage;
	}

	public TextField getDef_foetx() {
		return def_foetx;
	}

	public void setDef_foetx(TextField def_foetx) {
		this.def_foetx = def_foetx;
	}

	public TextField getDef_ptx() {
		return def_ptx;
	}

	public void setDef_ptx(TextField def_ptx) {
		this.def_ptx = def_ptx;
	}

	public TextField getDef_damagetx() {
		return def_damagetx;
	}

	public void setDef_damagetx(TextField def_damagetx) {
		this.def_damagetx = def_damagetx;
	}

	public HBox getDef_set() {
		return def_set;
	}

	public void setDef_set(HBox def_set) {
		this.def_set = def_set;
	}

	public VBox getDef_c1() {
		return def_c1;
	}

	public void setDef_c1(VBox def_c1) {
		this.def_c1 = def_c1;
	}

	public VBox getDef_c2() {
		return def_c2;
	}

	public void setDef_c2(VBox def_c2) {
		this.def_c2 = def_c2;
	}

	public void setRef_watx(TextField ref_watx) {
		this.ref_watx = ref_watx;
	}

	public void setRef_watx2(TextField ref_watx2) {
		this.ref_watx2 = ref_watx2;
	}
	
	
}
