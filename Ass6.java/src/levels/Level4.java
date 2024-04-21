package levels;


import animations.NightLevelBackGround;
import animations.OvadSabihBackGround;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level4 implements LevelInformation {
    private final int NUMBER_OF_BALLS = 3;
    private final int PADDLE_SPEED = 5;
    private final int PADDLE_WIDTH = 150;
    private final String LEVEL_NAME = "Ovads Sabih!";
    private final Velocity velocity = new Velocity(1, -1);
    private OvadSabihBackGround O_S_B = null;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        ArrayList<Velocity> velList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            velList.add(Velocity.fromAngleAndSpeed(250 + 20 * i, 5));
        }
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
        if (this.O_S_B == null) {
            this.O_S_B = new OvadSabihBackGround();
            return this.O_S_B;
        } else{
            return this.O_S_B;
        }
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
        int startBlock = 600;
        int width = 51;
        int blockHeight = 20;
        int startHeight = 300;
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 9 - i; j++) {
                geometry.Point p = new geometry.Point(startBlock - width * j, startHeight - blockHeight * i);
                geometry.Rectangle rect = new Rectangle(p, width, 20);
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
