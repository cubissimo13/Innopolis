import java.util.ArrayList;

public class Parking {
    private final int MAX_PLACES = 10;
    private String address;
    private Vehicle[] vehicle;
    private int countOfParkedVehicle = 0;

    public Parking() {
        this.address = "Lenina";
        this.vehicle = new Vehicle[MAX_PLACES];
    }

    public void parkVehicle(Vehicle vehicle) {
        if (countOfParkedVehicle < MAX_PLACES) {
            this.vehicle[countOfParkedVehicle] = vehicle;
            System.out.println(vehicle.model + " is parked");
        } else {
            System.out.println("Parking is Full");
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        int indexOfRemovingVehicle = 0;
        for (int i = 0; i < countOfParkedVehicle; i++) {
            if (this.vehicle[i].licensePlate == vehicle.licensePlate) {
                indexOfRemovingVehicle = i;
                break;
            } else {
                System.out.println("That vehicle not found on parking");
            }
        }
        for (int i = indexOfRemovingVehicle; i < countOfParkedVehicle; i++) {
            this.vehicle[i] = this.vehicle[i + 1];
        }
        System.out.println("vehicle was removed");
    }


    public String getAddress() {
        return address;
    }
}
