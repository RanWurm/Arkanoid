package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * decorator, incharge of all the stoppable animations.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor keyboard;
    private final String endKey;
    private final Animation animation;

    private boolean stop;

    /**
     * constructor.
     * @param sensor keyboard sensor.
     * @param key the key that end the screen.
     * @param animation the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.endKey = key;
        this.animation = animation;
        this.stop = true;
    }
    /**
     * does one frame.
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(endKey)) {
            this.stop = false;
        }
    }
    /**
     * indicates if the loop should stop.
     * @return boolean.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}