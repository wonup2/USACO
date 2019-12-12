import java.io.*;
import java.util.*;

public class herding {
	static Scanner in;
	static PrintWriter out;
	static int min, max;
	static int[] cow;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("herding.in"));
			out = new PrintWriter(new File("herding.out"));
			
			init();
			solve();
			out.println(min);
			out.println(max);
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		cow = new int[3];
		cow[0] = in.nextInt();
		cow[1] = in.nextInt();
		cow[2] = in.nextInt();
		Arrays.sort(cow);
		min = 0;
		max = Math.max(Math.abs(cow[0]-cow[1]), Math.abs(cow[0]-cow[1]))-1;
	}
	
	private static void solve() {
		if(cow[1]-cow[0] == 1 && cow[2]-cow[1] == 1) return;
		else if(cow[2] - cow[1] == 2){
			min = 1;
		}
		else {
			min = 2;
		}
	}
}