import java.util.ArrayList;
import java.util.List;

// Supporting class to represent a Bogie
class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));

        // 2. Use Stream API to calculate total seating capacity
        // - stream() converts the list into a stream
        // - map() extracts the capacity values
        // - reduce() sums the capacities using Integer::sum
        int totalSeatingCapacity = bogies.stream()
                .map(Bogie::getCapacity) // map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        // 3. Display the total seating capacity
        System.out.println("--- Train Consist Management: UC10 ---");
        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("Total Seating Capacity: " + totalSeatingCapacity);
    }
}