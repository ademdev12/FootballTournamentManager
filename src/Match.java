import java.util.Date;

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private Date date;
    private String stadium;

    public Match(Team homeTeam, Team awayTeam, Date date, String stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.stadium = stadium;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    public void recordResult(int homeTeamScore, int awayTeamScore) {
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public String getWinner() {
        if (homeTeamScore > awayTeamScore) {
            return homeTeam.getName();
        } else if (awayTeamScore > homeTeamScore) {
            return awayTeam.getName();
        } else {
            return "Draw";
        }
    }

    public void displayMatchDetails() {
        System.out.println("Match between " + homeTeam.getName() + " and " + awayTeam.getName());
        System.out.println("Date: " + date);
        System.out.println("Stadium: " + stadium);
        System.out.println("Winner: " + getWinner());
        
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

}
