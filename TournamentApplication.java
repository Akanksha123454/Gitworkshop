import java.util.Scanner;

class Player {
    String name;
    int runs;

    Player(String name) {
        this.name = name;
        this.runs = 0;
    }
}

class Team {
    String name;
    Player[] players;
    int playerCount;

    Team(String name) {
        this.name = name;
        this.players = new Player[11]; // Maximum 11 players per team
        this.playerCount = 0;
    }

    void addPlayer(String playerName) {
        if (playerCount < 11) {
            players[playerCount++] = new Player(playerName);
        } else {
            System.out.println("Team already has 11 players.");
        }
    }
}

class Match {
    Team team1, team2;
    int overs;
    int[] teamRuns;

    Match(Team team1, Team team2, int overs) {
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
        this.teamRuns = new int[2];
    }

    void updateRuns(int teamIndex, int runs) {
        teamRuns[teamIndex] += runs;
    }

    Team getWinner() {
        return teamRuns[0] > teamRuns[1] ? team1 : team2;
    }
}

public class TournamentApplication {
    static Team[] teams = new Team[10]; // Maximum 10 teams
    static Match[] matches = new Match[10]; // Maximum 10 matches
    static int teamCount = 0, matchCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTournament Menu:");
            System.out.println("1. Add New Team");
            System.out.println("2. Add Players in Team");
            System.out.println("3. Create Match");
            System.out.println("4. Allocate Team to Match");
            System.out.println("5. View All Teams");
            System.out.println("6. Show Team-wise Player List");
            System.out.println("7. Show Player-wise Runs");
            System.out.println("8. Team-wise Player Run Aggregate");
            System.out.println("9. Decide the Winner");
            System.out.println("10. Show Over Count Played by Team");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addNewTeam();
                    break;
                case 2:
                    addPlayersToTeam();
                    break;
                case 3:
                    createMatch();
                    break;
                case 4:
                    allocateTeamsToMatch();
                    break;
                case 5:
                    viewAllTeams();
                    break;
                case 6:
                    showTeamWisePlayerList();
                    break;
                case 7:
                    showPlayerWiseRuns();
                    break;
                case 8:
                    teamWiseRunAggregate();
                    break;
                case 9:
                    decideWinner();
                    break;
                case 10:
                    showOverCountPlayed();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addNewTeam() {
        if (teamCount < 10) {
            System.out.print("Enter team name: ");
            String name = sc.nextLine();
            teams[teamCount++] = new Team(name);
            System.out.println("Team added successfully.");
        } else {
            System.out.println("Maximum team limit reached.");
        }
    }

    static void addPlayersToTeam() {
        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();
        for (int i = 0; i < teamCount; i++) {
            if (teams[i].name.equals(teamName)) {
                System.out.print("Enter player name: ");
                String playerName = sc.nextLine();
                teams[i].addPlayer(playerName);
                return;
            }
        }
        System.out.println("Team not found.");
    }

    static void createMatch() {
        if (teamCount < 2) {
            System.out.println("Not enough teams to create a match.");
            return;
        }
        System.out.print("Enter overs: ");
        int overs = sc.nextInt();
        sc.nextLine();
        System.out.println("Match created with " + overs + " overs.");
    }

    static void allocateTeamsToMatch() {
        if (teamCount < 2) {
            System.out.println("Not enough teams to allocate.");
            return;
        }
        System.out.print("Enter first team name: ");
        String team1Name = sc.nextLine();
        System.out.print("Enter second team name: ");
        String team2Name = sc.nextLine();
        Team team1 = null, team2 = null;
        for (int i = 0; i < teamCount; i++) {
            if (teams[i].name.equals(team1Name)) team1 = teams[i];
            if (teams[i].name.equals(team2Name)) team2 = teams[i];
        }
        if (team1 != null && team2 != null && matchCount < 10) {
            matches[matchCount++] = new Match(team1, team2, 10);
            System.out.println("Match allocated successfully.");
        } else {
            System.out.println("Invalid team names or match limit reached.");
        }
    }

    static void viewAllTeams() {
        for (int i = 0; i < teamCount; i++) {
            System.out.println("Team: " + teams[i].name);
        }
    }

    static void showTeamWisePlayerList() {
        for (int i = 0; i < teamCount; i++) {
            System.out.println("Team: " + teams[i].name);
            for (int j = 0; j < teams[i].playerCount; j++) {
                System.out.println(" - " + teams[i].players[j].name);
            }
        }
    }

    static void showPlayerWiseRuns() {
        for (int i = 0; i < teamCount; i++) {
            for (int j = 0; j < teams[i].playerCount; j++) {
                System.out.println(teams[i].players[j].name + " - Runs: " + teams[i].players[j].runs);
            }
        }
    }

    static void teamWiseRunAggregate() {
        for (int i = 0; i < matchCount; i++) {
            System.out.println(matches[i].team1.name + " vs " + matches[i].team2.name);
        }
    }

    static void decideWinner() {
        for (int i = 0; i < matchCount; i++) {
            System.out.println("Winner: " + matches[i].getWinner().name);
        }
    }

    static void showOverCountPlayed() {
        for (int i = 0; i < matchCount; i++) {
            System.out.println("Match: " + matches[i].team1.name + " vs " + matches[i].team2.name + ", Overs: " + matches[i].overs);
        }
    }
}
