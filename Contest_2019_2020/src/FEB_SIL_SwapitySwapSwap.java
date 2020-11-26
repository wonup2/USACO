import java.io.*;
import java.util.*;

public class FEB_SIL_SwapitySwapSwap {
	
	static final String probName="swap";
	static BufferedReader br;
	static PrintWriter pw;
	
	static void solve() throws IOException {
		int N=readInt(),M=readInt(),K=readInt();
		
		int[] L=new int[M];
		int[] R=new int[M];
		for(int i=0;i<M;i++) {
			L[i]=readInt()-1;
			R[i]=readInt()-1;
		}
		
		int[] nextPos=new int[N];
		for(int i=0;i<N;i++) {
			nextPos[i]=i;
			for(int j=0;j<M;j++)
				if(L[j]<=nextPos[i]&&nextPos[i]<=R[j])
					nextPos[i]=L[j]+R[j]-nextPos[i];
		}
		
		ArrayList[] locations=new ArrayList[N+1];
		for(int i=0;i<N+1;i++)
			locations[i]=new ArrayList<Integer>();
		
		//the current cycle in investigation
		int cycleType=1;
		//which cycle each cow is a part of
		int[] cycleChain=new int[N];
		//the index of each cow within their cycle
		int[] cyclePos=new int[N];
		for(int i=0;i<N;i++,cycleType++)
			//if this cow has not been a part of an explored cycle
			if(cycleChain[i]==0) {
				cycleChain[i]=cycleType;//assign new cycle type
				locations[cycleType].add(i);//add to start of cycle
				int j=nextPos[i];//get next position in cycle
				if(j!=i)
					cyclePos[j]=1;//to set the next location to index 1 in the new cycle
				
				while(j!=i) {//as long as the cycle is not yet complete
					locations[cycleType].add(j);//add to the cycle
					cycleChain[j]=cycleType;//continue to set the cycle type
					if(nextPos[j]!=i)//as long as the next position isnt the end
						cyclePos[nextPos[j]]=1+cyclePos[j];//set the index within the cycle
					j=nextPos[j];//go to next position
				}
			}
		
		int[] ans=new int[N];
		for(int i=0;i<N;i++)
			ans[(int)locations[cycleChain[i]].get((cyclePos[i]+K)%locations[cycleChain[i]].size())]=i+1;
		for(int i:ans)
			pw.println(i);
	}
	
	public static void main(String[] args) throws IOException {
		st=new StreamTokenizer(br=new BufferedReader(new FileReader(probName+".in")));
		
		pw=new PrintWriter(new BufferedWriter(new FileWriter(probName+".out")));
		
		solve();
		
		br.close();
		
		pw.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int f,s;
		
		Pair(int first,int second){
			f=first;
			s=second;
		}
		
		public int compareTo(Pair p) {
			return f!=p.f?f-p.f:s-p.s;
		}
		
		@Override
		public String toString() {
			return f+" "+s;
		}
	}
	
	static StreamTokenizer st;
	static int readInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	
	static String readWord() throws IOException {
		st.nextToken();
		return st.sval;
	}
	
	static double readDouble() throws IOException {
		st.nextToken();
		return st.nval;
	}
	
	static void print(Object o) {
		int countArrayDimension=0;
		char[] className=o.getClass().toString().toCharArray();
		for(char c:className)
			if(c=='[')countArrayDimension++;
		if(countArrayDimension==0)
			System.out.println(o);
		else if(countArrayDimension==1) {
			switch(className[7]) {
			case 'B':System.out.println(Arrays.toString((byte[])o));break;
			case 'C':System.out.println(Arrays.toString((char[])o));break;
			case 'D':System.out.println(Arrays.toString((double[])o));break;
			case 'F':System.out.println(Arrays.toString((float[])o));break;
			case 'I':System.out.println(Arrays.toString((int[])o));break;
			case 'J':System.out.println(Arrays.toString((long[])o));break;
			case 'L':System.out.println(Arrays.toString((Object[])o));break;
			case 'S':System.out.println(Arrays.toString((short[])o));break;
			case 'Z':System.out.println(Arrays.toString((boolean[])o));break;
			default: System.out.println(className[7]+" "+o.getClass().toString());
			}
		}
		else
			for(Object ob:(Object[])o)
				print(ob);
	}

}
