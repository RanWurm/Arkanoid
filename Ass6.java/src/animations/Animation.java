package animations;

import biuoop.DrawSurface;

/**
 * the is an interface incharge of animations
 */
public interface Animation {
    /**
     * doOneFrame, does 1 frame.
     * @param d draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop, indicate that the loop should stop.
     * @return Boolean, true or false.
     */
    boolean shouldStop();
}