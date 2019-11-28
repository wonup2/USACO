import java.util.*;
import java.io.*;
public class measurement {
	static PrintWriter out;
	static Scanner in;
	static cow rank[];
	static int n;
	static int[] amount;
	static boolean[] board;
	static int noc;
	public static void main(String[] args) {
		try {
			init();
			solve();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		in.close();
		out.close();
	}
	public static void init() {
		try {
			in = new Scanner(new File("measurement.in"));
			out = new PrintWriter(new File("measurement.out"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		n = in.nextInt();
		rank = new cow[n];
		for(int i = 0; i < n; i++) {
			rank[i] = new cow(in.nextInt(), in.next(), in.nextInt());
		}
		Arrays.sort(rank);
		System.out.println(n);
		amount = new int[3];
		board = new boolean[3];
		for(int i = 0; i < 3; i++) {
			amount[i] = 7;
		}
		for(int i = 0; i < 3; i++) {
			board[i] = true;
		}
	}
	public static void solve() {
		//System.out.println(Arrays.toString(rank));
      	boolean[] temp = new boolean[3];
		for(int i = 0; i < n; i++) {
			if(rank[i].name.equals("Mildred")) {
				amount[0] = amount[0] + rank[i].change;
			}else if(rank[i].name.equals("Elise")) {
				amount[1] = amount[1] + rank[i].change;
			}else if(rank[i].name.equals("Bessie")) {
				amount[2] = amount[2] + rank[i].change;
			}
			int max = Math.max(Math.max(amount[0], amount[1]), amount[2]);
          	temp = board.clone();
            board = new boolean[3];
			for(int j = 0; j < 3; j++) {
				if(max == amount[j]) {
					board[j] = true;
				}
			}
            System.out.println(Arrays.toString(temp));
            System.out.println(Arrays.toString(board));
            
			if(!Arrays.equals(temp, board)) {
				noc++;
			}
		}
		out.println(noc);
	}
}
class cow implements Comparable<cow>{
	int day;
	String name;
	int change;
	cow(int d, String a, int c){
		day = d;
		name = a;
		change = c;
	}
	public String toString() {
		return day + " " + name + " " + change;
	}
	public int compareTo(cow that) {
		if(this.day > that.day) {
			return 1;
		}else if(this.day < that.day){
			return -1;
		}else {
			if(this.change > that.change) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}