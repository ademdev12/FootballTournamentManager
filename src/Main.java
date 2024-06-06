import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Team> teams = new ArrayList<>();
        GameParticipant arbitre = null;

        while (true) {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Créer une nouvelle équipe");
            System.out.println("2. Ajouter un joueur à une équipe");
            System.out.println("3. Créer et jouer un match");
            System.out.println("4. Afficher le classement des équipes");
            System.out.println("5. Quitter");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Entrez le nom de l'équipe :");
                    String teamName = scanner.nextLine();
                    Team team = new Team(teamName);
                    teams.add(team);
                    System.out.println("Équipe " + teamName + " créée avec succès !");
                    break;
                case 2:
                    if (teams.isEmpty()) {
                        System.out.println("Aucune équipe n'a été créée. Veuillez créer une équipe d'abord.");
                        break;
                    }
                    System.out.println("Sélectionnez l'équipe à laquelle vous souhaitez ajouter un joueur :");
                    for (int i = 0; i < teams.size(); i++) {
                        System.out.println((i + 1) + ". " + teams.get(i).getName());
                    }
                    int teamIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.println("Entrez le nom du joueur :");
                    String playerName = scanner.nextLine();
                    System.out.println("Entrez l'âge du joueur :");
                    int playerAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrez la position du joueur :");
                    String playerPosition = scanner.nextLine();
                    GameParticipant player = new Player(playerName, playerAge, playerPosition);
                    teams.get(teamIndex).addPlayer((Player) player);
                    System.out.println("Joueur " + playerName + " ajouté à l'équipe " + teams.get(teamIndex).getName() + " avec succès !");
                    break;
                case 3:
                    if (teams.size() < 2) {
                        System.out.println("Il faut au moins deux équipes pour organiser un match.");
                        break;
                    }
                    boolean teamsHaveEnoughPlayers = true;
                    for (Team t : teams) {
                        if (t.getPlayers().size() < 1) {
                            System.out.println("L'équipe " + t.getName() + " n'a pas suffisamment de joueurs pour jouer un match.");
                            teamsHaveEnoughPlayers = false;
                            break;
                        }
                    }
                    if (!teamsHaveEnoughPlayers) {
                        break;
                    }

                    System.out.println("Sélectionnez l'équipe à domicile :");
                    for (int i = 0; i < teams.size(); i++) {
                        System.out.println((i + 1) + ". " + teams.get(i).getName());
                    }
                    int homeTeamIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Sélectionnez l'équipe à l'extérieur :");
                    for (int i = 0; i < teams.size(); i++) {
                        if (i != homeTeamIndex) {
                            System.out.println((i + 1) + ". " + teams.get(i).getName());
                        }
                    }
                    int awayTeamIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Entrez la date du match (format : jour/mois/année) :");
                    String dateString = scanner.nextLine();
                    System.out.println("Entrez le nom du stade :");
                    String stadium = scanner.nextLine();
                    Date date = new Date(dateString);

                    System.out.println("Entrez le nom de l'arbitre :");
                    String arbName = scanner.nextLine();
                    System.out.println("Entrez l'âge de l'arbitre :");
                    int arbAge = scanner.nextInt();
                    System.out.println("Entrez l'expérience de l'arbitre en années :");
                    int arbExp = scanner.nextInt();
                    scanner.nextLine();
                    arbitre = new Arbitre(arbName, arbAge, arbExp);

                    Match match = new Match(teams.get(homeTeamIndex), teams.get(awayTeamIndex), date, stadium);
                    match.displayMatchDetails();
                    
                    System.out.println("Entrez le score de l'équipe à domicile :");
                    int homeTeamScore = scanner.nextInt();
                    System.out.println("Entrez le score de l'équipe à l'extérieur :");
                    int awayTeamScore = scanner.nextInt();
                    scanner.nextLine();

                    match.setHomeTeamScore(homeTeamScore);
                    match.setAwayTeamScore(awayTeamScore);
                    System.out.println("Le match s'est terminé avec le score : " + match.getHomeTeam().getName() + " " + homeTeamScore + " - " + awayTeamScore + " " + match.getAwayTeam().getName());
                    if (homeTeamScore > awayTeamScore) {
                        teams.get(homeTeamIndex).setRanking(teams.get(homeTeamIndex).getRanking() + 3);
                    } else if (homeTeamScore < awayTeamScore) {
                        teams.get(awayTeamIndex).setRanking(teams.get(awayTeamIndex).getRanking() + 3);
                    } else {
                        teams.get(homeTeamIndex).setRanking(teams.get(homeTeamIndex).getRanking() + 1);
                        teams.get(awayTeamIndex).setRanking(teams.get(awayTeamIndex).getRanking() + 1);
                    }
                    break;
                case 4:
                    if (teams.isEmpty()) {
                        System.out.println("Aucune équipe n'a été créée.");
                        break;
                    }
                    Collections.sort(teams, Comparator.comparingInt(Team::getRanking).reversed());

                    System.out.println("Classement des équipes :");
                    for (int i = 0; i < teams.size(); i++) {
                        System.out.println((i + 1) + ". " + teams.get(i).getName() + " - Points : " + teams.get(i).getRanking());
                    }
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 5.");
            }
        }
    }
}
