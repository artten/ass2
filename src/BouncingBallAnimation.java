import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


public class BouncingBallAnimation {
    static int WIDTH = 200;
    static int HEIGHT = 200;
    static int RADIUS = 30;
    public static void main(String[] args) {
        drawAnimation(new Point(Integer.parseInt(args[0]),Integer.parseInt(args[1])),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
       // drawAnimation(new Point(100,100),1,5);
    }

    /**
     * if the ball is outside of the surface put him inside
     * @param point - starting point of the ball
     * @return new point with correct coordinates
     */
    static  private Point checkBallLocation(Point point) {
        if (point.getX() < RADIUS) {
            point = new Point(RADIUS + 1, point.getY());
        }
        if (point.getX() > WIDTH - RADIUS) {
            point = new Point(WIDTH - RADIUS - 1, point.getY());
        }
        if (point.getY() < RADIUS) {
            point = new Point(point.getX(), RADIUS + 1);
        }
        if (point.getY() > HEIGHT - RADIUS) {
            point = new Point(point.getX(), HEIGHT - RADIUS - 1);
        }
        return point;
    }


    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title",WIDTH,HEIGHT);
        start = checkBallLocation(start);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), RADIUS, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep(new Point(0,0), HEIGHT, WIDTH);
            ball.checkBounce(new Point(0,0), HEIGHT, WIDTH);
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

}
