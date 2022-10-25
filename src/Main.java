import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Element> elements = CSVReader.readElement("/Users/rohansuri/Downloads/periodicdata.csv");
        System.out.println("What do you need help with?\n\t1: Information about an element\n\t2: Molar Mass Calculation ");
        String ans = sc.nextLine();
        boolean keepGoing = true;
        if (ans.equals("1")){
            while (keepGoing) {
                System.out.println("What element would you like information for? Enter atomic symbol please (type STOP to end): ");
                String symbol = sc.nextLine();
                if (symbol.equals("STOP") || symbol.equals(("stop")))
                    keepGoing = false;
                else {
                    System.out.println(Element.findBySymbol(elements, symbol));
                }
                System.out.println("Thanks for using my element finder!");
            }
        }

        else if (ans.equals("2")) {
            while (keepGoing) {
                System.out.println("What molecule would you like to find the molar mass of? Type STOP to end.");
                String userInput = sc.nextLine();
                if (userInput.equals("STOP") || userInput.equals("stop"))
                    keepGoing = false;
                else {
                    System.out.println(Element.calculateMolarMass(elements, userInput));
                }
            }
            System.out.println("Thanks for using my molar mass calculator!");
        }

        else
            System.out.println("Sorry, wrong answer. Goodbye!");

        sc.close();

    }





}