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
public class Pawn extends Piece {

    public Pawn(COLOR color) {
        super(color);
    }

    public Pawn(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/PawnW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/PawnB.png");
            default:
                return Resources.getImage("../assets/images/pieces/PawnW.png");
        }
    }

    @Override
    public ArrayList<Coordinate> getPossibleMovement(BoardInterface<Square> boardInterface) {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate.ROW current_row = getCoordinate().getRow();
        int current_comlumn = getCoordinate().getColumn();

        Coordinate c = null;
        switch (getColor()) {
            case White:
                if(current_comlumn != 8) {//fine della scacchiera
                    c = new Coordinate(current_row, current_comlumn + 1);
                    if(!boardInterface.getSquare(c).isPiecePresent())
                        squares.add(c);
                }
                if(current_comlumn == 2) {//partenza
                    c = new Coordinate(current_row, current_comlumn + 2);
                    if(!boardInterface.getSquare(c).isPiecePresent())
                        squares.add(c);
                }
                break;
            case Black:
                if(current_comlumn != 1) {//fine della scacchiera
                    c = new Coordinate(current_row, current_comlumn - 1);
                    if (!boardInterface.getSquare(c).isPiecePresent())
                        squares.add(c);
                }
                if(current_comlumn == 7) { //partenza
                    c = new Coordinate(current_row, current_comlumn - 2);
                    if (!boardInterface.getSquare(c).isPiecePresent())
                        squares.add(c);
                }
                break;
        }

        return squares;
    }
}
