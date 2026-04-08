/**
 * MAIN CLASS - TrainConsistManagementApp
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 */
public class TrainConsistManagementApp {

    // 1. CUSTOM RUNTIME EXCEPTION (Static inner class)
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // 2. GOODS BOGIE MODEL (Static inner class)
    static class GoodsBogie {
        private String shape;
        private String cargoType;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            System.out.println("Attempting to assign " + cargo + " to " + shape + " bogie...");
            try {
                // Validation Rule: Petroleum cannot go in Rectangular bogies
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("SAFETY VIOLATION: Petroleum is unsafe for Rectangular bogies!");
                }
                this.cargoType = cargo;
                System.out.println("SUCCESS: " + cargo + " assigned.");
            } catch (CargoSafetyException e) {
                System.err.println("CAUGHT: " + e.getMessage());
            } finally {
                System.out.println("LOG: Validation check finished.");
                System.out.println("------------------------------------");
            }
        }
    }

    // 3. MAIN METHOD
    public static void main(String[] args) {
        // Test Case 1: Safe assignment
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        // Test Case 2: Unsafe assignment (Triggers Exception)
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");

        System.out.println("System remains operational after handling exceptions.");
    }
}