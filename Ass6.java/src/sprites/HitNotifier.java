package sprites;

import listeners.HitListener;

/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public interface HitNotifier {
    /**
     * addHitListener.
     * Add hl as a listener to hit events.
     * @param hl hitListener
     */
     void addHitListener(HitListener hl);

    /**
     * removeHitListener.
     * Remove hl from the list of listeners to hit events.
     * @param hl the hit Listener.
     */
     void removeHitListener(HitListener hl);
}