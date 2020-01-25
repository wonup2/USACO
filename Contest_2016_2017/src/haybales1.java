import java.util.*;
import java.io.*;

public class haybales1 {

	public static void main(String[] args) throws Exception {

		// Read in first line.
		BufferedReader stdin = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int numQ = Integer.parseInt(tok.nextToken());

		// Read in values adding dummy -1 for list beginning.
		int[] vals = new int[n+1];
		vals[0] = -1;
		tok = new StringTokenizer(stdin.readLine());
		for (int i=1; i<=n; i++)
			vals[i] = Integer.parseInt(tok.nextToken());

		// We want this list sorted.
		Arrays.sort(vals);

		// Compress values mapping values to indexes.
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for (int i=0; i<=n; i++)
			map.put(vals[i], i);

		// Process each query.
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<numQ; i++) {

			// Get query find lower bounds in map and just subtract corresponding indexes.
			tok = new StringTokenizer(stdin.readLine());
			int low = map.floorKey(Integer.parseInt(tok.nextToken())-1);
			int high = map.floorKey(Integer.parseInt(tok.nextToken()));
			int res = map.get(high) - map.get(low);

			// For speed.
			sb.append(res+"\n");
		}

		// Output whole result.
		PrintWriter out = new PrintWriter(new FileWriter("haybales.out"));
		out.print(sb);
		out.close();
		stdin.close();
	}
}