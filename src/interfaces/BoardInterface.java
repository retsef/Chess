package interfaces;

import engine.Coordinate;
import pieces.Piece;

/**
 * Created by roberto on 15/05/16.
 */
public interface BoardInterface {

    public void setPieces(Piece.COLOR color);

    public Piece getPiece(Coordinate c);

}
