package edu.northeastern.csye6200;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LAB8P2 extends Application
{
	public static final double WIDTH = 400;
	public static final double HEIGHT = 400;
	public static final double HALFHEIGHT = (HEIGHT / 2);
	
	public static double[] percenVals = {0.35, 0.30, 0.30, 0.05};
	
	public static  Color[] allColors = {
			Color.BLUE,
			Color.GREEN,
			Color.RED,
			Color.ORANGE
		};

	public static String[] barTitles = {
		"Project -- " + String.format("%d%s", (int)(100 * percenVals[0]), "%"),
		"Exams -- " + String.format("%d%s", (int)(100 * percenVals[1]), "%"),
		"Assignments -- " + String.format("%d%s", (int)(100 * percenVals[2]), "%"),
		"Attendance -- "+ String.format("%d%s", (int)(100 * percenVals[3]), "%")
		};
	
	
	@Override
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		pane.setPadding(new Insets(5, 10, 0, 10));
		Rectangle[] bars = new Rectangle[4];
		
		for (int i = 0; i < bars.length; i++){
			// Create rectangle
			bars[i] = new Rectangle(
					5 + (100 * i), 
					HALFHEIGHT - (HEIGHT * percenVals[i]),
					WIDTH / bars.length - 5,
					HEIGHT * percenVals[i]
			);
			
			// Fill with color
			bars[i].setFill(allColors[i]);
			
			// Set the title for the bar
			Text mytext = new Text(
					5 + (100 * i),
					HALFHEIGHT - (HEIGHT * percenVals[i]) - 5,
					barTitles[i]
			);
			
			pane.getChildren().addAll(mytext, bars[i]);
		}
		
		primaryStage.setScene(new Scene(pane, WIDTH + 20, HALFHEIGHT));
		primaryStage.setTitle("Lab8_Problem 2");
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}

