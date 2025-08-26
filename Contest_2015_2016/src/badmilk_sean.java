
import java.io.*;
import java.util.*;
public class badmilk_sean {
	
	static BufferedReader in;
    static PrintWriter out;
    static int n;
    static int m;
    static int d;
    static int s;
	static int[] personDrink;
	static int[] milkDrink;
	static int[] timeDrink;
	static int[] personSick;
	static int[] timeSick;
	
	public static void main(String[] args) throws IOException {

    	in = new BufferedReader(new FileReader("badmilk.in"));
        out = new PrintWriter(new File("badmilk.out"));
        init();
        solve();
        in.close();
        out.close(); 
    }
	static void init() throws IOException {
    	StringTokenizer st;
    	String[] t = in.readLine().split(" ");
		n = Integer.parseInt(t[0]);
		m = Integer.parseInt(t[1]);
		d = Integer.parseInt(t[2]);
		s = Integer.parseInt(t[3]);
		personDrink = new int[d];
		milkDrink = new int[d];
		timeDrink = new int[d];
		for(int i = 0; i < d; i++) {
			String[] te = in.readLine().split(" ");
			personDrink[i] = Integer.parseInt(te[0]);
			milkDrink[i] = Integer.parseInt(te[1]);
			timeDrink[i] = Integer.parseInt(te[2]);
		}
		personSick = new int[s];
		timeSick = new int[s];
		for(int i = 0; i < s; i++) {
			String[] te = in.readLine().split(" ");
			personSick[i] = Integer.parseInt(te[0]);
			timeSick[i] = Integer.parseInt(te[1]);
		}
    }
	static void solve() {
		int maxCanGetSick = 0;
		for(int i = 1; i <= m; i++) {
			if(milkTypeCanBeBad(i)) {
				int numDrank = numPeopleDrink(i);
				if(numDrank > maxCanGetSick) {
					maxCanGetSick = numDrank;
				}
			}
		}
		
		out.println(maxCanGetSick);
    }	
	public static boolean milkTypeCanBeBad(int milkType) {
		for(int i = 0; i < personSick.length; i++) {
			if(!personDrankMilkBefore(personSick[i], milkType, timeSick[i])) {
				return false;
			}
		}
		return true;
	}
	private static boolean personDrankMilkBefore(int person, int milkType, int time) {
		for(int i = 0; i < personDrink.length; i++) {
			if(personDrink[i] == person && milkDrink[i] == milkType && timeDrink[i] < time) {
				return true;
			}
		}
		return false;
	}
	private static int numPeopleDrink(int milkType) {
		boolean[] didDrink = new boolean[51];
		for(int i = 0; i < personDrink.length; i++) {
			if(milkDrink[i] == milkType) {
				didDrink[personDrink[i]] = true;
			}
		}
		int numPeopleDrink = 0;
		for(int i = 1; i < didDrink.length; i++) {
			if(didDrink[i]) {
				numPeopleDrink++;
			}
		}
		return numPeopleDrink;
	}
}
