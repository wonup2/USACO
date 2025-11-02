import java.io.*;
import java.util.*;

public class Mowing {
	static class Step {
		char dir;
		int numSteps;

		public Step(char dir, int numSteps) {
			this.dir = dir;
			this.numSteps = numSteps;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("mowing.in"));
		int n = Integer.parseInt(read.readLine());
		Step[] steps = new Step[n];
		for (int s = 0; s < n; s++) {
			StringTokenizer step = new StringTokenizer(read.readLine());
			steps[s] = new Step(
					step.nextToken().charAt(0), Integer.parseInt(step.nextToken())
			);
		}
		read.close();

		// FJ's starting position.
		Point curr = new Point(0, 0);
		// Make a hashmap, and mark off steps.
		// We'll first mark off his starting position.
		Map<Point, Integer> visits = new HashMap<>(Map.of(curr, 0));

		int time = 0;
		int maxRegrow = Integer.MAX_VALUE;
		for (Step s : steps) {
			for (int i = 0; i < s.numSteps; i++) {
				// Update our curent position.
				curr = curr.next(s.dir);
				time++;

				// Check if FJ's been to this patch of grass before.
				if (visits.containsKey(curr)) {
					maxRegrow = Math.min(maxRegrow, time - visits.get(curr));
				}

				// Update the last time FJ has come upon this patch of grass.
				visits.put(curr, time);
			}
		}

		PrintWriter written = new PrintWriter("mowing.out");
		// Output -1 if FJ has never gone back to the same patch of grass.
		written.println(maxRegrow == Integer.MAX_VALUE ? -1 : maxRegrow);
		written.close();
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return The point reached after moving in the given direction from this point.
	 */
	public Point next(char dir) {
		switch (dir) {
			case 'N':
				return new Point(x, y + 1);
			case 'W':
				return new Point(x - 1, y);
			case 'E':
				return new Point(x + 1, y);
			case 'S':
				return new Point(x, y - 1);
			default:
				return this;
		}
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Point && x == ((Point) obj).x && y == ((Point) obj).y;
	}
}