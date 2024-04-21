package geometry; //Ran Wurmbrand 315366039
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 08.08.2022
 */

public class Point {
    private final double x;
    private final double y;
    /**
     * constructor.
     * @param x x determinant.
     * @param y y determinant.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * distance -- return the distance of this point to the other point.
     * this class return the distance between 2 points.
     * @param other the other point.
     * @return distance the distance from point.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2));
    }
    /**
     * this class return true is the points are equal, false otherwise.
     * @param other the other point.
     * @return boolean val.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        if (this.x != other.x || this.y != other.y) {
            return false;
        }
        return true;
    }
    /**
     * get the x value of a point.
     * @return x value.
     */
    public double getX() {
        return this.x;
    }
    /**
     *get the y value of a point.
     * @return y val.
     */
    public double getY() {
        return this.y;
    }
}