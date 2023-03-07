import java.util.ArrayList;

public class Train {
    /**
     * Ties Car, Engine, and Passenger classes together.
     * @param args The program's arguments.
     */
    private final Engine engine;
    private ArrayList<Car> Cars_currently_attached;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int maximum_capacity) {
        /**
        * The train with its fuel details, number of cars, and amount of the people that can fit in the train.
        * @param fuelType The type of fuel the train is using.
        * @param fuelCapacity The amount of fuel the train can hold.
        * @param nCars The number of cars attached to the train.
        * @param maximum_capacity The maximum amount of people that can fit in a train car.
        */
        this.engine = new Engine(fuelType, fuelCapacity);
        this.Cars_currently_attached = new ArrayList<Car>();
        for (int i=0; i<nCars; i++) {
            this.Cars_currently_attached.add(new Car(maximum_capacity));
        }
    }

    public Engine getEngine() {
        /**
        * The getter for the Engine class.
        * @return The methods within the Engine class.
        */
        
        return this.engine;
    }
    public Car getCar(int i) {
        /**
        * The getter for the Car class.
        * @throws RuntimeException When the value of i exceeds the amount of cars currently attached to the train.
        * @return The methods within the Car class.
        */
        if (i>Cars_currently_attached.size()) {
            throw new RuntimeException("'i' value is out of range! The train doesn't have this many cars. It actually has" + Cars_currently_attached.size() + "cars .");
        }
        return this.Cars_currently_attached.get(i);
    }

    public int getMaxCapacity() {
        /**
        * The getter for the getMaxCapacity method.
        * WILL ADD PARAMS AND STUFF ONCE DONE
        */
        int getMaxCapacity_value = 0; 
        for (int i=0; i<Cars_currently_attached.size(); i++) {
            getMaxCapacity_value = getMaxCapacity_value + Cars_currently_attached.get(i).getCapacity();
        }
        return getMaxCapacity_value;
    }

    public int seatsRemaining() {
         /**
        * The getter for the getMaxCapacity method.
        * WILL ADD PARAMS AND STUFF ONCE DONE
        */
        int seatsRemaining_value = 0; 
        for (int i=0; i<Cars_currently_attached.size(); i++) {
            seatsRemaining_value = seatsRemaining_value + Cars_currently_attached.get(i).seatsRemaining();
        }
        return seatsRemaining_value;
    }

    public void printManifest() {
        /**
         * DO ONCE THIS METHOD IS COMPLETE.
         */
        for (int i=0; i<this.Cars_currently_attached.size(); i++){ 
            Cars_currently_attached.get(i).printManifest(); //select the list of attached cars, select the car within the list, select that car's passenger list, and then get the name of each passenger in the list
        }
    }


    public static void main(String[] args) {
        //Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 15.0);
        Train newTrain = new Train(FuelType.ELECTRIC, 100.0, 3, 15);
        newTrain.Cars_currently_attached.add(new Car(10));
        try {
            while (true) {
                newTrain.engine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel (what is this line supposed to do after throwing the exception in engine.java?)
        }
        //Car my_first_car = new Car(null, 10);
        Passenger bob = new Passenger("Billy Bob Sr.");
        newTrain.Cars_currently_attached.get(0).addPassenger(bob);
        System.out.println(newTrain.getMaxCapacity());
        System.out.println(newTrain.seatsRemaining());
        newTrain.printManifest();
        // bob.boardCar(my_first_car);
        // bob.boardCar(my_first_car); // will throw the exception where passenger is already onboard car
        // bob.getOffCar(my_first_car);
        // bob.getOffCar(my_first_car); // will throw the exception where passenger is not onboard car, so can't be removed from there.
        // my_first_car.addPassenger(bob);
        // System.out.println("Passenger added.");
        // my_first_car.printManifest();
        // my_first_car.removePassenger(bob);
        // System.out.println("Passenger kicked out.");
        // my_first_car.printManifest();
        
    }

    

}

