import java.util.ArrayList;
import java.util.List;

// Custom exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

abstract class Bogie {
    protected String type;
    protected int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public int getCapacity() { return capacity; }
}

class PassengerBogie extends Bogie {
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        super(type, capacity);
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        List<Bogie> trainConsist = new ArrayList<>();

        System.out.println("--- Train Consist Management ---");

        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            trainConsist.add(validBogie);
            System.out.println("Added: " + validBogie.getType());
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        try {
            PassengerBogie zeroBogie = new PassengerBogie("AC Chair", 0);
            trainConsist.add(zeroBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            PassengerBogie negativeBogie = new PassengerBogie("First Class", -10);
            trainConsist.add(negativeBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final size: " + trainConsist.size());
    }
}