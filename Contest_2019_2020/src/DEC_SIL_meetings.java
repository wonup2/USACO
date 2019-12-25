import java.util.*;
import java.io.*;

public class DEC_SIL_meetings {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, l, total;
	static List<Double> status;
	static List<meet> a;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("meetings.in"));
		out = new PrintWriter(new FileWriter("meetings.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		a = new LinkedList<meet>(); 
		status = new LinkedList<Double>();
		total=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a.add(new meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			status.add(a.get(i).x*1.0);
			total += a.get(i).w;
		}
		Collections.sort(a);
		Collections.sort(status);
	}
	
	static void solve() {
		int meeting=0;
		int weight=0;
		System.out.println(a);
		while(true) { 			
			boolean no=true;
			int sign = 0;
			if(status.isEmpty()) break;
			if(weight>=total/2.0) break;
			
			status.set(0, status.get(0)+0.5*a.get(0).d);
			sign = a.get(0).d;
			for(int i=1; i<status.size(); i++) {
				if(sign!=a.get(i).d) no=false;
				status.set(i, status.get(i)+0.5*a.get(i).d);
				double n1 = status.get(i);
				double n2 = status.get(i-1);
				if(n1==n2) {
					meeting++; 
					a.get(i).d=a.get(i).d*-1;
					a.get(i-1).d=a.get(i-1).d*-1;
				}				
			}		
			if(no) break;
			if(weight>=total/2.0) break;
			if(!status.isEmpty() && status.get(0)<=0) {
				weight+=a.get(0).w; 
				status.remove(0); a.remove(0);
			}
			if(!status.isEmpty() && status.get(status.size()-1)>=l) {
				weight+=a.get(a.size()-1).w; 
				status.remove(status.size()-1);a.remove(a.size()-1);
			}
			System.out.print(status);
			System.out.println("  weight: "+weight +"  meeting:  "+meeting);	
		}		
		out.println(meeting);
	}
}

class meet implements Comparable<meet>{

	int w;
	int x;
	int d;
	meet(int w, int x, int d){
		this.w=w;
		this.x=x;
		this.d=d;
	}
	@Override
	public int compareTo(meet that) {
		// TODO Auto-generated method stub
		return this.x-that.x;
	}
	
	public String toString() {
		return w+" "+x+" "+d;
	}
}
