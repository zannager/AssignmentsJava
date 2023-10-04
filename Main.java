import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Athlete> athletes = new ArrayList<>();
        ArrayList<TrainingPlan> trainingPlans = new ArrayList<>();

        //Initialize training plans
        trainingPlans.add(new TrainingPlan("Beginner", 2, 25.00));
        trainingPlans.add(new TrainingPlan("Intermediate", 3, 30.00));
        trainingPlans.add(new TrainingPlan("Elite", 5, 35.00));

        Scanner scanner = new Scanner((System.in));

        //Initialize number of athletes
        int numOfAthletes = 6;

        //Input data for each athlete
        for (int i = 1; i <= numOfAthletes; i++) {
            System.out.println("Enter Athlete " + i + ":");
            System.out.println("Name: ");

            String name = scanner.nextLine();

            System.out.print("Training Plan (Beginner, Intermediate, Elite): ");

            String trainingPlan = scanner.nextLine();

            TrainingPlan selectedTrainingPlan = null;

            for (TrainingPlan plan : trainingPlans) {
                if (plan.getName().equals(trainingPlan)) {
                    selectedTrainingPlan = plan;
                    break;
                }
            }
            if (selectedTrainingPlan == null) {
                System.out.println("Invalid training plan, please enter a valid plan");
                i++;
                continue;
            }
            System.out.print("Current Weight (Kg): ");
            double currentWeight = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Competition Weight Category: ");
            String competitionWeightCategory = scanner.nextLine();

            System.out.print("Number of Competitions Entered this Month: ");
            int competitionsEntered = scanner.nextInt();

            if (selectedTrainingPlan.getName().equals("Intermediate") && competitionsEntered <= 0) {
                System.out.println("Intermediate athletes must enter at least one competition.");
                i--;
                continue;
            } else if (selectedTrainingPlan.getName().equals("Elite") && competitionsEntered <= 0) {
                System.out.println("Elite athletes must enter at least one competition.");
                i--;
                continue;
            }
            int privateCoachingHours = 0;
            if (selectedTrainingPlan.getName().equals("Intermediate") || selectedTrainingPlan.getName().equals("Elite")) {
                System.out.println("Number of hours of private coaching (max 5 hours/week");
                privateCoachingHours = scanner.nextInt();
                if (privateCoachingHours > 5) {
                    System.out.println("Max hours exceeded");
                    privateCoachingHours = 5;
                }
            }
            athletes.add(new Athlete(name, trainingPlan, currentWeight, competitionWeightCategory,
                    competitionsEntered, privateCoachingHours));
        }
        for (Athlete athlete : athletes) {
            System.out.println("\nAthlete: " + athlete.getName());
            System.out.println("Training plan: " + athlete.getTrainingPlan());

            double trainingCost = athlete.getNumCompetitions() * 22.00;
            double coachingCost = athlete.getHoursPrivateCoaching() * 9.00;
            double totalCost = trainingCost + coachingCost;

            System.out.println("Training and competition costs: $" + String.format("%.2f", trainingCost));
            System.out.println("Private coaching cost: $" + String.format("%.2f", coachingCost));
            System.out.println("Total cost for the month: $" + String.format("%.2f", totalCost));

            String weightCategory = athlete.getCompetitionWeightCategory();
            double upperWeightLimit = 0;

            if (weightCategory.equals("Heavyweight")) {
                upperWeightLimit = 1000;
            } else if (weightCategory.equals("Light heavyweight")) {
                upperWeightLimit = 100;
            } else if (weightCategory.equals("Middleweight")) {
                upperWeightLimit = 90;
            } else if (weightCategory.equals("Light middleweight")) {
                upperWeightLimit = 81;
            } else if (weightCategory.equals("Lightweight")) {
                upperWeightLimit = 73;
            } else if (weightCategory.equals("Flyweight")) {
                upperWeightLimit = 66;
            }

            if (athlete.getCurrentWeight() > upperWeightLimit) {
                System.out.println("Weight exceeds the competition weight category");
            } else {
                System.out.println("Weight is within the competition weight category.");
            }

        }
        scanner.close();
    }
}
