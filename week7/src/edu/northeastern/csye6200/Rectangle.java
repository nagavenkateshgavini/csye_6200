package edu.northeastern.csye6200;

public class Rectangle extends GeometricObject{

	private double width;
    private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2 * width + 2 * height;
	}
}
