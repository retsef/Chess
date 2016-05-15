package pieces;

import engine.Coordinate;
import util.Resources;

import java.awt.*;

/**
 * Created by roberto on 15/05/16.
 */
public class Bishop extends Piece {

    public Bishop(COLOR color) {
        super(color);
    }

    public Bishop(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/BishopW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/BishopB.png");
            default:
                return Resources.getImage("../assets/images/pieces/BishopW.png");
        }
    }
}
