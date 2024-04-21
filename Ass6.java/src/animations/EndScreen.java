package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * EndScreen,in-charge of the end screen.
 */
public class EndScreen implements Animation {
    private final int finalScore;
    private final KeyboardSensor keyboard;
    private Boolean stop = true;
    private String levelStatus;

    /**
     * constructor.
     * @param score the curr score.
     * @param key the keyboard.
     * @param s the status of the game,(win or lose).
     */
    public EndScreen(int score, KeyboardSensor key, String s) {
       this.finalScore = score;
       this.keyboard = key;
       levelStatus = s;
   }
    /**
     * doOneFrame,does one frame.
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (levelStatus.equals("Win")) {

            d.drawText(10, d.getHeight() / 2, "You Won! Your score is: " + finalScore, 32);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = false;
            }
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is: " + finalScore, 32);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = false;
            }
        }
    }
    /**
     * shouldStop, indicates that the loop should stop.
     * @return boolean true / false.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
