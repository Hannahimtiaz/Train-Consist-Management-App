import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case: Train Consist Management (First-Come-First-Served)
 * This class demonstrates how incoming train cars are added to a consist
 * in a fair and predictable order using a Queue.
 */

class TrainCar {
    private String carId;
    private String carType; // e.g., "Freight", "Passenger", "Tanker"

    public TrainCar(String carId, String carType) {
        this.carId = carId;
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car ID: " + carId + " [" + carType + "]";
    }
}

class ConsistQueue {
    private Queue<TrainCar> queue = new LinkedList<>();

    // Add a car to the end of the train
    public void addCar(TrainCar car) {
        queue.add(car);
        System.out.println("Added to queue: " + car);
    }

    // Display all cars in the current order
    public void displayConsist() {
        System.out.println("\n--- Current Train Consist (Arrival Order) ---");
        if (queue.isEmpty()) {
            System.out.println("The consist is currently empty.");
        } else {
            for (TrainCar car : queue) {
                System.out.println(car);
            }
        }
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Display application header
        System.out.println("Train Consist Management System");
        System.out.println("================================");

        // Initialize the consist queue
        ConsistQueue myConsist = new ConsistQueue();

        // Create train car arrival requests
        TrainCar c1 = new TrainCar("T-101", "Engine");
        TrainCar c2 = new TrainCar("F-505", "Freight");
        TrainCar c3 = new TrainCar("P-202", "Passenger");
        TrainCar c4 = new TrainCar("T-909", "Tanker");

        // Add cars to the queue (FIFO)
        myConsist.addCar(c1);
        myConsist.addCar(c2);
        myConsist.addCar(c3);
        myConsist.addCar(c4);

        // Display the sequence
        myConsist.displayConsist();

        System.out.println("\nStatus: Consist ready for departure sequencing.");
    }
}