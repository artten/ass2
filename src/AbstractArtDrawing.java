/**
 * @author 319339198
 */

import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;

/**
 * Draw Line with blue circle in the middle and red if intersection.
 */

public class AbstractArtDrawing {
    static final int NUM_LINE = 10; //number of line to draw
    static final int RADIUS = 3;

    /**
     * create NUM_LINE of random line.
     * @return array of line with random lines
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
     * find all points intersection of lines.
     * @param lines - all line to check if they intersect
     * @return array of points that intersection happened
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
     * draw red circles.
     * @param points - points that contains coordinate to draw
     * @param d - draw surface
     */
    private void drawAllIntersections(Point[] points, DrawSurface d) {
        for (Point point : points) {
            if (point == null) {
                break;
            }
            int r = RADIUS;
            d.setColor(Color.RED);
            d.fillCircle((int) point.getX(), (int) point.getY(), r);
        }
    }

    /**
     * draw lines in black and also draw in the middle of the line blue circle.
     * @param lines - array of line to draw
     * @param d - draw surface
     */
    private void drawLinesAndMiddle(Line[] lines, DrawSurface d) {
        for (Line line : lines) {
            d.setColor(Color.black);
            d.drawLine((int) line.start().getX(), (int) line.start().getY(), (int) line.end().getX(),
                    (int) line.end().getY());
            int r = RADIUS;
            Point middle = line.middle();
            d.setColor(Color.BLUE);
            d.fillCircle((int) middle.getX(), (int) middle.getY(), r);
        }
    }

    /**
     * draws ten random lines.
     */
    public void drawRandomCircles() {
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        Line[] lines = makeTenRandomLines();
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        drawLinesAndMiddle(lines, d);
        Point[] points = findAllIntersectPoints(lines);
        drawAllIntersections(points, d);

        gui.show(d);
    }

    /**
     * draws lines.
     * @param args - user input
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomCircles();
    }
}