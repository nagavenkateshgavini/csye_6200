package edu.northeastern.csye6200;

public class Lab9P2 {
	public static void main(String[] args) {
		GeometricObject[] geometricObjects = new GeometricObject[5];
		geometricObjects[0] = new Square(2);
		geometricObjects[1] = new Circle(5);
		geometricObjects[2] = new Square(5);
		geometricObjects[3] = new Rectangle(3, 4);
		geometricObjects[4] = new Square(4.5);

        for (int i = 0; i < geometricObjects.length; i++) {
            System.out.printf("Area is %.2f \n", geometricObjects[i].getArea());
            if (geometricObjects[i] instanceof Colorable) {
                System.out.println(((Colorable)geometricObjects[i]).howToColor());
            }
            System.out.printf("\n");
        }
	}
}
 
interface Colorable {
	String howToColor();
}

class Square extends GeometricObject implements Colorable {

	private double side;
	
	Square(double side) {
        this.side = side;
    }
	
	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return side * 4;
	}
	
	@Override
    public String howToColor() {
        return "Color all four sides";
    }

}