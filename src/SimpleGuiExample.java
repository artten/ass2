/**
 * @author 319339198
 */

import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;

/**
 * Test GUI.
 */
public class SimpleGuiExample {
    static final int NUM_LINE = 10;

    /**
     * creates ten random line.
     * @return array of lines
     */
    private Line[] makeTenRandomLines() {
        Random rand = new Random(); // create a random-number generator
        Line[] lines = new Line[NUM_LINE];
        for (int i = 0; i < NUM_LINE; ++i) {
            int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
            int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
            lines[i] = new Line(x1, y1, x2, y2);
        }
        return lines;
    }

    /**
     * find the intersection between the lines.
     * @param lines = all the line
     * @return array of intersection points
     */
    private Point[] findAllIntersectPoints(Line[] lines)  {
        Point[] points = new Point[NUM_LINE * NUM_LINE];
        int count = 0;
        for (int i = 0; i < NUM_LINE - 1; i++) {
            for (int j = i + 1; j < NUM_LINE; j++) {
                if (lines[i].isIntersecting(lines[j])) {
                    points[count] = lines[i].intersectionWith(lines[j]);
                    count++;
                }
            }
        }
        return points;
    }

    /**
     * draw all the intersection point on the surface.
     * @param points - all the points
     * @param d - surface
     */
    private void drawAllIntersections(Point[] points, DrawSurface d) {
        for (Point point : points) {
            if (point == null) {
                break;
            }
            int r = 3;
            d.setColor(Color.RED);
            d.fillCircle((int) point.getX(), (int) point.getY(), r);
        }
    }

    /**
     * draw all lines and the middle.
     * @param lines - all lines
     * @param d - surface
     */
    private void drawLinesAndMiddle(Line[] lines, DrawSurface d) {
        for (Line line : lines) {
            d.setColor(Color.black);
            d.drawLine((int) line.start().getX(), (int) line.start().getY(),
                    (int) line.end().getX(), (int) line.end().getY());
            int r = 3;
            Point middle = line.middle();
            d.setColor(Color.BLUE);
            d.fillCircle((int) middle.getX(), (int) middle.getY(), r);
        }
    }

    /**
     * draw the lines and circles on the surface.
     */
    public void drawRandomCircles() {
        Line[] lines = makeTenRandomLines();
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        drawLinesAndMiddle(lines, d);
        Point[] points = findAllIntersectPoints(lines);
        drawAllIntersections(points, d);

        gui.show(d);
    }

    /**
     * main.
     * @param args - user input
     */
    public static void main(String[] args) {
        SimpleGuiExample example = new SimpleGuiExample();
        example.drawRandomCircles();
    }
}