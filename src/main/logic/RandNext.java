/*

Generates next pieces for use in game

 */


package logic;

import model.Animatable;
import model.pieces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class RandNext {

    private static ArrayList<String> baseBag = new ArrayList<>();

    static {
        baseBag.add("LPiece");
        baseBag.add("JPiece");
        baseBag.add("TPiece");
        baseBag.add("IPiece");
        baseBag.add("OPiece");
        baseBag.add("ZPiece");
        baseBag.add("SPiece");
    }

    private String pieceClass;
    private String piecePath;

    //MODIFIES: this
    //EFFECTS: shuffles the bag and pulls a random piece out from the middle
    private String getRandom() {
        Collections.shuffle(baseBag);
        return baseBag.get(3);
    }

    /*public Animatable generatePiece() {
        pieceClass = getRandom();
        piecePath = "src/main/model/pieces/" + pieceClass;
        try {
            Class ranPiece = Class.forName(piecePath);
            Animatable newPiece = (Animatable) ranPiece.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("uh oh");
        }
    }*/

    //REQUIRES: initNext not being previously run in current game instance
    //EFFECTS: initializes next four pieces for use in game
    public ArrayList<String> initNext() {
        ArrayList<String> currentBag = new ArrayList<>();
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        //TODO: send currentBag to be drawn by UI
        return currentBag;
    }

}