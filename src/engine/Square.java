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
    private Piece piece;

    public Square(COLOR color) {
        this.color = color;
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
}
