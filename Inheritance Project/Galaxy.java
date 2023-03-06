public class Galaxy extends Universe{
    String shape;
    int starCount;
    
    public Galaxy(int distance, int size, String shape, int starCount){
        super(distance, size);
        this.shape = shape;
        this.starCount = starCount;

    }

    public String getShape() {
        return shape;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }
    
}
