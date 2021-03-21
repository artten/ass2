import biuoop.DrawSurface;

public class Ball {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;

    /**
     * constructor
     * @param center - center of the ball
     * @param r - radius of the ball
     * @param color - color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * constructor
     * @param x - x value
     * @param y - y value
     * @param r - radius of the ball
     * @param color - color of the ball
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x,y);
        this.radius = r;
        this.color = color;
    }

    /**
     * get the x value of the ball
     * @return the x position of the ball
     */
    public int getX(){
        return (int) this.center.getX();
    }

    /**
     * get the y value of the ball
     * @return the y position of the ball
     */
    public int getY(){
        return (int) this.center.getY();
    }

    /**
     * get the radius of the ball
     * @return the radius of the ball
     */
    public int getSize(){
        return this.radius;
    }

    /**
     * return the ball color
     * @return the color of the ball
     */
    public java.awt.Color getColor(){
        return this.color;
    }

    /**
     * draw this ball on the surface
     * @param surface - the surface to draw on
     */
    public void drawOn(DrawSurface surface){
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }

    /**
     * set new velocity
     * @param v - velocity
     */
    public void setVelocity(Velocity v){
        this.velocity = v;
    }

    /**
     * set new velocity
     * @param dx - dx value of velocity
     * @param dy - dy value of velocity
     */
    public void setVelocity(double dx, double dy){
        this.velocity = new Velocity(dx,dy);
    }

    /**
     *  get velocity
     * @return this velocity
     */
    public Velocity getVelocity(){
        return this.velocity;
    }

    /**
     * function that makes a move with a this ball
     */
    public void moveOneStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
    }
}