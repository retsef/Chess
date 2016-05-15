package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import engine.Coordinate.ROW;
import interfaces.BoardInterface;
import pieces.*;

/**
 * Created by roberto on 15/05/16.
 */
public class Board implements BoardInterface {

    private HashMap<Coordinate, Square> checkerboard;

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
                    coordinate = new Coordinate(Coordinate.ROW.values()[i%8], i>7?2:1);
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

    @Override
    public Piece getPiece(Coordinate c) {
        return getSquare(c).getPiece();
    }

}
