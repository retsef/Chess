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
public class Game implements Square.ActionListner, BoardInterface<engine.Square> {

    private Board board;
    private BoardInterface ui_boardinterface;

    private Arbitrator arbitrator;

    public Game() {
        board = new Board();

        setPieces(Piece.COLOR.Black);
        setPieces(Piece.COLOR.White);

        arbitrator = new Arbitrator();
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
    public engine.Square getSquare(Coordinate c) {
        return board.getSquare(c);
    }

    @Override
    public List<engine.Square> getSquares(Coordinate start, Coordinate end) {
        return board.getSquares(start,end);
    }

    @Override
    public void hightlightSquares(List<Coordinate> coordinateList) {
        board.hightlightSquares(coordinateList);
        this.ui_boardinterface.hightlightSquares(coordinateList);
    }

    @Override
    public void clearHightlightSquares() {
        board.clearHightlightSquares();
        this.ui_boardinterface.clearHightlightSquares();
    }

    @Override
    public void movePiece(Piece piece, Coordinate c) {
        board.movePiece(piece, c);
        this.ui_boardinterface.movePiece(piece, c);

        board.removeDisputed_piece();

        arbitrator.notifyActionMove(piece,c);
        arbitrator.passDeponent();
    }

    @Override
    public void OnClick(Coordinate c) {
        if (board.getSquare(c).isPiecePresent()) {
            Piece piece = board.getPiece(c);
            if(piece.getColor() != arbitrator.getCurrent_color())
                return;
            piece.setCoordinate(c);

            board.setDisputed_piece(piece); //salvo il pezzo selezionato

            System.out.println(piece.toString());
            ArrayList<Coordinate> arr = piece.getPossibleMovement(this);

            this.hightlightSquares(arr);
        } else {
            System.out.println(c.toString());
            Piece piece = board.getDisputed_piece(); //richiamo l'ultimo pezzo selecionato
            if (piece!=null) {
                ArrayList<Coordinate> arr = piece.getPossibleMovement(this);
                if (arr.contains(c))
                    this.movePiece(piece, c);
            }
        }
    }


}
