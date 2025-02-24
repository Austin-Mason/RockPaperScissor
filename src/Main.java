import java.util.Scanner;
public class Main {
    public static String validMove(Scanner scanner, String playerName) {
        String move;
        do {
            System.out.print(playerName + ", enter your move (R/P/S): ");
            move = scanner.nextLine().trim().toUpperCase();

            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println(" Invalid input. Please enter R, P, or S.");
            }
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));

        return move;
    }


    public static String moveName(String move) {
        return switch (move) {
            case "R" -> "Rock";
            case "P" -> "Paper";
            case "S" -> "Scissors";
            default -> "Invalid";
        };
    }

    // Method to determine the winner and display the result
    public static void theWinner(String moveA, String moveB) {
        System.out.println("\n Result:");
        System.out.println(moveName(moveA) + " vs " + moveName(moveB));

        if (moveA.equals(moveB)) {
            System.out.println("It's a Tie");
            return;
        }


        if ((moveA.equals("R") && moveB.equals("S")) ||
                (moveA.equals("P") && moveB.equals("R")) ||
                (moveA.equals("S") && moveB.equals("P"))) {

            System.out.println(resultPhrase(moveA, moveB) + " - Player A wins");
        } else {
            System.out.println(resultPhrase(moveB, moveA) + " - Player B wins ");
        }
    }

    // Method to return the winning phrase
    public static String resultPhrase(String winnerMove, String loserMove) {
        if (winnerMove.equals("R") && loserMove.equals("S")) return "Rock beats Scissors";
        if (winnerMove.equals("P") && loserMove.equals("R")) return "Paper covers Rock";
        if (winnerMove.equals("S") && loserMove.equals("P")) return "Scissors cuts Paper";
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        System.out.println("Rock paper scissors");

        do {
            // Get moves from both players
            String moveA = validMove(scanner, "Player A");
            String moveB = validMove(scanner, "Player B");

            // Determine and display the winner
            theWinner(moveA, moveB);

            // Prompt to play again
            System.out.print("\n Play again? (Y/N): ");
            playAgain = scanner.nextLine().trim().toUpperCase();

        } while (playAgain.equals("Y"));

        System.out.println("Game over");
        scanner.close();
    }
}



