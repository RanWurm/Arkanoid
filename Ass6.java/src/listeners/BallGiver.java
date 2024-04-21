package listeners;

import game.GameLevel;
import geometry.Velocity;
import sprites.Ball;
import sprites.Block;
import sprites.Counter;

import java.util.ArrayList;
import java.util.List;

public class BallGiver implements HitListener {
    private final GameLevel game;
    private final Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game            the game object.
     * @param remainingBlocks the blocks counter.
     */
    public BallGiver(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * getRemainingBlocks.
     * return the object counter.
     *
     * @return counter the object counter.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * getGame.
     * returns the class game member.
     *
     * @return game.Game. the game member.
     */
    public GameLevel getGame() {
        return game;
    }
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            velList.add(Velocity.fromAngleAndSpeed(310 - 10 * i, -5));
        }
        return velList;
    }
    /**
     * hitEvent.
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the block that was hit.
     * @param hitter   the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {

        beingHit.removeFromGame(game);
        game.getScoreTrack().hitEvent(beingHit, hitter);
        //game.ballsFactory(10,initialBallVelocities());
        this.remainingBlocks.decrease(1);
    }
}