import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Class representing a Passenger Bogie
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie{type='" + type + "', capacity=" + capacity + "}";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. User creates a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // 2. The system converts the list into a stream
        // 3. filter() is applied with a condition (capacity > 60)
        // 4. Matching bogies are collected into a new list [cite: 1]
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // 5. Filtered bogies are displayed [cite: 1]
        System.out.println("\nFiltered High-Capacity Bogies (Capacity > 60):");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No matching bogies found.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // 6. Program continues (Original list integrity check) [cite: 1]
        System.out.println("\nOriginal list remains unchanged (Size: " + bogies.size() + ")");
    }
}
