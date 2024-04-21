package geometry;

import java.util.ArrayList;
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 08.08.2022
 */
public class Rectangle {
    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * get the upper left Geometry.Point of the Geometry.Rectangle.
     * @return Geometry.Point upper-left point.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * return the width of the rectangle.
     * @return double rectangle width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * gets the height of the rectangle.
     * @return double rectangle height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * constructor Create a new rectangle with location and width/height.
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */

    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * constructor Create a new rectangle with location and width/height.
     * @param x the upper left x value of  the rectangle upper left point.
     * @param y the upper left y value of  the rectangle upper left point.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(double x, double y, double width, double height) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }
    /**
     * check if the point given is already on list.
     * @param l list of intersection points
     * @param p a point
     * @return boolean value that indcates if the point inside the list
     */
    private boolean ifInList(ArrayList<Point> l, Point p) {
        for (int i = 0; i < l.size(); i++) {
            if (p.equals(l.get(i))) {
                return true;
            }
        }
        return false;
    }
    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     * @param line a specific line.
     * @return List contains all the point (might be empty) of the given line that
     * intersect with the rectangle lines.
     */
    public java.util.List intersectionPoints(Line line) {
        ArrayList<Point> interPoints = new ArrayList<>();
        Point interPoint;
        Line[] lines = this.getRectangleLines();
        for (int i = 0; i < 4; i++) {
            //point intersectionWith might return a null value,so we need to consider this
            //before adding it to the List,we dont want null values inside the list.
            interPoint = line.intersectionWith(lines[i]);
            if (interPoint != null && !this.ifInList(interPoints, interPoint)) {
                interPoints.add(interPoint);
            }
        }
        return interPoints;
    }

    /**
     * return an array contains copys of the rectnagle lines.
     * @return Geometry.Line[] array with the rectangle lines
     */

    public Line[] getRectangleLines() {
        Point rightUp = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point rightDown = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY()
                + this.height);
        Line upperLine = new Line(this.upperLeft, rightUp);
        Line leftLine = new Line(this.getUpperLeft(), downLeft);
        Line rightLine = new Line(rightUp, rightDown);
        Line bottomLine = new Line(downLeft, rightDown);
        Line[] lines = {upperLine, leftLine, rightLine, bottomLine};
        return lines;
    }
}