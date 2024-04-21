package game;

import animations.AnimationRunner;
import animations.EndScreen;
import animations.KeyPressStoppableAnimation;


import biuoop.KeyboardSensor;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.LevelInformation;
import listeners.ScoreTrackingListener;
import sprites.Counter;


import java.util.ArrayList;
import java.util.List;

/**
 * in-charge of the game flow.
 */
public class GameFlow {
    private final KeyboardSensor keyboardSensor;
    private final AnimationRunner animationRunner;
    private final String win = "Win";
    private final String lose = "Lose";

    /**
     * constructor.
     * @param ar animation runner.
     * @param ks keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        animationRunner = ar;
        keyboardSensor = ks;

    }

    /**
     * LevelInformation creates the level requested.
     * @param indexList list of index's
     * @return list of levels.
     */
    public List<LevelInformation> createLevels(List<String> indexList) {
        List<LevelInformation> levelsList = new ArrayList<>();
        List<Integer> indexInInts = new ArrayList<>();

        for (String index : indexList) {
            try {
                indexInInts.add(Integer.parseInt(index));
            } catch (Exception e) {
                continue;
            }
        }
        for (int i = 0; i < indexInInts.size(); i++) {
            switch (indexInInts.get(i)) {
                case 1:
                    levelsList.add(new Level1());
                    break;
                case 2:
                    levelsList.add(new Level2());
                    break;
                case 3:
                    levelsList.add(new Level3());
                    break;
                case 4:
                    levelsList.add(new Level4());
                    break;
                default:
                    continue;
            }
        }
        return levelsList;
    }
    /**
     * runs the levels.
     * @param levels level list.
     */
    public void runLevels(List<LevelInformation> levels) {
        int counter = levels.size();
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(new Counter());
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner);
            level.setScoreTrack(scoreTrack);
            level.initialize();
            while (level.isRunning()) {
                level.run();
                counter--;
                    if (level.isLevelWon()) {
                        if (counter == 0) {
                            animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                                    new EndScreen(scoreTrack.getCurrentScore().getValue(), keyboardSensor, win)));
                        }
                    break;
                }
                if (level.levelFaild()) {
                    animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                            new EndScreen(scoreTrack.getCurrentScore().getValue(), keyboardSensor, lose)));
                    System.exit(0);
                }
            }
        }

        System.exit(0);
    }
}