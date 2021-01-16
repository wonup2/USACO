import java.util.*;
import java.io.*;
public class fenceplan {
	static BufferedReader in;
	static PrintWriter out;
	static boolean v[];
	static ArrayList<Integer> number = new ArrayList<Integer>();
	static ArrayList<Integer>[] a;
	static pair[] coords;
	static int n, m;
	static ArrayList<Integer> bounds = new ArrayList<Integer>();
	static ArrayList<Integer> points = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		in = new BufferedReader(new FileReader("fenceplan.in"));
		out = new PrintWriter(new File("fenceplan.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new boolean[n];
		a = new ArrayList[n];
		coords = new pair[n];
		for(int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine());
			coords[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y);
			a[y].add(x);
		}
	}
	
	static void solve() throws IOException{
		for(int i = 0; i < n; i++) {
			if(v[i] == false) {
				dfs(i);
				perim(i);
				points.clear();
			}
		}
		int res = bounds.get(0);
		for(int i = 1; i < bounds.size(); i++) {
			if(bounds.get(i) < res)
				res = bounds.get(i);
		}
		out.println(res);
	}
	
	static void dfs(int s) {
		v[s] = true;
		for(int i:a[s]) {
			if(!v[i]) {
				points.add(s);

				// get minX, minY, maxXm maxY on here
				// do not collect positions
				
				dfs(i);
			}
		}
	}
	
	static void perim(int a) {
		int maxX = coords[a].x;
		int minX = coords[a].x;
		int maxY = coords[a].y;
		int minY = coords[a].y;
		
		for(int i = 1; i < points.size(); i++) {
			if(coords[a+i].x > maxX)
				maxX = coords[a+i].x;
			if(coords[a+i].x < minX)
				minX = coords[a+i].x;
			if(coords[a+i].y > maxY)
				maxY = coords[a+i].y;
			if(coords[a+i].y < minY)
				minY = coords[a+i].y;
		}

		int res = (maxX-minX)*2 + (maxY-minY)*2;
		bounds.add(res);
	}
}

class pair {
	int x;
	int y;
	pair(int a, int b){
		x = a;
		y = b;
	}
	public String toString() {
		return x + " " + y;
	}
}