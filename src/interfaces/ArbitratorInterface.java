package interfaces;

import engine.Coordinate;
import pieces.Piece;

/**
 * Created by roberto on 20/05/16.
 */
public interface ArbitratorInterface {

    public void setCurrent_color(Piece.COLOR color);

    public void notifyActionMove(String c);
}
