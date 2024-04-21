package listeners;
import sprites.Ball;
import sprites.Block;

/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the sprites.Ball that's doing the hitting.
     * @param beingHit the collidable that being hhit
     * @param hitter the ball that hit the object.
     */

    void hitEvent(Block beingHit, Ball hitter);
}