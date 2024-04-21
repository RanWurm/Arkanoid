package listeners;

import game.GameLevel;
import sprites.Ball;
import sprites.Block;
import sprites.Counter;

/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */

public class BallRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBalls;

    /**
     * constructor.
     * @param game the game.
     * @param counter counter class in charge of simple math operators.
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        this.remainingBalls = counter;
    }

    /**
     * getRemainingBalls.
     * getter methods returning the class counter memeber.
     * @return the class counter member.
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
