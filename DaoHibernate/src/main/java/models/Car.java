package models;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "ownerid")
    private int ownerId;
    @Column(name = "model")
    private String model;
    @Column(name = "trip")
    private int trip;

    public Car() {
    }

    public Car(int ownerId, String model, int trip) {
        this.ownerId = ownerId;
        this.model = model;
        this.trip = trip;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", model='" + model + '\'' +
                ", trip=" + trip +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getModel() {
        return model;
    }

    public int getTrip() {
        return trip;
    }
}

