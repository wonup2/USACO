import java.util.*;
import java.io.*;

public class US_BR_lostcow {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("lostcow.in"));
		int x = in.nextInt();
		int y = in.nextInt();

		int total = 0, start = x, mult = 1;

		while (true) {
			
			int current = start;
			int next = x + mult;
			int min = Math.min(current,next);
			int max = Math.max(current,next);

			if (min<=y && y<=max) {
				total += Math.abs(y-current);
				break;
			}

			total += max-min;
			mult *= (-2);
			start = next;
			
		}


		PrintWriter out = new PrintWriter(new FileWriter("lostcow.out"));
		out.println(total);
		out.close();
		in.close();
	}	
}