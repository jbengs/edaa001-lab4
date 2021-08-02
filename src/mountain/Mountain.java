package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

import java.util.HashMap;
import java.util.Map;

public class Mountain extends Fractal {
    private double dev;
    private Map<Side, Point> map;

    public Mountain(Double dev) {
        super();
        this.dev = dev;
        map = new HashMap<>();
    }
    /**
     * Returns the title.
     *
     * @return the title
     */
    @Override
    public String getTitle() {
        return "Mountain";
    }

    /**
     * Draws the fractal.
     *
     * @param turtle the turtle graphic object
     */
    @Override
    public void draw(TurtleGraphics turtle) {
        Point p1 = new Point(100, 400);
        Point p2 = new Point(300, 200);
        Point p3 = new Point(500, 500);
        turtle.moveTo(p1.getX(), p1.getY());
        fractalTriangle(turtle, this.order, p1, p2, p3, dev);
    }

    private void fractalTriangle(TurtleGraphics turtle, int order, Point pA, Point pB, Point pC, double dev) {
        if (order == 0) {
            //ritar en triangel mellan punkterna
            turtle.moveTo(pA.getX(), pA.getY());
            turtle.forwardTo(pB.getX(), pB.getY());
            turtle.forwardTo(pC.getX(), pC.getY());
            turtle.forwardTo(pA.getX(), pA.getY());
        } else {
            Side sAB = new Side(pA, pB);
            Side sBC = new Side(pB, pC);
            Side sCA = new Side(pC, pA);
            Point pAB;
            Point pBC;
            Point pCA;

            if (map.containsKey(sAB)) {
                pAB = map.remove(sAB); //Tar bort från mapen eftersom den anldrig kommer användas igen.
            } else {
                pAB = new Point((pA.getX() + pB.getX()) / 2,
                        (int) RandomUtilities.randFunc(dev) + (pA.getY() + pB.getY()) / 2);
                map.put(sAB, pAB); //lägger den nya beräkningen i map
            }

            if (map.containsKey(sBC)) {
                pBC = map.remove(sBC);
            } else {
                pBC = new Point((pB.getX() + pC.getX())/2,
                        (int) RandomUtilities.randFunc(dev) + (pB.getY() + pC.getY())/2);
                map.put(sBC, pBC);
            }

            if (map.containsKey(sCA)) {
                pCA = map.remove(sCA);
            } else {
                pCA = new Point((pA.getX() + pC.getX()) / 2,
                        (int) RandomUtilities.randFunc(dev) + (pA.getY() + pC.getY()) / 2);
                map.put(sCA, pCA);
            }

            fractalTriangle(turtle, order-1, pA, pAB, pCA, dev/2);
            fractalTriangle(turtle, order-1, pAB, pB, pBC, dev/2);
            fractalTriangle(turtle, order-1, pCA, pBC, pC, dev/2);
            fractalTriangle(turtle,order-1, pAB, pBC, pCA, dev/2);
        }
    }
}
