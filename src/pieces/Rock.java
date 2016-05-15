package pieces;

import engine.Coordinate;
import util.Resources;

import java.awt.*;

/**
 * Created by roberto on 15/05/16.
 */
public class Rock extends Piece {

    public Rock(COLOR color) {
        super(color);
    }

    public Rock(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/RookW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/RookB.png");
            default:
                return Resources.getImage("../assets/images/pieces/RookW.png");
        }
    }
}
