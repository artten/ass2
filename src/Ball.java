import biuoop.DrawSurface;

public class Ball {
    private Point center;
    private int radius;
    private java.awt.Color color;

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
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }
}