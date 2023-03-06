public class Irregular extends Galaxy{
    String[] interactions;
    
    public Irregular(int distance, int age, String shape, int starCount, boolean barred, String[] interactions){
        super(distance, age, shape, starCount);
        this.interactions = interactions;
    }

    public String[] getInteractions() {
        return interactions;
    }
    
}
