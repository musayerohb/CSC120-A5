public class Train {
    /**
     * Ties Car, Engine, and Passenger classes together.
     * @param args The program's arguments.
     */
    public static void main(String[] args) {

        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 15.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel (what is this line supposed to do after throwing the exception in engine.java?)
        }
        Car my_first_car = new Car(null, 10);
        // Passenger bob = new Passenger("Billy Bob Sr."); 
        // my_first_car.addPassenger(bob);
        // System.out.println("Passenger added.");
        // my_first_car.printManifest();
        // my_first_car.removePassenger(bob);
        // System.out.println("Passenger kicked out.");
        // my_first_car.printManifest();
        
    }

    

}

