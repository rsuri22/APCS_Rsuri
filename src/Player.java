public class Player {
    String name;
    int score;
    public Player(String n, int s){
        name = n;
        score = s;
   }

   public int getScore(){
    return score;
   }

   public String getName(){
    return name;
   }

   public void setScore(int s) {
    score = s;
   }
   
   public void setName(String s) {
    name = s;
   }




}
