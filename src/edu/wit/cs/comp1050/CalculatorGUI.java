package edu.wit.cs.comp1050;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//Late as Always
public class CalculatorGUI extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
