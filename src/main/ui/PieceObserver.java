/*

Links to Board in logic package

*/

package ui;

import model.paint.Square;

public interface PieceObserver {

    public void update(Square square, int dir);

}
