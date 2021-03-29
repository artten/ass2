/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;
import java.util.Random;

/**
 * Frames with moving balls inside.
 */
public class MultipleFramesBouncingBallsAnimation {
    static final int WIDTH = 850;
    static final int HEIGHT = 900;
    static final int MAX_RADIUS = 50;
    static final Point FIRST_START = new Point(50, 50);
    static final Point FIRST_X_AND_Y_SIZE = new Point(450, 450);
    static final java.awt.Color FIRST_COLOR = Color.gray;
    static final Point SECOND_START = new Point(450, 450);
    static final Point SECOND_X_AND_Y_SIZE = new Point(150, 150);
    static final java.awt.Color SECOND_COLOR = Color.yellow;

    /**
     * main.
     * @param args - user input
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
       Ball[] balls = new Ball[args.length];
        for (int i = 0; i < args.length / 2; i++) {
            balls[i] = makeNewBall(Double.parseDouble(args[i]), (int) FIRST_X_AND_Y_SIZE.getX(),
                    (int) FIRST_X_AND_Y_SIZE.getY(), FIRST_START, Color.magenta);
         }
        for (int i = args.length / 2; i < args.length; i++) {
            balls[i] = makeNewBall(Double.parseDouble(args[i]), (int) SECOND_X_AND_Y_SIZE.getX(),
                    (int) SECOND_X_AND_Y_SIZE.getY(), SECOND_START, Color.GREEN);
        }
        drawAnimation(balls);
    }

    /**
     * add a new frame.
     * @param start - point
     * @param end - x - height y - width
     * @param color - color of the frame
     * @param d - surface
     */
    private static void addFrames(Point start, Point end, java.awt.Color color, DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
    }

    /**
     * make a new ball with random place on a map.
     * @param radius - the radius of the ball
     * @param width - width
     * @param height - height
     * @param point - middle
     * @param color - color of the ball
     * @return ball with all needed parameters
     */
    private static Ball makeNewBall(double radius, int width , int height, Point point, java.awt.Color color) {
        Random rand = new Random();
        int startX = rand.nextInt(height) + (int) point.getX();
        int startY = rand.nextInt(width) + (int) point.getY();
        Ball ball =  new Ball(new Point(startX, startY), radius, color);
        setVelocityForBall(ball);
        return ball;
    }

    /**
     * set a random velocity to a ball.
     * @param ball - the ball to set him velocity
     */
    private static void setVelocityForBall(Ball ball) {
        if (ball.getSize() >= MAX_RADIUS) {
            ball.setVelocity(randomNegativeOrPositive() * 1,
                    randomNegativeOrPositive() * 1);
        }
        ball.setVelocity(randomNegativeOrPositive() * (MAX_RADIUS - ball.getSize()),
                randomNegativeOrPositive() * (MAX_RADIUS - ball.getSize()));
    }

    /**
     * return 1 or -1 or 0.
     * @return 1 or -1 or 0
     */
    private static int randomNegativeOrPositive() {
        Random rand = new Random();
        return  rand.nextInt(1) - 1;
    }

    /**
     * draw the animation of the balls.
     * @param balls - all the balls
     */
    private static void drawAnimation(Ball[] balls) {
        GUI gui = new GUI("title", WIDTH, HEIGHT);
        Sleeper sleeper = new Sleeper();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            addFrames(FIRST_START, FIRST_X_AND_Y_SIZE, FIRST_COLOR, d);
            addFrames(SECOND_START, SECOND_X_AND_Y_SIZE, SECOND_COLOR, d);
            for (int i = 0; i < balls.length / 2; i++) {
                balls[i].moveOneStep(FIRST_START, (int) FIRST_X_AND_Y_SIZE.getX(), (int) FIRST_X_AND_Y_SIZE.getY());
                balls[i].checkBounce(FIRST_START, (int) FIRST_X_AND_Y_SIZE.getX(), (int) FIRST_X_AND_Y_SIZE.getY());
                balls[i].drawOn(d);
            }
            for (int i = balls.length / 2; i < balls.length; i++) {
                balls[i].moveOneStep(SECOND_START, (int) SECOND_X_AND_Y_SIZE.getX(), (int) SECOND_X_AND_Y_SIZE.getX());
                balls[i].checkBounce(SECOND_START, (int) SECOND_X_AND_Y_SIZE.getX(), (int) SECOND_X_AND_Y_SIZE.getX());
                balls[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);
        }
    }
}
