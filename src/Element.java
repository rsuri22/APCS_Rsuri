import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

public class Element {
    int atomicNumber;
    String symbol;
    double atomicMass;
    String name;
    String type;

    public Element(int atomicNumber, String symbol, double atomicMass, String name, String type){
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.atomicMass = atomicMass;
        this.name = name;
        this.type = type;
    }
    public static double calculateMolarMass(List<Element> elements, String molecule){
        double molecularMass = 0;
        molecule += "?";
        for (int i = 0; i < molecule.length(); i++){
            char c = molecule.charAt(i);
            if (Character.isUpperCase(c)){
                boolean runLoop = true;
                int j = i;
                while (runLoop){
                    j++;
                    if (j >= molecule.indexOf("?"))
                        runLoop = false;

                    else if (Character.isUpperCase(molecule.charAt(j)))
                        runLoop = false;
                }
//                boolean hasInt = false;
//                char[] chars = molecule.substring(i, j).toCharArray();
//                for (char a: chars){
//                    if (Character.isDigit(a))
//                        hasInt = true;
//                }
                boolean nextChar = true;
                if (molecule.charAt(i + 1) == '?'){
                    nextChar = false;

                }
                 if (!nextChar || i == j - 1){
                    Element e = findBySymbol(elements, molecule.substring(i, i + 1));
                    int numOfE = 1;
                    molecularMass += e.getAtomicMass() * numOfE;
                }
                else if (Character.isDigit(molecule.charAt(i + 1)) && nextChar) {
                    Element e = findBySymbol(elements, molecule.substring(i, i + 1));
                    int numOfE = Integer.parseInt(molecule.substring(i + 1, j));
                    molecularMass += e.getAtomicMass() * numOfE;
                }

                else if (Character.isDigit(molecule.charAt(i + 2))){
                    Element e = findBySymbol(elements, molecule.substring(i, i + 2));
                    int numOfE = Integer.parseInt(molecule.substring(i + 2, j));
                    molecularMass += e.getAtomicMass() * numOfE;
                }
                else {
                    Element e = findBySymbol(elements, molecule.substring(i, i + 2));
                    int numOfE = 1;
                    molecularMass += e.getAtomicMass() * numOfE;
                 }


            }
//            if (Character.isDigit(c)) {
//                int numOfE = Character.getNumericValue(c);
//                String currentE = "";
//                if (Character.isUpperCase(molecule.charAt(i - 1))){
//                    currentE += molecule.charAt(i - 1);
//                }
//                else {
//                    currentE += molecule.substring(i - 2, i);
//                }
//                Element e = findBySymbol(elements, currentE);
//                molecularMass += e.getAtomicMass() * numOfE;
//
//            }
        }
         return molecularMass;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getAtomicMass(){
        return atomicMass;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public void setAtomicNumber(int i){
        atomicNumber = i;
    }

    public void setSymbol(String s){
        symbol = s;
    }

    public void setAtomicMass(double a){
        atomicMass = a;
    }

    public void setName(String n){
        name = n;
    }

    public void setType(String t){
        type = t;
    }

    public static Element findBySymbol(List<Element> elements, String s){
        int i = 0;
        boolean runLoop = true;
        while ((i <= elements.size() - 1) && (runLoop)) {
            Element e = elements.get(i);
            if (s.equals(e.getSymbol())){
                runLoop = false;
                break;
            }
            i++;
        }
        return elements.get(i);
    }

    public String toString(){
        return  "Element Information:\n\tName: " + name + "\n\tSymbol: " + symbol + "\n\tAtomic Number: " + atomicNumber +
                "\n\tAtomic Mass: " + atomicMass + "\n\tType: " + type;
    }


}
