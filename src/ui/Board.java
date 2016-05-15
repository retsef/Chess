package ui;

import engine.*;
import interfaces.BoardInterface;
import pieces.Piece;
import ui.Square.*;
import util.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by roberto on 15/05/16.
 */
public class Board extends JPanel implements BoardInterface {

    private Background background;
    private HashMap<Coordinate, Square> checkerboard;
    private ActionListner actionListner;
    private BoardInterface game_boardinterface;

    public Board(ActionListner actionListner, BoardInterface boardInterface) {
        super();

        checkerboard = new HashMap<>();
        this.actionListner = actionListner;
        this.game_boardinterface = boardInterface;

        _init();

        this.background = new Background(800, 600);
        this.add(this.background);
    }

    private void _init() {
        this.setLayout(null);

        Coordinate coordinate = null;
        Square square = null;

        int row = -1;
        //la generazione delle case lle parte dall'alto
        ArrayList<Coordinate.ROW> rows = new ArrayList<>(Arrays.asList(Coordinate.ROW.values()));
        //Collections.reverse(rows);

        for(int i=0,max=64; i<max; i++) {
            row = i%8==0 ? row+1 : row;
            coordinate = new Coordinate(rows.get(i%8), Math.abs(row-8));
            checkerboard.put(
                    coordinate,
                    new Square());
            square = this.checkerboard.get(coordinate);

            square.setBounds((i%8)*71+18, row*71+18, 70, 70);

            square.setActionCommand(coordinate.toString());
            square.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Coordinate c = new Coordinate(e.getActionCommand());
                    actionListner.OnClick(c);
                }
            });

            square.setContentAreaFilled(false);
            this.add(square);
        }
    }

    @Override
    public void setPieces(Piece.COLOR color) {
        Coordinate coordinate = null;
        Piece piece = null;
        Square square = null;
        ImageIcon icon = null;

        switch (color) {
            case Black:
                ArrayList<Coordinate.ROW> rows = new ArrayList<>(Arrays.asList(Coordinate.ROW.values()));
                for(int i=0,max=16;i<max;i++) {
                    coordinate = new Coordinate(rows.get(i%8), i>7?7:8);
                    piece = this.getPiece(coordinate);
                    square = checkerboard.get(coordinate);
                    icon = new ImageIcon(piece.getImage());
                    square.setIcon(icon);
                }
                break;
            case White:
                for(int i=0,max=16;i<max;i++) {
                    coordinate = new Coordinate(Coordinate.ROW.values()[i%8], i>7?2:1);
                    piece = this.getPiece(coordinate);
                    square = checkerboard.get(coordinate);
                    icon = new ImageIcon(piece.getImage());
                    square.setIcon(icon);
                }
                break;
        }
    }

    @Override
    public Piece getPiece(Coordinate c) {
        return game_boardinterface.getPiece(c);
    }

    private class Background extends JPanel {
        private final Image img;

        public Background(int width, int height) {
            this.setSize(width, height);
            this.img = Resources.getImage("../assets/images/Chess_Board.png");
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(this.img,
                    0, 0,
                    600, 600,
                    this);
        }
    }

}
