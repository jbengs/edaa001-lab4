package mountain;

public class Side {
    private Point p1;
    private Point p2;

    public Side(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getPoint1() {
        return p1;
    }

    public Point getPoint2() {
        return p1;
    }

    @Override
    public int hashCode() {
        return p1.hashCode() + p2.hashCode();
    }

    @Override
    public boolean equals(Object x) {
        if (x instanceof Side) {
            if ((this.getPoint1().equals(((Side) x).getPoint1()) && this.getPoint2().equals(((Side) x).getPoint2()))
                    ||
                    (this.getPoint2().equals(((Side) x).getPoint1()) && this.getPoint1().equals(((Side) x).getPoint2()))) {
                return true;
            }
        }
        return false;

    }
}