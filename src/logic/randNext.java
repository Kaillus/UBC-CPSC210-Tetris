/*

Generates next pieces for use in game

 */


package logic;

import java.util.ArrayList;
import java.util.Collections;

public class randNext {

    static ArrayList<String> baseBag = new ArrayList<String>();
    static {
        baseBag.add("L");
        baseBag.add("J");
        baseBag.add("T");
        baseBag.add("I");
        baseBag.add("O");
        baseBag.add("Z");
        baseBag.add("S");
    }
    //TODO: figure out why i have to static everything here

    //TODO: figure out which is better: math generation or shuffle generation
    //^ shuffle generation probably better in order to allocate for infinite piece generation


    //random math generation

    //private int min = 0;
    //private int max = 6;

    //public static String selectNext() {
    //    Random random = new Random();
    //    int randomNum = random.nextInt(6);
    //    return bag.get(randomNum);
    //}

    //shuffle generation

    public String getRandom() {
        Collections.shuffle(baseBag);
        return baseBag.get(3);
    }

    public String getFirst() {
        Collections.shuffle(baseBag);
        return baseBag.get(0);
    }

    public ArrayList<String> initNext() {
        ArrayList<String> currentBag = new ArrayList<String>();
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        //TODO: send currentBag to be drawn by UI
        return currentBag;
    }

}