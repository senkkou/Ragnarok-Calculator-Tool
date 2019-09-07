package rct.view;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import rct.controller.MainController;


public class Start extends Application{

	public static void main(String[] args) {
	System.out.println("Initializing Ragnarok Calculator Tool\n");
	Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{	
		stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
		MainView main = new MainView(stage);
		MainController mainC = new MainController(main);
		System.out.println("\nDONE\nRagnarok Calculator Tool Loaded");
		
	}

}