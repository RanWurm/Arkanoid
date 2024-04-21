package tests;

import biuoop.DrawSurface;
import biuoop.GUI;


import java.awt.Color;
import java.awt.Polygon;


public class testGraphics {


    public static void main(String[] args) {
        GUI g = new GUI("Arkanoid", 800, 600);

        DrawSurface d = g.getDrawSurface();
        d.setColor(Color.black);
        d.drawLine(50,50,50-9,55);
        d.drawLine(50,50,50+9,45);
        g.show(d);



    }
}





