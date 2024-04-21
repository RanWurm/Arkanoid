package sprites;

import biuoop.DrawSurface;
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 08.08.2022
 */
public interface Sprite {
    /**
     * drawOn.
     * draw the sprite to the screen
     * @param d the surface.
     */
    void drawOn(DrawSurface d);
    /**
     * timePassed.
     * notify the sprite that time has passed
     */
    void timePassed();
}