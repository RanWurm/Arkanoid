package animations;

import biuoop.DrawSurface;
import sprites.Sprite;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import java.util.Random;

/**
 * fourth level,ovad Sabih.
 */
public class OvadSabihBackGround implements Sprite {
    private final ArrayList<Polygon> stars = new ArrayList<>();
    private int k = 0;
    private int m = 0;
    private int ovadsWordCounter = 0;

    private static Polygon star(int x, int y, int size) {
        y = y + 5;
        int[] xPnts = {x, x - 2 * size, x - 8 * size, x - 3 * size, x - 4 * size, x, x + 4 * size,
                x + 3 * size, x + 8 * size, x + 2 * size};
        int[] yPnts = {y - 2 * size, y + 3 * size, y + 3 * size, y + 6 * size, y + 12 * size,
                y + 8 * size, y + 12 * size, y + 6 * size, y + 3 * size, y + 3 * size};
        return new Polygon(xPnts, yPnts, xPnts.length);

    }

    private void createStars() {
        Random rand = new Random();
        for (int i = 0; i < 60; i++) {
            int x = rand.nextInt(800);
            int y = rand.nextInt(150);
            stars.add(star(x, y, 1));
        }
    }

    /**
     * draw clouds.
     *
     * @param d draw surface.
     * @param i factor of location.
     */
    public void drawClouds(DrawSurface d, int i) {
        if(70 + 50 * i + k > 1250){
             this.k = -600;
        }
        d.setColor(new Color(0xA29D96));
        d.fillCircle(100 + 50 * i + k, 235 + m , 25);
        d.setColor(new Color(0x59595B));
        d.fillCircle(90 + 50 * i + k, 210 + m , 24);
        d.setColor(new Color(0x81818F));
        d.fillCircle(125 + 50 * i + k, 203 + m, 20);
        d.setColor(new Color(0xC0C0D5));
        d.fillCircle(135 + 50 * i + k, 230 + m, 21);
        d.setColor(new Color(0xC0C0D5));
        d.fillCircle(130 + 50 * i + k, 235 + m, 13);
        d.setColor(new Color(0xA29D96));
        d.fillCircle(70 + 50 * i + k, 220 + m, 25);
        d.setColor(new Color(0x59595B));
        d.fillCircle(70 + 50 * i + k, 195 + m, 24);
        d.setColor(new Color(0x81818F));
        d.fillCircle(85 + 50 * i + k, 188 + m, 20);
        d.setColor(new Color(0xC0C0D5));
        d.fillCircle(95 + 50 * i + k, 215 + m, 21);
        d.setColor(new Color(0xC0C0D5));
        d.fillCircle(90 + 50 * i + k, 220 + m, 13);
    }
    private void writeOvadText(DrawSurface d){
        d.setColor(Color.black);
        int y = this.ovadsWordCounter / 150;
        switch (y  % 8){
            case 0 :
                d.drawText(55, 370, "Kama Kama", 20);
                d.drawText(70, 390, "Baderbi?", 20);
                break;
            case 1:
                d.drawText(65, 370, "Lehatzel?", 20);
                break;
            case 2:
                d.drawText(65, 370, "kal?", 20);
                break;
            case 3:
                d.drawText(65, 370, "Beinoni?", 20);
                break;
            case 4:
                d.drawText(65, 370, "kavaed?", 20);
                break;
            case 5:
                d.drawText(65, 370, "Massivi?", 20);
                break;
            case 6:
                d.drawText(65, 370, "Agressivi?", 20);
                break;
            case 7:
                d.drawText(65, 370, "Lehametz?", 20);
                break;
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.k += 1;
        this.ovadsWordCounter++;
        d.setColor(Color.black);
        d.setColor(new Color(0x3C3C48));
        d.fillRectangle(0, 0, 800, 600);
        if (stars.isEmpty()) {
            createStars();
        }
        for (Polygon p : stars) {
            d.setColor(new Color(255, 240, 158));
            d.fillPolygon(p);
            d.setColor(Color.BLACK);
            d.drawPolygon(p);
        }

        d.setColor(new Color(0x4D2A2A));
        d.fillRectangle(200, 380, 350, 220);
        d.setColor(new Color(0xA1A1B4));
        d.fillRectangle(214, 414, 320, 200);
        d.setColor(new Color(0x9A9191));
        d.fillRectangle(214, 520, 320, 80);
        d.setColor(new Color(0x562323));
        d.setColor(Color.black);
        d.fillRectangle(250, 490, 2, 30);
        d.drawLine(250, 502, 240, 510);
        d.drawLine(253, 502, 263, 510);
        Polygon tri = new Polygon(new int[]{200, 375, 550}, new int[]{380, 340, 380}, 3);
        d.setColor(Color.black);
        d.drawText(235, 400, "The best Meal in the Universe!", 20);
        d.fillPolygon(tri);
        writeOvadText(d);
        d.setColor(new Color(0x916F2F));
        d.fillCircle(251, 482, 8);
        d.setColor(new Color(0xB78738));
        d.fillCircle(251, 482, 6);
        d.setColor(new Color(0x7E0606));
        d.fillCircle(248, 482, 1);
        d.fillCircle(252, 482, 1);
        d.fillOval(248, 484, 5, 2);
        Polygon tri2 = new Polygon(new int[]{248, 100, 130}, new int[]{484, 430, 430}, 3);
        d.fillPolygon(tri2);
        d.setColor(Color.white);
        d.fillOval(35, 330, 150, 100);
        d.drawLine(90, 150, 105, 155);
        d.drawLine(120, 155, 135, 150);
        d.drawLine(111, 170, 111, 181);
        d.drawLine(118, 170, 118, 181);
        d.drawLine(111, 181, 113, 185);
        d.drawLine(118, 181, 113, 185);
        d.drawOval(107, 190, 18, 10);
        d.setColor(Color.black);

///angrey sun
        d.setColor(new Color(0xFFFFFF));
        d.fillCircle(114, 170, 52);
        d.setColor(new Color(0xD2D2C5));
        d.fillCircle(114, 170, 48);
        d.setColor(new Color(0xD7C2C2));
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
        for (int j = 0; j < 3; j++) {
            drawClouds(d, j);
        }
        this. m =40;
        for (int j = 3; j < 4; j++) {
            drawClouds(d, j);
        }
        this.m = -30;
        for (int j = 5; j < 8; j++) {
            drawClouds(d, j);
        }
        this.m = 30;
        for (int j = 7; j < 10; j++) {
            drawClouds(d, j);
        }
        this.m = 0;
        writeOvadText(d);
    }


    @Override
    public void timePassed() {

    }
}

