package engine;

import interfaces.BoardInterface;
import pieces.Piece;
import pieces.Piece.COLOR;
import ui.Square;

/**
 * Created by roberto on 15/05/16.
 */
public class Game implements Square.ActionListner, BoardInterface {

    private Board board;

    public Game() {
        board = new Board();

        setPieces(Piece.COLOR.Black);
        setPieces(Piece.COLOR.White);
    }

    @Override
    public void setPieces(COLOR color) {
        board.setPieces(color);
    }

    @Override
    public Piece getPiece(Coordinate c) {
        return board.getPiece(c);
    }

    @Override
    public void OnClick(Coordinate c) {
        Piece piece = board.getPiece(c);
        piece.setCoordinate(c);

        System.out.println(piece.toString());
    }
}
