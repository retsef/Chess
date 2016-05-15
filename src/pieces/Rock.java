package pieces;

import engine.Coordinate;
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
    public ArrayList<Coordinate> getPossibleMovement() {
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
