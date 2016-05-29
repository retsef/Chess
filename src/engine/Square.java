package engine;

import pieces.Piece;

/**
 * Created by roberto on 15/05/16.
 */
public class Square {
    public enum COLOR {
        BLACK, WHITE
    }

    private COLOR color;
    private Coordinate coordinate;
    private Piece piece;

    public Square(COLOR color, Coordinate coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }

    public boolean isPiecePresent() {
        return this.piece != null;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;

        Square c = (Square) obj;
        return this.toString().equals(c.toString());
    }

    @Override
    public int hashCode() {
        return this.coordinate.hashCode()+this.color.hashCode();
    }

    @Override
    public String toString() {
        return "Square{" +
                "color=" + color +
                ", coordinate=" + coordinate +
                ", piece=" + piece +
                '}';
    }
}
