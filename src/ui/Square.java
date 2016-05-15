package ui;

import engine.Coordinate;

import javax.swing.*;
import java.awt.*;

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
