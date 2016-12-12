
public class Motorcycle extends Vehicle {

    private String typeOfBike;

    public Motorcycle(String model, int topSpeed, int licensePlate, String typeOfBike) {
        super(model, topSpeed, licensePlate);
        this.typeOfBike = typeOfBike;
    }

    @Override
    public void drive(){
        System.out.println("--------Ride My Bicycle------->");
    }

    @Override
    public void broken(){
        System.out.println("!Bike broken!");
    }

    public String getTypeOfBike() {
        return typeOfBike;
    }


}
