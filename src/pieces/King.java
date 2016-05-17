package pieces;

import engine.Coordinate;
import engine.Square;
import interfaces.BoardInterface;
import util.Resources;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 15/05/16.
 */
public class King extends Piece {

    public King(COLOR color) {
        super(color);
    }

    public King(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/KingW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/KingB.png");
            default:
                return Resources.getImage("../assets/images/pieces/KingW.png");
        }
    }

    @Override
    public ArrayList<Coordinate> getPossibleMovement(BoardInterface<Square> boardInterface) {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate c = getCoordinate();
        Coordinate c_tmp = null;

        /* <- A -> */
        if (!c.isOnFirstColumn()) { //
            c_tmp = new Coordinate(c.getRow(), c.getColumn() - 1);
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }
        if (!c.isOnLastColumn()) { //
            c_tmp = new Coordinate(c.getRow(), c.getColumn()+1);
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }

        /* ^- A -v */
        if (!c.isOnFirstRow()) { //
            c_tmp = new Coordinate(Coordinate.ROW.values()[c.getRow().ordinal()-1], c.getColumn());
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }
        if (!c.isOnLastRow()) { //
            c_tmp = new Coordinate(Coordinate.ROW.values()[c.getRow().ordinal()+1], c.getColumn());
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }

        /* ^\   /^
         * v/ A \v */
        if (!c.isOnFirstRow() && !c.isOnFirstColumn()) { //
            c_tmp = new Coordinate(Coordinate.ROW.values()[c.getRow().ordinal()-1], c.getColumn()-1);
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }
        if (!c.isOnLastRow() && !c.isOnFirstColumn()) { //
            c_tmp = new Coordinate(Coordinate.ROW.values()[c.getRow().ordinal()+1], c.getColumn()-1);
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }
        if (!c.isOnFirstRow() && !c.isOnLastColumn()) { //
            c_tmp = new Coordinate(Coordinate.ROW.values()[c.getRow().ordinal()-1], c.getColumn()+1);
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }
        if (!c.isOnLastRow() && !c.isOnLastColumn()) { //
            c_tmp = new Coordinate(Coordinate.ROW.values()[c.getRow().ordinal()+1], c.getColumn()+1);
            if(!boardInterface.getSquare(c_tmp).isPiecePresent())
                squares.add(c_tmp);
        }


        return squares;
    }
}
