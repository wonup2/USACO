import java.util.*;
import java.io.*;
 
public class DEC_SIL_convention2 {
	
	static BufferedReader in;
	static PrintWriter out;
	static int N, time, wait;
	static List<group> a;
	static PriorityQueue<group> pq;
	
	public static void main(String[] args) throws IOException {
		in = in=new BufferedReader(new FileReader("convention2.in"));
		out=new PrintWriter(new FileWriter("convention2.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {		
		N=Integer.parseInt(in.readLine());
		a=new LinkedList<group>();
		pq=new PriorityQueue<group>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			a.add(new group(i, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));		
		}
						
		Collections.sort(a, new Comparator<group>() {

			@Override
			public int compare(group arg0, group arg1) {
				
				return arg0.a - arg1.a;
			}			
		});
		
		//System.out.println(a);
	}
	
	static void solve() {
		
		int max=0;
		reset();
		
		while(!a.isEmpty()) {
			
			while(!a.isEmpty() && a.get(0).a<=time) pq.add(a.remove(0));		
		
			if(pq.isEmpty()) reset();
			else{
				group now=pq.poll();
				wait = time-now.a;
				time+=now.t;				
			}
			
			max=Math.max(wait, max);			
		}
		out.println(max);
		out.close();
	}
	
	static void reset() {
		time = a.get(0).a + a.get(0).t;
		a.remove(0);
		wait=0;
	}
}

class group implements Comparable<group>{
	int s, a, t;
	group(int s, int a, int t){
		this.s=s; this.a=a; this.t=t;
	}
	@Override
	public int compareTo(group that) {
		return this.s-that.s;
	}
	public String toString() {
		return s+" "+a+" "+t;
	}
}