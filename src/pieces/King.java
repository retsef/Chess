package pieces;

import engine.Coordinate;
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
    public ArrayList<Coordinate> getPossibleMovement() {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate.ROW current_row = getCoordinate().getRow();
        int current_comlumn = getCoordinate().getColumn();


        return squares;
    }
}
