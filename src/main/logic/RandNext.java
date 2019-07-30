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
    private ArrayList<Animatable> currentBag = new ArrayList<>();
    private Animatable targetPiece;
    private int sevenSetCounter;

    static {
        baseBag.add("LPiece");
        baseBag.add("JPiece");
        baseBag.add("TPiece");
        baseBag.add("IPiece");
        baseBag.add("OPiece");
        baseBag.add("ZPiece");
        baseBag.add("SPiece");
    }

    public RandNext() {
        this.sevenSetCounter = 6;
    }

    //MODIFIES: this
    //EFFECTS: the bag is a set of 7 pieces. getRandom() shuffles the bag and then pulls out each piece so there are
    //         no repeating pieces and then shuffles the bag again once all pieces have been selected once
    public Animatable getRandom() {
        if (sevenSetCounter == 6) {
            Collections.shuffle(baseBag);
            sevenSetCounter = 0;
        } else {
            sevenSetCounter = sevenSetCounter + 1;
        }
        return generatePiece(baseBag.get(sevenSetCounter));
    }

    //MODIFIES: this
    //EFFECTS: uses getRandom() to generate a piece and then constructs a new object based on that piece via
    //         switch statements (two methods because checkstyle limits one method to 20 lines)
    public Animatable generatePiece(String temp) {
        switch (temp) {
            case "LPiece":
                targetPiece = new LPiece();
                break;
            case "JPiece":
                targetPiece = new JPiece();
                break;
            case "TPiece":
                targetPiece = new TPiece();
                break;
            default:
                switchExtend(temp);
                break;
        }
        return targetPiece;
    }

    private void switchExtend(String temp) {
        switch (temp) {
            case "IPiece":
                targetPiece = new IPiece();
                break;
            case "OPiece":
                targetPiece = new OPiece();
                break;
            case "ZPiece":
                targetPiece = new ZPiece();
                break;
            default:
                targetPiece = new SPiece();
                break;
        }
    }

    //REQUIRES: initNext not being previously run in current game instance
    //MODIFIES: this
    //EFFECTS: initializes next four pieces for use in game
    public ArrayList<Animatable> initNext() {
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        //TODO: send currentBag to be drawn by UI
        return currentBag;
    }

    //MODIFIES: this
    //EFFECTS: returns and removes the first (latest) entry in the pieces coming up and generates a new one at the tail
    public Animatable nextPiece() {
        Animatable latest = currentBag.get(0);
        currentBag.remove(0);
        currentBag.add(getRandom());
        return latest;
    }

}