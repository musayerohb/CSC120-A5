public class Engine {
    private FuelType fuel_type;
    private double maximum_fuel_level;
    public double current_fuel_level;

    public Engine(FuelType fuel_type, double maximum_fuel_level, double current_fuel_level){
        this.fuel_type = fuel_type;
        this.maximum_fuel_level = maximum_fuel_level;
        this.current_fuel_level = current_fuel_level;
    }

    public void go() {
            if (this.current_fuel_level > 0) {
                this.current_fuel_level--;
                System.out.println(current_fuel_level);
            }
            else{
                throw new RuntimeException("Out of fuel!");
            }
    }

    public void refuel() {
        //make boolean statement for when current fuel level is already equal to the max fuel level?
        this.current_fuel_level = this.maximum_fuel_level;
    }

}
