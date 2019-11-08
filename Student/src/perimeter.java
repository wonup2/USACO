import java.util.*;
import java.io.*;
public class perimeter {

	private static int n, count;
	private static char[][] a;
	private static boolean[][] v;
//	private static ArrayList<Integer> areas;
//	private static ArrayList<Integer> perims;
	static int max_area, max_peri, area, peri, dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader(new File("perimeter.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		try {
			init();
			out.println(solve());
			out.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	static void init() throws IOException{
		n = Integer.parseInt(in.readLine());
		count = 1;
//		area = new ArrayList<Integer>();
//		peri = new ArrayList<Integer>();
		v = new boolean[n][n];
		a = new char[n][];
		for (int i = 0; i < n; i++) {
			a[i] = in.readLine().toCharArray();
		}
		in.close();
	}
	
	static String solve() {
		int maxArea = 0;
		for (int  i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == '#') {
					//v = new boolean[n][n];
					area=0;
					peri=0;
					dfs(i, j);	
					
					if(max_area==area){
						max_peri = Math.min(max_peri, peri);
					}
					else{
						max_peri = Math.max(max_peri, peri);
					}
					max_area = Math.max(max_area, area);

				}
			}
		}
		return max_area+" "+ max_peri ;
	}

	static void dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n) {
			peri++;
			return;
		}
		if(a[x][y] == '.') {
			peri++;
			return;
		}
		if(v[x][y]) return;
		
		v[x][y] = true;
		
		area++;
		
		dfs(x, y+1);
		dfs(x+1, y);
		dfs(x, y-1);
		dfs(x-1, y);
		
		return;		

	}
	
	static int perimeter(int x, int y) {
		//find perimeter
		return 0;
	}
}
