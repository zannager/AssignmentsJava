package Perfection;


public class TrainingPlan {
    double Beginner = 25.00;
    double Intermediate = 30.00;
    double Elite = 35.00;
    double privateTuitionPerHour = 9.00;
    double feePerCompetition = 22.00;
    int weekPerMonth = 4;

    public static String recommendWeightCategory(double currentWeight) {
        if (currentWeight > 100 ) {
            return "Heavyweight";
        } else if (currentWeight > 90) {
            return "Light-Heavyweight";
        } else if (currentWeight > 81) {
            return "Middleweight";
        } else if (currentWeight > 73) {
            return "Light-Middleweight";
        } else if (currentWeight > 66) {
            return "Lightweight";
        } else {
            return "Flyweight";
        }
    }

/*this MonthlyTrainingTotal method takes the planName as a parameter. This will calculate the monthly training cost
    based on the training plan multiply it by 4 weeks.*/
    public long MonthlyTrainingTotal(String planName) {
        double totalCost = 0.0;

        if (planName.equalsIgnoreCase("Beginner")) {
            totalCost = Beginner;
        } else if (planName.equalsIgnoreCase("Intermediate")) {
            totalCost = Intermediate;
        } else if (planName.equalsIgnoreCase("Elite")) {
            totalCost = Elite;
        } else {
            System.out.println("Unknown plan. Please choose from: Beginner, Intermediate, Elite");
            return -1;
        }

        long monthlyTrainingCost = (long) (totalCost * weekPerMonth);
        return monthlyTrainingCost;
    }

    /*another method to calculate the private tuition cost multiplied by number of hours */
    public double PrivateTuitionCost(double privateHours) {
        double maxPrivateHours = 5.0;
        if (privateHours > maxPrivateHours) {
            System.out.println("Only 5 hours of private coaching is allowed per week");
            privateHours = maxPrivateHours;
        }
        return privateHours * privateTuitionPerHour;
    }
    public double CompetitionEntryCost(int numCompetitions){
        return feePerCompetition * numCompetitions;
    }



}
