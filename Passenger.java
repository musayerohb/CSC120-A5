public class Passenger {
    /**
     * Stores information about individual passengers on the train. Also uses Car class' methods when passengers board and leave the train.
     * @param arguments The program's arguments
     */
    private String name;

    public Passenger(String name) {
        /**
         * Contains the name of each passenger on the train.
         * @param name The name of the passenger.
         */
        this.name = name;
    }
    public String get_Passeger_name() {
        /**
         * Getter for the Car class to have access to the passenger names.
         * @return The name of the passenger.
         */
        return this.name;
    }

    public void boardCar(Car c) {
        /**
         * Calls the addPassenger method from the Car class to add passengers' information to the train once they board.
         * @param c The train car the passenger is entering.
         */
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getOffCar(Car c) {
        /**
         * Calls the removePassenger method from the Car class to remove passengers' information from the train once they leave.
         * @param c The train car the passenger is leaving.
         */
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }     
    }
}