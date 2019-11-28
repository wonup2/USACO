import java.util.*;
import java.io.*;
public class JAN_planting {
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new File("planting.out"));
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		int[] a = new int[n+1];
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x]++;
			a[y]++;
		}
		
		Arrays.sort(a);
		out.println(a[n]+1);
		out.close();
		in.close();		
	}
}
