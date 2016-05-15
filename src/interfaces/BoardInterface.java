package interfaces;

import engine.Coordinate;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberto on 15/05/16.
 */
public interface BoardInterface {

    public void setPieces(Piece.COLOR color);

    public Piece getPiece(Coordinate c);

    public void hightlightSquares(List<Coordinate> coordinateList);

}
