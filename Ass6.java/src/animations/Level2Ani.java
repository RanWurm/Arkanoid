package animations;
import biuoop.DrawSurface;
import sprites.Sprite;

import java.awt.Color;
import java.util.Random;


public class Level2Ani implements Sprite {

public Level2Ani() {

}

    @Override
    public void drawOn(DrawSurface d) {
        Random rand = new Random();
        d.setColor(new Color(0x17515D));

    }
    @Override
    public void timePassed() {

    }
}
