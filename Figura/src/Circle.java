public class Circle extends Figura {
    private double radius;

    public Circle(String typeOfFigura, int x, int y, double radius) {
        super(typeOfFigura, x, y);
        this.radius = radius;
    }

    public double areable(){
        double area;
        area = Math.PI*Math.pow(this.radius, 2);
        return area;
    }

    public double getRadius() {
        return radius;
    }
}
