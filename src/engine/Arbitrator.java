package engine;

import pieces.Piece;

import java.util.ArrayList;

/**
 * Created by roberto on 17/05/16.
 */
public class Arbitrator {

    private Piece.COLOR current_color;
    private ArrayList<String> logger;

    public Arbitrator() {
        current_color = Piece.COLOR.White;
        logger = new ArrayList<>();
    }

    public Piece.COLOR getCurrent_color() {
        return current_color;
    }

    public void passDeponent() {
        this.current_color = this.current_color == Piece.COLOR.Black ? Piece.COLOR.White : Piece.COLOR.Black;
    }

    public void notifyActionMove(Piece p, Coordinate c) {
        logger.add(p.toString()+" moved to "+c.toString());
    }

}
