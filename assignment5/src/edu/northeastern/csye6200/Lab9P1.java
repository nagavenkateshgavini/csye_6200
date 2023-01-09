package edu.northeastern.csye6200;

public class Lab9P1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Octagon octagon = new Octagon(9);

		System.out.printf("Area is %.2f \n", octagon.getArea());
		System.out.printf("Perimeter is %.2f \n", octagon.getPerimeter());

		Octagon octagonCloned = (Octagon)octagon.clone();

		int result = (octagon.compareTo(octagonCloned));
		System.out.println("Compare the methods " + result);
	}
}

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

	private double side;
	
	Octagon(double side) {
		this.side = side;
	}
	
	@Override
	public int compareTo(Octagon o) {
		if(getArea() == o.getArea()) {
			return 0;
		}
		else if (getArea() > o.getArea()) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * side * side;
	}

	@Override
	public double getPerimeter() {
		return 8 * side;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
}

}
