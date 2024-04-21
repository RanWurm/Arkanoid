package game;

import animations.AnimationRunner;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.LevelInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public class Ass6Game {

    /**
     * main.
     *
     * @param args argument from cmd.
     */
    public static void main(String[] args) {
        List<String> indexListFromArgs = new ArrayList<>();
        for (String s : args) {
            indexListFromArgs.add(s);
        }
        GUI g = new GUI("Arkanoid", 800, 600);
        KeyboardSensor kS = g.getKeyboardSensor();
        AnimationRunner aR = new AnimationRunner(g, 60);
        GameFlow gF = new GameFlow(aR, kS);
        List<LevelInformation> levels = gF.createLevels(indexListFromArgs);
        if (levels.isEmpty()) {
//            levels.add(new Level1());
//            levels.add(new Level2());
//            levels.add(new Level3());
//            levels.add(new Level4());
        }
        gF.runLevels(levels);
    }
}
