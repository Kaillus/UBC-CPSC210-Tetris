package ui;

import model.paint.Square;

import java.util.ArrayList;
import java.util.List;

public abstract class PieceSubject {

    protected List<PieceObserver> observers = new ArrayList<>();

    public void addObserver(PieceObserver o) {
        this.observers.add(o);
    }

    public void removeObserver(PieceObserver o) {
        this.observers.remove(o);
    }

    public void notifyObservers(Square square, int dir) {
        //for (Square square )
        for (PieceObserver o : observers) {
            o.update(square, dir);
        }
    }

}
