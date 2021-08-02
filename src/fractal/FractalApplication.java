package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[4];
		Point a = new Point(100, 400);
		Point b = new Point(200, 100);
		Point c = new Point(400, 500);
		double dev1 = 40;
		Point d= new Point(100, 450);
		Point e = new Point(700, 200);
		Point f = new Point(1400, 400);
		double dev2 = 90;
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain("Triangle", 0.0, a, b, c);
		fractals[2] = new Mountain("Mountain", dev1, a, b, c);
		fractals[3] = new Mountain("Mountain range", dev2, d,e,f);
		new FractalView(fractals, "Fraktaler", 1500, 600);
	}

}
