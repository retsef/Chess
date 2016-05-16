package engine;

import interfaces.BoardInterface;
import pieces.Piece;
import pieces.Piece.COLOR;
import ui.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberto on 15/05/16.
 */
public class Game implements Square.ActionListner, BoardInterface {

    private Board board;
    private BoardInterface ui_boardinterface;

    public Game() {
        board = new Board();

        setPieces(Piece.COLOR.Black);
        setPieces(Piece.COLOR.White);
    }

    public void setUi_boardinterface(BoardInterface ui_boardinterface) {
        this.ui_boardinterface = ui_boardinterface;
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
    public void hightlightSquares(List<Coordinate> coordinateList) {
        board.hightlightSquares(coordinateList);
        this.ui_boardinterface.hightlightSquares(coordinateList);
    }

    @Override
    public void OnClick(Coordinate c) {
        if (board.getSquare(c).isPiecePresent()) {
            Piece piece = board.getPiece(c);
            piece.setCoordinate(c);

            System.out.println(piece.toString());
            ArrayList<Coordinate> arr = piece.getPossibleMovement();
            //System.out.println(arr.size());

            this.hightlightSquares(arr);
        }
    }
}
