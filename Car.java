import java.util.ArrayList;

public class Car {
    /**
     * Contains Passenger class objects.
     * @param arguments The program's arguments
     */
    private ArrayList<Passenger> passengersOnboard;
    private int maximumCapacity;

    public Car(int maximumCapacity) {
        /**
         * Stores the amount of people on the train in am array list and the maxiumum capacity in a variable.
         * @param passengersOnboard The numeber of passengers on the train.
         * @param maximumCapacity The maximum number of people that can be on the train at once.
         */
        this.maximumCapacity = maximumCapacity;
        this.passengersOnboard = new ArrayList<Passenger>();

    }

    public int getCapacity(){
        /**
         * Getter for the maximum capacity of people on the train.
         * @return The maximum number of people that can be on the train at once.
         */
        return this.maximumCapacity;
    }

    public int seatsRemaining(){
        /**
         * Calculates and returns the number of remaining seats available on the train.
         * @return The remaining number of seats available for passengers.
         */
        return (this.maximumCapacity - this.passengersOnboard.size());
    }

    public void addPassenger(Passenger p){
        /**
         * Adds passengers to the train. If a passenger is added twice OR there are no seats left open, an exception is thrown.
         * @param p The passenger being added.
         * @throws RuntimeException If the remaining amount of seats is 0.
         * @throws RuntimeException If a passenger who was already added to the train is added again.
         */
        if (this.seatsRemaining() == 0) {
            throw new RuntimeException("This car is full.");
        } else if (this.passengersOnboard.contains(p)) {
            throw new RuntimeException("This passenger is already onboard this car!");
        }
        else{
            this.passengersOnboard.add(p);
            this.seatsRemaining();
        }
    }

    public void removePassenger(Passenger p){
        /**
         * Removes passengers from the train. If a passenger is not on the train, an exception is thrown.
         * @param p The passenger being removed.
         * @throws RuntimeException If the information of the passenger being removed does not exist in the passengersOnboard list.
         */
        if (this.passengersOnboard.contains(p) == false) {
            throw new RuntimeException("The passenger is not onboard this car!");
        }
        else{
            passengersOnboard.remove(p);
            this.seatsRemaining();
        }
    }

    public void printManifest(){
        /**
         * Prints a list of all passengers in a car. If no passengers are in the car, it prints that the car is empty.
         */
        for (int i=0; i<this.passengersOnboard.size(); i++){
            System.out.println(passengersOnboard.get(i).get_Passeger_name()); //passengersOnboard[0].name
        }
        if (passengersOnboard.size() == 0) {
            System.out.println("This car is EMPTY.");
        }
         
    }

}