import java.io.*;
import java.util.*;

public class time {	
		
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st=new StringTokenizer("");
	static int N,M,C;
	static int[] m, ans, T;
	static HashMap<Integer,HashSet<Integer>> edges=new HashMap<Integer,HashSet<Integer>>();
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new FileReader("time.in"));
		N=readInt();
		M=readInt();
		C=readInt();		
		m=new int[N];
		for(int i=0;i<N;i++)m[i]=-readInt();
		for(int i=0;i<M;i++)addEdge(readInt()-1,readInt()-1);
		br.close();		
		ans=new int[N];
		T=new int[N];		
		modifiedDijkstra(0);		
		pw=new PrintWriter(new BufferedWriter(new FileWriter("time.out")));		
		pw.println(-ans[0]);		
		pw.close();
	}
	static int readInt() throws IOException {
		while(!st.hasMoreTokens())readNextLine();
		return Integer.parseInt(st.nextToken());
	}
	
	static void readNextLine() throws IOException {
		st=new StringTokenizer(br.readLine());
	}
	
	static void addEdge(int u, int v) {
		if(!edges.containsKey(u))edges.put(u, new HashSet<Integer>());
		edges.get(u).add(v);
	}
	
	static void modifiedDijkstra(int source) {
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		pq.add(new Edge(source,0,0));
		
		for(int i=0;i<N;i++)ans[i]=T[i]=Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
			if(cur.w>ans[cur.v]||cur.w==ans[cur.v]&&cur.t>=T[cur.v])continue;
			ans[cur.v]=cur.w;
			T[cur.v]=cur.t;			
			if(edges.containsKey(cur.v)) {
				int temp=cur.w+C*(2*cur.t+1);
				for(int e:edges.get(cur.v))
					if(ans[e]>temp+m[e])pq.add(new Edge(e,cur.t+1,temp+m[e]));
			}
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int v,t,w;

		Edge(int v,int t,int w){
			this.v=v;
			this.t=t;
			this.w=w;
		}
		
		public int compareTo(Edge e) {
			return w!=e.w?w-e.w:t!=e.t?t-e.t:v-e.v;
		}
	}

}
