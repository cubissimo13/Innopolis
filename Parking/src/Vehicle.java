
public abstract class Vehicle {

    protected String model;
    protected int topSpeed;
    protected int licensePlate;

    public Vehicle(String model, int topSpeed, int licensePlate) {
        this.model = model;
        this.topSpeed = topSpeed;
        this.licensePlate = licensePlate;
    }

    public abstract void drive();

    public abstract void broken();

    public String getModel() {
        return model;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

}
