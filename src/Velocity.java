// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor
     * @param dx - added x
     * @param dy - added y
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * get velocity x value
     * @return this dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * get velocity y value
     * @return this dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * add velocity to the point
     * @param p - point with x and y value
     * @return new point with added velocity
     */
    public Point applyToPoint(Point p){
        return new Point(p.getX() + dx,p.getY() + dy);
    }
}