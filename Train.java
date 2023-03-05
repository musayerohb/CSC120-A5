public class Train {
    public static void main(String[] args) {

        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 15.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel (what is this line supposed to do after throwing the exception in engine.java?)
        }
    }
}

