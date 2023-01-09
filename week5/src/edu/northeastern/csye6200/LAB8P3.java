package edu.northeastern.csye6200;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LAB8P3 extends Application {
	
	@Override 
	public void start(Stage primaryStage) {
        GridPane grids = new GridPane();    

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                Random rand = new Random();
                int rand1 = rand.nextInt(2);
                String randInString = String.valueOf(rand1);

                TextField textField = new TextField();
                textField.setPrefHeight(50);
                textField.setPrefWidth(50);
                textField.setAlignment(Pos.CENTER);
                textField.setEditable(false);
                textField.setText(randInString);

                grids.setRowIndex(textField, i);
                grids.setColumnIndex(textField, j);    
                grids.getChildren().add(textField);
            }
        }

        Scene scene = new Scene(grids, 500, 500);    
        primaryStage.setTitle("Lab 8 Problem 3 - Extra Credit");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}