package animations;
import biuoop.DrawSurface;
import sprites.Sprite;

import java.awt.Color;
import java.util.Random;

/**
 * wide and easy background.
 */

public class WideAndEasyBackGround implements Sprite {
    /**
     * constructor.
     */
    public WideAndEasyBackGround() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        Random rand = new Random();
        d.setColor(new Color(0x398596));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.ORANGE);
        int x = 120;
        for (int i = 0; i < 810; i += 5) {
            d.drawLine(x, x, i, rand.nextInt(500));
        }
        d.fillCircle(120, 120, 85);
        d.setColor(new Color(0x800505));
        d.fillCircle(90, 105, 10);
        d.fillCircle(150, 105, 10);
        d.setColor(Color.white);
        d.fillCircle(90, 110, 4);
        d.fillCircle(150, 110, 4);
        d.setColor(new Color(0x800505));
        d.drawLine(70, 70, 105, 95);
        d.drawLine(135, 95, 165, 70);
        d.drawLine(110, 110, 110, 140);
        d.drawLine(130, 110, 130, 140);
        d.drawLine(110, 140, 120, 150);
        d.drawLine(130, 140, 120, 150);
        d.drawOval(98, 155, 50, 25);
    }
    @Override
    public void timePassed() {

    }
}
