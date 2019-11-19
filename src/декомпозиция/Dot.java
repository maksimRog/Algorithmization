package декомпозиция;

public class Dot {


	
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;

		}
		private int x;
		private int y;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
public static double getDistance(Dot d1, Dot d2){
	return Math.sqrt(Math.pow(d2.getX()-d1.getX(), 2)+Math.pow(d2.getY()-d1.getY(), 2));
}
@Override
public String toString() {
	return "Dot [x=" + x + ", y=" + y + "]";
}
			
		
}
