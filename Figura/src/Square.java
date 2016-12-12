public class Square extends Figura {
    double side;

    public Square(String typeOfFigura, int x, int y, double side) {
        super(typeOfFigura, x, y);
        this.side = side;
    }

    public double areable(){
        double area;
        area = Math.pow(this.side, 2);
        return area;
    }

    public double getSide() {
        return side;
    }
}
