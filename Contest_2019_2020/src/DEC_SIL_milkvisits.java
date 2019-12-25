import java.io.*;
import java.util.*;

public class DEC_SIL_milkvisits{
	
	static int[] p;    //parent node
	static char[] T;
	static boolean[] V;
	static HashMap<Integer,HashSet<Integer>>paths=new HashMap<Integer,HashSet<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		//first line
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//set up
		p=new int[N+1];
		T=new char[N+1];
		V=new boolean[N+1];
		T=("0"+br.readLine()).toCharArray();
		
		//read edges
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			paths.putIfAbsent(X,new HashSet<Integer>());
			paths.putIfAbsent(Y,new HashSet<Integer>());
			paths.get(X).add(Y);
			paths.get(Y).add(X);
		}
					
		//run dfs for ranking
		dfs(1,1);
		
		//System.out.println(Arrays.toString(T));
		//System.out.println(Arrays.toString(p));

		StringBuilder ans=new StringBuilder();
		
		//queries
		for(int i=0;i<M;i++) {
			//read queries
			st=new StringTokenizer(br.readLine());
			int Ai=Integer.parseInt(st.nextToken());
			int Bi=Integer.parseInt(st.nextToken());
			char Ci=st.nextToken().charAt(0);
			//solve queries
			if(T[Ai]==T[Bi]&&T[Ai]!=Ci) {
				if(p[Ai]==p[Bi])//if in same group
					ans.append(0);
				else//if in different groups
					ans.append(1);
			}
			else ans.append(1);
		}
		//no more reading needed
		br.close();
		
		//print answer
		pw.println(ans.toString());
		
		pw.close();
	}
	
	static void dfs(int parent,int cur) {
		V[cur]=true;
		if(T[cur]==T[parent])	//if same taste
			p[cur]=parent;		//group together
		else {					//if different taste
			p[cur]=cur;			//start new group
			parent=cur;			//make new parent
		}
		for(int i:paths.get(cur))
			if(!V[i])
				dfs(parent,i);
	}
}
