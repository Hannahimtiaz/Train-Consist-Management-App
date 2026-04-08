import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Test Case 1: Basic Alphabetical Sorting
        String[] bogies1 = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        sortAndDisplay("Basic Alphabetical Sorting", bogies1);

        // Test Case 2: Unsorted Input Handling
        String[] bogies2 = {"Luxury", "General", "Sleeper", "AC Chair"};
        sortAndDisplay("Unsorted Input Handling", bogies2);

        // Test Case 3: Already Sorted Array
        String[] bogies3 = {"AC Chair", "First Class", "General"};
        sortAndDisplay("Already Sorted Array", bogies3);

        // Test Case 4: Duplicate Bogie Names
        String[] bogies4 = {"Sleeper", "AC Chair", "Sleeper", "General"};
        sortAndDisplay("Duplicate Bogie Names", bogies4);

        // Test Case 5: Single Element Array Handling
        String[] bogies5 = {"Sleeper"};
        sortAndDisplay("Single Element Array Handling", bogies5);
    }

    /**
     * Sorts the bogie array using Arrays.sort() and prints the result.
     * Uses O(n log n) time complexity.
     */
    public static void sortAndDisplay(String testName, String[] bogies) {
        System.out.println("Test Case: " + testName);
        System.out.println("Before Sorting: " + Arrays.toString(bogies));

        // Using Java's built-in optimized sorting utility
        Arrays.sort(bogies);

        System.out.println("After Sorting:  " + Arrays.toString(bogies));
        System.out.println("--------------------------------------------");
    }
}