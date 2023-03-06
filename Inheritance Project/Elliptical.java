public class Elliptical extends Galaxy {
    int age;
    int diameter;
    
    public Elliptical(int distance, int size, String shape, int starCount, int diameter, int age){
        super(distance, size, shape, starCount);
        this.age = age;
        this.diameter = diameter;
    }

    public int getAge() {
        return age;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
    
}
