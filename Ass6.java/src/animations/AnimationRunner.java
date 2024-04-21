package animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * this class incharge of running the animations.
 */
public class AnimationRunner {
    private final GUI gui;
    private int framesPerSecond;
    private final Sleeper sleeper;

    /**
     * constructor.
     *
     * @param gui             the gui.
     * @param framesPerSecond frames per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
    }

    /**
     * run, runs the animation.
     *
     * @param animation the count down animation.
     */
    public void run(CountdownAnimation animation) {
        long sleepTime = 1000;
        while (!animation.shouldStop()) {
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            sleeper.sleepFor(sleepTime);
        }
    }

    /**
     * run, runs the game play animation.
     *
     * @param animation the game animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * setFramesPerSecond,sets how many frame per sec.
     *
     * @param framesPerSecond int ,frame per sec.
     */
    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }
}
