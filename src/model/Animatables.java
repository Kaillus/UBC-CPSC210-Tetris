package model;

import logic.Board;

public interface Animatables {

    void draw(Board board, int x, int y);

    void update();

}