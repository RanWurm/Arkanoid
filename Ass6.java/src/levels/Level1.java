package levels;
import animations.directHitBackGround;
import geometry.Rectangle;
import geometry.Velocity;

import sprites.Block;
import sprites.Sprite;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level1 implements LevelInformation {
    private final int NUMBER_OF_BALLS = 1;
    private final int PADDLE_SPEED = 5;
    private final int PADDLE_WIDTH = 150;
    final String LEVEL_NAME = "Direct Hit";
    private final Velocity velocity = new Velocity(0, -7);

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velList = new ArrayList<>();
        velList.add(this.velocity);
        return velList;
    }

    @Override
    public int paddleSpeed() {
        return this.PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return this.PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return this.LEVEL_NAME;
    }

    @Override
    public Sprite getBackground() {
        return new directHitBackGround();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Rectangle rect = new Rectangle(385, 135, 30, 30);
        Block b = new Block(rect, Color.RED);
        blockList.add(b);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
