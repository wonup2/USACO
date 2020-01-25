import java.io.*;
import java.util.*;
public class JAN_GOLD_shortcut {

	static ArrayList<Pair> []a;
	static int INF = Integer.MAX_VALUE;
	static int n, m, s, d[], cow[], path[];
		
	@SuppressWarnings("unchecked")
	static void ini() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("shortcut.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		a = new ArrayList[n+1];
		d = new int[n+1];
		cow = new int[n+1];
		path = new int[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++){
			a[i] = new ArrayList<Pair>();
			d[i] = INF;
			path[i] = 1;
			cow[i] = Integer.parseInt(st.nextToken());
		}
		
		path[1]=0;
		for(int i=0; i<m; i++){
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			a[x].add(new Pair(y, z));
			a[y].add(new Pair(x, z));
		}
		in.close();
	}	

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new File("shortcut.out"));
		ini();
		dijkstra(1);

		long[] passedCow = new long[n+1];
        for(int i = 2; i <= n; i++)
        {
            int cows = cow[i];
            int curr = i;
            while(curr!=1) {
            	passedCow[curr]+=cows;
                curr = path[curr];
            }           
        }

        long ans = 0;
        for(int i = 2; i <=n; i++)    
            ans = Math.max(ans, passedCow[i]*(d[i]-s));
        
		out.println(ans);
		out.close();
	}

	static void dijkstra(int start){
		d[start] = 0;
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(start,0));
		
		while(!q.isEmpty()){
			int cur = q.peek().v;
			int dis = q.peek().w;			
			q.poll();
			if(d[cur] < dis) continue; 
			
			for(int i=0; i<a[cur].size(); i++){
				int nextVer = a[cur].get(i).v;
				int nextDis = dis + a[cur].get(i).w;
				if(nextDis < d[nextVer]){					
					d[nextVer] = nextDis;					
					q.add(new Pair(nextVer, nextDis));
					path[nextVer]=cur;
				}
				if(nextDis == d[nextVer] && path[nextVer] > cur) path[nextVer]=cur; 
			}			
		}
	}
	
	
	static class Pair implements Comparable<Pair>{
		int v;
		int w;
		Pair(int n, int p){
			v = n;
			w = p;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.w==o.w) return this.v-o.v;
			return this.w - o.w;
		}
	}
}
	
	

