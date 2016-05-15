package pieces;

import engine.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 15/05/16.
 */
public abstract class Piece {

    public enum COLOR {
        White, Black;
    }

    private COLOR color;
    private Coordinate coordinate;

    public Piece(COLOR color) {
        this.color = color;
    }

    public Piece(COLOR color, Coordinate coordinate) {
        this(color);
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public COLOR getColor() {
        return color;
    }

    public abstract Image getImage();

    public abstract ArrayList<Coordinate> getPossibleMovement();

    @Override
    public String toString() {
        return getColor().toString()+" "+this.getClass().getSimpleName()+" : "+getCoordinate().toString();
    }
}
