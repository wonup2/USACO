import java.io.*;
import java.util.*;
public class DEC_SIL_shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n];
		int[] v = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken())-1;
			v[d[i]]++;
		}
		
		int ans = n;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			if(v[i] == 0) {
				q.add(i);
				ans--;
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			v[d[curr]]--;
			if(v[d[curr]] == 0) {
				q.add(d[curr]);
				ans--;
			}
		}
		pw.println(ans);
		pw.close();
	}
}