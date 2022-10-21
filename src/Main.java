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
        System.out.println("What molecule would you like to find the molar mass of?");
        String molecule = sc.nextLine();
        System.out.println(Element.calculateMolarMass(elements, molecule));
//        System.out.println("What element's information would you like? Enter atomic symbol: ");
//        String symbol = sc.nextLine();
//        System.out.println(Element.findBySymbol(elements, symbol));

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