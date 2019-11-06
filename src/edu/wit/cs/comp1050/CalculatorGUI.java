package edu.wit.cs.comp1050;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//Late as Always
public class CalculatorGUI extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		//BUTTONS*****************************************
		//NUMBERS
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button zero = new Button("0");
		
		//FUNCTIONS		
		Button addition= new Button("+");
		Button subtraction = new Button("-");
		Button multiplication = new Button("*");
		Button division = new Button("/");
		Button log = new Button("log");
		Button sqrt = new Button(String.format("%c", (char) 251 ));
		Button power = new Button("x^y");
		Button exponential = new Button("e^x");
		Button sine = new Button("sin(x)");
		Button cosine = new Button("cos(x)");
		
		
		
		Pane basic = new Pane();
		
		Pane scientific = new Pane();

		Button swtch = new Button();
		
		
		
		
		
		
		swtch.setOnAction(event -> {
			if(basic.isVisible()) {
				primaryStage.setTitle("Scientific Calculator");
				primaryStage.setScene(new Scene(scientific, 200, 200));
				primaryStage.show();
			}
			else {
				primaryStage.setTitle("Basic Calculator");
				primaryStage.setScene(new Scene(basic, 200, 200));
				primaryStage.show();
			}
		});
		
		primaryStage.setTitle("Basic Calculator");
		primaryStage.setScene(new Scene(basic, 200, 200));
		primaryStage.show();
		
		
	}

}
