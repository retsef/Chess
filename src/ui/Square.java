package ui;

import engine.Coordinate;

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

    public Square() {
        super();
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        this.setBackground(new Color(239,204,58,180));

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
    }

    public static interface ActionListner {
        public void OnClick(Coordinate c);
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        //super.setIcon(defaultIcon);
        this.icon = defaultIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (icon != null) {
            SwingUtilities.calculateInnerArea(this, innerArea);

            g.drawImage(((ImageIcon)icon).getImage(),
                    innerArea.x-25, innerArea.y-5,
                    //innerArea.width, innerArea.height,
                    this);
        }
    }

}
