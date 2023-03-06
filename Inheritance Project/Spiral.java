public class Spiral extends Galaxy{
    boolean barred;
    
    public Spiral(int distance, int age, String shape, int starCount, boolean barred){
        super(distance, age, shape, starCount);
        this.barred = barred;
    }

    public boolean isBarred() {
        return barred;
    }

    public void setBarred(boolean barred) {
        this.barred = barred;
    }
    
}
