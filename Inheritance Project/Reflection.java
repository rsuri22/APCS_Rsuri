public class Reflection extends Nebula {
    int scatterCoefficient;
    
    public Reflection(int distance, int size, String composition, String color, int scatterCoefficient){
        super(distance, size, composition, color);
        this.scatterCoefficient = scatterCoefficient;
    }

    public int getScatterCoefficient() {
        return scatterCoefficient;
    }

    public void setScatterCoefficient(int scatterCoefficient) {
        this.scatterCoefficient = scatterCoefficient;
    }
    
}
