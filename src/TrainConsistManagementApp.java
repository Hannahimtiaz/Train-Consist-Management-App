import java.util.ArrayList;
import java.util.List;

// Class representing a Goods Bogie
class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("==========================================\n");

        // 1. User prepares a list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // 2 & 3. Convert list to stream and use allMatch() for safety rules
        // 4. Conditional logic: Cylindrical bogies must only carry Petroleum
        boolean isSafe = goodsBogies.stream().allMatch(bogie -> {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Other bogie types have no cargo restrictions in this UC [cite: 1]
        });

        // 5 & 6. Display the result to the user [cite: 1]
        if (isSafe) {
            System.out.println("RESULT: The train is marked SAFE. All safety protocols passed.");
        } else {
            System.out.println("RESULT: The train is UNSAFE! Invalid cargo detected in cylindrical bogies.");
        }

        // 7. Program continues [cite: 1]
        System.out.println("\nValidation complete. Program continues...");
    }
}