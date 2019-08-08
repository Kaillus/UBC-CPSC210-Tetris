package ui.logic;

import logic.RandNext;
import ui.model.PieceProxy;
import ui.model.paint.Square;
import ui.model.pieces.Piece;
import ui.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static ui.Constants.UIFrame;
import static ui.Constants.gameSpeed;
import static ui.logic.State.States.GAME_OVER;

public class Board extends JPanel implements ActionListener {

    private int boardHeight;
    private int boardWidth;

    private Square[][] gameBoard;

    private boolean pause;
    private boolean end;

    //private Map<String, Piece> boardPieces;
    private PieceProxy proxy;
    //private Piece currentPiece;
    //private Piece savedPiece;
    //private int index;
    private RandNext randNext;
    private Timer timer;
    private int timerMultiplier;

    //MODIFIES: this
    //EFFECTS: builds a new Board
    public Board(int width, int height) {
        this.setBackground(Color.gray);
        Dimension d = new Dimension(Constants.blockSize * width, Constants.blockSize * height);
        this.setSize(d);
        this.setPreferredSize(d);
        this.setLocation(100,0);
        this.boardHeight = height;
        this.boardWidth = width;
        this.pause = false;
        this.end = false;
        this.gameBoard = new Square[boardHeight][boardWidth];
        this.timer = new Timer((500 / getTimerMultiplier(gameSpeed)), this);
        timer.start();
        this.proxy = new PieceProxy();
        randNext = new RandNext(this);
        proxy.setPiece(nextPiece());
        UIFrame.getContentPane().add(this);
        UIFrame.revalidate();
        UIFrame.repaint();
    }

    private int getTimerMultiplier(int gameSpeed) {
        if (gameSpeed < 1 || gameSpeed > 11) {
            return 1;
        } else {
            return gameSpeed;
        }
    }

    private void endGame() {
        timer.stop();
        State.getInstance().switchState(GAME_OVER);
    }

    public Square[][] getBoardState() {
        return gameBoard;
    }

    public int getBoardHeight() {
        return this.boardHeight;
    }

    public int getBoardWidth() {
        return this.boardWidth;
    }

    public void setPause(boolean p) {
        pause = p;
    }

    public PieceProxy getProxy() {
        return proxy;
    }

    public void repaintBoard() {
        repaint();
    }

    public Timer getTimer() {
        return timer;
    }

    //MODIFIES: this
    //EFFECTS: gets the next piece from the upcoming pieces
    private Piece nextPiece() {
        return randNext.nextPiece();
    }

    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        Graphics2D betterBrush = (Graphics2D) brush;

        // put the current piece on the board
        proxy.fill(betterBrush);
        proxy.draw(betterBrush);
        // Put all other blocks on the board
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                Square block = gameBoard[j][i];
                if (block != null) {
                    block.draw(betterBrush);
                    block.fill(betterBrush);
                }
            }
        }
    }

    //EFFECTS: checks to see if a piece can move into the given coordinates.
    public boolean canMove(int column, int row) {
        return (isFree(column, row) && isValid(column, row));
    }

    //MODIFIES: this
    //EFFECTS: checks to see if the given coordinates point to a location on the board that is null.
    private boolean isFree(int column, int row) {
        try {
            return (gameBoard[row][column] == null);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    //EFFECTS: checks to see if the given coordinates are within the bounds of the board
    private boolean isValid(int column, int row) {
        //return (column < boardWidth && row < boardHeight && column >= 0 && row >= 0);
        return (column < boardWidth && column >= 0 && row < boardHeight);
    }

    //MODIFIES: this
    //EFFECTS: tries to place all the blocks in the given piece on the board. then, checks the rows to see if
    //         a line has been filled up (horizontally). then, checks to see if one column is full (vertically). if so,
    //         ends the game. if not, generates the next piece.
    public void placePiece(Piece piece) {
        Square[] blocks = {piece.getOne(), piece.getTwo(), piece.getThr(), piece.getFou()};
        for (Square block : blocks) {
            int x = (int) block.getX();
            int y = (int) block.getY();
            int column = x / Constants.blockSize;
            int row = y / Constants.blockSize;
            try {
                gameBoard[row][column] = block;
            } catch (ArrayIndexOutOfBoundsException e) {
                //
            }
        }
        this.checkRows();
        if (checkEndGame()) {
            endGame();
        } else {
            proxy.setPiece(nextPiece());
        }
    }

    //MODIFIES: this
    //EFFECTS: checks to see if one column is full (vertically). if so, sets end to true.
    public boolean checkEndGame() {
        for (int i = 0; i < boardWidth; i++) {
            Square block = gameBoard[0][i];
            if (block != null) {
                end = true;
                return end;
            }
        }
        end = false;
        return end;
    }

    //MODIFIES: this
    //EFFECTS: checks to see if a row (horizontal) is full. if so, delete the row and move all the blocks above it on
    //         the board down one row.
    private void checkRows() {
        for (int j = 0; j < boardHeight; j++) {
            boolean rowCheck = true;
            for (int i = 0; i < boardWidth; i++) {
                Square block = gameBoard[j][i];
                if (block == null) {
                    rowCheck = false;
                }
            }
            if (rowCheck) {
                moveBlocksDown(j);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: deletes a row and moves the blocks above it down.
    private void moveBlocksDown(int row) {
        if ((row < 0) || (row >= boardHeight)) {
            return;
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < boardWidth; j++) {
                Square block = gameBoard[i][j];
                gameBoard[i][j] = null;
                gameBoard[i + 1][j] = block;
                if (block != null) {
                    block.setLocation(block.getX(), block.getY() + Constants.blockSize);
                }
            }
        }
        for (int i = 0; i < boardWidth; i++) {
            gameBoard[i][0] = null;
        }
    }

    public void actionPerformed(ActionEvent e) {
        proxy.moveDown();
        repaint();
    }

}