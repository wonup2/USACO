import java.io.*;
import java.util.*;

public class DEC_SIL_homework {

	static BufferedReader in;
	static PrintWriter out;
	static int n, total, sum[], min[], grade[];
	public static void main(String[] args) throws IOException {
		in=new BufferedReader(new FileReader("homework.in"));
		out=new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		init();
		solve();
		in.close();
		out.close();
	}
	
	private static void init() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		grade=new int[n];
		sum = new int[n];
		min = new int[n];
		total=0;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		sum[0] = 0;
		grade[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++){
			grade[i] = Integer.parseInt(st.nextToken());
			sum[i] = grade[i] + sum[i-1];
		}
		total = sum[n-1];
		
		min[n-1] = grade[n-1];
		for(int i=n-2; i>0; i--){
			min[i] = Math.min(grade[i], min[i+1]);
		}
	}
	
	private static void solve() {
		double max = 0;
		ArrayList<Integer> eat = new ArrayList<Integer>();   
		double r = n-1;	
		for(int i=1; i<=n-2; i++){
			double ave = (total-sum[i-1]-min[i])/(r-i);
			if(max == ave) eat.add(i);
			else if(max < ave) {
				max = ave; 
				eat=new ArrayList<Integer>();
				eat.add(i);
			}
		}
		Collections.sort(eat);
		for(int e: eat)
			out.println(e);
	}
}