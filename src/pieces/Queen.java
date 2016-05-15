package pieces;

import engine.Coordinate;
import util.Resources;

import java.awt.*;

/**
 * Created by roberto on 15/05/16.
 */
public class Queen extends Piece {

    public Queen(COLOR color) {
        super(color);
    }

    public Queen(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/QueenW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/QueenB.png");
            default:
                return Resources.getImage("../assets/images/pieces/QueenW.png");
        }
    }
}
