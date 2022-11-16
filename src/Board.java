import java.util.Scanner;
import java.io.File;

public class Board {
public static String guessedChars = "";
public String loadPhrase() {
    String tempPhrase = "";
    
    int numOfLines = 0;
    tempPhrase = "how are you";
    
    try {
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/APCS_Rsuri/src/phrases.txt"));
      while (sc.hasNextLine()){
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } 
    catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try {
      int count = 0;
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/APCS_Rsuri/src/phrases.txt"));
      while (sc.hasNextLine()) {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt) {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    return tempPhrase;

  }

  public void runGame(String phrase, Player player1, Player player2){
    Scanner sc = new Scanner(System.in);

    String guessedString = "";
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.substring(i, i + 1).equals(" ")){
        guessedString += " ";
      }
      else {
        guessedString += "_";
      }
    }
    boolean game = true;
    while (game){
      checkIfWin(player1, player2, phrase, guessedString);
      System.out.println(guessedString);
      guessedString = playerTurn(player1, player2, guessedString, phrase);
      System.out.println(player1.getName() + ": " + player1.getScore() + "\n" + player2.getName() + ": " + player2.getScore());
      turnWait(1500);

      checkIfWin(player1, player2, phrase, guessedString);
      System.out.println(guessedString);
      guessedString = playerTurn(player2, player1, guessedString, phrase);
      System.out.println(player1.getName() + ": " + player1.getScore() + "\n" + player2.getName() + ": " + player2.getScore());
      turnWait(1500);
    }
    sc.close();
  }

  public String playerTurn(Player playerA, Player playerB, String guessedString, String phrase){
    Scanner sc = new Scanner(System.in);
    System.out.println("It is " + playerA.getName() + "'s turn.");
    boolean correct = true;
    char correctChar = ' ';
    guessedChars += correctChar;
    while (correct){
      System.out.println("The letters already guessed are:" + guessedChars);
      System.out.println("Guess a letter: ");
      String letter = sc.nextLine().toLowerCase();
      if (guessedChars.contains(letter)){
        System.out.println("Already guessed that one. Try again!");
        continue;
      }
      else if (letter.length() > 1) {
        System.out.println("Hmmmm. Yucky input. Try again!");
        continue;
      }
      guessedChars += letter;
      for (int j = 0; j < phrase.length(); j++) {
        correct = false;
        if (phrase.substring(j, j+1).equals(letter)) {
          correctChar = phrase.charAt(j);
          guessedString = addGuess(phrase, guessedString, correctChar);
          System.out.println("Correct! Revealed phrase:\n" + guessedString);
          playerA.setScore(playerA.getScore() + 1);
          correct = true;
          checkIfWin(playerA, playerB, phrase, guessedString);
          break;
        }
      }  
    }
    System.out.println("Sorry, that is incorrect.");
    return guessedString;  
  }

  public static String addGuess(String phrase, String guessedString, char guessedLetter){
    String editedString = "";
    for (int i = 0; i < phrase.length(); i++){
      if (guessedLetter == phrase.charAt(i)){
        editedString += phrase.charAt(i);
      }
      else {
        editedString += guessedString.charAt(i);
      }
    }
    guessedString = editedString;
    return guessedString;
  }

  public static void checkIfWin(Player player1, Player player2, String phrase, String guessedString){
    if (phrase.equals(guessedString)){
      System.out.println("The game is over! Here are the scores:\n\t" + player1.getName() + ": " + player1.getScore()
      + "\n\t" + player2.getName() + ": " + player2.getScore());
      System.exit(0);

    }
  }

  public static void turnWait(int waitTime){
    try {
      Thread.sleep(waitTime);   
    }
    catch(InterruptedException ex) {
        ex.printStackTrace();
    }
    System.out.println("\033[H\033[2J");

  }

}