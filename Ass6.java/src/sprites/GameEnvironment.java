package sprites;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import sprites.Collidable;
import sprites.CollisionInfo;

import java.util.ArrayList;
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public class GameEnvironment {
    private final ArrayList<Collidable> collidables;
    /**
     * constructor.
     * initialize the list.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * getCollidables.
     * returns the collidable list member of th class.
     * @return List, list that contains all of the collidables.
     */
    public ArrayList<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * addCollidable.
     * this method will add collidable to the list.
     * @param c an collidable object.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }
    /**
     * checks if object in list,and removes it if it does.
     * @param c the sprites.Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * isEmpty.
     * @return checks if the list is empty.
     */
    public boolean isEmpty() {
        return this.collidables.isEmpty();
    }

    /**
     * getClosestCollision.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory Geometry.Line, which is the trajectory line/
     * @return Collision info that contains the closest point of the first object that will
     * be hit.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point pToReturn = null;
        Collidable collided;
        if (collidables.size() == 0) {
            return null;
        }
        Rectangle r = collidables.get(0).getCollisionRectangle();
        collided = collidables.get(0);
        pToReturn = trajectory.closestIntersectionToStartOfLine(r);
        for (int i = 1; i < collidables.size(); i++) {
            Rectangle rect = collidables.get(i).getCollisionRectangle();
            Point tmp = trajectory.closestIntersectionToStartOfLine(rect);
            if (pToReturn == null) {
                pToReturn = trajectory.closestIntersectionToStartOfLine(rect);
                collided = collidables.get(i);
            } else {
                if (tmp != null && trajectory.start().distance(pToReturn) >= trajectory.start().distance(tmp)) {
                    pToReturn = tmp;
                    collided = collidables.get(i);
                }
            }
        }
        if (pToReturn == null) {
            return null;
        }
        return new CollisionInfo(pToReturn, collided);
    }

}
