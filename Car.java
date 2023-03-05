import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengers_onboard;
    private int maximum_capacity;

    public Car(ArrayList<String> passengers_onboard, int maximum_capacity) {
        this.maximum_capacity = maximum_capacity;
        this.passengers_onboard = new ArrayList<Passenger>(maximum_capacity);

    }

    public int getCapacity(){
        return this.maximum_capacity;
    }

    public int seatsRemaining(){
        return (this.maximum_capacity - this.passengers_onboard.size());
    }

    public void addPassenger(Passenger p){
        if (this.seatsRemaining() == 0) {
            throw new RuntimeException("This car is full.");
        } else if (this.passengers_onboard.contains(p)) {
            throw new RuntimeException("This passenger is already onboard this car!");
        }
        else{
            passengers_onboard.add(p);
        }
    }

    public void removePassenger(Passenger p){
        if (this.passengers_onboard.contains(p) == false) {
            throw new RuntimeException("The passenger is not onboard this car!");
        }
        else{
            passengers_onboard.remove(p);
        }
    }

}

