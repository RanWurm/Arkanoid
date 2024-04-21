package levels;
import animations.WideAndEasyBackGround;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level2 implements LevelInformation {
    private final int SPEED = 20;
    private final int NUMBER_OF_BALLS = 10;
    private final int PADDLE_SPEED = 5;
    private final int PADDLE_WIDTH = 650;
    private final String LEVEL_NAME = "Noob Level";

    @Override
    public int numberOfBalls() {
        return this.NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
       ArrayList<Velocity> velList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
           velList.add(Velocity.fromAngleAndSpeed(230 + 10 * i, 5));
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
        return new WideAndEasyBackGround();
    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        java.awt.Color[] colors = {Color.gray, Color.red, Color.yellow, Color.blue, Color.pink, Color.WHITE};
        int counter = 0;
        for (int i = 0; i < 15; i++) {
            Rectangle r = new Rectangle(22.5 + 51 * i, 270, 51, 20);
            Block b = new Block(r, colors[(counter / 2) % 6]);
            blocks.add(b);
            counter++;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
