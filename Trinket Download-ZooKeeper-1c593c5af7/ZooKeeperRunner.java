import java.util.ArrayList;
/*
 * Activity 4.9.2
 */
public class ZooKeeperRunner
{
  public static void main(String[] args)
  { 
    ArrayList<Animal> zoo = new ArrayList<Animal>();

    Animal g = new Giraffe();
    Animal d = new Deer();
    Animal gr = new Gorilla();
    Animal h = new Hippo();
    Animal m = new Monkey();

    zoo.add(g);
    zoo.add(d);
    zoo.add(gr);
    zoo.add(h);
    zoo.add(m);

    speakAll(zoo);
    
       
  }

  public static void speakAll(ArrayList<Animal> zoo){
    for (Animal a: zoo){
      a.speak();
    }

  }
}