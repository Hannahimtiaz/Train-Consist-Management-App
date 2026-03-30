import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Bogie class to model passenger bogies with name and capacity
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie{Name='" + name + "', Capacity=" + capacity + "}";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a List to store passenger bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add bogies like Sleeper, AC Chair, and First Class with capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        passengerBogies.forEach(System.out::println);

        // 3. Use Comparator to sort by capacity (Ascending Order)
        // Using Comparator.comparingInt() for clean logic
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        // 4. Display sorted bogies [cite: 1]
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Optional: To identify high-capacity bogies first (Descending Order) [cite: 1]
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());
        System.out.println("\nAfter Sorting by Capacity (High to Low):");
        passengerBogies.forEach(System.out::println);
    }
}