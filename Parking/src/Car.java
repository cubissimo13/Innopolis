
public class Car extends Vehicle {

    private int countOfSeats;
    private int countOfDoors;

    public Car(String model, int topSpeed, int licensePlate, int countOfSeats, int countOfDoors) {
        super(model, topSpeed, licensePlate);
        this.countOfSeats = countOfSeats;
        this.countOfDoors = countOfDoors;
    }

    @Override
    public void drive() {
        System.out.println("--------Ride My Car------->");
    }

    @Override
    public void broken() {
        System.out.println("! Car is broken !");
    }

    public int getCountOfSeats() {

        return countOfSeats;
    }

    public int getCountOfDoors() {
        return countOfDoors;
    }


}
