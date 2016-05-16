package pieces;

import engine.Coordinate;
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
    public ArrayList<Coordinate> getPossibleMovement() {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate.ROW current_row = getCoordinate().getRow();
        int current_comlumn = getCoordinate().getColumn();

        switch (getColor()) {
            case White:
                if (current_comlumn == 2) {
                    squares.add(new Coordinate(current_row, 3));
                    squares.add(new Coordinate(current_row, 4));
                }
                break;
            case Black:
                if (current_comlumn == 7) {
                    squares.add(new Coordinate(current_row, 6));
                    squares.add(new Coordinate(current_row, 5));
                }

                break;
        }

        return squares;
    }
}
