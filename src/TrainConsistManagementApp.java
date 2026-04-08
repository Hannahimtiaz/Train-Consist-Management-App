import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. User provides a list of bogie IDs
        // Example list from test cases: {"BG101", "BG205", "BG309", "BG412", "BG550"}
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println("Current Bogies in Consist: ");
        for (String bogie : bogies) {
            System.out.print(bogie + " ");
        }
        System.out.println("\n");

        // 2. User provides a search key
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Perform Linear Search
        boolean found = performLinearSearch(bogies, searchKey);

        // 6. Result is displayed
        if (found) {
            System.out.println("Bogie " + searchKey + " found in the consist.");
        } else {
            System.out.println("Bogie " + searchKey + " not found in the consist.");
        }

        scanner.close();
    }

    /**
     * Implements Linear Search logic to traverse the array sequentially.
     * Key Concepts: Sequential Traversal, Equality Comparison, Early Termination.
     */
    public static boolean performLinearSearch(String[] arr, String key) {
        // 3. System traverses the array sequentially
        for (int i = 0; i < arr.length; i++) {
            // 4. Each element is compared with the search key using equals() [cite: 1]
            if (arr[i].equals(key)) {
                // 5. If match found, search stops (Early Termination) [cite: 1]
                return true;
            }
        }
        // If the entire array is traversed and no match is found [cite: 1]
        return false;
    }
}