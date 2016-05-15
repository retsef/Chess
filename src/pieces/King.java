package pieces;

import engine.Coordinate;
import util.Resources;

import java.awt.*;

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
}
