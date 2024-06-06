import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;
    private int ranking;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.ranking = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void displayPlayers() {
        System.out.println("Players of team " + name + ":");
        for (Player player : players) {
            System.out.println("- " + player.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
