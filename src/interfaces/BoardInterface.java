package interfaces;

import engine.Coordinate;
import engine.Square;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by roberto on 15/05/16.
 */
public interface BoardInterface<Square> {

    public void setPieces(Piece.COLOR color);

    public Piece getPiece(Coordinate c);

    public Square getSquare(Coordinate c);
    public List<Square> getSquares(Coordinate start, Coordinate end);

    public void hightlightSquares(List<Coordinate> coordinateList);

    public void clearHightlightSquares();

    public void movePiece(Piece piece, Coordinate c);

}
