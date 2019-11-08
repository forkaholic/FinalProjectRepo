package edu.wit.cs.comp1050;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Late as Always
public class CalculatorGUI extends Application{
	
	private boolean scientific;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unused")
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
		Button toggle = new Button("Mode");
		Button answer = new Button("ANS");
		Button clear = new Button("C");
		Button equals = new Button("=");
		Button decimal = new Button(".");
		Button negative = new Button("-");
		Button openP = new Button("(");
		Button closeP = new Button(")");
		
		Button addition= new Button("+");
		Button subtraction = new Button("-");
		Button multiplication = new Button("*");
		Button division = new Button("/");
		Button log = new Button("log");
		Button sqrt = new Button(String.format("%c", (char) 251));
		Button power = new Button("x^y");
		Button exponential = new Button("e^x");
		Button sine = new Button("sin(x)");
		Button cosine = new Button("cos(x)");
		
		//PANES IN ORDER**********************************
		VBox base = new VBox();
		base.setAlignment(Pos.CENTER);
		
		Text screen = new Text("NULL");
		HBox ansCandToggle = new HBox();
		
		VBox science = new VBox();
		HBox sciencer1 = new HBox();
		HBox sciencer2 = new HBox();
		
		VBox main = new VBox();
		HBox mainr1 = new HBox();
		HBox mainr2 = new HBox();
		HBox mainr3 = new HBox();
		HBox mainr4 = new HBox();

		//BUTTON & TEXT ASSEMBLY**************************
		base.getChildren().add(screen);
		
		ansCandToggle.getChildren().add(answer);
		ansCandToggle.getChildren().add(clear);
		ansCandToggle.getChildren().add(toggle);
		
		sciencer1.getChildren().add(log);
		sciencer1.getChildren().add(sqrt);
		sciencer1.getChildren().add(openP);
		sciencer1.getChildren().add(closeP);
		
		sciencer2.getChildren().add(sine);
		sciencer2.getChildren().add(cosine);
		sciencer2.getChildren().add(power);
		sciencer2.getChildren().add(exponential);
		
		mainr1.getChildren().add(seven);
		mainr1.getChildren().add(eight);
		mainr1.getChildren().add(nine);
		mainr1.getChildren().add(addition);
		
		mainr2.getChildren().add(four);
		mainr2.getChildren().add(five);
		mainr2.getChildren().add(six);
		mainr2.getChildren().add(subtraction);
		
		mainr3.getChildren().add(one);
		mainr3.getChildren().add(two);
		mainr3.getChildren().add(three);
		mainr3.getChildren().add(multiplication);
		
		mainr4.getChildren().add(decimal);
		mainr4.getChildren().add(zero);
		mainr4.getChildren().add(negative);
		mainr4.getChildren().add(division);
		
		
		
		//PANE ASSEMBLY****************************
		base.getChildren().add(ansCandToggle);
		science.getChildren().add(sciencer1);
		science.getChildren().add(sciencer2);
		base.getChildren().add(main);
		main.getChildren().add(mainr1);
		main.getChildren().add(mainr2);
		main.getChildren().add(mainr3);
		main.getChildren().add(mainr4);
		main.getChildren().add(equals);
		
		toggle.setOnAction(event -> {
			if(!this.scientific) {
				primaryStage.setTitle("Scientific Calculator");
				base.getChildren().add(2, science);
				primaryStage.show();
				this.scientific = true;
			}
			
			else {
				primaryStage.setTitle("Basic Calculator");
				base.getChildren().remove(2);
				primaryStage.show();
				this.scientific = false;
			}
		});
		
		primaryStage.setTitle("Basic Calculator");
		primaryStage.setScene(new Scene(base, 200, 200));
		primaryStage.show();
		
		
	}

}
