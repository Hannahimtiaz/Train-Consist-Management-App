import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    /**
     * Performs a binary search on the bogie IDs.
     * Requirement: Input must be sorted. If not, it sorts the array first.
     */
    public static boolean searchBogie(String[] bogies, String searchKey) {
        // Handle empty array case
        if (bogies == null || bogies.length == 0) {
            return false;
        }

        // Ensure data is sorted before searching
        Arrays.sort(bogies);

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {
            // Compute middle index
            int mid = low + (high - low) / 2;

            // Compare key with mid element using compareTo()
            int comparison = searchKey.compareTo(bogies[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison < 0) {
                high = mid - 1; // Search left half
            } else {
                low = mid + 1; // Search right half [cite: 1]
            }
        }

        return false; // Match not found [cite: 1]
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Train Consist Management System (Binary Search) ---");

        // Example workflow based on UC19 flow [cite: 1]
        System.out.print("Enter Bogie IDs separated by commas (e.g., BG309,BG101,BG550): ");
        String input = scanner.nextLine();

        String[] bogies;
        if (input.trim().isEmpty()) {
            bogies = new String[0];
        } else {
            bogies = input.split(",");
            for (int i = 0; i < bogies.length; i++) {
                bogies[i] = bogies[i].trim();
            }
        }

        System.out.print("Enter the Bogie ID to search: ");
        String searchKey = scanner.nextLine().trim();

        // Perform optimized searching [cite: 1]
        boolean found = searchBogie(bogies, searchKey);

        if (found) {
            System.out.println("Result: Bogie " + searchKey + " found in the system.");
        } else {
            System.out.println("Result: Bogie " + searchKey + " not found.");
        }

        scanner.close();
    }
}