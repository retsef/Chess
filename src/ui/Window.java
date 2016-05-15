package ui;

import engine.Game;
import pieces.Piece;

import javax.swing.*;

/**
 * Created by roberto on 15/05/16.
 */
public class Window extends JFrame {

    private Game game;
    private Board ui_board;

    public Window() {
        super();

        _init();

        start();
    }

    private void _init() {
        this.setTitle("Chess");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setSize(600, 625);
        this.setLocationRelativeTo(null);
    }

    private void start() {
        game = new Game();

        ui_board = new Board(game, game);
        ui_board.setPieces(Piece.COLOR.Black);
        ui_board.setPieces(Piece.COLOR.White);

        this.add(ui_board);

        this.setVisible(true);
    }

}
