package ui;

import engine.Game;
import pieces.Piece;
import util.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by roberto on 15/05/16.
 */
public class Window extends JFrame {

    private Game game;
    private Board ui_board;
    private Arbitrator ui_arbitrator;

    public Window() {
        super();

        _init();

        start();
    }

    private void _init() {
        this.setTitle("Chess");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        this.setSize(850, 625);
        this.setLocationRelativeTo(null);

        try {
            BufferedImage image = Resources.getImage("../assets/images/Chess.png");
            this.setIconImage(image);
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void start() {
        game = new Game();
        ui_board = new Board();
        ui_arbitrator = new Arbitrator();

        game.setUi_boardinterface(ui_board);
        game.setUi_arbitratorinterface(ui_arbitrator);

        ui_board.setActionListner(game);
        ui_board.setGame_boardinterface(game);

        ui_board.setPieces(Piece.COLOR.Black);
        ui_board.setPieces(Piece.COLOR.White);

        ui_board.setLocation(0,0);
        this.add(ui_board);
        ui_arbitrator.setLocation(600,0);
        this.add(ui_arbitrator);

        this.setVisible(true);
    }

}
