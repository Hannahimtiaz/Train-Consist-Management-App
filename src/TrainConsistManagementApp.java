import java.util.ArrayList;
import java.util.List;


public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Display Welcome banner
        System.out.println("====================================");
        System.out.println("     Train Consist Management App   ");
        System.out.println("====================================\n");

        // Create a dynamic list to store train bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initial consist information
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // Print current state of the train
        System.out.println("Current train consist: " + trainConsist);
    }
}
