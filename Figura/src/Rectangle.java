public class Rectangle extends Figura {
    private double sideX;
    private double sideY;

    public Rectangle(String typeOfFigura, int x, int y, double sideX, double sideY) {
        super(typeOfFigura, x, y);
        this.sideX = sideX;
        this.sideY = sideY;
    }

    public double areable(){
        double area;
        area = this.sideX*this.sideY;
        return area;
    }

    public double getSideX() {
        return sideX;
    }

    public double getSideY() {
        return sideY;
    }
}
