package rct.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ElementView extends Stage {
	
	private GridPane pane;
	private Image tablelvl;
	private ImageView tablelvlview;
	
	public ElementView(int table){
	init(table);
	Scene scene = new Scene(pane, 725, 265, Color.GRAY);
	this.setScene(scene);
	this.resizableProperty().set(false);
	this.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
	this.show();
	}
	
	public void init(int table){
		pane = new GridPane();
		
		switch(table){
		case 1:
			tablelvl = new Image(getClass().getResourceAsStream("t1.jpg"));
			this.setTitle("Element Table Level 1");
			break;
		
		case 2:
			tablelvl = new Image(getClass().getResourceAsStream("t2.jpg"));
			this.setTitle("Element Table Level 2");
			break;
			
		case 3:
			tablelvl = new Image(getClass().getResourceAsStream("t3.jpg"));
			this.setTitle("Element Table Level 3");
			break;
			
		case 4:
			tablelvl = new Image(getClass().getResourceAsStream("t4.jpg"));
			this.setTitle("Element Table Level 4");
			break;
			
		default: break;
		}
		tablelvlview = new ImageView();
		tablelvlview.setImage(tablelvl);
		pane.add(tablelvlview, 0, 0);
		
	}

}
