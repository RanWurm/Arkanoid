package levels;

import animations.NightLevelBackGround;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level3 implements LevelInformation {
    private final int NUMBER_OF_BALLS = 6;
    private final int PADDLE_SPEED = 5;
    private final int PADDLE_WIDTH = 150;
    private final String LEVEL_NAME = "Night Level";
    private NightLevelBackGround N_L_B = null;
    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velList.add(Velocity.fromAngleAndSpeed(250 + 10 * i, 5));
        }
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
        return new NightLevelBackGround();
    }

    /**
     * createBlocks.
     * this method will create the game blocks, will add them to the game sprites,
     * will increase the counter of the blocks.
     */
    @Override
    public List<Block> blocks() {
        ArrayList<Block> blockList = new ArrayList<>();
        java.awt.Color[] colors = {Color.WHITE, Color.red, Color.yellow, Color.blue, Color.pink, Color.WHITE};
        int rightBoarder = 780;
        int width = 51;
        int blockHeight = 20;
        int startHeight = 180;
        for (int i = 0; i < 5; i++) {
            for (int j = 10 - i; j > 0; j--) {
                Point p = new Point(rightBoarder - width * j, startHeight + blockHeight * i);
                Rectangle rect = new Rectangle(p, width, 20);
                Block b = new Block(rect, colors[i]);
                blockList.add(b);
            }
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}


