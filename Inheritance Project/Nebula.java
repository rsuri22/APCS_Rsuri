public class Nebula extends Universe{
    String composition;
    String color;

    public Nebula(int distance, int size, String composition, String color){
        super(distance, size);
        this.composition = composition;
        this.color = color;

    }
    
    public String getComposition() {
        return composition;
    }

    public String getColor() {
        return color;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    
}
