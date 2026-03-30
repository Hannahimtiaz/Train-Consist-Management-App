import java.util.*;
import java.util.stream.Collectors;

// Helper class representing a Bogie
class Bogie {
    private String name;
    private String type; // e.g., Passenger, Goods
    private int capacity;

    public Bogie(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Bogie{name='%s', type='%s', capacity=%d}", name, type, capacity);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. User creates a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("Sleeper", "Passenger", 72));
        bogies.add(new Bogie("AC Chair", "Passenger", 40));
        bogies.add(new Bogie("First Class", "Passenger", 24));
        bogies.add(new Bogie("Rectangular", "Goods", 100));
        bogies.add(new Bogie("Cylindrical", "Goods", 80));

        System.out.println("--- Original Flat List of Bogies ---");
        bogies.forEach(System.out::println);

        // 2. System converts the list into a stream
        // 3. groupingBy() collector is applied
        // 4. Bogies are grouped into a Map where the key is the Bogie Name [cite: 1]
        Map<String, List<Bogie>> groupedByName = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 5. Grouped result is displayed [cite: 1]
        System.out.println("\n--- Grouped Bogies (By Name/Category) ---");
        groupedByName.forEach((name, bogieList) -> {
            System.out.println("Category: " + name + " | Count: " + bogieList.size());
            bogieList.forEach(b -> System.out.println("  - " + b));
        });

        // Additional Example: Grouping by Broad Type (Passenger vs Goods) [cite: 1]
        Map<String, List<Bogie>> groupedByType = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("\n--- Grouped Bogies (By Type: Passenger vs Goods) ---");
        groupedByType.forEach((type, list) -> {
            System.out.println("Type: " + type + " (" + list.size() + " bogies)");
        });

        // 6. Program continues [cite: 1]
    }
}