package engine;

import interfaces.ArbitratorInterface;
import pieces.Piece;

import java.util.ArrayList;

/**
 * Created by roberto on 17/05/16.
 */
public class Arbitrator {

    private Piece.COLOR current_color;
    private ArrayList<String> logger;
    private ArbitratorInterface arbitratorInterface;

    public Arbitrator() {
        current_color = Piece.COLOR.White;
        logger = new ArrayList<>();
    }

    public void setInterface(ArbitratorInterface arbitratorInterface) {
        this.arbitratorInterface = arbitratorInterface;
    }

    public Piece.COLOR getCurrent_color() {
        return current_color;
    }

    public void passDeponent() {
        this.current_color = this.current_color == Piece.COLOR.Black ? Piece.COLOR.White : Piece.COLOR.Black;
        this.arbitratorInterface.setCurrent_color(getCurrent_color());
    }

    public void notifyActionMove(Piece p, Coordinate c) {
        String event = p.toString()+" moved to "+c.toString();
        logger.add(event);
        this.arbitratorInterface.notifyActionMove(event);
    }

}
