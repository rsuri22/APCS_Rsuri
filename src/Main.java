import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("\033[H\033[2J");
      System.out.println("What is the name of Player 1?");
      String player1Name = sc.nextLine();
      System.out.println("What is the name of Player 2?");
      String player2Name = sc.nextLine();
      System.out.println("\033[H\033[2J");
      Board b = new Board();
      Player player1 = new Player(player1Name, 0);
      Player player2 = new Player(player2Name, 0);
      b.runGame(b.loadPhrase(), player1, player2);
      sc.close();
    }

}