package pieces;

import engine.Coordinate;
import interfaces.BoardInterface;
import util.Resources;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 15/05/16.
 */
public class Queen extends Piece {

    public Queen(COLOR color) {
        super(color);
    }

    public Queen(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/QueenW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/QueenB.png");
            default:
                return Resources.getImage("../assets/images/pieces/QueenW.png");
        }
    }

    @Override
    public ArrayList<Coordinate> getPossibleMovement(BoardInterface boardInterface) {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate.ROW current_row = getCoordinate().getRow();
        int current_comlumn = getCoordinate().getColumn();
        for(int i=0,max=16;i<max;i++)
            squares.add(new Coordinate(
                    i<8?current_row:Coordinate.ROW.values()[i%8],
                    i<8?(i%8)+1:current_comlumn));

        squares.remove(getCoordinate());
        squares.remove(getCoordinate());

        return squares;
    }
}
