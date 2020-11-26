import java.io.*;
import java.util.*;
public class JAN_SIL_lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		Set<Integer> set = new HashSet<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		State[] l = new State[2*n];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			l[2*i] = new State(start, i);
			l[2*i+1] = new State(end, i);
		}
		Arrays.sort(l);

		int totalCover = 0;
		int[] alone = new int[n];
		int pre = 0;
		
		for(State cur: l) {
			if(set.size() == 1)	alone[set.hashCode()] += cur.time - pre;
			
			if(!set.isEmpty()) totalCover += cur.time - pre;
			
			if(set.contains(cur.index)) set.remove(cur.index);			
			else set.add(cur.index);
			
			pre = cur.time;
		}
		
		Arrays.sort(alone);
		int ans = totalCover - alone[0];
		
		pw.println(ans);
		pw.close();
	}
	
	static class State implements Comparable<State> {
		public int time, index;
		public State(int a, int b) {
			time=a;
			index=b;
		}
		public int compareTo(State s) {
			return time - s.time;
		}
		
		public String toString() {
			return time+" "+index;
		}
	}	
}