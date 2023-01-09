package edu.northeastern.csye6200;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LAB8P1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of columns: ");
		int cols = scanner.nextInt();
		Random rndRandom = new Random();
		
		
		int[][] matrix = new int[rows][cols];
		
		// Fill the array
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrix[i][j] = rndRandom.nextInt(10);
			}
		}
		
		// Check for largest row
		int largestRowIdx = -1;
		int rowSumPlaceHolder = 0;
		int newSum = 0;
		for(int i = 0; i < rows; i++) {
			newSum = sumRow(matrix[i]);
			if(newSum > rowSumPlaceHolder) {
				largestRowIdx = i;
				rowSumPlaceHolder = newSum;
			}
		}
		
		// Check for largest column
		int largestColIdx = -1;
		int colSumPlaceholder = 0;
		int newSumCol = 0;
		for(int i = 0; i < cols; i++) {
			newSumCol = sumColumn(matrix, i);
			if(newSumCol > colSumPlaceholder) {
				largestColIdx = i;
				colSumPlaceholder = newSumCol;
			}
		}
		
		// print the array
		System.out.println("The array content is:");
		System.out.println();
		for(int i=0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
		System.out.println("The index of the largest row: " + largestRowIdx);
		System.out.println("The index of the largest column: " + largestColIdx);
		
		scanner.close();
	}

	public static int sumRow(int row[]) {
		int sum = 0;
		for(int i = 0; i < row.length; i++) {
			sum += row[i];
		}
		return sum;
	}

	public static int sumColumn(int matrix[][], int column) {
		int sum = 0;
		for(int i = 0; i < matrix.length; i++) {
			sum += matrix[i][column];
		}
		
		return sum;
	}
}
