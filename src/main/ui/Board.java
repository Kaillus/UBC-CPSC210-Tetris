package ui;

import logic.RandNext;
import model.Animatable;
import model.PieceProxy;
import model.paint.Square;
import model.pieces.Piece;
import ui.Constants;
import ui.PieceObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.VK_DOWN;
import static ui.Constants.UIFrame;
import static ui.State.States.GAME_OVER;

public class Board extends JPanel implements PieceObserver, ActionListener {

    private int boardHeight;
    private int boardWidth;

    private Square[][] gameBoard;

    private boolean pause;
    private boolean end;

    //private Map<String, Piece> boardPieces;
    private PieceProxy proxy;
    private Piece currentPiece;
    private Piece savedPiece;
    //private int index;
    private RandNext randNext;
    private Timer timer;
    private KeyDownListener downKey;
    private KeyLeftListener leftKey;
    private KeyRightListener rightKey;
    private KeySpaceListener spaceKey;
    private KeyTabListener pauseKey;

    //MODIFIES: this
    //EFFECTS: builds a new Board
    public Board(int width, int height) {
        createKeyListeners(this);
        this.boardHeight = height;
        this.boardWidth = width;
        this.pause = false;
        this.end = false;
        this.proxy = new PieceProxy();
        randNext = new RandNext(this);
        nextPiece();
        this.setBackground(Color.black);
        Dimension d = new Dimension(Constants.blockSize * width, Constants.blockSize * height);
        this.setSize(d);
        this.setPreferredSize(d);
        UIFrame.getContentPane().add(this);
        UIFrame.revalidate();
        UIFrame.repaint();
        this.gameBoard = new Square[this.boardHeight][this.boardWidth];
        this.timer = new Timer(500, this);
        timer.start();
    }

    private void createKeyListeners(Board board) {
        downKey = new KeyDownListener(board);
        leftKey = new KeyLeftListener(board);
        rightKey = new KeyRightListener(board);
        spaceKey = new KeySpaceListener(board);
        pauseKey = new KeyTabListener(board);
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public Piece getSavedPiece() {
        return savedPiece;
    }

    public void setCurrentPiece(Piece piece) {
        currentPiece = piece;
    }


    //MODIFIES: this
    //EFFECTS: if savedPiece doesn't exist, simply moves the currentPiece to the savedPiece and generates a new piece.
    //         otherwise, swaps the currentPiece with the savedPiece and places the old savedPiece on the board
    public void setSavedPiece() {
        if (savedPiece == null) {
            savedPiece = currentPiece;
            nextPiece();
        } else {
            Piece tempCurrent = currentPiece;
            placeNextPiece(savedPiece, true);
            savedPiece = tempCurrent;
        }
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

    public boolean checkPause() {
        return pause;
    }

    public boolean checkEndGame() {
        for (int i = 0; i < boardWidth; i++) {
            Square block = gameBoard[i][0];
            if (block != null) {
                end = true;
                return end;
            }
        }
        end = false;
        return end;
    }

    @Override
    public void update(Square square, int dir) {
        switch (dir) {
            case 1: //DOWN
                moveOnBoard(square, 0, 1);
                break;
            case 2: //LEFT
                moveOnBoard(square, -1, 0);
                break;
            case 3: //RIGHT
                moveOnBoard(square, 1, 0);
                break;
            default:
                System.out.println("illegal direction PieceObserver");
                break;
        }
    }

    /*
    //MODIFIES: this
    //EFFECTS: increments the index (number of objects on the board, concatenated to hashMap keys in placeNextPiece)
    private void incrementIndex() {
        index = index + 1;
    }
    */

    //MODIFIES: this
    //EFFECTS: gets the next piece from the upcoming pieces
    private Piece nextPiece() {
        currentPiece = randNext.nextPiece();
        System.out.println(currentPiece);
        proxy.setPiece(currentPiece);
        return currentPiece;
        //placePiece(currentPiece, boardWidth / 2, 0);
        //System.out.println(boardWidth / 2);
        //boardPieces.replace("currentPiece", currentPiece);
    }

    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        Graphics2D betterBrush = (Graphics2D) brush;

        // put the current piece on the board
        currentPiece.fill(betterBrush);
        currentPiece.draw(betterBrush);
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

    //REQUIRES: board initialized
    //EFFECTS: returns colour located at input x, y
    public Color getColourByPos(int x, int y) {
        return gameBoard[y][x].getColour();
    }

    //MODIFIES: this
    //EFFECTS: checks to see if the given coordinates are in the list of current coordinates or are empty spaces
    //         current coordinates meaning they're part of the current block, and so if the piece moves that way
    //         it won't be moving into a conflicting spot
    private boolean isFree(int column, int row) {
        try {
            return (gameBoard[column][row] == null);
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    //EFFECTS: checks to see if the given coordinates are within the bounds of the board
    private boolean isValid(int column, int row) {
        return (column < boardWidth && row < boardHeight && column >= 0 && row >= 0);
    }

    //EFFECTS: checks to see if a piece can move in the input direction and returns a boolean based on testing.
    //         the input values to loopCheck are in terms of dx and dy - if newX is 1, loopCheck checks to see if
    //         movement to the current x values + 1 are possible and same for newY
    public boolean canMove(int column, int row) {
        return (isFree(column, row) && isValid(column, row));
    }


    public void placePiece(Piece piece) {
        Square[] blocks = {piece.getOne(), piece.getTwo(), piece.getThr(), piece.getFou()};
        for (Square block : blocks) {
            int x = (int) block.getSquareX();
            int y = (int) block.getSquareY();
            int column = x / Constants.blockSize;
            int row = y / Constants.blockSize;

            try {
                gameBoard[column][row] = block;
            } catch (ArrayIndexOutOfBoundsException e) {
                //
            }
        }

        this.checkRows();
        if (this.checkEndGame()) {
            State.getInstance().switchState(GAME_OVER);
        } else {
            proxy.setPiece(this.nextPiece());
        }
    }

    private void moveBlocksDown(int row) {
        if ((row < 0) || (row >= boardHeight)) {
            return;
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < boardWidth; j++) {
                Square block = gameBoard[j][i];
                gameBoard[j][i] = null;
                gameBoard[j][i] = block;
                if (block != null) {
                    block.setLocation(block.getSquareX(), block.getSquareY() + Constants.blockSize);
                }
            }
        }
        for (int i = 0; i < boardWidth; i++) {
            gameBoard[i][0] = null;
        }
    }

    private void checkRows() {
        for (int j = 0; j < boardHeight; j++) {
            boolean rowCheck = true;
            for (int i = 0; i < boardWidth; i++) {
                Square block = gameBoard[i][j];
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
    //EFFECTS: places an input Square's colour's number conversion on the board
    public void placeOnBoard(Square square) {
        this.gameBoard[square.getSquareY()][square.getSquareX()] = square;
    }

    public void moveOnBoard(Square square, int newX, int newY) {
        int oldX = square.getSquareX();
        int oldY = square.getSquareY();
        this.gameBoard[oldY][oldX] = new Square(Color.black, oldX, oldY);
        square.setLocation((oldX + newX), (oldY + newY));
        //this.gameBoard[oldY + newY][oldX + newX] = square;
        placeOnBoard(square);
    }

    public void wipeSquare(int x, int y) {
        this.gameBoard[y][x] = new Square(Color.black, x, y);
    }


    //MODIFIES: this
    //EFFECTS: if saved is true, switches the currentPiece with (and places) the input piece. else, moves the current
    //         piece to a new spot in the boardPieces hashmap (changing its key to object#) and
    //         increments the index + generates next piece
    public void placeNextPiece(Piece piece, boolean saved) {
        if (!saved) {
            //String objName = "object" + Integer.toString(index);
            //boardPieces.put(objName, currentPiece);
            //incrementIndex();
            nextPiece();
        } else {
            currentPiece = piece;
        }
    }

    public void actionPerformed(ActionEvent e) {
        proxy.moveDown();
        repaint();
    }

    private class KeyDownListener extends KeyHandler {

        public KeyDownListener(JPanel panel) {
            super(panel, KeyEvent.VK_DOWN);
        }

        public void actionPerformed(ActionEvent e) {
            if (!pause && !end) {
                proxy.moveDown();
                repaint();
            }
        }
    }

    private class KeyLeftListener extends KeyHandler {

        public KeyLeftListener(JPanel panel) {
            super(panel, KeyEvent.VK_LEFT);
        }

        public void actionPerformed(ActionEvent e) {
            if (!pause && !end) {
                proxy.moveLeft();
                repaint();
            }
        }
    }

    private class KeyRightListener extends KeyHandler {

        public KeyRightListener(JPanel panel) {
            super(panel, KeyEvent.VK_LEFT);
        }

        public void actionPerformed(ActionEvent e) {
            if (!pause && !end) {
                proxy.moveRight();
                repaint();
            }
        }
    }

    private class KeySpaceListener extends KeyHandler {

        public KeySpaceListener(JPanel panel) {
            super(panel, KeyEvent.VK_LEFT);
        }

        public void actionPerformed(ActionEvent e) {
            if (!pause && !(State.getInstance().getState() == GAME_OVER)) {
                proxy.moveDown();
                repaint();
            }
        }
    }

    private class KeyTabListener extends KeyHandler {

        public KeyTabListener(JPanel panel) {
            super(panel, KeyEvent.VK_TAB);
        }

        public void actionPerformed(ActionEvent e) {
            if (timer.isRunning()) {
                timer.stop();
                pause = true;
            } else {
                if (!(State.getInstance().getState() == GAME_OVER)) {
                    timer.start();
                    pause = false;
                }
            }
        }
    }

}
