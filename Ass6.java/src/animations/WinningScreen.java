package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * in-charge of winning screen.
 */

public class WinningScreen implements Animation {
    private final int finalScore;
    private final KeyboardSensor keyboard;
    private Boolean stop = true;

    /**
     * constructor.
     * @param score current score.
     * @param keyboard keyboard sensor.
     */

    public WinningScreen(int score, KeyboardSensor keyboard) {
        this.finalScore = score;
        this.keyboard = keyboard;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Won! Your score is: " + finalScore, 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
