public abstract class Figura implements FiguraInterface{
    private String typeOfFigura;
    private int x;
    private int y;

    public Figura(String typeOfFigura, int x, int y) {
        this.typeOfFigura = typeOfFigura;
        this.x = x;
        this.y = y;
    }

    public String getTypeOfFigura() {
        return typeOfFigura;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
