package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of values: ");
		int totalValues = scanner.nextInt();
		
		int[] numbers = new int[totalValues];
		try {
			System.out.print("Enter the numbers as an array:");		
			numbers = new int[totalValues];
			for(int i = 0;i < totalValues;i++){
			   numbers[i] = scanner.nextInt();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}		
		
		boolean isConsecutiveFourExists = isConsecutiveFour(numbers);
		if(isConsecutiveFourExists) {
			System.out.println("The list has consecutive fours");
		}else {
			System.out.println("The list has no consecutive fours");
		}
	}

	public static boolean isConsecutiveFour(int[] values) {
		int counter = 0;
		int previous = values[0];
		for(int i=1; i < values.length; i++) {
			if(values[i] == previous) {
				counter++;
			}
			previous = values[i];
			
			if(i==(values.length-1)) {
				if(values[i]==previous) {
					counter++;
				}
			}

			if(counter==4) {
				return true;
			}
		}
		return false;
	}

}

