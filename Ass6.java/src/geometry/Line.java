package geometry; //Ran Wurmbrand 315366039


import java.util.ArrayList;

/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 08.08.2022
 */

public class Line {
    private Point start;
    private Point end;
    private final double eps = 0.00000001;
    /**
     * constructor.
     *
     * @param start the starting point.
     * @param end   the ending point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.arrange();
    }
    public Line(int x, int y,int x2, int y2){
        this.start = new Point(x,y);
        this.end = new Point(x2,y2);
        this.arrange();
    }

    private void arrange() {
        if (this.start.getX() > this.end.getX()) {
            Point temp = this.start;
            this.start = this.end;
            this.end = temp;
        }
    }

    /**
     * finds the slope of the line.
     *
     * @return the slope value.
     */
    public double findSlope() {
        if (this.start().getX() - this.end().getX() == 0) {
            return 0.0;
        }
        if (this.start().getY() - this.end().getY() == 0) {
            return 0.0;
        }
        return (this.start().getY() - this.end().getY()) / (this.start().getX() - this.end().getX());
    }

    /**
     * finds the b of linear equation (y = mx + b).
     *
     * @return b value.
     */
    public double findB() {
        return (this.start().getY() - this.start().getX() * (findSlope()));
    }

    /**
     * it checks if the line is parallel to any axes,return 1 if parallel to x 0 if to y.
     *
     * @return 1 if the line is parallel to x 0 if not
     */
    public int isParallelToX() {
        if (this.start().getY() == this.end().getY()) {
            return 1;
        }
        return 0;
    }

    /**
     * checks if this line parallel yo y axes.
     *
     * @return int value, 1 if it does parallel 0 if not.
     */
    public int isParallelToY() {
        if (this.start().getX() == this.end().getX()) {
            return 1;
        }
        return 0;
    }

    /**
     * check if 2 line are the same one.
     *
     * @param l2 second line
     * @return boolean value
     */
    public boolean areEqual(Line l2) {
        double firstSlop = this.findSlope();
        double secondSlop = l2.findSlope();
        double b1 = this.findB();
        double b2 = l2.findB();
        if (firstSlop == secondSlop) {
            if (this.isParallelToX() == l2.isParallelToX()) {
                if (b1 == b2) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isXvalueOnLine(double x) {
        if (x >= this.start().getX() - eps && x <= this.end().getX() + eps) {
            return true;
        } else if (x <= this.start().getX() + eps && x >= this.end().getX() - eps) {
            return true;
        }
        return false;
    }

    /**
     * checks if the line has a point which is y value is the same as the given value.
     *
     * @param y the value we check.
     * @return boolean true or false.
     */
    public boolean isYvalueOnLine(double y) {
        if (y >= this.start().getY() - eps && y <= this.end().getY()+ eps) {
            return true;
        } else if (y <= this.start().getY() + eps && y >= this.end().getY()- eps) {
            return true;
        }
        return false;
    }
    /**
     * getPointInCaseOfParallels will be called only if there is an intersection between the lines,
     * and atleast one of the line is parallel to x or y axes.
     *
     * @param l2 the other line
     * @return the point of the intersection
     */
    private Point getPointInCaseOfParallels(Line l2) {
        double x;
        double y;
        double firstSlop = this.findSlope();
        double secondSLop = l2.findSlope();
        double b1 = this.findB();
        double b2 = l2.findB();
        if (this.isParallelToX() == 1) {
            y = this.end().getY();
            if (l2.isParallelToY() == 1) {
                x = l2.start().getX();
            } else {
                x = (y - b2) / secondSLop;
            }
            return new Point(x, y);
        }
        if (this.isParallelToY() == 1) {
            x = this.start().getX();
            if (l2.isParallelToX() == 1) {
                y = l2.end().getY();
            } else {
                y = secondSLop * x + b2;
            }
            return new Point(x, y);
        }
        if (l2.isParallelToX() == 1) {
            y = l2.end().getY();
            if (this.isParallelToY() == 1) {
                x = this.start().getX();
            } else {
                x = (y - b1) / firstSlop;
            }
            return new Point(x, y);
        }
        if (l2.isParallelToY() == 1) {
            x = l2.start().getX();
            if (this.isParallelToX() == 1) {
                y = this.end().getY();
            } else {
                y = firstSlop * x + b1;
            }
            return new Point(x, y);
        }
        return null;
    }

    /**
     * gets the point of intersection.
     *
     * @param l2 the second line
     * @return the point of intersection.
     */
    public Point getPointOfIntersect(Line l2) {
        double firstSlop = this.findSlope();
        double secondSlop = l2.findSlope();
        double b1 = this.findB();
        double b2 = l2.findB();
        double x;
        double y;
        if (this.isParallelToX() == 1 || this.isParallelToY() == 1
                || l2.isParallelToX() == 1 || l2.isParallelToY() == 1) {
            return this.getPointInCaseOfParallels(l2);
        } else {
            x = (b2 - b1) / (firstSlop - secondSlop);
            y = firstSlop * x + b1;
            return new Point(x, y);
        }
    }
    /**
     * Return the length of the line.
     *
     * @return the length
     */
    public double length() {
        return this.start.distance(this.end);
    }
    /**
     * Returns the middle point of the line.
     *
     * @return middle point
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2.0;
        double midY = (this.start.getY() + this.end.getY()) / 2.0;
        return new Point(midX, midY);
    }
    /**
     * Returns the start point of the line.
     *
     * @return the start point
     */
    public Point start() {
        return this.start;
    }
    /**
     * Returns the end point of the line.
     *
     * @return the end point
     */
    public Point end() {
        return this.end;
    }
    /**
     * checks if this line is parallel to any of the axes.
     * @return true or false.
     */
    public boolean isLineParallelToAxes() {
        if (this.isParallelToX() == 1 || this.isParallelToY() == 1) {
            return true;
        }
        return false;
    }
    /**
     * isIntersecting.
     * checks if the 2 lines are indeed intersect.
     * @param other the other line
     * @return ture / false depends if they intersect.
     */
    public boolean isIntersecting(Line other) {
        Line bellow;
        Line above;
        if (this.start.getY() <= other.start.getY()) {
            bellow = this;
            above = other;
        } else {
            above = other;
            bellow = this;
        }
        if (!bellow.isLineParallelToAxes() && !above.isLineParallelToAxes()) {
            if (this.areEqual(other)) {
                if (other.isXvalueOnLine(this.end().getX()) || this.isXvalueOnLine(other.end().getX())) {
                    return true;
                }
                return false;
            }
            if (bellow.end.getY() < above.end().getY()) {
                return false;
            }
            Point p = this.getPointOfIntersect(other);
            if (above.isXvalueOnLine(p.getX()) && bellow.isXvalueOnLine(p.getX())) {
                if (above.isYvalueOnLine(p.getY()) && bellow.isYvalueOnLine(p.getY())) {
                    return true;
                }
                return false;
            }
        } else {
            Point p = this.getPointInCaseOfParallels(other);
            if (this.areEqual(other)) {
                if (bellow.isXvalueOnLine(above.end().getX()) || above.isXvalueOnLine(bellow.end().getX())) {
                    return true;
                }
                return false;
            }
            if (above.isXvalueOnLine(p.getX()) && bellow.isXvalueOnLine(p.getX())) {
                if (above.isYvalueOnLine(p.getY()) && bellow.isYvalueOnLine(p.getY())) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    /**
     * checks if there is intersection and return the point of intersection.
     *
     * @param other the other point.
     * @return point of intersection.
     */
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            return this.getPointOfIntersect(other);
        }
        return null;
    }

    /**
     * return true is the lines are equal, false otherwise.
     *
     * @param other the other line
     * @return boolean value
     */
    public boolean equals(Line other) {
        if (!this.start().equals(other.start()) || !this.end().equals(other.end())) {
            return false;
        }
        return true;
    }
    /**
     * closestIntersectionToStartOfLine.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @param rect rectangle that might intersect with the line
     * @return Geometry.Point,the closest point to the start of the line,or null if there are no intersections.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        ArrayList<Point> l = (ArrayList<Point>) rect.intersectionPoints(this);
        if (l.isEmpty()) {  //case Geometry.Line doesn't intersect Rectang  le.
            return null;
        }
        int size = l.size();
        Point toReturn = l.get(0);
        Point start = this.start();
        for (int i = 1; i < size; i++) {
            if (start.distance(l.get(i)) <= start.distance(toReturn)) {
                toReturn = l.get(i);
            }
        }
        return toReturn;
    }
}
