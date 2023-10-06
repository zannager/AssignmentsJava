package Perfection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Athlete [] athletes = new Athlete[6]; // Create an array to store athlete objects

        int numAthletes = 0; // Keep track of the number of athletes added

/* Entries for 6 athletes*/
        for (int i = 0; i < 6; i++) {
            athletes[i] = new Athlete();
            athletes[i].GetAthleteDetails();
            athletes[i].DisplayAthleteDetails();
            numAthletes++;
/* allow user to add another athlete after 6*/
            }
        while (true) {
            System.out.println("Do you want to add another athlete? (yes/no)");
            String choice = input.nextLine().toLowerCase();
            if (!choice.equals("yes")){
                break;
            }
            if (numAthletes < athletes.length) {
                athletes[numAthletes] = new Athlete();
                athletes[numAthletes].GetAthleteDetails();
                athletes[numAthletes].DisplayAthleteDetails();
                numAthletes++;
            } else {
                System.out.println("Maximum number of athletes reached.");
                break;
            }
        }
// Display a summary of added athletes
// Display in table
        System.out.println("\nSummary of all Athletes:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-20s | %-20s | %-15s | %-10s | %-15s |\n", "Name", "Training Plan", "Category", "Private Coaching", "Competitions", "Total Cost");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < numAthletes; i++) {
            Athlete athlete = athletes[i];
            System.out.printf("| %-25s | %-20s | %-20s | $%-13.d | %-21d | %-15d |\n", athlete.getName(),
                    athlete.getTrainingPlan(), athlete.getCompetitionWeightCategory(),
                    athlete.getHoursPrivateCoaching(), athlete.getNumCompetitions(), athlete.getTotalCost());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }
}
