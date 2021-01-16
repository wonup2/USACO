import java.util.*;
import java.io.*;

public class badmilk {

	static Scanner in;
	static PrintWriter out;
	static triple list[];
	static boolean badmilk[], a[][];	
	static int N, M, D, S;
	static int ans;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("badmilk.in"));
		out = new PrintWriter(new File("badmilk.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {	
		
		N = in.nextInt(); 
		M = in.nextInt(); 
		D = in.nextInt(); 
		S = in.nextInt(); 
				
		list = new triple[D+S];
		for(int i=0; i<D; i++) {
			list[i] = new triple(in.nextInt(), in.nextInt(), in.nextInt());
		}
		for(int i=D; i<D+S; i++) {
			list[i] = new triple(in.nextInt(), -1, in.nextInt());
		}
		
		//System.out.println(Arrays.toString(list));
		Arrays.sort(list);
		//System.out.println(Arrays.toString(list));

		badmilk = new boolean[M];
		a = new boolean[N][M];
		
		Arrays.fill(badmilk, true);
		
	}
	static void solve() {
		
		for(triple d:list) {
			
			int id = d.id-1;
			int milk = d.milk-1;
			
			if(milk==-2) {
				for(int i=0; i<M; i++) {
					badmilk[i] = badmilk[i] && a[id][i];
				}
			}
			else a[id][milk]=true;
		}

//		System.out.println(Arrays.deepToString(a));
//		System.out.println(Arrays.toString(badmilk));
		
		
		
		out.println(ans);
	}	
}


class triple implements Comparable<triple>{
	
	int id;
	int milk;
	int time;
	
	triple(int a, int b, int c){
		id = a;
		milk = b;
		time = c;
	}
	
	public String toString() {
		return id+" "+milk +" "+time;
	}

	@Override
	public int compareTo(triple o) {		
		return this.time - o.time;
	}
	
}