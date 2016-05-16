package ui;

import engine.Coordinate;
import util.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by roberto on 15/05/16.
 */
public class Square extends JButton {

    private Icon icon;
    private final Rectangle innerArea = new Rectangle();

    private Icon highlight;

    public Square() {
        super();
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        //hightlight_on = new Color(239,204,58,180);
        this.setBackground(new Color(0,0,0,0));

        try {
            this.highlight = new ImageIcon(Resources.getImage("../assets/images/highlight.png"));
        } catch (Exception e) { e.printStackTrace(); }
        /*
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent m) {
                setBackground(new Color(239,204,58,200));
            }
            @Override
            public void mouseExited(MouseEvent m) {
                setBackground(new Color(239,204,58,180));
            }
        });
        */
    }

    public static interface ActionListner {
        public void OnClick(Coordinate c);
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        //super.setIcon(defaultIcon);
        this.icon = defaultIcon;
    }

    public void removeIcon() {
        this.icon = null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SwingUtilities.calculateInnerArea(this, innerArea);

        //paint background
        if(isContentAreaFilled()) {
            g.drawImage(((ImageIcon)this.highlight).getImage(),
                    0, innerArea.y+5,
                    this);
        }

        //paint icon
        if (icon != null) {

            g.drawImage(((ImageIcon)this.icon).getImage(),
                    innerArea.x-25, innerArea.y-5,
                    //innerArea.width, innerArea.height,
                    this);
        }

    }

}
