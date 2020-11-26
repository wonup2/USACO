import java.util.*;
import java.io.*;

public class FEB_BR_teleport {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("teleport.in"));
		PrintWriter out = new PrintWriter(new File("teleport.out"));
		
		int a = in.nextInt();
		int b = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		int c1 = Math.abs(a-x) + Math.abs(b-y);
		int c2 = Math.abs(a-y) + Math.abs(b-x);
		int c3 = Math.abs(a-b);
		out.print(Math.min(Math.min(c1, c2), c3));
		out.close();
		in.close();
	}
}
