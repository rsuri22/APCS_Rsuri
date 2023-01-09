package Activity_3_7_4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HorseBarn h = new HorseBarn();
        ArrayList<Horse> randomHorses = randomizeHorses(h);
        pairHorses(randomHorses);
//        System.out.println(randomHorses.toString());


    }

    public static ArrayList<Horse> randomizeHorses(HorseBarn h){
        int[] randNums = RandomPermutation.next(h.getSpaces().size());
        ArrayList<Horse> randomHorses = new ArrayList<Horse>();

        for (int i = 0; i < h.getSpaces().size(); i++){
            randomHorses.add(h.getSpaces().get(randNums[i]));
        }

        return randomHorses;
    }

    public static void pairHorses(ArrayList<Horse> randomHorses){
        if (randomHorses.size() % 2 == 1){ 
            System.out.println(randomHorses.get(randomHorses.size() - 1) + " is the only horse without a partner. The rest of the partners are displayed below:");
        }
        for (int i = 0; i < randomHorses.size(); i += 2) {
            if (i == randomHorses.size()-1){
                break;
            }
            System.out.println("Pair: " + randomHorses.get(i).toString() + " and " + randomHorses.get(i+1).toString());
            

        }



    }
}
