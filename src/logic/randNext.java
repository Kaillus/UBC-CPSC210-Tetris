package logic;

//import model.Square;

import java.util.ArrayList;
import java.util.Random;




public class randNext {

    static ArrayList<String> bag = new ArrayList<String>();
    static {
        bag.add("L");
        bag.add("J");
        bag.add("T");
        bag.add("I");
        bag.add("O");
        bag.add("Z");
        bag.add("S");
    }
    //TODO: figure out why i have to static everything

    private int min = 0;
    private int max = 6;

    public static String selectNext() {
        Random random = new Random();
        int randomNum = random.nextInt(6);
        return bag.get(randomNum);
    }
}