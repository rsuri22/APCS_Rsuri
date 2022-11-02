import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Element> elements = CSVReader.readElement("/workspace/APCS_Rsuri/periodicdata2.csv");
        chemHelper(elements);
    }

    public static void chemHelper(List<Element> elements){
        Scanner sc = new Scanner(System.in);
        boolean runLoop = true;
        while (runLoop){
            boolean keepGoing = true;
            System.out.println("What do you need help with? (STOP to end)\n\t1: Information about an element\n\t2: Molar Mass Calculation\n\t3: Structure Determination");
            String ans = sc.nextLine();
            if (ans.equals("1")){
                while (keepGoing) {
                    System.out.println("What element would you like information for? Enter atomic symbol please (type b to go back): ");
                    String symbol = sc.nextLine();
                    if (symbol.equals("b") || symbol.equals(("stop")))
                        keepGoing = false;
                    else {
                        System.out.println(Element.findBySymbol(elements, symbol));
                    }
                    System.out.println("Thanks for using my element finder!");
                }
            }

            else if (ans.equals("2")) {
                while (keepGoing) {
                    System.out.println("What molecule would you like to find the molar mass of? Type b to go back.");
                    String userInput = sc.nextLine();
                    if (userInput.equals("b") || userInput.equals("stop"))
                        keepGoing = false;
                    else {
                        System.out.println(Element.calculateMolarMass(elements, userInput));
                    }
                }
                System.out.println("Thanks for using my molar mass calculator!");
            }
            else if (ans.equals("3")) {
                while (keepGoing) {
                    System.out.println("What molecule would you like to find the structure of? Type b to go back.");
                    String userInput = sc.nextLine();
                    if (userInput.equals("b") || userInput.equals("stop"))
                        keepGoing = false;
                    else {
                        System.out.println("Structure: " + Element.structureDetermination(elements, userInput));
                    }
                }
                System.out.println("Thanks for using my structure determinator!");
            }

            else {
                System.out.println("Goodbye!");
                runLoop = false;
            }
        }
    sc.close();
    }

}