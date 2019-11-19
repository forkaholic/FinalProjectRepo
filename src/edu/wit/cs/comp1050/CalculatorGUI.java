package edu.wit.cs.comp1050;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	private StringBuilder currentCalc = new StringBuilder();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unused")
	public void start(Stage primaryStage) throws Exception {
		ScientificCalculator storage = new ScientificCalculator();
		Text screen = new Text(currentCalc.toString());
		//BUTTONS*****************************************
		/**
		 * DVarga, 2016, Source Code. https://stackoverflow.com/questions/40967789/check-which-button-object-is-clicked-using-javafx
		 */		
		String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "ANS", ".",
				"_", "(", ")", "+", "-", "*", "/", "log",
				"\u221A(", "^(", "e^(", "sin(", "cos("};
		Button[] buttons = new Button[strings.length];
		for(int i = 0; i < strings.length; i++) {
			final int buttonID = i;
			buttons[buttonID] = new Button(strings[buttonID]);
			buttons[buttonID].setMinSize(150, 50);
			buttons[buttonID].setOnAction(e -> { 
				currentCalc.append(strings[buttonID]);
				screen.setText(currentCalc.toString());
			});
		}
		
		buttons[20].setText("\u221A(x)");
		buttons[21].setText("x^y");
		buttons[22].setText("e^x");
		buttons[23].setText("sin(x)");
		buttons[24].setText("cos(x)");
				
		Button toggle = new Button("Mode");
		Button clear = new Button("C");
		Button equals = new Button("=");
		
		toggle.setMinSize(300, 50);
		clear.setMinSize(150, 50);
		equals.setMinSize(600,50);	
				
		//PANES IN ORDER**********************************
		VBox base = new VBox();
		base.setAlignment(Pos.CENTER);
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
		screen.setX(100);
		screen.setY(100);
		//ANS,TOGGLE,CLEAR
		ansCandToggle.getChildren().add(buttons[10]);
		ansCandToggle.getChildren().add(toggle);
		ansCandToggle.getChildren().add(clear);
		
		//E^X,LOG,(,)
		sciencer1.getChildren().add(buttons[22]);
		sciencer1.getChildren().add(buttons[19]);
		sciencer1.getChildren().add(buttons[13]);
		sciencer1.getChildren().add(buttons[14]);
		
		//X^Y,SQRT,SIN,COS
		sciencer2.getChildren().add(buttons[21]);
		sciencer2.getChildren().add(buttons[20]);
		sciencer2.getChildren().add(buttons[23]);
		sciencer2.getChildren().add(buttons[24]);
		
		mainr1.getChildren().add(buttons[7]);
		mainr1.getChildren().add(buttons[8]);
		mainr1.getChildren().add(buttons[9]);
		mainr1.getChildren().add(buttons[15]);
		
		mainr2.getChildren().add(buttons[4]);
		mainr2.getChildren().add(buttons[5]);
		mainr2.getChildren().add(buttons[6]);
		mainr2.getChildren().add(buttons[16]);
		
		mainr3.getChildren().add(buttons[1]);
		mainr3.getChildren().add(buttons[2]);
		mainr3.getChildren().add(buttons[3]);
		mainr3.getChildren().add(buttons[17]);
		
		mainr4.getChildren().add(buttons[11]);
		mainr4.getChildren().add(buttons[0]);
		mainr4.getChildren().add(buttons[12]);
		mainr4.getChildren().add(buttons[18]);
		
		
		
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
		
		//OUTPUT WINDOW****************
		Stage output = new Stage();		
		output.setTitle("Calculations");
		VBox outBox = new VBox();
		output.setScene(new Scene(outBox, 500, 220));
		output.show();
		
		//ACTION EVENTS****************		
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
		
		clear.setOnAction(event -> {
			currentCalc.delete(0, currentCalc.length());
			screen.setText(currentCalc.toString());
		});
		
		equals.setOnAction(event -> {
			if(storage.getArr().size() == 10) {
				outBox.getChildren().remove(0);
				storage.removeFirst();
			}
			storage.setResult(currentCalc.toString());
			outBox.getChildren().add(new Text(currentCalc.toString()));
			currentCalc.delete(0, currentCalc.length());
			screen.setText(currentCalc.toString());
		});
		
		primaryStage.setTitle("Basic Calculator");
		primaryStage.setScene(new Scene(base, 600, 450));
		primaryStage.show();
	}

}


