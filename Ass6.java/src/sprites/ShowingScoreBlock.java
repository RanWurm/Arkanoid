package sprites;

import biuoop.DrawSurface;
import game.GameLevel;
import listeners.BallRemover;
import listeners.ScoreTrackingListener;

import java.awt.Color;
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 08.08.2022
 */
public class ShowingScoreBlock implements Sprite {
    private final int xLocation = 350;
    private final int yLocation = 22;

    private final ScoreTrackingListener scoreTrack;
    private final BallRemover lives;
    private final String LevelName;
    /**
     * Constructor.
     * @param s listeners.ScoreTrackingListener that contains the scoreTracker
     */
    public  ShowingScoreBlock(ScoreTrackingListener s,BallRemover ballsNum,String lvlName) {
        this.scoreTrack = s;
        this.LevelName = lvlName;
        this.lives = ballsNum;
    }
    /**
     * addToGame.
     * adds the block to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * drawOn.
     * draw the block on the surface.
     * @param d the surface given.
     */
    @Override
    public void drawOn(DrawSurface d) {
        String score = String.valueOf(scoreTrack.getCurrentScore().getValue());
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 1, 800, yLocation);
        d.setColor(Color.BLACK);
        d.drawText(xLocation, yLocation - 1, "Score :" + score, 15);
        d.drawText(xLocation / 3, yLocation - 1, "Lives :" + lives.getRemainingBalls().getValue(), 15);
        d.drawText(xLocation + 200, yLocation -2, "Level Name :" + LevelName, 15);
    }

    /**
     * timePassed.
     * does nothing there is other method that deal with it.
     */
    @Override
    public void timePassed() {

    }
}
