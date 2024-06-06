public class Player extends AbstractPerson implements GameParticipant {
    
    private String position;
    private int goalsScored;
    private int assists;

    public Player(String name, int age, String position) {
        super(name, age);
        this.position = position;
        this.goalsScored = 0;
        this.assists = 0;
    }

    public void scoreGoal() {
        goalsScored++;
    }

    public void assist() {
        assists++;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Position: " + position);
        System.out.println("Goals Scored: " + goalsScored);
        System.out.println("Assists: " + assists);
    }
}
