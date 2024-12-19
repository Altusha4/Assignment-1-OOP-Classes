import java.util.Scanner; // Import Scanner class for user input

public class FitnessApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize Scanner for input

        System.out.print("Enter your name: "); // Prompt user for their name
        String name = scanner.nextLine(); // Read the user's name

        int age = getValidIntInput(scanner, "Enter your age: "); // Prompt for and validate age
        double weight = getValidDoubleInput(scanner, "Enter your weight: "); // Prompt for and validate weight

        User user = new User(name, age, weight); // Create a User object with input data

        while (true) { // Main menu loop
            System.out.println("\nWelcome to FitnessApp!");
            System.out.println("1. Manage WorkoutRoutine"); // Menu option for managing workouts
            System.out.println("2. Manage User"); // Menu option for managing user info
            System.out.println("3. Exit"); // Exit option
            System.out.print("Choose an option: ");

            int choice = getValidIntInput(scanner, ""); // Read and validate user's menu choice

            switch (choice) {
                case 1: // Manage workout routines
                    manageWorkoutRoutine(scanner, user);
                    break;
                case 2: // Manage user information
                    manageUser(scanner, user);
                    break;
                case 3: // Exit the application
                    System.out.println("Goodbye!");
                    scanner.close(); // Close the scanner
                    return; // Exit the main method
                default: // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageWorkoutRoutine(Scanner scanner, User user) {
        while (true) { // Loop for workout routine menu
            System.out.println("\nWorkoutRoutine Menu:");
            System.out.println("1. Add Routine"); // Add a new workout routine
            System.out.println("2. Remove Routine"); // Remove an existing routine
            System.out.println("3. View All Routines"); // View all added routines
            System.out.println("4. Compare Two Routines"); // Compare two routines
            System.out.println("5. Back to Main Menu"); // Return to the main menu
            System.out.print("Choose an option: ");

            int choice = getValidIntInput(scanner, ""); // Validate menu choice

            switch (choice) {
                case 1: // Add a new routine
                    System.out.print("Enter routine name: ");
                    String routineName = scanner.nextLine(); // Read routine name
                    int duration = getValidIntInput(scanner, "Enter duration (minutes): "); // Read and validate duration
                    int calories = getValidIntInput(scanner, "Enter calories burned: "); // Read and validate calories

                    user.addRoutine(new WorkoutRoutine(routineName, duration, calories)); // Add routine to user
                    System.out.println("Routine added successfully.");
                    break;
                case 2: // Remove a routine
                    System.out.print("Enter the name of the routine to remove: ");
                    String nameToRemove = scanner.nextLine(); // Read routine name to remove
                    user.removeRoutine(nameToRemove); // Remove routine from user
                    System.out.println("Routine removed successfully.");
                    break;
                case 3: // View all routines
                    System.out.println("\nAll Routines:");
                    if (user.getRoutines().isEmpty()) { // Check if there are no routines
                        System.out.println("No routines found.");
                    } else {
                        user.getRoutines().forEach(System.out::println); // Print all routines
                    }
                    break;
                case 4: // Compare two routines
                    compareTwoRoutines(scanner, user);
                    break;
                case 5: // Return to the main menu
                    return;
                default: // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void compareTwoRoutines(Scanner scanner, User user) {
        if (user.getRoutines().size() < 2) { // Ensure there are at least two routines
            System.out.println("Not enough routines to compare. Please add more routines first.");
            return;
        }

        System.out.println("\nAvailable Routines:");
        for (int i = 0; i < user.getRoutines().size(); i++) { // Display all routines with indices
            System.out.printf("%d. %s\n", i + 1, user.getRoutines().get(i).getRoutineName());
        }

        int firstChoice = getValidIntInput(scanner, "Select the first routine (number): ") - 1; // Read first routine index
        int secondChoice = getValidIntInput(scanner, "Select the second routine (number): ") - 1; // Read second routine index

        if (firstChoice < 0 || firstChoice >= user.getRoutines().size() ||
                secondChoice < 0 || secondChoice >= user.getRoutines().size()) { // Validate indices
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        WorkoutRoutine routine1 = user.getRoutines().get(firstChoice); // Get first routine
        WorkoutRoutine routine2 = user.getRoutines().get(secondChoice); // Get second routine

        System.out.println("\nComparison:");
        System.out.printf("%s burned %.2f calories per minute.\n", routine1.getRoutineName(), routine1.getCaloriesPerMinute());
        System.out.printf("%s burned %.2f calories per minute.\n", routine2.getRoutineName(), routine2.getCaloriesPerMinute());

        if (routine1.getCaloriesBurned() > routine2.getCaloriesBurned()) {
            System.out.printf("%s burned more calories overall (%d kcal) compared to %s (%d kcal).\n",
                    routine1.getRoutineName(), routine1.getCaloriesBurned(),
                    routine2.getRoutineName(), routine2.getCaloriesBurned());
        } else if (routine1.getCaloriesBurned() < routine2.getCaloriesBurned()) {
            System.out.printf("%s burned more calories overall (%d kcal) compared to %s (%d kcal).\n",
                    routine2.getRoutineName(), routine2.getCaloriesBurned(),
                    routine1.getRoutineName(), routine1.getCaloriesBurned());
        } else {
            System.out.println("Both routines burned the same amount of calories.");
        }
    }

    private static void manageUser(Scanner scanner, User user) {
        while (true) { // Loop for user management menu
            System.out.println("\nUser Menu:");
            System.out.println("1. View User Info"); // View user details
            System.out.println("2. Update User Info"); // Update user details
            System.out.println("3. Back to Main Menu"); // Return to main menu
            System.out.print("Choose an option: ");

            int choice = getValidIntInput(scanner, ""); // Validate menu choice

            switch (choice) {
                case 1: // Display user details
                    System.out.println(user);
                    break;
                case 2: // Update user details
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine(); // Read new name
                    int newAge = getValidIntInput(scanner, "Enter new age: "); // Read and validate new age
                    double newWeight = getValidDoubleInput(scanner, "Enter new weight: "); // Read and validate new weight

                    user.setName(newName); // Update name
                    user.setAge(newAge); // Update age
                    user.setWeight(newWeight); // Update weight

                    System.out.println("User info updated successfully.");
                    break;
                case 3: // Return to main menu
                    return;
                default: // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getValidIntInput(Scanner scanner, String prompt) {
        int value;
        while (true) { // Loop until valid input is entered
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                value = Integer.parseInt(input); // Try to parse integer
                return value; // Return valid integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer."); // Handle invalid input
            }
        }
    }

    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        double value;
        while (true) { // Loop until valid input is entered
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                value = Double.parseDouble(input); // Try to parse double
                return value; // Return valid double
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number."); // Handle invalid input
            }
        }
    }
}
