import java.util.*;
import java.io.*;

public class revegetate {

	static Scanner in;
	static PrintWriter out;
	static int N, M;
	static String ans;
	static ArrayList<Integer> a[];
	static ArrayList<String> f[];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("revegetate.in"));
		out = new PrintWriter(new File("revegetate.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
				
		N = in.nextInt(); 
		M = in.nextInt();
		
		f = new ArrayList[N];
		for(int i=0; i<N; i++) {
			f[i] = new ArrayList<String>();
			f[i].add("1");f[i].add("2");f[i].add("3");f[i].add("4");
		}
		
		a = new ArrayList[N];
		for(int i=0; i<N; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			a[x].add(y);
			a[y].add(x);
		}
		ans = "";
//		System.out.println("Fields:    " + Arrays.toString(f));
//		System.out.println("Network:  " + Arrays.toString(a));		
	}
	
	static void solve() {
		
		for(int i=0; i<N; i++) {
			String curSeed = f[i].get(0);
			ans+=curSeed;
			
			for(int j:a[i])	f[j].remove(curSeed);
		}
			
		out.println(ans);				
	}	
}
