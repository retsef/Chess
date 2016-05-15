package pieces;

import engine.Coordinate;
import util.SpriteSheetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * Created by roberto on 15/05/16.
 */
public abstract class Piece implements ImageObserver {

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

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
    }
}
