package animations;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * incharge of losing screen.
 */
public class LosingScreen implements Animation {
    private final int finalScore;
    private final KeyboardSensor keyboard;
    private Boolean stop = true;

    /**
     * constructor.
     * @param score curr score.
     * @param keyboard keyboard sensor.
     */
    public LosingScreen(int score, KeyboardSensor keyboard) {
        this.finalScore = score;
        this.keyboard = keyboard;
    }

    /**
     * does one frame.
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is: " + finalScore, 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
