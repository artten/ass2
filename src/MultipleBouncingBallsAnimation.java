/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.util.Random;

/**
 * make a surface with bouncing balls.
 */
public class MultipleBouncingBallsAnimation {

    static final int WIDTH = 200;
    static final int HEIGHT = 200;
    static final int MAX_RADIUS = 50;

    /**
     * main function get 6 inputs and run animation.
     * @param args - 6 parameters of radius to build balls
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
       Ball[] balls = new Ball[args.length];
       for (int i = 0; i < args.length; i++) {
           balls[i] = makeNewBall(Double.parseDouble(args[i]));
        }
        drawAnimation(balls);
    }

    /**
     * make a new ball with random place on a map.
     * @param radius - the radius of the ball
     * @return ball with all needed parameters
     */
    private static Ball makeNewBall(double radius) {
        Random rand = new Random();
        int startX = rand.nextInt(WIDTH) + 1;
        int startY = rand.nextInt(HEIGHT) + 1;
        Ball ball =  new Ball(new Point(startX, startY), radius, java.awt.Color.BLACK);
        setVelocityForBall(ball);
        return ball;
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
     * draw the animation of the balls.
     * @param balls - all the balls
     */
     private static void drawAnimation(Ball[] balls) {
        GUI gui = new GUI("title", WIDTH, HEIGHT);
        Sleeper sleeper = new Sleeper();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Ball ball : balls) {
                ball.moveOneStep(new Point(0, 0), HEIGHT, WIDTH);
                ball.checkBounce(new Point(0, 0), HEIGHT, WIDTH);
                ball.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);
        }
    }
}
