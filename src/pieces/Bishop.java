package pieces;

import engine.Coordinate;
import util.Resources;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 15/05/16.
 */
public class Bishop extends Piece {

    public Bishop(COLOR color) {
        super(color);
    }

    public Bishop(COLOR color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public Image getImage() {
        switch (getColor()) {
            case White:
                return Resources.getImage("../assets/images/pieces/BishopW.png");
            case Black:
                return Resources.getImage("../assets/images/pieces/BishopB.png");
            default:
                return Resources.getImage("../assets/images/pieces/BishopW.png");
        }
    }

    @Override
    public ArrayList<Coordinate> getPossibleMovement() {
        ArrayList <Coordinate> squares = new ArrayList<>();

        Coordinate.ROW current_row = getCoordinate().getRow();
        int current_comlumn = getCoordinate().getColumn();
        for(int i=0,max=16;i<max;i++)
            squares.add(new Coordinate(
                    Coordinate.ROW.values()[i%8],
                    i<7?(i%8)+1:Math.abs((i%8)-8)));

        squares.remove(getCoordinate());
        squares.remove(getCoordinate());

        return squares;
    }
}
