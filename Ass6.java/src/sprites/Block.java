package sprites;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import biuoop.DrawSurface;
import game.GameLevel;
import geometry.Velocity;
import listeners.HitListener;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final Point upperLeft;
    private final double width;
    private final double height;
    private final java.awt.Color color;
    private final List<HitListener> hitListeners;

    /**
     * timePassed.
     * method that implement the sprite interface.
     * actually does nothing,because we have other method that takes care of it,but its part of
     * the interface so need to be implemented.
     */
    @Override
    public void timePassed() {

    }
    /**
     * getColor.
     * returns the color of the ball
     * @return Color, the color of the ball.
     */
    public Color getColor() {
        return color;
    }

    /**
     * addToGame.
     * adds the block to the game
     * @param g the game class.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removeFromGame.
     * removes the block from the game.
     * @param g the game class.
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    /**
     * constructor.
     * @param rect an rectangle object that will be the base of the block.
     * @param color the color of the block
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.upperLeft = rect.getUpperLeft();
        this.width = rect.getWidth();
        this.height = rect.getHeight();
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * drawOn.
     * drawn the block on the surface.
     * @param surface the surface object that the block will be printed on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);


    }

    /**
     *getCollisionRectangle.
     * gets the rectangle base of the block,will be called when the block is being hit.
     * @return Geometry.Rectangle which is the rectangle base of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.upperLeft, this.width, this.height);
    }

    /**
     * hit.
     * this method will check on which of the block lines the ball hitted,
     * then it will notify the block remover of the hit and will change the ball,
     * velocity accordingly.
     * @param hitter the ball that hit the block
     * @param collisionPoint the exact point of the hit.
     * @param currentVelocity the current velocity of the ball.
     * @return geometry.Velocity, a new velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line interPoint = new Line(collisionPoint, collisionPoint);
        Line[] recLines = this.getCollisionRectangle().getRectangleLines();
        int flag = 0;
        double curDx = currentVelocity.getDx();
        double curDy = currentVelocity.getDy();
        // rectlines[0] is the upper line and rectlines[3] is the down line
        if (recLines[0].isIntersecting(interPoint) || recLines[3].isIntersecting(interPoint)) {
            curDy *= -1;
            flag = 1;
        }
        // rectLines[1] is the left line and rectLines[2] is the right line.
        if (recLines[1].isIntersecting(interPoint) || recLines[2].isIntersecting(interPoint)) {
            curDx *= -1;
            flag = 1;
        }
        if (flag == 1) {
            this.notifyHit(hitter);
        }
        return new Velocity(curDx, curDy);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
