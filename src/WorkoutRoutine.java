// Represents a workout routine in the fitness app
public class WorkoutRoutine {
    // Name of the workout routine
    private String routineName;
    // Duration of the workout in minutes
    private int durationInMinutes;
    // Total calories burned during the workout
    private int caloriesBurned;

    // Constructor to initialize the workout routine attributes
    public WorkoutRoutine(String routineName, int durationInMinutes, int caloriesBurned) {
        this.routineName = routineName; // Set the name of the routine
        this.durationInMinutes = durationInMinutes; // Set the duration in minutes
        this.caloriesBurned = caloriesBurned; // Set the calories burned
    }

    // Getter for the routine name
    public String getRoutineName() {
        return routineName; // Return the name of the routine
    }

    // Getter for the total calories burned
    public int getCaloriesBurned() {
        return caloriesBurned; // Return the calories burned during the workout
    }

    // Calculates and returns calories burned per minute
    public double getCaloriesPerMinute() {
        return (double) caloriesBurned / durationInMinutes; // Divide calories by duration
    }

    // Overrides the default toString method to display routine details
    @Override
    public String toString() {
        // Format the routine details into a readable string
        return String.format("Routine: %-20s | Duration: %3d min | Calories: %4d kcal", 
                              routineName, durationInMinutes, caloriesBurned);
    }
}
