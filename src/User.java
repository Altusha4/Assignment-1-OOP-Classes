import java.util.ArrayList;
import java.util.List;

// Represents a user in the fitness app
public class User {
    // User's name
    private String name;
    // User's age
    private int age;
    // User's weight in kilograms
    private double weight;
    // List of workout routines associated with the user
    private List<WorkoutRoutine> routines;

    // Constructor to initialize the user's attributes
    public User(String name, int age, double weight) {
        this.name = name; // Set user's name
        this.age = age; // Set user's age
        this.weight = weight; // Set user's weight
        this.routines = new ArrayList<>(); // Initialize an empty list of routines
    }

    // Setter for name
    public void setName(String name) {
        this.name = name; // Update the user's name
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age; // Update the user's age
    }

    // Setter for weight
    public void setWeight(double weight) {
        this.weight = weight; // Update the user's weight
    }

    // Getter for routines
    public List<WorkoutRoutine> getRoutines() {
        return routines; // Return the list of workout routines
    }

    // Adds a workout routine to the user's list
    public void addRoutine(WorkoutRoutine routine) {
        routines.add(routine); // Add the routine to the list
    }

    // Removes a workout routine from the user's list by name
    public void removeRoutine(String routineName) {
        // Remove routine if its name matches the provided name (case-insensitive)
        routines.removeIf(r -> r.getRoutineName().equalsIgnoreCase(routineName));
    }

    // Overrides the default toString method to return user details
    @Override
    public String toString() {
        // Format the user's information as a readable string
        return String.format("User Info:\nName: %s | Age: %2d | Weight: %.2f kg", name, age, weight);
    }
}
