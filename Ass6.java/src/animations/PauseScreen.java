package animations;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the pause screen class.
 */
public class PauseScreen implements Animation {
    private final KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k the keyboard.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = false;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
