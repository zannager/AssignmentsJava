package Perfection;

import java.util.Scanner;
import java.util.ArrayList;

public class Athlete extends TrainingPlan{

    private String name;
    private String trainingPlan;
    private double currentWeight;
    private String competitionWeightCategory;
    private int numCompetitions;
    private int hoursPrivateCoaching;


    public void GetAthleteDetails() {
        Scanner myInput = new Scanner(System.in);

        System.out.println("Enter athlete's name: ");
        name = myInput.nextLine();

// gives error when training plan is not on the list
        while(true) {
            System.out.println("Enter your Training Plan: \n -Beginner \n -Intermediate \n -Elite ");
            trainingPlan = myInput.nextLine();

            // Check if the athlete is Intermediate or Elite to allow competition entry
            if (trainingPlan.equalsIgnoreCase("Intermediate") || trainingPlan.equalsIgnoreCase("Elite")) {
                System.out.println("Number of competitions entered this month: ");
                numCompetitions = myInput.nextInt();
            } else if (trainingPlan.equalsIgnoreCase("Beginner")) {
                numCompetitions = 0; // Set numCompetitions to 0 for other plans
                System.out.println("Beginners are not yet allowed to enter competitions.");
            } else {
                System.out.println("Unknown plan. Please choose from: Beginner, Intermediate, Elite");
                continue; // Prompt the user to enter the correct plan
            }
            break; // Valid input, exit the loop
        }

// Validate and read the current weight
        while (true) {
            try {
                System.out.println("What is your Current Weight? ");
                currentWeight = myInput.nextDouble();
                break; // valid input, exit the loop
            } catch (Exception e) {
                System.out.println("Invalid input for weight. Please enter a valid number.");
                myInput.nextLine();
            }
        }


// Automatically recommend the weight category based on currentWeight
        competitionWeightCategory = TrainingPlan.recommendWeightCategory(currentWeight);

        System.out.println("Your Competition Weight Category is: " + competitionWeightCategory);

//Input validation for private coaching hours
        do {
            System.out.println("Number of private coaching hours per week (maximum 5 hours): ");
            hoursPrivateCoaching = myInput.nextInt();
            if (hoursPrivateCoaching >= 0 && hoursPrivateCoaching <= 5) {
                break; // Valid input, exit the loop
            } else {
                System.out.println("Invalid number of private coaching hours. Please enter a value between 0 and 5.");
            }
        } while (true);


    }
// to call the monthly training total from TrainingPlan class
    public long monthlyTrainingCost() {
        return MonthlyTrainingTotal(trainingPlan);
    }
/*to call the private tuition cost from the TrainingPlan */
    public double privateTuitionCost() {
        return PrivateTuitionCost(hoursPrivateCoaching);
    }
 /*to call the competition entry cost from the TrainingPlan */
    public double competitionEntryCost(){
        return CompetitionEntryCost(numCompetitions);
    }

    public String getName() {
        return name;
    }
    public String getTrainingPlan() {
        return trainingPlan;
    }
    public String getCompetitionWeightCategory() {
        return competitionWeightCategory;
    }
    public double getTotalCost() {
        return monthlyTrainingCost() + privateTuitionCost() + competitionEntryCost();
    }
    public int getHoursPrivateCoaching() {
        return  hoursPrivateCoaching;
    }
    public int getNumCompetitions() {
        return numCompetitions;
    }

    public void DisplayAthleteDetails() {


        System.out.println("Athlete Name: " + name);
        System.out.println("Itemized list of all costs for the month:");

        // Format the costs to two decimal places
        String formattedTrainingCost = String.format("$%.2f",(double) monthlyTrainingCost());
        String formattedTuitionCost = String.format("$%.2f", privateTuitionCost());
        String formattedEntryCost = String.format("$%.2f", competitionEntryCost());


        System.out.println(" - Monthly Training Total Cost: " + formattedTrainingCost);
        System.out.println(" - Monthly Private Tuition Cost: " + formattedTuitionCost);
        System.out.println(" - Monthly Competition Entry Cost: " + formattedEntryCost);

        /*to calculate total cost for the month, create a variable for totalCost*/
        double totalCost = monthlyTrainingCost() + privateTuitionCost() + competitionEntryCost();
        String formattedTotalCost = String.format("$%.2f", totalCost);
        formattedTotalCost = String.format("$%.2f", totalCost);

        System.out.println("Total cost of training and competitions for the month: " + formattedTotalCost);
        System.out.println();
        System.out.println("Training Plan: " + trainingPlan);
        System.out.println("Weight: " + currentWeight);
        System.out.println("Weight Category: " + competitionWeightCategory);
        System.out.println("Number of competitions entered this month: " + numCompetitions);
        System.out.println("Number of private coaching hours: " + hoursPrivateCoaching);
        System.out.println();


    }



}
