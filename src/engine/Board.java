package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import engine.Coordinate.ROW;
import interfaces.BoardInterface;
import pieces.*;

/**
 * Created by roberto on 15/05/16.
 */
public class Board implements BoardInterface {

    private HashMap<Coordinate, Square> checkerboard;
    private Piece disputed_piece;
    //private Square disputed_square;

    public Board() {
        _init();
    }

    private void _init() {
        checkerboard = new HashMap<>();

        int row = 0;
        for(int i=0,max=64; i<max; i++) {
            row = i%8==0 ? row+1 : row;
            checkerboard.put(
                    new Coordinate(ROW.values()[i%8], row),
                    new Square(Square.COLOR.values()[i%2]));
        }
    }

    @Override
    public void setPieces(Piece.COLOR color) {
        Coordinate coordinate = null;
        Piece piece = null;
        switch (color) {
            case Black:
                ArrayList<ROW> rows = new ArrayList<>(Arrays.asList(Coordinate.ROW.values()));
                for(int i=0,max=16;i<max;i++) {
                    coordinate = new Coordinate(rows.get(i%8), i>7?7:8);
                    piece = getDefaultPiece(coordinate, color);
                    getSquare(coordinate).setPiece(piece);
                }
                break;
            case White:
                for(int i=0,max=16;i<max;i++) {
                    coordinate = new Coordinate(Coordinate.ROW.values()[i%8], i>7?1:2);
                    piece = getDefaultPiece(coordinate, color);
                    getSquare(coordinate).setPiece(piece);
                }
                break;
        }
    }

    private Piece getDefaultPiece(Coordinate coordinate, Piece.COLOR color) {
        switch (color) {
            case White:
                switch (coordinate.toString()) {
                    case "A,1":
                    case "H,1":
                        return new Rock(color);
                    case "B,1":
                    case "G,1":
                        return new Knight(color);
                    case "C,1":
                    case "F,1":
                        return new Bishop(color);
                    case "D,1":
                        return new King(color);
                    case "E,1":
                        return new Queen(color);
                    default:
                        return new Pawn(color);
                }
            case Black:
                switch (coordinate.toString()) {
                    case "A,8":
                    case "H,8":
                        return new Rock(color);
                    case "B,8":
                    case "G,8":
                        return new Knight(color);
                    case "C,8":
                    case "F,8":
                        return new Bishop(color);
                    case "D,8":
                        return new King(color);
                    case "E,8":
                        return new Queen(color);
                    default:
                        return new Pawn(color);
                }
            default:
                return new Pawn(color);
        }

    }

    public Square getSquare(Coordinate c) {
        return checkerboard.get(c);
    }

    public boolean isPiecePresent(Coordinate c) {
        return getSquare(c).isPiecePresent();
    }

    @Override
    public void hightlightSquares(List<Coordinate> coordinateList) {

    }

    @Override
    public void clearHightlightSquares() {

    }

    @Override
    public Piece getPiece(Coordinate c) {
        return getSquare(c).getPiece();
    }

    @Override
    public void movePiece(Piece piece, Coordinate c) {
        this.getSquare(piece.getCoordinate()).removePiece(); //rimmuovo il vecchio pezzo
        this.getSquare(c).setPiece(piece); //sposto il pezzo

        clearHightlightSquares();
    }

    public Piece getDisputed_piece() {
        return disputed_piece;
    }

    public void setDisputed_piece(Piece disputed_piece) {
        this.disputed_piece = disputed_piece;
    }

    public void removeDisputed_piece() {
        this.disputed_piece = null;
    }

}
