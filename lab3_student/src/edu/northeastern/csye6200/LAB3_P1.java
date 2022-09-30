package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P1 {
	private static final int CARD_MIN_CHAR=13;
	private static final int CARD_MAX_CHAR=16;
	
	private static final String VISA_START_CHAR="4";
	private static final String MASTER_START_CHAR="5";
	private static final String AM_EXPRESS_START_CHAR="37";
	private static final String DISCOVER_START_CHAR="6";


	public static void main(String[] args) {
		long cardNumber = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter a credit card number as a long integer:");
			
			cardNumber = scanner.nextLong();
		}
		catch (Exception e) {
			System.out.println("Failed to read input from user with error: "+ e);
		}
		
		
		boolean isvalid = isValid(cardNumber);
		
		if(isvalid==true) {
			System.out.println(cardNumber + " is valid");
		}
		else {
			System.out.println(cardNumber + " is invalid");
		}
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {	
		int size = getSize(number);
		if(size > CARD_MAX_CHAR && size <CARD_MIN_CHAR) {
			return false;
		}
		
		// Check whether the card starts with 4, 5, 37, 6
		String cardNumberInString = String.valueOf(number);
		if((cardNumberInString.startsWith(VISA_START_CHAR)
				|| cardNumberInString.startsWith(MASTER_START_CHAR) 
				|| cardNumberInString.startsWith(AM_EXPRESS_START_CHAR)
				|| cardNumberInString.startsWith(DISCOVER_START_CHAR)) != true) {
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
		for (int i=0; i<cardNumberInString.length(); i++) {
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
