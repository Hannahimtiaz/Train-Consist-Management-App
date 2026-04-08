import java.util.Scanner;

/**
 * MAIN CLASS - TrainConsistManagementApp
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. User provides passenger bogie capacities
        System.out.println("Enter the number of passenger bogies:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("No bogies to sort.");
            return;
        }

        int[] capacities = new int[n];
        System.out.println("Enter the capacities of the bogies:");
        for (int i = 0; i < n; i++) {
            capacities[i] = scanner.nextInt();
        }

        // Perform Bubble Sort
        bubbleSort(capacities);

        // 6. Sorted result is displayed
        System.out.print("Sorted Bogie Capacities: ");
        for (int i = 0; i < capacities.length; i++) {
            System.out.print(capacities[i] + (i == capacities.length - 1 ? "" : ", "));
        }
        System.out.println();

        scanner.close();
    }

    /**
     * Bubble Sort Algorithm Implementation
     * Repeatedly swaps adjacent elements if they are in the wrong order.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 2. System iterates through the array
        for (int i = 0; i < n - 1; i++) {
            // 5. Multiple passes continue until sorted
            for (int j = 0; j < n - i - 1; j++) {
                // 3. Adjacent values are compared
                if (arr[j] > arr[j + 1]) {
                    // 4. If out of order (left > right), values are swapped
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}