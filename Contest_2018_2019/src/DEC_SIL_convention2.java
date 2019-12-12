import java.util.*;
import java.io.*;
 
public class DEC_SIL_convention2 {
	
	static Scanner in;
	static PrintWriter out;
	static int n, time, wait;
	static List<group> gr;
	static PriorityQueue<group> q;
	
	public static void main(String[] args) {
		init();
		solve();
	}

	static void init() {		
		try {
			in=new Scanner(new FileReader("convention2.in"));
			out=new PrintWriter(new FileWriter("convention2.out"));
			n=in.nextInt();
			gr=new LinkedList<group>();
			q=new PriorityQueue<group>();
		
			for(int i=0; i<n; i++)
				gr.add(new group(i, in.nextInt(), in.nextInt()));			
			
			in.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(gr, new Comparator<group>() {
			@Override
			public int compare(group o1, group o2) {
				return o1.a-o2.a;
			}			
		});
		
		
	}
	
	static void solve() {
		
		int max=0;
		reset();
		
		while(!gr.isEmpty()) {
			
			while(!gr.isEmpty() && gr.get(0).a<=time) q.add(gr.remove(0));		
		
			if(q.isEmpty())	reset();
			else{
				group now=q.poll();
				wait = time-now.a;
				time+=now.t;				
			}
			
			max=Math.max(wait, max);			
		}
		out.println(max);
		out.close();
	}
	
	static void reset() {
		time = gr.get(0).a+gr.get(0).t;
		gr.remove(0);
		wait=0;
	}
}

class group implements Comparable<group>{
	int p, a, t;
	group(int p, int a, int t){
		this.p=p; this.a=a; this.t=t;
	}
	@Override
	public int compareTo(group that) {
		return this.p-that.p;
	}
	public String toString() {
		return p+" "+a+" "+t;
	}
}