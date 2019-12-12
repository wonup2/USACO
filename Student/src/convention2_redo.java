import java.util.*;
import java.io.*;

class theCows implements Comparable<theCows>{
	
	public int arrive;
	public int howLong;
	public int priority;
	
	public theCows(int arrivalTime, int takesHowLong, int cowPriority) {
		arrive = arrivalTime;
		howLong = takesHowLong;
		priority = cowPriority;
	}
	
	public int compareTo(theCows that) {
		return this.priority - that.priority;
	}
	
	public String toString() {
		return this.arrive + " " + this.howLong + " " + this.priority;
	}
}

public class convention2_redo {

	static BufferedReader in;
	static PrintWriter out;
	static int n, depart, maxWait;
	static ArrayList<theCows> cows;
	static PriorityQueue<theCows> order;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(new File("convention2.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		try {
			init();
			solve();
			out.println(maxWait);
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() throws IOException{
		n = Integer.parseInt(in.readLine());
		cows = new ArrayList<theCows>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			cows.add(new theCows(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}
		Collections.sort(cows, new Comparator<theCows>(){
			@Override
			public int compare(theCows cow1, theCows cow2) {
				return cow1.arrive - cow2.arrive;
			}
		});
		order = new PriorityQueue<theCows>();
		visit = new boolean[n];
	}
	
	public static void solve() {
		for (int i = 0; i < n; i++) {
			if (order.isEmpty() && !visit[i]) {
				visit[i] = true;
				repeat(i, cows.get(i), cows.get(i).arrive);
			}
		}		
	}
	
	public static void repeat(int x,theCows temp, int arr) {
		maxWait = Math.max(maxWait, depart - temp.arrive);
		depart = arr + temp.howLong;
		for (int i = x; i < n; i++) {
			if (visit[i])
				continue;
			if (cows.get(i).arrive >= temp.arrive && cows.get(i).arrive < depart) {
				visit[i] = true;
				order.add(cows.get(i));
			}
			else {x=i;break;}
		}
		if (order.isEmpty())
			return;
		else
			repeat(x, order.poll(), depart);
	}
}
