package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

import java.util.HashMap;
import java.util.Map;

public class Mountain extends Fractal {
    private Point p1, p2, p3;
    private double dev;
    private Map<Side, Point> sideMap;
    private String title;

    public Mountain(String title, Double dev, Point p1, Point p2, Point p3) {
        super();
        this.dev = dev;
        sideMap = new HashMap<>();
        this.title = title;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    /**
     * Returns the title.
     *
     * @return the title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Draws the fractal.
     *
     * @param turtle the turtle graphic object
     */
    @Override
    public void draw(TurtleGraphics turtle) {
        fractalTriangle(turtle, order, dev, p1, p2, p3);
    }

    private void fractalTriangle(TurtleGraphics turtle, int order, double dev, Point a, Point b, Point c) {
        if (order == 0) {
            turtle.moveTo(a.getX(), a.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
        } else {
            Side sideAB = new Side(a, b);
            Side sideBC = new Side(b, c);
            Side sideCA = new Side(c, a);
            Point ab;
            Point bc;
            Point ca;

            if (sideMap.containsKey(sideAB)) {
                ab = sideMap.remove(sideAB);
            } else {
                int t1 = (int) RandomUtilities.randFunc(dev); // separate for the sake of clarification
                ab = new Point((a.getX() + b.getX()) / 2, t1 + (a.getY() + b.getY()) / 2);
                // multiplication by t gave irregular results and lost information due to int
                sideMap.put(sideAB, ab);
            }

            if (sideMap.containsKey(sideBC)) {
                bc = sideMap.remove(sideBC);
            } else {
                int t2 = (int) RandomUtilities.randFunc(dev);
                bc = new Point((b.getX() + c.getX()) / 2, t2 + (b.getY() + c.getY()) / 2);
                sideMap.put(sideBC, bc);
            }

            if (sideMap.containsKey(sideCA)) {
                ca = sideMap.remove(sideCA);
            } else {
                int t3 = (int) RandomUtilities.randFunc(dev);
                ca = new Point((c.getX() + a.getX()) / 2, t3 + (c.getY() + a.getY()) / 2);
                sideMap.put(sideCA, ca);
            }

            fractalTriangle(turtle, order - 1, dev / 2, a, ab, ca);
            fractalTriangle(turtle, order - 1, dev / 2, ab, b, bc);
            fractalTriangle(turtle, order - 1, dev / 2, ca, bc, c);
            fractalTriangle(turtle, order - 1, dev / 2, ab, bc, ca);
        }
    }
}
