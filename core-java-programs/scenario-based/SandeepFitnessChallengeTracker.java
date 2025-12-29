public class SandeepFitnessChallengeTracker {
    public static void main(String[] args){
        int[] pushUps = {20, 30, 0, 25, 40, 0, 35};

        int totalPushUps = 0;
        int workoutDays = 0;
        for (int count : pushUps) {
            if (count == 0) {
                continue;
            }

            totalPushUps += count;
            workoutDays++;
        }

        double average = (workoutDays > 0)
                ? (double) totalPushUps / workoutDays
                : 0;

        System.out.println("Sandeep’s Fitness Report");
        System.out.println("Total Push-ups (Active Days): " + totalPushUps);
        System.out.println("Workout Days: " + workoutDays);
        System.out.println("Average Push-ups per Workout Day: " + average);
    }
}

