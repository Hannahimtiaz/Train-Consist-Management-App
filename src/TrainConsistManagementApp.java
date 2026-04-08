import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Accept input for Train ID
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        // 2. Accept input for Cargo Code
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // --- DEFINE REGEX RULES ---
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        System.out.println("\n--- Validation Results ---");

        // 3. Validate Train ID
        validateInput("Train ID", trainId, trainIdRegex);

        // 4. Validate Cargo Code
        validateInput("Cargo Code", cargoCode, cargoCodeRegex);

        scanner.close();
    }

    /**
     * Helper method to compile regex and match against input
     */
    private static void validateInput(String fieldName, String input, String regex) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(input);

        // Check if the entire input matches the pattern
        if (matcher.matches()) {
            System.out.println("✔ " + fieldName + " '" + input + "' is valid.");
        } else {
            System.out.println("❌ " + fieldName + " '" + input + "' is invalid.");
            System.out.println("   (Requirement: Entire string must match the pattern exactly)");
        }
    }
}