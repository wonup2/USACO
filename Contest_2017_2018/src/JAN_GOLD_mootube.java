// 2018 January USACO Gold and Silver Problem: Mootube

import java.util.*;
import java.io.*;

public class JAN_GOLD_mootube {

	public static int n;
	public static edge[] g;
	public static query[] questions;

	public static void main(String[] args) throws Exception {

		// Read the data, sort by end time.
		BufferedReader stdin = new BufferedReader(new FileReader("mootube.in"));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		n = Integer.parseInt(tok.nextToken());
		int q = Integer.parseInt(tok.nextToken());

		// empty graph.
		g = new edge[n-1];

		// Add edges.
		for (int i=0; i<n-1; i++) {
			tok = new StringTokenizer(stdin.readLine());
			int v1 = Integer.parseInt(tok.nextToken()) - 1;
			int v2 = Integer.parseInt(tok.nextToken()) - 1;
			int w = Integer.parseInt(tok.nextToken());
			g[i] = new edge(v1, v2, w);
		}

		// Sort in order of relevance (so highest to lowest).
		Arrays.sort(g);

		// Store questions here.
		questions = new query[q];

		// Read queries.
		for (int i=0; i<q; i++) {
			tok = new StringTokenizer(stdin.readLine());
			int k = Integer.parseInt(tok.nextToken());
			int v = Integer.parseInt(tok.nextToken()) - 1;
			questions[i] = new query(i, k, v);
		}

		// Put in order from greatest to least k.
		Arrays.sort(questions);

		// Will keep track of which videos are "fused".
		djset set = new djset(n);

		// Store all results here.
		int[] res = new int[q];

		// i is for queries, j for edges
		int j = 0;
		for (int i=0; i<q; i++) {

			// Fuse together edges in djset as long as they are bigger than this k.
			while (j < n-1 && g[j].w >= questions[i].k) {
				set.union(g[j].v1, g[j].v2);
				j++;
			}

			// Now, our result is the size of the set that v belongs to.
			res[questions[i].ID] = set.size[set.find(questions[i].v)]-1;
		}

		// Form full answer.
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<q; i++)
			sb.append(res[i]+"\n");

		// Output to file.
		PrintWriter out = new PrintWriter(new FileWriter("mootube.out"));
		out.print(sb);
		out.close();
		stdin.close();
	}
}

class query implements Comparable<query> {

	public int ID;
	public int k;
	public int v;

	public query(int myID, int myk, int myv) {
		ID = myID;
		k = myk;
		v = myv;
	}

	// Sorts from greatest to least query K value.
	public int compareTo(query other) {
		if (k != other.k)
			return other.k - this.k;
		return this.ID - other.ID;
	}
}

class edge implements Comparable<edge> {

	public int v1;
	public int v2;
	public int w;

	public edge(int from, int to, int weight) {
		v1 = from;
		v2 = to;
		w = weight;
	}

	public int compareTo(edge other) {
		return other.w - this.w;
	}
}

class djset {

	public int[] parent;
	public int[] size;

	// Creates a disjoint set of size n (0, 1, ..., n-1)
	public djset(int n) {
		parent = new int[n];
		size = new int[n];
		for (int i=0; i<n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public int find(int v) {

		// I am the club president!!! (root of the tree)
		if (parent[v] == v) return v;

		// Find my parent's root.
		int res = find(parent[v]);

		// Attach me directly to the root of my tree.
		parent[v] = res;
		return res;
	}

	public boolean union(int v1, int v2) {

		// Find respective roots.
		int rootv1 = find(v1);
		int rootv2 = find(v2);

		// No union done, v1, v2 already together.
		if (rootv1 == rootv2) return false;

		// Attach tree of v2 to tree of v1.
		parent[rootv2] = rootv1;
		size[rootv1] += size[rootv2];
		return true;
	}
}