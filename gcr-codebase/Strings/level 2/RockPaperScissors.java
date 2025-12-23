import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        String[][] gameResults = new String[games][4];

        for (int i = 0; i < games; i++) {

            System.out.println("\nGame " + (i + 1));
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.next().toLowerCase();

            String computerChoice = getComputerChoice();

            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            gameResults[i][0] = String.valueOf(i + 1);
            gameResults[i][1] = userChoice;
            gameResults[i][2] = computerChoice;
            gameResults[i][3] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, games);

        displayResults(gameResults, stats);
    }

    // Method to get computer choice using Math.random()
    public static String getComputerChoice() {

        int choice = (int) (Math.random() * 3);

        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    // Method to find winner
    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    // Method to calculate average & percentage
    public static String[][] calculateStats(int userWins, int computerWins, int draws, int games) {

        String[][] stats = new String[3][3];

        double userPercent = (userWins * 100.0) / games;
        double computerPercent = (computerWins * 100.0) / games;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent) + "%";

        stats[2][0] = "Draw";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = "-";

        return stats;
    }

    // Method to display results
    public static void displayResults(String[][] games, String[][] stats) {

        System.out.println("\nGame Results");
        System.out.println("------------------------------------------------");
        System.out.println("Game\tUser\tComputer\tWinner");

        for (int i = 0; i < games.length; i++) {
            System.out.println(
                games[i][0] + "\t" +
                games[i][1] + "\t" +
                games[i][2] + "\t\t" +
                games[i][3]
            );
        }

        System.out.println("\nFinal Statistics");
        System.out.println("--------------------------------");
        System.out.println("Player\tWins\tWin %");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(
                stats[i][0] + "\t" +
                stats[i][1] + "\t" +
                stats[i][2]
            );
        }
    }
}