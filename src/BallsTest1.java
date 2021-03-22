import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;


public class BallsTest1 {
    static int WIDTH = 200;
    static int HEIGHT = 200;
    public static void main(String[] args) {
     drawAnimation(new Point(100,100),1,5);
    }
    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title",WIDTH,HEIGHT);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            ball.checkBounce(HEIGHT, WIDTH);
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}