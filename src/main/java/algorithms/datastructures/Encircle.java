package algorithms.datastructures;

import java.util.Scanner;

public class Encircle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int prev_path = 0,initial_path =0;
		Point b_point = new Encircle().new Point(0, 0);
		Point prev_point = b_point;
		char array[] = line.toCharArray();
		boolean circleExists = false,hasG = false;
		
		int loop = 4;
		while (loop >= 0) {
			for (int i = 0; i < array.length; i++) {
				int cur_path = prev_path;
				if (array[i] == 'L') {
					cur_path = (prev_path + 1) % 4;
					prev_path = cur_path;
					if(initial_path == prev_path && !hasG)
						circleExists = true;
					else
						circleExists = false;
				} else if (array[i] == 'R') {
					cur_path = (prev_path - 1) < 0 ? 3 : (prev_path - 1);
					prev_path = cur_path;
					if(initial_path == prev_path && !hasG)
						circleExists = true;
					else
						circleExists = false;
				} else {
					Point point = b_point;
					hasG = true;
					switch (cur_path) {
					case 0: {
						point = new Encircle().new Point(prev_point.x + 1, prev_point.y);
						prev_point = point;
						break;
					}
					case 1: {
						point = new Encircle().new Point(prev_point.x, prev_point.y + 1);
						prev_point = point;
						break;
					}
					case 2: {
						point = new Encircle().new Point(prev_point.x - 1, prev_point.y);
						prev_point = point;
						break;
					}
					case 3: {
						point = new Encircle().new Point(prev_point.x, prev_point.y - 1);
						prev_point = point;
						break;
					}
					}
					if (point.equals(b_point))
						circleExists = true;
					else
						circleExists = false;
				}
			}
			System.out.println("previous Path = "+prev_path);
			if(circleExists)
				break;
			loop--;
		}
		if (circleExists)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");

		sc.close();
	}

	class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private Encircle getOuterType() {
			return Encircle.this;
		}

	}

}
