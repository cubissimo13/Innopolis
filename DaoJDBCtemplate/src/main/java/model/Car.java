package model;

public class Car {
    private int id;
    private int ownerId;
    private String model;
    private int trip;

    private Car(){

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

    public static Builder newBuilder(){
        return new Car().new Builder();
    }

    public class Builder{

        private Builder() {
        }

        public Builder setId(int id){
            Car.this.id = id;
            return this;
        }

        public Builder setOwnerId(int ownerId){
            Car.this.ownerId = ownerId;
            return this;
        }

        public Builder setModel(String model){
            Car.this.model = model;
            return this;
        }

        public Builder setTrip(int trip){
            Car.this.trip = trip;
            return this;
        }

        public Car build(){
            return Car.this;
        }

    }
}
