import java.io.*;
import java.util.*;

public class JAN_mountains {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter out = new PrintWriter(new FileWriter("mountains.out"));
		int n = Integer.parseInt(in.readLine());
		int[] set = new int[n * 2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			set[i * 2] = Integer.parseInt(st.nextToken());
			set[i * 2 + 1] = Integer.parseInt(st.nextToken());
		}
				
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int now = i << 1;  
			int f = 1;
			for (int j = 0; j < n; j++) {
				if (j == i)	continue;
				int temp = j << 1;   
				int a = Math.abs(set[now] - set[temp]);
				int b = set[temp + 1] - set[now + 1];  
				if (a <= b) {f = 0;	break;}
			}
			ans += f;
		}
		out.println(ans);
		out.close();
	}
}
