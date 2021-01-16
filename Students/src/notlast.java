import java.util.*;
import java.io.*;

public class notlast {

	static Scanner in;
	static PrintWriter out;
	static int N;
	static int ans;
	static HashMap<String , Integer> cows;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("notlast.in"));
		out = new PrintWriter(new File("notlast.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		N = in.nextInt();  //in.nextLine() is needed sometimes
		
		cows = new HashMap<String, Integer>();  	//<-------------------------
		cows.put("Bessie", 0);
		cows.put("Elsie", 0);
		cows.put("Daisy", 0);
		cows.put("Gertie", 0);
		cows.put("Annabelle", 0);
		cows.put("Maggie", 0);
		cows.put("Henrietta", 0);

		for(int i=0; i<N; i++) {
			String name = in.next();
			int milk = in.nextInt();
			cows.put(name, cows.get(name)+milk);			
		}
		
		//System.out.println(cows);
	}
	static void solve() {

		TreeSet<Integer> milk = new TreeSet<Integer>();	 //<-------------------------
		
		milk.addAll(cows.values()); //<-------------------------
		ArrayList<Integer> milk2 = new ArrayList<Integer>();
		milk2.addAll(milk);
		
		int sec = milk2.get(1);
		
			
//		int i = 0;
//		for(int num:milk) {
//			i++;
//			if(i==2) {
//				sec = num;
//				break;
//			}			
//		}
//
//		System.out.println(sec);
		out.println(ans);
	}	
}
