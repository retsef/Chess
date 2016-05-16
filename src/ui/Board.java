package ui;

import engine.*;
import interfaces.BoardInterface;
import javafx.util.Pair;
import pieces.Piece;
import ui.Square.*;
import util.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by roberto on 15/05/16.
 */
public class Board extends JPanel implements BoardInterface {

    private Background background;
    private HashMap<Coordinate, Square> checkerboard;
    private ActionListner actionListner;
    private BoardInterface game_boardinterface;

    public Board() {
        super();

        checkerboard = new HashMap<>();

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

            square.setBounds((i%8)*71+18, row*71+8, 70, 82);

            square.setActionCommand(coordinate.toString());
            square.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Coordinate c = new Coordinate(e.getActionCommand());
                    actionListner.OnClick(c);
                }
            });

            this.add(square);
        }
    }

    public void setActionListner(ActionListner actionListner) {
        this.actionListner = actionListner;
    }

    public void setGame_boardinterface(BoardInterface game_boardinterface) {
        this.game_boardinterface = game_boardinterface;
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
                    coordinate = new Coordinate(Coordinate.ROW.values()[i%8], i>7?1:2);
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

    @Override
    public void movePiece(Piece piece, Coordinate c) {
        Square square_start = checkerboard.get(piece.getCoordinate());
        Square square_end = checkerboard.get(c);

        square_start.removeIcon();
        square_end.setIcon(new ImageIcon(piece.getImage()));

        square_start.repaint();
        clearHightlightSquares();
    }

    @Override
    public void hightlightSquares(List<Coordinate> coordinateList) {
        clearHightlightSquares();

        for(Coordinate c : coordinateList)
            checkerboard.get(c).setContentAreaFilled(true);
    }

    @Override
    public void clearHightlightSquares() {
        for(Map.Entry<Coordinate, Square> pair: checkerboard.entrySet())
            pair.getValue().setContentAreaFilled(false);
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
