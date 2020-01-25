import java.util.*;
import java.io.*;

public class US_BR_lostcow {

	public static void main(String[] args) throws Exception {

		Scanner stdin = new Scanner(new File("lostcow.in"));
		int x = stdin.nextInt();
		int y = stdin.nextInt();

		int total = 0, curx = x, mult = 1;

		// Simulate.
		while (true) {

			// Go to the new x.
			int newx = x + mult;
			int min = Math.min(curx,newx);
			int max = Math.max(curx,newx);
			int travel = max-min;

			// We made it, get out.
			if (inbetween(min, y, max)) {
				total += Math.abs(y-curx);
				break;
			}

			// Go to next iteration.
			mult *= (-2);
			total += travel;
			curx = newx;
		}

		// Ta da!
		PrintWriter out = new PrintWriter(new FileWriter("lostcow.out"));
		out.println(total);
		out.close();
		stdin.close();
	}

	public static boolean inbetween(int a, int b, int c) {
		return a <= b && b <= c;
	}
}