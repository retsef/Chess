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
        return null;
    }
}
