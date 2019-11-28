import java.io.*;
import java.util.*;
public class JAN_lifeguards_silver {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		TreeSet<Integer> set = new TreeSet<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		State[] l = new State[2*n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			l[2*i] = new State(start, i);
			l[2*i+1] = new State(end, i);
		}
		
		Arrays.sort(l);
		System.out.println(Arrays.toString(l));
		
		int actualCover = 0;
		int[] alone = new int[n];
		int checkedTime = 0;
		
		for(State out: l) {
			if(set.size() == 1)	
				alone[set.first()] += out.time - checkedTime;
			
			if(!set.isEmpty()) 
				actualCover += out.time - checkedTime;
			
			if(set.contains(out.index)) 
				set.remove(out.index);			
			else 
				set.add(out.index);
			
			checkedTime = out.time;
		}
		int ret = 0;
		for(int out: alone) {
			ret = Math.max(ret, actualCover - out);
		}
		System.out.println(ret);
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