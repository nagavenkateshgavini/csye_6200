package edu.northeastern.csye6200;

public class LAB5P1 {

	public static void main(String[] args) {
		MyInteger n1 = new MyInteger(7);
		
		System.out.println("n1 is even? " + n1.isEven());
		System.out.println("n1 is prime? " + n1.isPrime());
		System.out.println("15 is prime? " + MyInteger.isPrime(15));
		
		char[] charArray = { '4', '3', '7', '8' };
		System.out.println("parseInt(char[]) for { '4', '3', '7', '8' } = " + MyInteger.parseInt(charArray));
		
		String str = "4378";
		System.out.println("parseInt(String) for 4378 = " + MyInteger.parseInt(str));
		
		MyInteger n2 = new MyInteger(24);
		System.out.println("n2 is odd? " + n2.isOdd());
		System.out.println("45 is odd? " + MyInteger.isOdd(45));
		
		System.out.println("n1 is equal to n2? " + n1.equals(n2));
		System.out.println("n1 is equal to 5? " + n1.equals(5));
	}
}

class MyInteger {
	
	public int value;
	public MyInteger(int value) {
		this.value = value;
	}

	
	public int getValue() {
		return this.value;
	}


	public boolean isPrime() {
		if(this.value <= 1) {
			return false;
		}
		else {
			for(int i = 2; i <= this.value/2; i++) {
				if(this.value % i == 0 ) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static boolean isPrime(int num) {
		if(num <= 1) {
			return false;
		}
		else {
			for(int i = 2; i <= num/2; i++) {
				if(num % i == 0 ) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static boolean isPrime(MyInteger o) {
		if(o.getValue() <= 1) {
			return false;
		}
		else {
			for(int i = 2; i <= o.getValue()/2; i++) {
				if(o.getValue() % i == 0 ) {
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean isEven() {
		if(this.value % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isEven(int n) {
		if(n % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isEven(MyInteger n) {
		if(n.getValue() % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isOdd() {
		if(this.value % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}


	public static boolean isOdd(int n) {
		if(n % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public static boolean isOdd(MyInteger n) {
		if(n.getValue() % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean equals(int anotherNum) {
		if(this.value == anotherNum) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean equals(MyInteger o) {
		if(this.value == o.getValue()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static int parseInt(char[] numbers) {
	    int result = 0;
	    for (int i = 0; i < numbers.length; i++){
	        int digitVal = (int)numbers[i] - 48;
	        result = result * 10 + digitVal;
	    }
	    return result;
	}

	public static int parseInt(String s) {		
	    int finalNum = 0; 
	    int strLenght = s.length(); 
	    for(int i = 0; i < strLenght; i++)  
	    	finalNum = finalNum * 10 + ((int)s.charAt(i) - 48);
	    
	    return finalNum;
	}
}