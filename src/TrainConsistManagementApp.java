import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // Simulates the collection of bogie IDs in the train consist
    private List<String> bogieIds;

    public TrainConsistManagementApp() {
        this.bogieIds = new ArrayList<>();
    }

    /**
     * Adds a bogie ID to the collection.
     * @param bogieId The ID of the bogie to add.
     */
    public void addBogie(String bogieId) {
        bogieIds.add(bogieId);
    }

    /**
     * Searches for a bogie ID.
     * Implements UC20 requirements:
     * 1. Check if collection is empty.
     * 2. Throw IllegalStateException if empty.
     * 3. Proceed with search if data exists.
     */
    public boolean searchBogie(String targetId) {
        // Step 2 & 3: Defensive Programming / State Validation
        if (bogieIds.isEmpty()) {
            // Step 4: Throw IllegalStateException - Fail-Fast Principle
            throw new IllegalStateException("Search operation failed: No bogies are available in the train consist.");
        }

        // Step 5: Proceed with search logic if validation passes
        for (String id : bogieIds) {
            if (id.equalsIgnoreCase(targetId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // --- Test Scenario 1: Search Throws Exception When Empty ---
        TrainConsistManagementApp appEmpty = new TrainConsistManagementApp();
        System.out.println("Testing Case: Search Throws Exception When Empty");
        try {
            appEmpty.searchBogie("BG101");
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
        System.out.println();

        // --- Test Scenario 2 & 3: Search Match Found After Validation ---
        TrainConsistManagementApp appWithData = new TrainConsistManagementApp();
        appWithData.addBogie("BG101");
        appWithData.addBogie("BG205");
        appWithData.addBogie("BG309");

        System.out.println("Testing Case: Search Match Found (BG205)");
        boolean found = appWithData.searchBogie("BG205");
        System.out.println("Bogie Found: " + found);
        System.out.println();

        // --- Test Scenario 4: Search Match Not Found After Validation ---
        System.out.println("Testing Case: Search Match Not Found (BG999)");
        boolean notFound = appWithData.searchBogie("BG999");
        System.out.println("Bogie Found: " + notFound);
        System.out.println();

        // --- Test Scenario 5: Single Element Valid Case ---
        TrainConsistManagementApp appSingle = new TrainConsistManagementApp();
        appSingle.addBogie("BG101");
        System.out.println("Testing Case: Single Element Search (BG101)");
        System.out.println("Bogie Found: " + appSingle.searchBogie("BG101"));

        System.out.println("\nUC20 execution completed...");
    }
}