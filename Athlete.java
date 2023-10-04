public class Athlete {
    // Create constructor from here
    private String name;
    private String trainingPlan;
    private double currentWeight;
    private String competitionWeightCategory;
    private int numCompetitions;
    private int hoursPrivateCoaching;

    //Output after creating constructor
    public Athlete(String name, String trainingPlan, double currentWeight, String competitionWeightCategory, int numCompetitions, int hoursPrivateCoaching) {
        //Create your getters and setters
        this.name = name;
        this.trainingPlan = trainingPlan;
        this.currentWeight = currentWeight;
        this.competitionWeightCategory = competitionWeightCategory;
        this.numCompetitions = numCompetitions;
        this.hoursPrivateCoaching = hoursPrivateCoaching;
    }

    //Result after generating getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getCompetitionWeightCategory() {
        return competitionWeightCategory;
    }

    public void setCompetitionWeightCategory(String competitionWeightCategory) {
        this.competitionWeightCategory = competitionWeightCategory;
    }

    public int getNumCompetitions() {
        return numCompetitions;
    }

    public void setNumCompetitions(int numCompetitions) {
        this.numCompetitions = numCompetitions;
    }

    public int getHoursPrivateCoaching() {
        return hoursPrivateCoaching;
    }

    public void setHoursPrivateCoaching(int hoursPrivateCoaching) {
        this.hoursPrivateCoaching = hoursPrivateCoaching;
    }



}
