public class Engine {
    /**
     * Stores information about the train's fuel type, fuel level, and capacity.
     */
    private FuelType fuel_type;
    private double maximum_fuel_level;
    private double current_fuel_level;

    public Engine(FuelType fuel_type, double maximum_fuel_level){
        /** 
         * Contains variables for the type of fuel, the maximum fuel level, and the train's current fuel level.
         * @param fuel_type The train's fuel type.
         * @param maximum_fuel_level The train's maximum fuel level.
         * @para current_fuel_level The train's current fuel level.
         */
        this.fuel_type = fuel_type;
        this.maximum_fuel_level = maximum_fuel_level;
        this.current_fuel_level = maximum_fuel_level;
    }

    public double getMaximum_fuel_level() {
        /**
         * Getter for the maximum fuel level method.
         * @return the maximum fuel level of the train.
         */
        return this.maximum_fuel_level;
    }

    public double getCurrent_fuel_level() {
        /**
         * Getter for the current fuel level method.
         * @return The current fuel level of the train.
         */
        return this.current_fuel_level;
    }

    public void go() {
        /** 
         * Simulates the train's fuel level depleting over time. Throws an exception when the train's current fuel level reaches 0 to end the method.
         * @throws RuntimeException When the train runs out of fuel.
         */
            if (this.current_fuel_level > 0) {
                this.current_fuel_level--;
                System.out.println(current_fuel_level);
            }
            else{
                throw new RuntimeException("Out of fuel!");
            }
    }

    public void refuel() {
        /**
         * Refuels the train, setting the train's current fuel level to its maximum.
         */
        this.current_fuel_level = this.maximum_fuel_level;
    }


}