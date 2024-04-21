package animations;

import biuoop.DrawSurface;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * CountdownAnimation,class in-charge of the count-down animation.
 */
public class CountdownAnimation implements Animation {

    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean running = false;

    /**
     * constructor.
     * @param countFrom from which number start counting.
     * @param gameScreen all of the game sprites.
     */
    public CountdownAnimation(int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    /**
     * doOneFrame,does one frame.
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(new Color(0x8F0000));
        d.drawText(380 ,100,
                Integer.toString(countFrom), 50);
        countFrom -= 1;
        if (countFrom == 0) {
            running = true;
        }
    }
    /**
     * shouldStop,indcates that the loop should stop.
     * @return boolean true or false.
     */
    @Override
    public boolean shouldStop() {
        return running;
    }
}
