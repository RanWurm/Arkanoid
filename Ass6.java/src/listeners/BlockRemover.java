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
public class BlockRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBlocks;

    /**
     * constructor.
     * @param game the game object.
     * @param remainingBlocks the blocks counter.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * getRemainingBlocks.
     * return the object counter.
     * @return counter the object counter.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * getGame.
     * returns the class game member.
     * @return game.Game. the game member.
     */
    public GameLevel getGame() {
        return game;
    }
    /**
     * hitEvent.
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     * @param beingHit the block that was hit.
     * @param hitter the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        game.getScoreTrack().hitEvent(beingHit, hitter);
        this.remainingBlocks.decrease(1);
    }
}
