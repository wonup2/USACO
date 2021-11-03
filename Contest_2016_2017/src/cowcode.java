import java.util.*;
import java.io.*;

public class cowcode {
	static Scanner in;
	static PrintWriter out;
	static String word;
	static long length, num;
	static ArrayList <Long> start;
	
	public static void main(String [] args) {
		try {
			init();
			solve();
			in.close();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() throws IOException {
		in = new Scanner(new File("cowcode.in"));
		out = new PrintWriter(new File("cowcode.out"));
		
		word = in.next();
		length = word.length();
		num = in.nextLong() - 1;
		start = new ArrayList<Long>();
	}
	
	public static void solve() throws IOException {
		start.add(length);
		long temp = length;
		while(temp * 2 < num) {
			temp *= 2;
			start.add(temp);
		}
		Collections.reverse(start);
		
		while(num >= length) {
			if(start.get(0) < num) {
				num = num - start.remove(0) - 1;
			} else if(start.get(0) == num) {
				num--;
			} else {
				start.remove(0);
			}
		}
		out.println(word.charAt((int) num));
	}
}