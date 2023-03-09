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
        * @return The cars currently attached to the train.
        */
        if (i>Cars_currently_attached.size()) {
            throw new RuntimeException("'i' value is out of range! The train doesn't have this many cars. It actually has" + Cars_currently_attached.size() + "cars .");
        }
        return this.Cars_currently_attached.get(i);
    }

    public int getMaxCapacity() {
        /**
        * The getter for the getMaxCapacity method.
        * @return The maximum capacity of all the train cars.
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
        * @return The seats remaining in the train car.
        */
        int seatsRemaining_value = 0; 
        for (int i=0; i<Cars_currently_attached.size(); i++) {
            seatsRemaining_value = seatsRemaining_value + Cars_currently_attached.get(i).seatsRemaining();
        }
        return seatsRemaining_value;
    }

    public void printManifest() {
        /**
         * Prints the names of all the passengers onboard each train car.
         */
        for (int i=0; i<this.Cars_currently_attached.size(); i++){ 
            Cars_currently_attached.get(i).printManifest();
        }
    }


    public static void main(String[] args) {
        Train newTrain = new Train(FuelType.ELECTRIC, 100.0, 3, 15);
        newTrain.Cars_currently_attached.add(new Car(10));
        try {
            while (true) {
                newTrain.engine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        newTrain.engine.refuel();
        System.out.println(newTrain.engine.getCurrent_fuel_level());

        Passenger bob = new Passenger("Billy Bob Sr.");
        Passenger bobjr = new Passenger("Billy Bob jr");

        newTrain.Cars_currently_attached.get(0).addPassenger(bob);
        newTrain.Cars_currently_attached.get(1).addPassenger(bobjr);
        newTrain.Cars_currently_attached.get(1).removePassenger(bobjr);
        System.out.println(newTrain.getMaxCapacity());
        System.out.println(newTrain.seatsRemaining());
        newTrain.printManifest();

        Car my_first_car = new Car(10);
        bobjr.boardCar(my_first_car);
        bobjr.boardCar(my_first_car); // will throw the exception where passenger is already onboard car
        bobjr.getOffCar(my_first_car);
        bobjr.getOffCar(my_first_car); // will throw the exception where passenger is not onboard car, so can't be removed from there.
        my_first_car.addPassenger(bobjr);
        my_first_car.printManifest();
        my_first_car.removePassenger(bobjr);
        System.out.println("Passenger kicked out.");
        my_first_car.printManifest();
        
    }

    

}