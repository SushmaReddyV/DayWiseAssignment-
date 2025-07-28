import java.util.*;
public class LeaderboardSystem {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 100));
        players.add(new Player("Bob", 150));
        players.add(new Player("Charlie", 120));

        players.sort((a, b) -> b.score - a.score);

        System.out.println("Leaderboard (High to Low):");
        for (Player p : players) {
            System.out.println(p);
        }

        // Search for a specific player's rank
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player name to find rank: ");
        String target = sc.nextLine();

        int rank = 1;
        for (Player p : players) {
            if (p.name.equalsIgnoreCase(target)) {
                System.out.println(p.name + " is ranked #" + rank);
                return;
            }
            rank++;
        }

        System.out.println("Player not found.");
    }
}
