import java.util.*;
import java.io.*;

public class FEB_BR_comfortable {

	static BufferedReader in;
	
	static int n;
	static boolean[][] a;
	static int[][] b;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {		
		n = Integer.parseInt(in.readLine());
		a = new boolean[1001][1001];
		b = new int[1001][1001];
	}
	
	static void solve() throws IOException {		
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = 0;

		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = true;
			
			for(int j=0; j<4; j++) {
				
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if(nx<0 || nx>1000 || ny<0 || ny>1000) continue;
				
				b[nx][ny]++;			
				
				if(b[nx][ny]==3 && a[nx][ny]) cnt++;
				else if(b[nx][ny]==4 && a[nx][ny]) cnt--;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb.toString());
	}			
}


/*
11
0 1
1 0
1 1
1 2
2 1
2 2
3 1
3 2
4 1
2 3
5 3

0
0
0
1
0
0
1
2
4
*/