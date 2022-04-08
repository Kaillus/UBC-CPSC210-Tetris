/*

Interface for handling states

 */

package ui;

import static logic.Constants.TetrisFrame;

public interface DrawState {

    void update();

    void draw();

    static void shutdown() {
        TetrisFrame.removeAll();
        TetrisFrame.repaint();
        TetrisFrame.revalidate();
    }

    void init();

}