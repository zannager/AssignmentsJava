public class TrainingPlan {

    private  String name;
    private int sessionsPerWeek;
    private double weeklyFee;

    public TrainingPlan(String name, int sessionsPerWeek, double weeklyFee) {
        this.name = name;
        this.sessionsPerWeek = sessionsPerWeek;
        this.weeklyFee = weeklyFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSessionsPerWeek() {
        return sessionsPerWeek;
    }

    public void setSessionsPerWeek(int sessionsPerWeek) {
        this.sessionsPerWeek = sessionsPerWeek;
    }

    public double getWeeklyFee() {
        return weeklyFee;
    }

    public void setWeeklyFee(double weeklyFee) {
        this.weeklyFee = weeklyFee;
    }


}
