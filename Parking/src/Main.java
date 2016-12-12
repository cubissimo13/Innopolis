
public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking();
        Motorcycle bike = new Motorcycle("Kawasaki", 10, 333, "sport");
        Car car = new  Car("Honda", 60, 111, 5, 4);

        parking.parkVehicle(bike);
        parking.removeVehicle(bike);
        parking.parkVehicle(car);
        parking.removeVehicle(car);
    }
}
