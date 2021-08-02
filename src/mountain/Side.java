package mountain;

public class Side {
    private Point a;	//renamed from x
    private Point b;	//renamed from a

    public Side(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }

    @Override
    public boolean equals(Object x) {
        if (x instanceof Side) {
            Side temp = (Side) x;
            if ((this.getA().equals(temp.getA()) && this.getB().equals(temp.getB()))
                    ||
                    (this.getB().equals(temp.getA()) && this.getA().equals(temp.getB()))) {
                return true;
            }
        }
        return false;

    }
}