package animations;
import biuoop.DrawSurface;
import biuoop.GUI;
import game.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * the direct hit back ground.
 */
public class directHitBackGround implements Sprite {
    /**
     * constructor.
     */
    public directHitBackGround() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x1E1C1C));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(0x070785));
        d.drawCircle(400, 150, 150);
        d.drawCircle(400, 150, 100);
        d.drawCircle(400, 150, 50);
        d.drawLine(220, 150, 380, 150);
        d.drawLine(420, 150, 580, 150);
        d.drawLine(400, 0, 400, 130);
        d.drawLine(400, 170, 400, 325);
    }

    /**
     * timePassed. does nothing but in interface.
     */
    @Override
    public void timePassed() {

    }
}
