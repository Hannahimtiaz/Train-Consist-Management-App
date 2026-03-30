import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be
 * managed dynamically using ArrayList operations.
 *
 * At this stage, the application:
 * - Adds new bogies to the train
 * - Removes existing bogies
 * - Checks for bogie availability
 * - Displays the final consist
 *
 * This maps CRUD operations using ArrayList.
 *
 * @author Developer
 * @version 2.0
 */

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("====================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        passengerBogies.add("Bogie1");
        passengerBogies.add("Bogie2");
        passengerBogies.add("Bogie3");

        System.out.println("After adding bogies: " + passengerBogies);

        // ---- DELETE (Remove a bogie) ----
        passengerBogies.remove("Bogie2");
        System.out.println("After removing Bogie2: " + passengerBogies);

        // ---- READ (Check availability) ----
        if (passengerBogies.contains("Bogie1")) {
            System.out.println("Bogie1 is present in the train.");
        } else {
            System.out.println("Bogie1 is NOT present.");
        }

        // ---- UPDATE (Modify a bogie) ----
        passengerBogies.set(0, "Bogie1-Updated");
        System.out.println("After updating Bogie1: " + passengerBogies);

        // Final state
        System.out.println("\nFinal train consist: " + passengerBogies);
    }
}