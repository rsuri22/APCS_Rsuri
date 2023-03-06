public class Dark extends Nebula {
    String blockedObject;
    
    public Dark(int distance, int size, String composition, String color, String blockedObject){
        super(distance, size, composition, color);
        this.blockedObject = blockedObject;
    }

    public String getBlockedObject() {
        return blockedObject;
    }
    
}
