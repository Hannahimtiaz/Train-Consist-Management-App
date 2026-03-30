import java.util.LinkedList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("=======================================\n");

        // Create a LinkedList
        List<String> trainConsist = new LinkedList<>();

        // Add bogies in sequence
        trainConsist.add("BG101");
        trainConsist.add("BG102");
        trainConsist.add("BG103");

        // Insert bogie at specific position
        trainConsist.add(1, "BG104"); // inserted at index 1

        // Remove bogies
        trainConsist.remove(0); // remove first bogie
        trainConsist.remove(trainConsist.size() - 1); // remove last bogie

        // Display updated train consist
        System.out.println("Updated Train Consist:");
        for (String bogie : trainConsist) {
            System.out.println(bogie);
        }
    }
}