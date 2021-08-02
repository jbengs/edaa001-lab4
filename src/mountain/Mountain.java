package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

    public Mountain() {
        super();
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
        fractalTriangle(turtle, this.order, p1, p2, p3);
    }

    private void fractalTriangle(TurtleGraphics turtle, int order, Point pA, Point pB, Point pC) {
        if (order == 0) {
            //rita en triangel mellan punkterna
            turtle.moveTo(pA.getX(), pA.getY());
            turtle.forwardTo(pB.getX(), pB.getY());
            turtle.forwardTo(pC.getX(), pC.getY());
            turtle.forwardTo(pA.getX(), pA.getY());
        } else {
            Point pAB = new Point((pA.getX() + pB.getX())/2, (pA.getY() + pB.getY())/2 );
            Point pBC = new Point((pB.getX() + pC.getX())/2, (pB.getY() + pC.getY())/2);
            Point pCA = new Point((pA.getX() + pC.getX())/2, (pA.getY() + pC.getY())/2 );

            fractalTriangle(turtle, order-1, pA, pAB, pCA);
            fractalTriangle(turtle, order-1, pAB, pB, pBC);
            fractalTriangle(turtle, order-1, pCA, pBC, pC);
            fractalTriangle(turtle,order-1, pAB, pBC, pCA);
        }
    }
}
