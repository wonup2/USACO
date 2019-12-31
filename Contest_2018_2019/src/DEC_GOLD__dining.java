//gene

import java.io.*;
import java.util.*;

public class DEC_GOLD__dining{
	
	static class pair implements Comparable<pair>{
		int f,s;
		
		pair(int first,int second){
			this.f=first;
			this.s=second;
		}
		
		public int compareTo(pair p) {
			if(this.s<p.s)return -1;
			if(this.s>p.s)return 1;
			if(this.f<p.f)return -1;
			if(this.f>p.f)return 1;
			return 0;
		}
		
	}
	
	static PriorityQueue<pair> pq=new PriorityQueue<pair>();
	static HashMap<Integer,HashMap<Integer,Integer>>edge=new HashMap<Integer,HashMap<Integer,Integer>>();
	static HashMap<Integer,Integer>minDist=new HashMap<Integer,Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("dining.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()),//nodes
			M=Integer.parseInt(st.nextToken()),//edges
			K=Integer.parseInt(st.nextToken());//haybales
		
		for(int i=0;i<M;i++) {//adds edges
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()),
				b=Integer.parseInt(st.nextToken()),
				t=Integer.parseInt(st.nextToken());
			edge.putIfAbsent(a,new HashMap<Integer,Integer>());
			edge.putIfAbsent(b,new HashMap<Integer,Integer>());
			edge.get(a).put(b,t);
			edge.get(b).put(a,t);
		}
//		System.out.println(edge);
		dijkstra(N);//run dijkstra without haybales
//		System.out.println(minDist);
		//store original values before clearing
		HashMap<Integer,Integer>origDist=(HashMap<Integer, Integer>) minDist.clone();
		minDist.clear();
		
		edge.put(N+1,new HashMap<Integer,Integer>());
		for(int i=0;i<K;i++) {//adds haybales as if it comes from node N+1
			st=new StringTokenizer(br.readLine());
			int b=Integer.parseInt(st.nextToken()),
				y=Integer.parseInt(st.nextToken());
			edge.get(N+1).put(b,origDist.get(b)-y);
		}
		br.close();
//		System.out.println(edge);
		dijkstra(N+1);//run with haybale
//		System.out.println(minDist);
		for(int i=1;i<N;i++)//compare before and after haybale
			pw.println(minDist.get(i)<=origDist.get(i)?1:0);
		
		pw.close();
	}
	
	public static void dijkstra(int node) {
		pq.add(new pair(node,0));//start
		minDist.put(node,0);
		while(!pq.isEmpty()) {
			pair cur=pq.poll();
			if(cur.s>minDist.get(cur.f))continue;
			if(edge.containsKey(cur.f))
				for(Map.Entry<Integer,Integer> p:edge.get(cur.f).entrySet())
					if(!minDist.containsKey(p.getKey())||minDist.get(p.getKey())>cur.s+p.getValue()) {
						minDist.put(p.getKey(),cur.s+p.getValue());
						pq.add(new pair(p.getKey(),minDist.get(p.getKey())));
					}
		}
	}

}