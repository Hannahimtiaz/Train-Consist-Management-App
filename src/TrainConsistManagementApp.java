import java.util.HashMap;
import java.util.Map;

/**
 * UC6: Map Bogie to Capacity (HashMap)
 * This class associates each bogie with its seating or load capacity
 * using a key-value mapping structure.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("==================================================");

        // 1. Create a HashMap for bogie-capacity mapping
        // Key: Bogie Name (String), Value: Capacity (Integer)
        Map<String, Integer> capacityMap = new HashMap<>();

        // 2. Insert capacity values for each bogie using the put() method
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair Car", 78);
        capacityMap.put("First Class", 24);
        capacityMap.put("General", 90);
        capacityMap.put("Luggage", 10);

        // 3. Iterate through map entries using entrySet()
        System.out.println("Bogie-Capacity Mapping Details:");
        System.out.println("--------------------------------------------------");

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            // 4. Display bogie and capacity information [cite: 1]
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total types of bogies mapped: " + capacityMap.size());
        System.out.println("==================================================");
    }
}