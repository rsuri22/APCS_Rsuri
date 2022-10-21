import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Element> elements = readElementFromCSV("/Users/rohansuri/Downloads/periodicdata.csv");
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

    private static Element createElement(String[] scrapedData){
        int atomicNumber = Integer.parseInt(scrapedData[0]);
        String symbol = scrapedData[1];
        double atomicMass = Double.parseDouble(scrapedData[2]);
        String name = scrapedData[3];
        String type = scrapedData[4];
        return new Element(atomicNumber, symbol, atomicMass, name, type);
    }

    private static List<Element> readElementFromCSV(String filename){
        List<Element> elements = new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null){
                String[] attributes = line.split(",");
                Element element = createElement(attributes);
                elements.add(element);
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return elements;
        }

}