public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Circle", 1, 1, 20);
        System.out.println("Area of " + circle.getTypeOfFigura() + " with radius " + circle.getRadius() + " is " + circle.areable());

        Square square = new Square("Square", 1, 1, 2);
        System.out.println("Area of " + square.getTypeOfFigura() + " with side " + square.getSide() + " is " + square.areable());

        Rectangle rectangle = new Rectangle("Rectnagle", 1, 1, 2, 4);
        System.out.println("Area of " + rectangle.getTypeOfFigura() + " with side X =" + rectangle.getSideX() + " and side Y=" +rectangle.getSideY() + " is " + rectangle.areable());
    }
}
