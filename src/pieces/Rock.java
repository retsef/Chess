package pieces;

import engine.Coordinate;
import engine.Square;
import interfaces.BoardInterface;
import util.Resources;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 15/05/16.
 */
public class Rock extends Piece {

    public Rock(COLOR color) {
        super(color);
    }

    public Rock(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/RookW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/RookB.png");
            default:
                return Resources.getImage("../assets/images/pieces/RookW.png");
        }
    }

    @Override
    public ArrayList<Coordinate> getPossibleMovement(BoardInterface<Square> boardInterface) {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate.ROW current_row = getCoordinate().getRow();
        int current_comlumn = getCoordinate().getColumn();

        Coordinate c = null;
        ArrayList <Square> gap = new ArrayList<>();
        for(int i=0,max=16;i<max;i++) {
            c = new Coordinate(
                    i < 8 ? current_row : Coordinate.ROW.values()[i % 8],
                    i < 8 ? (i % 8) + 1 : current_comlumn);
            if(!boardInterface.getSquare(c).isPiecePresent()) { //esclude le caselle gia' occupate
                //squares.add(c);
                //esclude le caselle insaccessibili (gap)
                gap.clear();
                gap.addAll(boardInterface.getSquares(getCoordinate(), c));
                gap.remove(boardInterface.getSquare(getCoordinate()));
                //gap.remove(boardInterface.getSquare(c));

                int piece_count = 0;
                for (Square sq: gap) {
                    if(sq.isPiecePresent())
                        piece_count += 1;
                }
                if(piece_count==0)
                    squares.add(c);
            }
        }

        squares.remove(getCoordinate());
        squares.remove(getCoordinate());

        return squares;
    }
}
