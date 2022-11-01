import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Element {
    int atomicNumber;
    String name;
    String symbol;
    double atomicMass;
    int numberOfNeutrons;
    int numberOfProtons;
    int numberOfElectrons;
    int period;
    int group;
    String phase;
    String natural;
    String type;
    double atomicRadius;
    double electronegativity;
    double firstIonization;
    double density;
    double meltingPoint;
    double boilingPoint;
    int numberOfIsotopes;
    String discoverer;
    int numberOfValence;

    public Element(int atomicNumber, String name, String symbol, double atomicMass, int numberOfNeutrons, int numberOfProtons, int numberOfElectrons,
                   int period, int group, String phase, String natural, String type, double atomicRadius, double electronegativity, double firstIonization,
                   double density, double meltingPoint, double boilingPoint, int numberOfIsotopes, String discoverer, int numberOfValence){
        this.atomicNumber = atomicNumber;
        this.name = name;
        this.symbol = symbol;
        this.atomicMass = atomicMass;
        this.numberOfNeutrons = numberOfNeutrons;
        this.numberOfProtons = numberOfProtons;
        this.numberOfElectrons = numberOfElectrons;
        this.period = period;
        this.group = group;
        this.phase = phase;
        this.natural = natural;
        this.type = type;
        this.atomicRadius = atomicRadius;
        this.electronegativity = electronegativity;
        this.firstIonization = firstIonization;
        this.density = density;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.numberOfIsotopes = numberOfIsotopes;
        this.discoverer = discoverer;
        this.numberOfValence = numberOfValence;
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

            else if (c == '(') {
                StringBuilder segment = new StringBuilder(molecule.substring(i + 1, molecule.indexOf(')')));
                int numOfE = Integer.parseInt(molecule.substring(molecule.indexOf(')') + 1, molecule.indexOf(')') + 2));
                String seg = segment.toString();
                molecule = molecule.replaceFirst("[\\[\\]){}]", "");
                molecularMass += calculateMolarMass(elements, seg) * numOfE;
                i += segment.length();

            }
        }
         return molecularMass;
    }

    public static String structureDetermination(List<Element> elements, String molecule){
        String structure = "";
        int valenceCount = 0;
        HashMap<Element, Integer> moleculeValues = new HashMap<Element, Integer>();
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

                    else if (Character.isUpperCase(molecule.charAt(j)) || molecule.charAt(j) == ' ')
                        runLoop = false;
                }
                boolean nextChar = true;
                if (molecule.charAt(i + 1) == '?'){
                    nextChar = false;
                }
                if (!nextChar || i == j - 1){
                    Element e = findBySymbol(elements, molecule.substring(i, i + 1));
                    int numOfE = 1;
                    moleculeValues.put(e, numOfE);
                }

                else if (Character.isDigit(molecule.charAt(i + 1)) && nextChar) {
                    Element e = findBySymbol(elements, molecule.substring(i, i + 1));
                    int numOfE = Integer.parseInt(molecule.substring(i + 1, j));
                    moleculeValues.put(e, numOfE);
                }

                else if (Character.isDigit(molecule.charAt(i + 2))){
                    Element e = findBySymbol(elements, molecule.substring(i, i + 2));
                    int numOfE = Integer.parseInt(molecule.substring(i + 2, j));
                    moleculeValues.put(e, numOfE);
                }
                else {
                    Element e = findBySymbol(elements, molecule.substring(i, i + 2));
                    int numOfE = 1;
                    moleculeValues.put(e, numOfE);
                }
            }
            else if (c == '-'){
                valenceCount += Character.getNumericValue(molecule.charAt(i-1));
            }
            else if (c == '+'){
                valenceCount -= Character.getNumericValue(molecule.charAt(i-1));
            }


        }

        int numAtoms = 0;
        int numHydrogen = 0;
        Element centerAtom = findBySymbol(elements, "F");
        for (Element e : moleculeValues.keySet()){
            valenceCount += e.getNumberOfValence() * moleculeValues.get(e);
            numAtoms += moleculeValues.get(e);
            if (e.getName().equals("Hydrogen")){
                numHydrogen = moleculeValues.get(e);
                System.out.println(numHydrogen);
                continue;
            }
            else if (e.getElectronegativity() < centerAtom.getElectronegativity()){
                centerAtom = e;
            }
        }
        int numPairs = valenceCount/2;
        int nonCentralPairs = (numAtoms - numHydrogen - 1) * 4 + numHydrogen;
        int nonCentralAtoms = (numAtoms - 1);
        int lonePairs = numPairs - nonCentralPairs;
        System.out.println("The total number of pairs is " + numPairs + ", the central atom is " + centerAtom.getName() + ", the number of lone pairs is "
        + lonePairs + ", and the number of non-central atoms is " + nonCentralAtoms);
        if (nonCentralAtoms == 1){
            if (lonePairs == 0){
                structure = "Linear";
            }
            if (lonePairs == 1){
                structure = "Linear";
            }
            if (lonePairs == 2){
                structure = "Linear";
            }
            if (lonePairs == 3){
                structure = "Linear";
            }
            if (lonePairs == 4){
                structure = "Linear";
            }
            if (lonePairs == 5){
                structure = "Linear";
            }
        }
        if (nonCentralAtoms == 2){
            if (lonePairs == 0){
                structure = "Linear";
            }
            if (lonePairs == 1){
                structure = "Bent";
            }
            if (lonePairs == 2){
                structure = "Bent";
            }
            if (lonePairs == 3){
                structure = "Linear";
            }
            if (lonePairs == 4){
                structure = "Linear";
            }
        }
        if (nonCentralAtoms == 3){
            if (lonePairs == 0){
                structure = "Trigonal Planar";
            }
            if (lonePairs == 1){
                structure = "Trigonal Pyramidal";
            }
            if (lonePairs == 2){
                structure = "T-Shaped";
            }
            if (lonePairs == 3){
                structure = "T-Shaped";
            }

        }
        if (nonCentralAtoms == 4){
            if (lonePairs == 0){
                structure = "Tetrahedral";
            }
            if (lonePairs == 1){
                structure = "See-Saw";
            }
            if (lonePairs == 2){
                structure = "Square Planar";
            }

        }
        if (nonCentralAtoms == 5){
            if (lonePairs == 0){
                structure = "Trigonal Bipyramidal";
            }
            if (lonePairs == 1){
                structure = "Square Pyramidal";
            }

        }
        if (nonCentralAtoms == 6){
            if (lonePairs == 0){
                structure = "Octahedral";
            }

        }
        if (nonCentralAtoms == 7){
            if (lonePairs == 0){
                structure = "Pentagonal Bipyramidal";
            }

        }
        return structure;

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

    public double getElectronegativity(){
        return electronegativity;
    }

    public int getNumberOfValence(){
        return numberOfValence;
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
        return  "\nElement Information:\n\tName: " + name + "\n\tSymbol: " + symbol + "\n\tAtomic Number: " + atomicNumber +
                "\n\tAtomic Mass: " + atomicMass + "g/mol\n\tNumber Of Neutrons: " + numberOfNeutrons + "\n\tNumber Of Protons: " + numberOfProtons +
                "\n\tNumber Of Electrons: " + numberOfElectrons + "\n\tPeriod: " + period + "\n\tGroup: " + group + "\n\tPhase: " + phase +
                "\n\tNatural: " + natural + "\n\tType: " + type + "\n\tAtomic Radius: " + atomicRadius + "A\n\tElectronegativity: " + electronegativity +
                "\n\tFirst Ionization Energy: " + firstIonization + "eV\n\tDensity: " + density + "g/cm^3\n\tMelting Point: " + meltingPoint +
                "C\n\tBoiling Point: " + boilingPoint + "C\n\tNumber Of Isotopes: " + numberOfIsotopes + "\n\tDiscoverer: " + discoverer +
                "\n\tNumber Of Valence Electrons: " + numberOfValence;
    }


}
