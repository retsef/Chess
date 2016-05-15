package pieces;

import engine.Coordinate;
import util.Resources;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 15/05/16.
 */
public class Knight extends Piece {

    public Knight(COLOR color) {
        super(color);
    }

    public Knight(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/KnightW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/KnightB.png");
            default:
                return Resources.getImage("../assets/images/pieces/KnightW.png");
        }
    }

    @Override
    public ArrayList<Coordinate> getPossibleMovement() {
        return null;
    }
}
