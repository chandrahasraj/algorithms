package algorithms.concepts;

public class FileSystem {

}

class Point{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object arg0) {
		Point point = (Point)arg0;
		if(point.x == this.x && point.y==this.y)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
}
