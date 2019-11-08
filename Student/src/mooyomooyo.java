import java.util.*;
import java.io.*;
public class mooyomooyo{

	static int n, k;
	static char[][] a;
	static boolean[][] v;
	static Queue<Integer> q;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("mooyomooyo.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		try {
			init();
			solve();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = new LinkedList<Integer>();
		v = new boolean[n][10];
		a = new char[n][];
		for (int i = 0; i < n; i++) {
			a[i] = in.readLine().toCharArray();
		}
		in.close();
	}
	
	private static void solve() {
	  boolean change = true;
      while(change){
    	  change = false;
    	  v = new boolean[n][10];
    	  for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {		
				if (a[i][j]=='0') continue; //send number to dfs to see where it ends
					dfs(i, j, a[i][j]);
					if (q.size() < k*2)
						q.clear();
					else {
						change=true;
						while (!q.isEmpty()) {
                        	a[q.poll()][q.poll()] = '0';                       
						}
					}
					gravity();
				} 
    	  }
      }
      
      
      for (char[] c : a) out.println(c);
		out.close();
	}
	
	private static void dfs(int x, int y, char color) {
		if (v[x][y]) return;
		v[x][y] = true;
		q.add(x);
		q.add(y);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		    if (nx < 0 || nx >= n || ny < 0 || ny >= 10 || a[nx][ny] != color) continue;			
			dfs(nx, ny, color);			
		}
	}
	
	private static void gravity() { //use for loop and start from bottom to keep
		//going up and replace the one beneath with the 
		//one above, the one above turns to 0
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < 10; j++) {
				if (a[i][j] == '0') {
					a[i][j] = a[i-1][j];
					a[i-1][j] = '0';
				}
			}
		}
		
	}
	static void printA(char[][] chars) {
		for (char[] c : chars) System.out.println(c);
		System.out.println();
	}
}


/*
6 3
0000000000
0000000300
0000000300
1000022030
2211122220
1111111223
*/