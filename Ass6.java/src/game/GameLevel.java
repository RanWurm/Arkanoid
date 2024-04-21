package game;

import animations.LosingScreen;
import animations.Animation;
import animations.PauseScreen;
import animations.CountdownAnimation;
import animations.AnimationRunner;
import animations.KeyPressStoppableAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import geometry.Velocity;
import levels.LevelInformation;
import listeners.BallRemover;
import listeners.BlockRemover;
import geometry.Rectangle;
import geometry.Point;
import listeners.ScoreTrackingListener;
import sprites.Ball;
import sprites.Block;
import sprites.Collidable;
import sprites.Counter;
import sprites.GameEnvironment;
import sprites.Sprite;
import sprites.Paddle;
import sprites.ShowingScoreBlock;
import sprites.SpriteCollection;

import java.awt.Color;
import java.util.List;

/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Sleeper sleeper;
    private BallRemover ballRemover;
    private BlockRemover blockRemovers;
    private ScoreTrackingListener scoreTrack;
    private final AnimationRunner runner;
    private final KeyboardSensor keyboard;
    private boolean running = true;
    private final LevelInformation lvl;

    /**
     * constructor.
     * @param lvl the level.
     * @param k the keyboard sensor.
     * @param runner the animation runner.
     */
    public GameLevel(LevelInformation lvl, KeyboardSensor k, AnimationRunner runner) {
        this.lvl = lvl;
        this.keyboard = k;
        this.runner = runner;
    }
    /**
     * addCollidable.
     * adds colliable to the game environment.
     *
     * @param c collidable.
     */

    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * addSprite.
     * add sprite to the sprite collection.
     *
     * @param s the sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * getScoreTrack.
     * gets thh scoreTracker of the game.
     *
     * @return listeners.ScoreTrackingListener, the scoreTracker of the game.
     */
    public ScoreTrackingListener getScoreTrack() {
        return scoreTrack;
    }
    /**
     * initialize.
     * Initialize a new game: create the Blocks and sprites.Ball (and sprites.Paddle)
     * and add them to the game.
     */
    public void initialize() {
        sleeper = new Sleeper();
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        blockRemovers = new BlockRemover(this, new Counter());
        ballRemover = new BallRemover(this, new Counter());
        addSprite(lvl.getBackground());
        Paddle paddle = new Paddle(keyboard, lvl.paddleWidth());
        paddle.addToGame(this);
        List<Block> b = lvl.blocks();
        createBlocks(b);
        ballsFactory(lvl.numberOfBalls(), lvl.initialBallVelocities());
        createScreenBoundary(lvl.levelName());

    }

    /**
     * ballsFactory.
     * this method creates balls.
     * @param velList list of velocities.
     * @param numOfBalls int, the number of ball wanted.
     */
    public void ballsFactory(int numOfBalls, List<Velocity> velList) {
        for (int i = 0; i < numOfBalls; i++) {
            Ball ball = new Ball(390 + 6 * i, 554, 6, Color.BLACK);
            Velocity v = velList.get(i);
            ball.setVelocity(v.getDx(), v.getDy());
            ball.addToGame(this);
            ball.setColor(new Color(0xFF0000));
            ballRemover.getRemainingBalls().increase(1);
            ball.setGameEnvironment(environment);
        }
    }
    /**
     * createScreenBoundary.
     * this method creates the screen block boundary, the upper block will show the current score,
     * the lower will be called death region meaning that if will remove any ball that hits it,by notify
     * the ball remover.
     * also it will add the block to the game sprites.
     * @param name name of game.
     */
    public void createScreenBoundary(String name) {
        Rectangle rectangle = new Rectangle(new Point(0, 0), 800, 40);
        Block scoreShowingRect = new Block(rectangle, Color.gray);
        Rectangle rectangle2 = new Rectangle(new Point(0, 0), 20, 600);
        Block block2 = new Block(rectangle2, Color.gray);
        Rectangle rectangle3 = new Rectangle(new Point(781, 0), 20, 600);
        Block block3 = new Block(rectangle3, Color.gray);
        Rectangle rectangle4 = new Rectangle(new Point(0, 599), 800, 1);
        Block deathRegion = new Block(rectangle4, Color.darkGray);
        deathRegion.addHitListener(this.ballRemover);
        Block[] blocks = new Block[]{deathRegion, block2, block3, scoreShowingRect};
        for (Block b : blocks) {
            b.addToGame(this);
        }
        ShowingScoreBlock sh = new ShowingScoreBlock(this.scoreTrack, this.ballRemover, name);
        sh.addToGame(this);
    }
    /**
     * createBlocks.
     * this method will create the game blocks, will add them to the game sprites,
     * will increase the counter of the blocks.
     * @param blocks list of blocks.
     */
    public void createBlocks(List<Block> blocks) {
        for (Block b : blocks) {
            b.addToGame(this);
            b.addHitListener(blockRemovers);
            blockRemovers.getRemainingBlocks().increase(1);
        }
    }
    /**
     * run.
     * Run the game -- start the animation loop.
     */
    public void run() {
        CountdownAnimation cD = new CountdownAnimation(3, sprites);
        runner.setFramesPerSecond(1);
        this.runner.run(cD);
        runner.setFramesPerSecond(60);
        this.runner.run(this);
    }
    /**
     * removeCollidable.
     * this method will remove the coliidable from game environment.
     *
     * @param c the collidable need to be removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * removes the sprite from sprite Collection.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("P") || this.keyboard.isPressed("פ")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(keyboard)));
        } else {
            d.setColor(Color.DARK_GRAY);
            d.fillRectangle(0, 0, 800, 700);
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
            if (this.levelFaild()) {
                this.running = false;
                this.runner.run(new LosingScreen(getScoreTrack().getCurrentScore().getValue(), keyboard));
            }
            if (this.blockRemovers.getRemainingBlocks().getValue() == 0) {
                scoreTrack.getCurrentScore().increase(100);
                this.running = false;
            }
        }
    }
    @Override
    public boolean shouldStop() {
        return this.running;
    }

    /**
     * indicates if the game should run.
     * @return boolean.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * checks if the level failed.
     * @return boolean.
     */
    public boolean levelFaild() {
        if (this.ballRemover.getRemainingBalls().getValue() == 0) {
            return true;
        }
        return false;
    }
    /**
     * checks if the level won.
     * @return boolean.
     */
    public boolean isLevelWon() {
        if (this.blockRemovers.getRemainingBlocks().getValue() == 0) {
            return true;
        }
        return false;
    }

    /**
     * sets the level score tracker.
     * @param scoreTrack score tracker.
     */
    public void setScoreTrack(ScoreTrackingListener scoreTrack) {
        this.scoreTrack = scoreTrack;
    }
}

