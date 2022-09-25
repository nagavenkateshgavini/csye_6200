package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P1 {
	public static void main(String[] args) {
		long cardNumber = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter a credit card number as a long integer:");
			
			cardNumber = scanner.nextLong();
		}
		catch (Exception e) {
			System.out.println("Failed to read input from user with error: "+ e);
		}
		
		
		boolean isvalid = isValid(cardNumber);
		
		if(isvalid==true) {
			System.out.println(cardNumber + "is valid");
		}
		else {
			System.out.println(cardNumber + "is invalid");
		}
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {	
		// Check if the card number is in between 13 and 16 numbers
		int size = getSize(number);
		if(size > 16 && size <13) {
			return false;
		}
		
		// Check whether the card starts with 4, 5, 37, 6
		String cardNumberInString = String.valueOf(number);
		if((cardNumberInString.startsWith("4") || cardNumberInString.startsWith("5") 
				|| cardNumberInString.startsWith("37") || cardNumberInString.startsWith("6")) != true) {
			return false;
		}
		
		// Check if the sum divisible by 10 or not
		int evenSum = 0;
		int oddSum = 0;
		String cardNumberInStringReversedString = getStringReversal(cardNumberInString);
		for(int i=0; i < cardNumberInStringReversedString.length(); i++) {
			if((i+1) % 2 == 0) {
				int numChar = Character.getNumericValue(cardNumberInStringReversedString.charAt(i));
				int evenNumDigit = sumOfDoubleEvenPlace(numChar);
				evenSum += evenNumDigit;
			}
			else {
				int oddNumDigit = Character.getNumericValue(cardNumberInStringReversedString.charAt(i));
				oddSum += oddNumDigit;
			}
		}
		
		int entireSum = evenSum + oddSum;
		if(entireSum % 10 != 0) {
			return false;
		}
		
		return true;
	}

	
	public static String getStringReversal(String cardNumberInString) {
		String finalStr="";
	    char ch;
        for (int i=0; i<cardNumberInString.length(); i++)
        {
        	ch = cardNumberInString.charAt(i); 
        	finalStr = ch+finalStr; 
        }
        return finalStr;
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(int number) {
		int finalNumberVal = 0;
		int numberModified = number * 2;
		String numberModifiedInString = String.valueOf(numberModified);
		if(numberModifiedInString.length() > 1) {
			int sum = 0;
			char[] numbersArray = numberModifiedInString.toCharArray();
			for(char charNum : numbersArray) {
				sum += Character.getNumericValue(charNum);
			}
			finalNumberVal = sum;
		}
		else {
			finalNumberVal = numberModified;
		}
		
		return finalNumberVal;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		int length = String.valueOf(d).length();
		return length;
	}
}
