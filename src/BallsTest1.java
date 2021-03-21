import biuoop.GUI;
import biuoop.DrawSurface;


public class BallsTest1 {
    public static void main(String[] args) {
        GUI gui = new GUI("title", 200, 200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        java.util.Random rand = new java.util.Random();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            Ball ball = new Ball(rand.nextInt(200), rand.nextInt(200), 30, java.awt.Color.BLACK);
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}