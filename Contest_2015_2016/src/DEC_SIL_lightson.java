
import java.util.*;
import java.io.*;

public class DEC_SIL_lightson {

	static int[] DX = {-1,0,0,1};
    static int[] DY = {0,-1,1,0};

    static int n, m, ans;
    static BufferedReader in;
    static PrintWriter out;
    static ArrayList<pair>[][] a;
    static boolean[][] v, l;
    
	public static void main(String[] args) throws Exception {

		in = new BufferedReader(new FileReader("lightson.in"));
		out = new PrintWriter(new File("lightson.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n][n];
		
		for (int i=0; i<n*n; i++)
            a[i/n][i%n] = new ArrayList<pair>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(in.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            a[r1][c1].add(new pair(r2, c2));
        }
        
        System.out.println(Arrays.deepToString(a));
	}
	
	static void solve() {

		v = new boolean[n][n];
        l = new boolean[n][n];
        l[0][0] = true;
        ans = 1;
        dfs(0,0);
        
        out.println(ans);       
	}
	
	static void dfs(int i, int j) {
	    if (i < 0 || i >= n || j < 0 || j >= n || !l[i][j] || v[i][j]) return;

        v[i][j] = true;

        for (pair x: a[i][j]) {
            if (!l[x.first][x.second]) {
                l[x.first][x.second] = true;
                ans++;
                for (int it = 0; it < 4; it++) {
                    if (x.first + DX[it] >= n || x.first + DX[it] < 0) continue;
                    if (x.second + DY[it] >= n || x.second + DY[it] < 0) continue;
                    if (v[x.first + DX[it]][x.second + DY[it]]) dfs (x.first, x.second);
                }
            }
        }
        
        for (int it = 0; it < 4; it++) 
            dfs(i + DX[it], j +DY[it]);        		
	}	
}


class pair{
	int first, second;
	pair(int a, int b){
		first = a;
		second = b;
	}
	public String toString() {
		return first+" "+second;
	}
}