import java.io.*;
import java.util.*;
 
public class JAN_SIL_Cereal2 {

	static class cow{
		int id, to;
		boolean isFirst;
		cow(int a, int b, boolean c){
			id = a; to = b; isFirst = c;
		}
		public String toString() {
			return id+" "+to+" "+isFirst;
		}
	}
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, m, hungry, ignore=-1, first=-1;
	static boolean v[], getCereal[], cycle[];
	static ArrayList<cow> a[];
	static ArrayList<Integer> order;
	
	static void findCycle(int cur, int pre) {
		cycle[cur] = true;
		for(cow next: a[cur]) {
			if(!cycle[next.to]) findCycle(next.to, cur);
			else {
				if(first == -1 &&next.to != pre ) { 
					if(next.isFirst) first = next.to;
					else first = cur;
					
					ignore = next.id;  System.out.println(next+" "+ignore);
					order.add(next.id);
					getCereal[next.id] = true;
				}
			}
		}
	}
	
	static void dfs(int cur) {
		v[cur] = true;
		for(cow next:a[cur]) {
			//System.out.println("dfs " + cur +" [" + next+"] "+v[next.to]);

			if(!v[next.to] && next.id != ignore) {
				getCereal[next.id]=true;
				order.add(next.id);
				dfs(next.to);
			}
		}
	}
	
	static void solve() {
		
		for(int i=1; i<=m; i++) {
			first = -1;
			ignore = -1;
			if(!v[i]) {
				//System.out.println(i);
				findCycle(i, -1);
				
				if(first != -1) { 
					//System.out.println(first); 
					dfs(first); 
				}
				else {dfs(i); //System.out.println("here " + i);
				
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(!getCereal[i]) {
				hungry++;
				order.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(hungry).append("\n");
		for(int o:order) sb.append(o).append("\n");
		
		System.out.print(sb.toString());
	}
	static void init()throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[m+1];
		for(int i=1; i<=m; i++) a[i] = new ArrayList<cow>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(new cow(i, y, false));
			a[y].add(new cow(i, x, true));
		}
		
		System.out.println(Arrays.toString(a));
		v = new boolean[m+1];
		getCereal = new boolean[n+1];
		cycle = new boolean[m+1];
		order = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
}