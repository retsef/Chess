package ui;

import interfaces.ArbitratorInterface;
import pieces.Piece;
import pieces.Rock;
import util.Resources;

import javax.swing.*;
import java.awt.*;

/**
 * Created by roberto on 20/05/16.
 */
public class Arbitrator extends JPanel implements ArbitratorInterface {

    private Background background;

    private Piece.COLOR current_color;
    private JButton current_piece;
    private Piece black_piece;
    private Piece white_piece;

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public Arbitrator() {
        super();
        this.current_color = Piece.COLOR.White;

        _init();

        this.background = new Background(250, 600);
        this.add(this.background);
    }

    private void _init() {
        this.setLayout(null);
        this.setBounds(0,0,250,600);

        _init_history();
        _init_piece_status();
    }

    private void _init_history() {
        this.textArea = new JTextArea(5, 30);
        this.scrollPane = new JScrollPane(textArea);
        this.scrollPane.setBounds(10,160,230,430);
        //scrollPane.setPreferredSize(new Dimension(380, 100));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
    }

    private void _init_piece_status() {
        this.current_piece = new JButton();
        this.current_piece.setBounds(70, 10, 100, 100);
        this.current_piece.setContentAreaFilled(false);
        this.current_piece.setBorderPainted(false);
        this.current_piece.setFocusPainted(false);
        this.current_piece.setBackground(new Color(0,0,0,0));

        this.black_piece = new Rock(Piece.COLOR.Black);
        this.white_piece = new Rock(Piece.COLOR.White);

        switch (this.current_color) {
            case Black:
                this.current_piece.setIcon(new ImageIcon(black_piece.getImage()));
                break;
            case White:
                this.current_piece.setIcon(new ImageIcon(white_piece.getImage()));
                break;
            default:
                this.current_piece.setIcon(new ImageIcon(white_piece.getImage()));
                break;
        }

        this.add(current_piece);
    }

    @Override
    public void setCurrent_color(Piece.COLOR color) {
        this.current_color = color;

        switch (this.current_color) {
            case Black:
                this.current_piece.setIcon(new ImageIcon(black_piece.getImage()));
                break;
            case White:
                this.current_piece.setIcon(new ImageIcon(white_piece.getImage()));
                break;
            default:
                this.current_piece.setIcon(new ImageIcon(white_piece.getImage()));
                break;
        }
    }

    @Override
    public void notifyActionMove(String c) {
        this.textArea.append(c+"\n");
        //The pane auto-scrolls with each new response added
        this.textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    private class Background extends JPanel {
        private final Image img;

        public Background(int width, int height) {
            this.setSize(width, height);
            this.img = Resources.getImage("../assets/images/background.png");
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
