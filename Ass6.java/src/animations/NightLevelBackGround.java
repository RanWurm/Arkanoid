package animations;

import biuoop.DrawSurface;
import sprites.Sprite;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Polygon;

/**
 * incharge of the night level background// level 2.
 */
public class NightLevelBackGround implements Sprite {
    private final ArrayList<Polygon> stars = new ArrayList<>();
    /**
     * It draws a star.
     *
     * @param x    the x coordinate of the center of the star
     * @param y    The y coordinate of the center of the star.
     * @param size The size of the star.
     * @return Star new star.
     */
    private static Polygon star(int x, int y, int size) {
        y = y + 5;
        int[] xPnts = {x, x - 2 * size, x - 8 * size, x - 3 * size, x - 4 * size, x, x + 4 * size,
                x + 3 * size, x + 8 * size, x + 2 * size};
        int[] yPnts = {y - 2 * size, y + 3 * size, y + 3 * size, y + 6 * size, y + 12 * size,
                y + 8 * size, y + 12 * size, y + 6 * size, y + 3 * size, y + 3 * size};
        return new Polygon(xPnts, yPnts, xPnts.length);

    }

    /**
     * create stars array.
     */
    private void createStars() {
        Random rand = new Random();
        for (int i = 0; i < 60; i++) {
            int x = rand.nextInt(800);
            int y = rand.nextInt(150);
            stars.add(star(x, y, 1));
        }
    }
    @Override
    public void drawOn(DrawSurface d) {
    if (stars.isEmpty()) {
        createStars();
    }
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        for (Polygon p :stars) {
            d.setColor(new Color(255, 240, 158));
            d.fillPolygon(p);
            d.setColor(Color.BLACK);
            d.drawPolygon(p);
        }
        d.setColor(new Color(0x562323));
        d.fillRectangle(60, 400, 120, 200);
        d.setColor(new Color(0x3B3B67));
        d.fillRectangle(75, 415, 90, 200);
        d.setColor(new Color(0x562323));
        for (int i = 1; i < 4; i++) {
            d.fillRectangle(60 + 28 * i, 400, 8, 200);
        }
        for (int j = 1; j < 10; j++) {
            d.fillRectangle(60, 415 + 28 * j, 120, 8);
        }
        d.setColor(Color.darkGray);
        d.fillRectangle(100, 360, 30, 40);
        d.setColor(new Color(0x252528));
        d.fillRectangle(110, 210, 10, 150);
        d.setColor(new Color(0xFFFF76));
        d.fillCircle(114, 170, 52);
        d.setColor(new Color(0xD2D218));
        d.fillCircle(114, 170, 48);
        d.setColor(new Color(0xB7B744));
        d.fillCircle(114, 170, 45);
        d.setColor(new Color(0x7E0606));
        d.fillCircle(98, 160, 5);
        d.fillCircle(128, 160, 5);
        d.drawLine(90, 150, 105, 155);
        d.drawLine(120, 155, 135, 150);
        d.drawLine(111, 170, 111, 181);
        d.drawLine(118, 170, 118, 181);
        d.drawLine(111, 181, 113, 185);
        d.drawLine(118, 181, 113, 185);
        d.drawOval(107, 190, 18, 10);
        d.setColor(Color.white);
        d.fillCircle(98, 162, 1);
        d.fillCircle(128, 162, 1);
    }

    @Override
    public void timePassed() {

    }
}
