public class Emission extends Nebula {
    int temperature;
    int UVLevel;
    
    public Emission(int distance, int age, String composition, String color, int temperature, int UVLevel){
        super(distance, age, composition, color);
        this.temperature = temperature;
        this.UVLevel = UVLevel;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getUVLevel() {
        return UVLevel;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setUVLevel(int uVLevel) {
        UVLevel = uVLevel;
    }
    
}
